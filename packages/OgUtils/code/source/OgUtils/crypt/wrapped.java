package OgUtils.crypt;

// -----( IS Java Code Template v1.2
// -----( CREATED: 2007-10-29 11:43:43 GMT
// -----( ON-HOST: VMISD

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
// --- <<IS-END-IMPORTS>> ---

public final class wrapped

{
	// ---( internal utility methods )---

	final static wrapped _instance = new wrapped();

	static wrapped _newInstance() { return new wrapped(); }

	static wrapped _cast(Object o) { return (wrapped)o; }

	// ---( server methods )---




	public static final void createCryptKeyDemo (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(createCryptKeyDemo)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [o] object:0:required cryptKey
		final byte[] key = {(byte)0x01,(byte)0xE3,(byte)0xA2,
		(byte)0x19,(byte)0x59,(byte)0xBD,(byte)0xEE,(byte)0x32};
		
		IDataCursor pipelineCursor = pipeline.getCursor();
		Object cryptKey = new Object();
		cryptKey = key;
		IDataUtil.put( pipelineCursor, "cryptKey", cryptKey );
		pipelineCursor.destroy();
		
		// --- <<IS-END>> ---

                
	}



	public static final void cryptString (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(cryptString)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] object:0:required cryptKey
		// [i] field:0:required inputString
		// [i] field:0:optional cryptAlgorithm
		// [o] field:0:required cryptedString
		// [o] field:0:required cryptError
		
		// pipeline
		IDataCursor pipelineCursor = pipeline.getCursor();
			byte[] key = (byte[]) IDataUtil.get( pipelineCursor, "cryptKey" );
			String	inputString = IDataUtil.getString( pipelineCursor, "inputString" );
			String	cryptAlgorithm = IDataUtil.getString( pipelineCursor, "cryptAlgorithm" );
		        if (cryptAlgorithm == null || cryptAlgorithm.length()==0) {
		          cryptAlgorithm="DES";
		        }
			String sCryptedString = "";
			try {	
			  	myCrypt oCrypt = new myCrypt(key,cryptAlgorithm);		
				sCryptedString = oCrypt.encryptHexString(inputString);
			} catch (Exception e) {
				IDataUtil.put( pipelineCursor,"cryptError",e.getMessage());
		}
		// pipeline
		
		IDataUtil.put( pipelineCursor,"cryptedString",sCryptedString);
		pipelineCursor.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void decryptString (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(decryptString)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] object:0:required cryptKey
		// [i] field:0:required inputString
		// [i] field:0:optional cryptAlgorithm
		// [o] field:0:required decryptedString
		
		// pipeline
		IDataCursor pipelineCursor = pipeline.getCursor();
			byte[] key = (byte[]) IDataUtil.get( pipelineCursor, "cryptKey" );
			String	inputString = IDataUtil.getString( pipelineCursor, "inputString" );
			String	cryptAlgorithm = IDataUtil.getString( pipelineCursor, "cryptAlgorithm" );
		        if (cryptAlgorithm == null || cryptAlgorithm.length()==0) {
		          cryptAlgorithm="DES";
		        }	
			myCrypt oCrypt = new myCrypt(key,cryptAlgorithm);		
			String sCryptedString = oCrypt.decryptHexString(inputString);
		
		// pipeline
		
		IDataUtil.put( pipelineCursor,"decryptedString",sCryptedString);
		pipelineCursor.destroy();
		 
		// --- <<IS-END>> ---

                
	}

	// --- <<IS-START-SHARED>> ---
	static class myCrypt {
		
		private javax.crypto.spec.SecretKeySpec keySpec;
	
		private byte[] key;
	
		private String algorithm;
	
		/** Creates a new instance of Crypt */
		public myCrypt(byte[] key, String algorithm) {
			this.key = key;
			this.algorithm = algorithm;
			this.keySpec = new javax.crypto.spec.SecretKeySpec(this.key,
					this.algorithm);
		}
	
		/** Encrypts the give String to an array of bytes */
		public byte[] encryptString(String text) 
	        throws Exception {
			//try {
				javax.crypto.Cipher cipher = javax.crypto.Cipher
						.getInstance(this.algorithm);
				cipher.init(javax.crypto.Cipher.ENCRYPT_MODE, this.keySpec);
				return cipher.doFinal(text.getBytes());
			//} catch (Exception e) {
			//	return null;
			//}
		}
	
		/** Decrypts the given array of bytes to a String */
		public String decryptString(byte[] b) {
			try {
				javax.crypto.Cipher cipher = javax.crypto.Cipher
						.getInstance(this.algorithm);
				cipher.init(javax.crypto.Cipher.DECRYPT_MODE, this.keySpec);
				return new String(cipher.doFinal(b));
			} catch (Exception e) {
				return null;
			}
		}
	
		/**
		 * Encrypts the given String to a hex representation of the array of bytes
		 */
		public String encryptHexString(String text) 
	    throws Exception 
	    {
			return toHex(encryptString(text));
		}
	
		/**
		 * Decrypts the given hex representation of the array of bytes to a String
		 */
		public String decryptHexString(String text) {
			return decryptString(toByteArray(text));
		}
		
		/** Converts the given array of bytes to a hex String */
		public String toHex(byte[] buf) {
		char[] cbf=new char[buf.length*2];
		for (int jj=0, kk=0; jj<buf.length; jj++) {
		cbf[kk++]="0123456789ABCDEF".charAt((buf[jj]>>4) & 0x0F);
		cbf[kk++]="0123456789ABCDEF".charAt(buf[jj] & 0x0F);
		}
		return new String(cbf);
		}
	
		/** Converts a valid hex String to an array of bytes */
		public byte[] toByteArray(String hex) {
		byte[] result=new byte[hex.length()/2];
		for (int jj=0, kk=0; jj<result.length; jj++) {
		result[jj]=(byte)(
		("0123456789ABCDEF".indexOf(hex.charAt(kk++))<<4)+
		"0123456789ABCDEF".indexOf(hex.charAt(kk++)));
		}
		return result;
		}	
	}
	// --- <<IS-END-SHARED>> ---
}


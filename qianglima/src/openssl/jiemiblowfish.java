package openssl;

import java.io.File;


import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;







public class jiemiblowfish {
     
	public static void testDecryption() throws Exception {
	    File encryptedFile = new File("D:\\BaiduYunDownload\\blowfish.data");
	    String password = "qlcoder";

	    byte[] encryptedBytes = FileUtils.readFileToByteArray(encryptedFile);

	    SecretKeySpec blowfishKey = new SecretKeySpec(password.getBytes("ASCII"), "Blowfish");
	    Cipher blowfishCipher = Cipher.getInstance("Blowfish/ECB/NoPadding");
	    blowfishCipher.init(Cipher.DECRYPT_MODE, blowfishKey);
	    byte[] decryptedContent = blowfishCipher.doFinal(encryptedBytes);

	    System.out.println(new String(decryptedContent));
	}
	
	public static void main(String[] args) throws Exception {
		testDecryption();
	}
	
}

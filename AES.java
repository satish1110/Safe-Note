import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class AES 
{
private static String algorithm = "AES";

static ql q;

 private static byte[] keyValue=(q.st).getBytes();
        // Performs Encryption
        public static String encrypt(String plainText) throws Exception 
        {
                Key key = generateKey();
                Cipher chiper = Cipher.getInstance(algorithm);
                chiper.init(Cipher.ENCRYPT_MODE, key);
                byte[] encVal = chiper.doFinal(plainText.getBytes());
                String encryptedValue = Base64.getEncoder().encodeToString(encVal);
                return encryptedValue;
        }

        // Performs decryption
        public static String decrypt(String encryptedText) throws Exception 
        {
                // generate key 
                Key key = generateKey();
                Cipher chiper = Cipher.getInstance(algorithm);
                chiper.init(Cipher.DECRYPT_MODE, key);
                byte[] decordedValue = Base64.getDecoder().decode(encryptedText);
                byte[] decValue = chiper.doFinal(decordedValue);
                String decryptedValue = new String(decValue);
                return decryptedValue;
        }

//generateKey() is used to generate a secret key for AES algorithm
        private static Key generateKey() throws Exception 
        {
                Key key = new SecretKeySpec(keyValue, algorithm);
                return key;
        
		}

        // performs encryption & decryption 

 }
 
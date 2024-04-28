//pair of keys generations
//same as 
import java.security.*;
import javax.crypto.*;

public class RSA{
  public static void main(String[] args) throws Exception{
    byte[] pt = "HelloWorld".getBytes();
    KeyPair pair = KeyPairGenerator.getInstance("RSA").generateKeyPair();
    PublicKey pu = pair.getPublic();
    PrivateKey pr = pair.getPrivate();
    byte[] ct = encrypt(pt,pu);
    byte[] dt = decrypt(ct,pr);
    System.out.println("Plain Text: " + new String(pt));
    System.out.println("Cipher Text :" + new String(ct));
    System.out.println("Decrypted Text " + new String(dt));
  }
  public static byte[] encrypt(byte[] pt, PublicKey pu)throws Exception{
    Cipher cphr = Cipher.getInstance("RSA");
    cphr.init(Cipher.ENCRYPT_MODE, pu);
    return cphr.doFinal(pt);
  }
  public static byte[] decrypt(byte[] ct, PrivateKey pr)throws Exception{
    Cipher cphr = Cipher.getInstance("RSA");
    cphr.init(Cipher.DECRYPT_MODE, pr);
    return cphr.doFinal(ct);
  }
}

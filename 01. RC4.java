import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.*;
//new SecretKeySpec(key,"RC4") Cipher.getInstance("RC4") cphr.init(Cipher.MODE,k) return cphr.doFinal(text)
public class RC4{
  public static void main(String[] args){
    byte[] pt = "HelloWorld".getBytes();
    byte[] key = "SecretKeyy".getBytes();
    byte[] ct = encrypt(pt,key);
    byte[] dt = decrypt(ct,key);
    System.out.println("Encrypted Text " + new String(ct));
    System.out.println("Decrypted Text " + new String(dt));
  }
  public static byte[] encrypt(byte[] pt, byte[] key){
    Key k = new SecretKeySpec(key,"RC4");
    Cipher cphr = Cipher.getInstance("RC4");
    cphr.init(Cipher.ENCRYPT_MODE, k);
    return cphr.doFinal(pt);
  }
  public static byte[] decrypt(byte[] ct, byte[] key){
    Key k = new SecretKeySpec(key,"RC4");
    Cipher cphr = Cipher.getInstance("RC4");
    cphr.init(Cipher.DECRYPT_MODE,k);
    return cphr.doFinal(ct);
  }
}

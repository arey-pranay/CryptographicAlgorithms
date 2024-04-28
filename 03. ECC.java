
public class ECC{
  static int a = 1;
  static int b = 1;
  static int p = 23;
  public static void main(String[] args){
    int[] P = {13,7};
    int[] Q = {9,7};
    int[] R = addn(P,Q);
    System.out.print(R[0] + " " + R[1]);
  }
  public static int[] addn(int[] P, int[] Q){
    int lambda;
    if(P[0]==Q[0] && P[1]==Q[1])
      lambda = ( ( 3*(P[0]*2) + a ) * modInv(2*P[1],p) ) % p;
    else
      lambda = (Q[1] - P[1])/(Q[0]-P[0]);
    int R[] = new int[2];
    R[0] = ((lambda*lambda)-P[0]-Q[0]) % p;
    R[1] = (lambda*(P[0]-R[0]) - P[1] ) % p;
    if(R[0] < 0) R[0] +=p;
    if(R[1] < 0) R[1] +=p;
    return R;
  }
  
  public static int modInv(int a, int m){
    for(int i=0;i<m;i++){
      if ( ( (a%m)*(i%m) ) % m == 1) return i;
    }
    return -1;
  }
}

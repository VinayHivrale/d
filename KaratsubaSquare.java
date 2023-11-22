
import java.util.*;
import java.math.*;

public class KaratsubaSquare{

    public static BigInteger karatsuba(BigInteger x, BigInteger y) {

       if(x.compareTo(BigInteger.TEN)<0 || y.compareTo(BigInteger.TEN)<0)
       return x.multiply(y);

       String xStr=x.toString();
       String yStr=y.toString();

       int n=Math.max(xStr.length(),yStr.length());

       int halfn=n/2;

       BigInteger a=x.divide(BigInteger.TEN.pow(halfn));
       BigInteger b=x.mod(BigInteger.TEN.pow(halfn));
       BigInteger c=y.divide(BigInteger.TEN.pow(halfn));
       BigInteger d=y.mod(BigInteger.TEN.pow(halfn));
       

       BigInteger ac=karatsuba(a,c);
       BigInteger ad=karatsuba(a,d);
       BigInteger bc=karatsuba(c,b);
       BigInteger bd=karatsuba(d,b);

          BigInteger Res=ac.multiply(BigInteger.TEN.pow(2*halfn)).add(ad.add(bc).multiply(BigInteger.TEN.pow(halfn))).add(bd);
          return Res;






   

    }
    public static void main(String[] args){
       
     Scanner scanner=new Scanner(System.in);
     System.out.println("Enter the number to be squared");
     BigInteger large=scanner.nextBigInteger();

     System.out.println("the square of the number is:"+ karatsuba(large,large) );


    }
}
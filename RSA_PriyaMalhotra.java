import java.util.*;
import java.io.*;
import java.util.List;
import java.util.ArrayList;
import java.lang.Math;
import java.math.BigInteger;

public class RSA_PriyaMalhotra{
   public static void main (String [] args)throws FileNotFoundException{
      BigInteger x = FindPlaintext(new BigInteger("55816511737637873797"), new BigInteger("98345982343523023"), new BigInteger("22840895532499044809"));
      System.out.println(x);
   }
   
   public static BigInteger FindPlaintext(BigInteger pq, BigInteger E, BigInteger ME)throws FileNotFoundException{
      BigInteger D = (ExtEuclidGivesD(pq, E));
      System.out.println("" + "The value of D is:  " + D);
      BigInteger M1 = ME.modPow(D, pq);
      System.out.print("The value of M is:  ");
      return M1;
   }
   
   public static BigInteger ExtEuclidGivesD(BigInteger pq, BigInteger E)throws FileNotFoundException{  
      BigInteger pqvals[];
      pqvals = FindPQ(pq); 
      BigInteger p = pqvals[0];
      System.out.println("The value of P is:  " + p);
      BigInteger q = pqvals[1];
      System.out.println("The value of Q is:  " + q);
      BigInteger num = (p.subtract(new BigInteger("1")).multiply((q.subtract(new BigInteger("1")))));
      BigInteger num2 = new BigInteger("1");
      BigInteger D = E.modInverse(num);
      return D;
   }

   public static BigInteger[] FindPQ(BigInteger pq)throws FileNotFoundException{
      Scanner in = new Scanner(new File("2T_part4.txt"));
      BigInteger retu[] = new BigInteger[2];
      for(int j = 0; j < 10000000; j++){
         BigInteger newPrime1 = new BigInteger(in.next());
         if(in.hasNext() && pq.mod(newPrime1).equals(new BigInteger("0"))){
               System.out.println("Found P and Q");
               retu[0] = newPrime1;
               retu[1] = (pq.divide(newPrime1));
         } 
      }
      return retu;  
   }
     
}
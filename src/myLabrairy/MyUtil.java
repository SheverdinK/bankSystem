/** all right recieved  @ Sheverdin Konstantin  */


package myLabrairy;

import bin.client.Client;
import bin.client.Gold;
import bin.client.Platinum;
import bin.client.Regular;

import java.util.Random;
import java.util.Scanner;

import static java.lang.System.out;


public class MyUtil {

    Scanner scanner = new Scanner(System.in);

    public  String getString () {
        return scanner.next();
    }
    public long getLong () {
        return  scanner.nextLong ();
    }
    public float getFloat() {
        return scanner.nextFloat ();
    }
    public int getInt () {
        return scanner.nextInt ();
    }

    Random numRandom = new Random ();
    public  int getRandomNum(int startNum, int endNum){
        return   startNum + numRandom.nextInt (endNum);
    }

    public  int getTempID(){
        return getInt ();
    }

    public boolean isId (int id, int n)  {
        System.out.println ("id = " + id);
        System.out.println ("n = " + n);
        boolean idIsNdigit = false;
        int   tempId = 0;

        int nDigitMinTemp=1, nDigitMin=0, nDigitMax=0 ;
        for (int i = 1; i < n ; i++) {
            nDigitMax = (nDigitMax+9)*10;
            nDigitMinTemp *= 10;
            if (i == n-1) {
                nDigitMin = nDigitMinTemp;
            }
        }
        nDigitMax += 9;
        System.out.println ("nDigitMin = " + nDigitMin);
        System.out.println ("nDigitMax = " + nDigitMax);
       if (id <= nDigitMin || id >= nDigitMax){
           System.out.println (" FAlSE ");
           return  false;
//           throw new Exception (">>>>>>>>>>  Invalid ID. Try again <<<<<<<<<<<<");
       }
        else {
           System.out.println ("TRUE");
           return true;
       }
    }

    public Client getTypeOfClient (int id, String name, float balance) {
        Client client;
        if (balance < 10000) {
            out.println("Regular balance = " + balance);
            client = new Regular(id, name, balance);}
        else if (balance < 100000){
            out.println("Gold balance = " + balance);
            client = new Gold(id, name, balance);}
        else {
            out.println("Platinum balance = " + balance);
            client = new Platinum(id, name, balance);}
        return client;
    }
}






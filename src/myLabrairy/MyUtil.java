/** all right received  @ Sheverdin Konstantin  */

package myLabrairy;

import bin.client.*;

import java.util.ListIterator;
import java.util.Random;
import java.util.Scanner;

public class MyUtil {

    Scanner scanner = new Scanner(System.in);
    Random numRandom = new Random ();

    public String getString () {
        return scanner.next();
    }
    public float  getFloat() {
        return scanner.nextFloat ();
    }
    public int    getInt () {
        return scanner.nextInt ();
    }
    public int    getRandomNum(int startNum, int endNum){
        return   startNum + numRandom.nextInt(endNum);
    }

    public int isId ( int n)  {
         int id = getInt ();
        int nDigitMinTemp=1, nDigitMin=0, nDigitMax=0 ;
        for (int i = 1; i < n ; i++) {
            nDigitMax = (nDigitMax+9)*10;
            nDigitMinTemp *= 10;
            if (i == n-1) {
                nDigitMin = nDigitMinTemp;
            }
        }
        nDigitMax += 9;
        if (id <= nDigitMin || id >= nDigitMax){
            return  0;
//           throw new Exception (">>>>>>>>>>  Invalid ID. Try again <<<<<<<<<<<<");
        }
        else {
            return id;
        }
    }

    public Client getTypeOfClient (int id, String name, float balance) {
        Client client;
        if (balance < 10000) {
            client = new Regular(id, name, balance);}
        else if (balance < 100000){
            client = new Gold(id, name, balance);}
        else {
            client = new Platinum(id, name, balance);}
        return client;
    }

    public int findClientId (int nClientId, ListIterator<Client> clientIterator) {
        boolean isFound = false;
        int i = 0;

        System.out.println ("Enter ID - " + nClientId + " digit");
        int tempId = this.isId (nClientId);

        while (clientIterator.hasNext ()) {
            Client client = clientIterator.next ();
            if (client.getId () == tempId) {
                isFound = true;
                break;
            }
            i++;
        }
        if (!isFound)  {
            System.err.println (" **** ID  NOT FOUND  ******");
            i= (-1);
        }
        return i;
    }

    public int findAccountId (int nAccountId, ListIterator<Account> accountIterator) {
        boolean isFound = false;
        int i = 0;

        System.out.println ("Enter Account  ID - " + nAccountId + " digit");
        int tempId = this.isId (nAccountId);

        while (accountIterator.hasNext ()) {
            Account account = accountIterator.next ();
            if (account.getId () == tempId) {
                isFound = true;
                break;
            }
            i++;
        }
        if (!isFound)  {
            System.err.println (" ****  ACCOUNT ID  NOT FOUND  ******");
            i= (-1);
        }
        return i;
    }

}






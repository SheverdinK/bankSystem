/** all right received  @ Sheverdin Konstantin  */

package myLabrairy;

import bin.client.*;
import myException.MyException;

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

    public boolean isId (int id, int n) throws MyException {

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
            throw new MyException (">>>>>>>>>> After THROW.  Invalid ID. Try again <<<<<<<<<<<<");
        }
        else {
            return true;
        }
    }

    public Client setTypeOfClient (int id, String name,float balance) {
        Client client;
        if (balance < 10000) {
            client = new Regular(id, name, balance);}
        else if (balance < 100000){
            client = new Gold(id, name, balance);}
        else {
            client = new Platinum(id, name, balance);}
        return client;
    }

    public int findClientId (int id, ListIterator<Client> clientIterator) {
        boolean isFound = false;
        int i = 0;

        while (clientIterator.hasNext ()) {
            Client client = clientIterator.next ();
            if (client.getId () == id) {
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

    public int findAccountId (int id, ListIterator<Account> accountIterator) {
        boolean isFound = false;
        int i = 0;


        while (accountIterator.hasNext ()) {
            Account account = accountIterator.next ();
            if (account.getId () == id) {
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
    public  int getId (int nClientId, String printMessage) {
        int id = 0;
        boolean isId = false;
        while (!isId) {
            try {
                System.out.println (printMessage);
                id = getInt ();
                isId = isId (id, nClientId);
            }
            catch (MyException eId) {

                System.out.println( eId.getMessage());
            }
        }
        return id;
    }

}






/**
 * all right received  @ Sheverdin Konstantin
 */

package bin.bank;

import bin.client.Client;

import java.util.ArrayList;
import java.util.List;

public class Bank {

    private static final int numberOfClient = 100;
    private static Bank bank;
    float balance;
    List <Client>  clientsList;


    private Bank () {
        clientsList = new ArrayList<> ();
    }

    public static Bank getBank () {
        if (bank == null) {
            System.out.println ("Bank == NULL");
            return bank = new Bank ();
        } else {
            System.out.println ("BANK ! =  null");
            return bank;
        }
    }

    public float getBalance () {
        System.out.println ("Get Balance");
        return 123f;
    }

    public void addClient (Client client) {      //  Create Random Array of  Client
        String description = ">>Client ADDED<<";
        clientsList.add (client);
    }

    public void removeClients (Client client) {
        String description = "CLIENT REMOVED";
        System.out.println ("client = " + client);
        clientsList.remove (client);
        System.out.println (" ------  Remove  Another Client ? ---------");
    }
    public void printClientList (){
        int i=1;
        for (Client client : clientsList) {

            System.out.println (i++ +""+ client);
        }
    }
    public List <Client> getClientsList () {
        return clientsList;
    }

    @Override
    public String toString () {
        return "Bank{" +
                "balance=" + balance +
                ", clientsList=" + clientsList +
                '}';
    }
}
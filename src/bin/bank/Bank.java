/**
 * all right received  @ Sheverdin Konstantin
 */

package bin.bank;

import bin.client.Client;
import bin.log.Log;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Bank {

    private static final int numberOfClient = 100;
    private static Bank bank;
    float balance;
    List <Client>  clientsList = new ArrayList<> ();


    private Bank () { }

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

    public void addClient (Client client) {     // Add One Client
        String description = "Client Added";
        int index = 0;
        Iterator <Client> clientIterator = clientsList
        System.out.println (Log.getData (clients[index].getId (), description, clients[index].getBalance (), client.getClass ().getName ()));
    }           // For real Program

    public void removeClients (Client client) {
        String description = "CLIENT REMOVED";

        int i = 0;
        boolean isFound = false;
        while (i < clients.length) {
            if (clients[i] != null) {
                if (clients[i].equals (client)) {
                    System.out.println (Log.getData (
                            clients[i].getId (), description,
                            clients[i].getBalance (),
                            clients[i].getClass ().getName ()));
                    clients[i] = null;
                    isFound = true;
                    break;
//                  i = clients.length;
                }
            }
            i++;
        }
        if (!isFound) {
            System.out.println ("ID IS NOT FOUND !!! TRY AGAIN");
        }
        System.out.println (" ------  Remove  Another Client ? ---------");
    }

    public void addClient (Client client, int i) {      //  Create Random Array of  Client
        int index = 0;
        boolean isEmpty = true;

        while (isEmpty) {
            if (clients[i] == null) {
                clients[i] = client;
                index = i;
                isEmpty = false;
            } else if (i < clients.length - 1) i++;
            else i = 0;
        }
        String description = " Client Random ADDED ";
        System.out.print (" index = " + index + " *** ");
        System.out.println (Log.getData (
                        clients[index].getId (),
                        description,
                        clients[index].getBalance (),
                        client.getClass ().getSimpleName ())
        );
    }   // For Random Program

    public Client[] getClients () {
        return clients;
    }

    /* public void printClientList () {
         System.out.println ("**************  Print Client List ************************ ");
         for (int i = 0; i < clients.length; i++) {

//             System.out.println ("i= " + i + "  id: " + clients[i].getId () + " Name: " + clients[i].getName () + " Balance: " + clients[i].getBalance ());

         }
     }*/

}
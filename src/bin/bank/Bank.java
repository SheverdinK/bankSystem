/** all right received  @ Sheverdin Konstantin  */

package bin.bank;

import bin.client.Client;
import bin.log.Log;

import static java.lang.System.out;

public class Bank {

    private static Bank bank;
    static final   int  numberOfClient = 100;
    float balance;
    Client [] clients;

    private    Bank () {
        clients = new Client[numberOfClient];
    }

    public static Bank getBank () {
        if (bank == null) {
            out.println ("Bank == NULL");
            return bank = new Bank ();
        }
        else       {
            out.println ("BANK ! =  null");
            return bank;
        }
    }

    public void addClient (Client client) {     // Add One Client
        String description = "Client Added";
        int index = 0;
        for (int i = 0; i < clients.length; i++) {
            if (clients[i] == null) {
                clients[i] = client;
                index = i;
                i = clients.length;
            }
        }
        out.print (" index = " + index + " *** ");
        out.println (Log.getData (clients[index].getId (), description, clients[index].getBalance (),client.getClass ().getName () ));
    }           // For real Program

    public void removeClients (Client client) {
        String description = "CLIENT REMOVED";

        int i = 0;
        while (i < clients.length) {
            if (clients[i] != null) {
                System.out.println("!!!Remove!!!! Id = " + clients[i].getId());
                if (clients[i].equals(client)) {
                    out.println (Log.getData (
                                    clients[i].getId (), description,
                                    clients[i].getBalance (),
                                    clients[i].getClass ().getName ()));
                    clients[i] = null;
                    i = clients.length;
                }
            }
            i++;
        }
    }

    public void addClient (Client client, int i) {      //  Create Random Array of  Client
        int index =0;
        boolean isEmpty = true;

        while (isEmpty) {
            if (clients[i] == null) {
                clients[i] = client;
                index =i;
                isEmpty = false;
            }
            else if ( i < clients.length-1)   i++;
            else i=0;
        }
        String description = " Client Random ADDED " ;
        out.print (" index = " + index + " *** ");
        out.println (Log.getData (
                        clients[index].getId (),
                        description,
                        clients[index].getBalance (),
                        client.getClass ().getName ())
                 );
    }   // For Random Program

    public Client[] getClients () {
        String description = "Get Client";
        int i = 0;
        while (i < clients.length) {
            if (clients[i] != null) {
//                System.out.println ("LOG Get Client: ");
//                out.print (" index = " + i + " *** ");
                /*out.println (Log.getData (
                        clients[i].getId (),
                        "GET CLIENT",
                        clients[i].getBalance (),
                        clients[i].getClass ().getName ()));*/
            }
            i++;
        }
        return  clients;
    }

    public float getBalance () {
        out.println ("Get Balance");
        return 123f;
    }


    /* public void printClientArray () {
         out.println ("**************  Print Client Array  ************************ ");
         for (int i = 0; i < clients.length; i++) {
             out.println ("i= " + i + "  id: " + clients[i].getId () + " Name: " + clients[i].getName () + " Balance: " + clients[i].getBalance ());
         }
     }*/

}
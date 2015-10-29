/** all right recieved  @ Sheverdin Konstantin  */

package runPackege;

import bin.bank.Bank;
import bin.client.*;
import myLabrairy.ToExit;

import static java.lang.System.out;

public class BankMenu {

    public boolean mainMenu (ToExit myUtil, Bank bank)  {
        out.println ("------------------------ M A I N    M E N U --------------------------");
        out.println ("1 >>>> B A N K <<<<<");
        out.println ("2 >>>> CLIENT  <<<<<");

        int inMainMenu = myUtil.getInt ();
        switch (inMainMenu) {                  // MENU 1:   1 - BANK; 2- CLIENT
            case 1:
                System.out.println ("------------- B A N K ---------------");
                System.out.println ("1 - ADD Client");
                System.out.println ("2 - REMOVE  Client");
                System.out.println ("3 - GET  Balance");

                bankMenu (myUtil, bank);

                break;
            case 2:
                System.out.println (" -------------- C L I E N T ------------- ");
                System.out.println ("1 - Add Accoutn");
                System.out.println ("2 - Remove Account");
                System.out.println ("3 - Total  Balance");
                clientMenu (myUtil, bank);
                break;
        }

        System.out.println ("---------------  C O N T I N U E ? ? ?  ----------  ");

        return myUtil.isExit ();
    }

    public void bankMenu (ToExit myUtil, Bank bank)  {
        int inBankMenu = myUtil.getInt ();
//      int  inBankMenu = 1;
        switch (inBankMenu) {           //   MENU 1-1: BANK ( 1-Add Client; 2- Remove Client; 3 - Get Balance )
            case 1:
                boolean flagAddClient = true;
                while (flagAddClient) {          // Loop for Restart the "addAccount"
                   /* out.println ("Enter ID : ");
                    int  id = myUtil.setTempID (9);

                    out.println ("Enter  NAME of the CLient : ");
                    String name = myUtil.getString ();

                    out.println ("Enter Sum of Money  to Deposit : ");
                    float balance = myUtil.getFloat ();*/

                    int id = myUtil.getRandomNum (320000000, 889999999);
                    String name = "testName";
                    float balance = myUtil.getRandomNum (100, 1000000);

                    Client client;

                    client = myUtil.getTypeOfClient (id,  name,  balance);

                    bank.addClient (client);

                    out.println (" ------  ADD Another Client ? ---------");

                    flagAddClient = myUtil.isExit ();
                }    // while
                break;
            case 2:
                boolean flagRemoveClient = true;
                while (flagRemoveClient) {
                    out.println ("Enter ID : ");
                    int tempId = myUtil.getTempID();
                    int Id = myUtil.isId(tempId, 9);
                    Client client = new Regular (Id);
                    bank.removeClients(client);

                    out.println (" ------  Remove  Another Client ? ---------");

                    flagRemoveClient = myUtil.isExit ();
                }
                break;
            case 3:
                bank.getBalance ();
                break;
        }// switch
    }

    public void clientMenu (ToExit myUtil, Bank bank)  {
        int inClientMenu = myUtil.getInt ();
        switch (inClientMenu) {           //   MENU 2-1: Client ( 1-Add Account; 2- Remove Account; 3 - Total Balance )
            case 1:
                boolean flagAddAccount = true;
                while (flagAddAccount) {          // Loop for Restart the "ADD Account"

                    int id = myUtil.getRandomNum (10000, 99999);

                    float balance = myUtil.getRandomNum (100, 1000000);

                    Account account = new Account (id, balance);
                    Client.addAccount (account);
                    out.println (" ------  ADD Another Account ? ---------");
                    flagAddAccount = myUtil.isExit ();
                }    // while
                break;
            case 2:
                boolean flagRemoveAccount = true;
                while (flagRemoveAccount) {
                    out.println ("Enter ID : ");
                    int  id = myUtil.getTempID();
                    Client client = new Regular (id);
                    client.removeAccount(client);
                    out.println (" ------  Remove  Another Client ? ---------");

                    flagRemoveAccount = myUtil.isExit ();
                }
                break;
            case 3:
                bank.getBalance ();
                break;
        }    // switch
    }
}

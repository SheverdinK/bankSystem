/** all right received  @ Sheverdin Konstantin  */

package runPackege;

import bin.bank.Bank;
import bin.client.Account;
import bin.client.Client;
import bankException.IdException;
import bin.log.LoggerFile;
import myLabrairy.ToExit;

import java.util.List;
import java.util.ListIterator;

public class BankMenu {

    final int nClientId = 9;
    final int nAccountId = 5;
    ToExit myUtil = new ToExit();

    public int setMenu () {return    myUtil.getInt ();}

    public boolean mainMenu (ToExit myUtil, Bank bank) {
       int inMainMenu = setMenu ();
        System.out.println ("------------------------ M A I N    M E N U --------------------------");
        System.out.println ("1 >>>> B A N K <<<<<");
        System.out.println ("2 >>>> CLIENT  <<<<<");

        switch (inMainMenu) {                  // MENU 1:   1 - BANK; 2- CLIENT
            case 1:
                System.out.println ("------------- B A N K ---------------");
                System.out.println ("1 - ADD Client");
                System.out.println ("2 - REMOVE  Client");
                System.out.println ("3 - PRINT  Client List");

                bankMenu (myUtil, bank);

                break;
            case 2:
                System.out.println (" -------------- C L I E N T ------------- ");
                System.out.println ("1 - Add Account");
                System.out.println ("2 - Remove Account");
                System.out.println ("3 - Total  Balance");

              clientMenu (myUtil, bank);

                break;
        }

        System.out.println ("---------------  C O N T I N U E ? ? ?  ----------  ");

        return myUtil.isExit ();
    }

    /***********
     * C A L L  F O R   B A N K
     ******************/
    public void bankMenu (ToExit myUtil, Bank bank) {

        int inBankMenu = setMenu ();
//      int  inBankMenu = 1;
        switch (inBankMenu) {           //   MENU 1-1: BANK ( 1-Add Client; 2- Remove Client; 3 - Get Balance )
            case 1:                                               //  ADD Client
                boolean flagAddClient = true;
                while (flagAddClient) {                           // Loop for Restart the "addAccount"

                    int id = myUtil.getRandomNum (320000000, 579999999);   // endNumber = 899.999.999 - startNumber
                    String name = "testName";
                    float balance = myUtil.getRandomNum (100, 1000000);

                    Client client;

                    client = myUtil.setTypeOfClient (id, name, balance);

                    bank.addClient (client);
                    bank.printClientList ();

                    System.out.println (" ------  ADD Another Client ? ---------");

                    flagAddClient = myUtil.isExit ();
                }    // while
                break;
            case 2:                                                 // Remove Client
                boolean flagRemoveClient = true;
                while (flagRemoveClient) {
                    Client client;
                    System.out.println ("Enter ID : " + nClientId + "  Digit");
                    int id = myUtil.getId (nClientId, "Enete ID " );
                    client = new Client (id) {};
                    bank.removeClients (client);
                    bank.printClientList ();
                    flagRemoveClient = myUtil.isExit ();
                }
                break;
            case 3:
//                bank.printClientList ();
                LoggerFile loggerFile = new LoggerFile ();

                break;
        }// switch
    }

    /***********
     * C A L L  F O R   C L I E N T
     ******************/
    public void clientMenu (ToExit myUtil, Bank bank) {
        int caseClientMenu = myUtil.getInt ();

        switch (caseClientMenu) {           //   MENU 2-1: Client ( 1-Add Account; 2- Remove Account; 3 - Total Balance )
            case 1:                                       //     ADD ACCOUNT
                boolean flagAddAccount = true;
                while (flagAddAccount) {                  // Loop for Restart the "ADD Account"
                    int accountID = myUtil.getRandomNum (10000, 89999);
                    float balance = myUtil.getRandomNum (100, 1000000);

                    List<Client> clientsList = bank.getClientsList ();
                    ListIterator<Client> clientIterator = clientsList.listIterator ();
                    int idClient = myUtil.getId (nClientId, "Enter ID number");
                    int indexId = myUtil.findClientId (idClient,  clientIterator);

                    if ( indexId >0) {
                        Client client = clientsList.get(indexId);
                        Account account = new Account (accountID, balance);

                        try {

                            client.addAccount (account);
                        } catch (IdException eAccount) {

                            System.err.println ( eAccount.getMessage ());
                        }

                        client.printAccountList ();
                    }

                    flagAddAccount = myUtil.isExit ();
                    System.out.println (" ------  ADD Another Account ? ---------");
                }
                break;
            case 2:                                      //  Remove ACCOUNT
                boolean flagRemoveAccount = true;
                while (flagRemoveAccount) {

                    List<Client> clientsList = bank.getClientsList ();
                    ListIterator<Client> clientIterator = clientsList.listIterator ();
                    int idClient = myUtil.getId (nClientId, "Enter ID number ");
                    int indexId = myUtil.findClientId (idClient,  clientIterator);
                    if ( indexId >= 0) {
                        System.out.println ("indexId = " + indexId);
                        Client client = clientsList.get(indexId);

                        List<Account> accountList = client.getAccountList ();
                        ListIterator<Account> accountIterator = accountList.listIterator ();
                        int idAccount = myUtil.getId (nAccountId, "Enter number of Account");
                        int indexAccountId = myUtil.findAccountId (idAccount, accountIterator);

                          if ( indexAccountId >=  0 ){
                              System.out.println ("indexAccountId = " + indexAccountId);
                               Account account = accountList.get (indexAccountId);
                              client.removeAccount (account);
                              client.printAccountList ();
                          }
                          else System.out.println (" **** Account ID NOT FOUND ****");
                    }

                    System.out.println (" ------  Remove  Another Account ? ---------");
                    flagRemoveAccount = myUtil.isExit ();
                }
                break;
     /*       case 3:
//                bank.printClientList  ();
                break;*/
        }
    }
}


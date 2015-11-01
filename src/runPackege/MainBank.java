/** all right received  @ Sheverdin Konstantin  */

package runPackege;

import bin.bank.Bank;
import myLabrairy.ToExit;

public class MainBank {

    public static void main (String[] args) {
       Bank bank = Bank.getBank ();

           /*                         RUN Random  Method
                ---------------------------------------------------------------------          */
        RandomClient70 randClient = new RandomClient70 ();

        randClient.setRandomClient (bank);
        bank.printClientList ();

 /*                                         Run Real program
        ------------------------------------------------------------------------      */
        boolean flagMainMenu = true;
        BankMenu bankMenu = new BankMenu ();

        while (flagMainMenu) {
            ToExit myUtil = new ToExit ();
            flagMainMenu = bankMenu.mainMenu (myUtil, bank);
        }


    }
}
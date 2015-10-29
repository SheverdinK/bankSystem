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

 /*                                         Run Real program
        ------------------------------------------------------------------------      */
        boolean flagMainmenu = true;
        BankMenu bankMenu = new BankMenu ();
        while (flagMainmenu) {
            ToExit myUtil = new ToExit ();
            flagMainmenu = bankMenu.mainMenu (myUtil, bank);
        }


    }
}
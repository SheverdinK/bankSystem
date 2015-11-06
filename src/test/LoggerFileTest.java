package test;

import bin.bank.Bank;
import bin.log.LoggerFile;
import org.junit.Before;
import org.junit.Test;
import runPackege.BankMenu;
import runPackege.RandomClient70;

public class LoggerFileTest extends BankMenu {

    @Before
    public void setUp () throws Exception {
        Bank bank = Bank.getBank ();
        RandomClient70 randClient = new RandomClient70 ();
        randClient.setRandomClient (bank);
        bank.printClientList ();
    }

    @Test
    public void testSaveClientListToFile () throws Exception {
        LoggerFile loggerFile = new LoggerFile ();
        loggerFile.saveClientListToFile ();
    }

    @Test
    public void testReadClientListFromFile () throws Exception {
    LoggerFile loggerFile = new LoggerFile ();
        loggerFile.readClienListFromFile ("clientList.dat");
    }
}
package test;

import bin.log.LoggerFile;
import org.junit.Test;
import runPackege.BankMenu;

public class LoggerFileTest extends BankMenu {

    /*@Before
    public void setUp () throws Exception {
        Bank bank = Bank.getBank ();
        RandomClient70 randClient = new RandomClient70 ();
        randClient.setRandomClient (bank);
        bank.printClientList ();
    }
*/
    @Test
    public void testSaveClientListToFile () throws Exception {
        LoggerFile loggerFile = new LoggerFile ();
        loggerFile.saveClientListToFile ();
    }

    @Test
    public void testReadClientListFromFile () throws Exception {
    LoggerFile loggerFile = new LoggerFile ();
        loggerFile.readClientListFromFile ("clientList.dat");
    }
    @Test
    public void findDirAndFile() throws Exception  {
        String dirName = "C:\\Program Files\\Internet Explorer";
        LoggerFile loggerFile = new LoggerFile ();
        loggerFile.findDirAndFile (dirName);
    }

    @Test
    public void testFindFileWithMask () throws Exception {
        String dirName = "D:\\Limudim\\JhonBrice\\JAVA\\myProjectIdea\\bankSystem\\src\\bin\\client";
        String mask = ".dat";
        LoggerFile loggerFile = new LoggerFile ();
        loggerFile.findFileWithMask (dirName, mask);
          }
/*
 @Test
    public void testFindFileWithMask () throws Exception {
        String dirName = "D:\\Limudim\\JhonBrice\\JAVA\\myProjectIdea\\bankSystem\\src\\bin\\client";
        String mask = ".dat";
        LoggerFile loggerFile = new LoggerFile ();
        List fileList = loggerFile.findFileWithMask (dirName, mask);
        System.out.println ("*********************************************");
        System.out.println ("Files with mask : " + " >>> " +  mask + "<<<");
        Iterator fileIterator = fileList.iterator ();
        while (fileIterator.hasNext ())  {
            System.out.println (fileIterator.next ());
        }
    }
    */
}
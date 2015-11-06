package bin.log;

import bin.bank.Bank;
import bin.client.Client;

import java.io.*;
import java.util.Iterator;
import java.util.List;

public class LoggerFile implements Serializable {
    Bank bank;
    List<Client> clientsList;
    String fileName = "clientList.dat";
    public LoggerFile () {
        bank = Bank.getBank ();
        clientsList = bank.getClientsList ();
    }

    public void saveClientListToFile () {
        Iterator <Client> clientIterator = clientsList.iterator ();

        FileOutputStream outFile = null;
            try {
                outFile = new FileOutputStream (fileName);
            } catch (FileNotFoundException e) {
                e.printStackTrace ();
            }

            ObjectOutputStream oos = null;
            try {
                oos = new ObjectOutputStream (outFile);

            } catch (IOException e) {
                e.printStackTrace ();
            }

            try {
                if (oos != null) {
                   oos.writeObject (clientsList + "\n");
                }
            } catch (IOException e) {
                e.printStackTrace ();
            }
           finally {
                try {
                    oos.close ();
                } catch (IOException e) {
                    e.printStackTrace ();
                }
            }
        }

   public  void readClienListFromFile(String fileName) {
       FileInputStream  fis = null;
       try {
            fis = new FileInputStream (fileName);
       } catch (FileNotFoundException e) {
           e.printStackTrace ();
       }
       ObjectInputStream ois = null;
       try {
           ois = new ObjectInputStream (fis);
       } catch (IOException e) {
           e.printStackTrace ();
       }
       try {
           assert ois != null;
           System.out.println (ois.readObject ());
       } catch (IOException | ClassNotFoundException e) {
           e.printStackTrace ();
       }
   }
}

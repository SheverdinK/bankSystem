package bin.log;

import bin.bank.Bank;
import bin.client.Client;

import java.io.*;
import java.util.ArrayList;
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
        Iterator<Client> clientIterator = clientsList.iterator ();

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
        } finally {
            try {
                assert oos != null;
                oos.close ();
            } catch (IOException e) {
                e.printStackTrace ();
            }
        }
    }

    public void readClientListFromFile (String fileName) {
        FileInputStream fis = null;
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

    public void findDirAndFile (String dirName) {
        int dirCount = 0;
        int fileCount = 0;
        File file = new File (dirName);
        if (file.isDirectory ()) {

            File[] fileList = file.listFiles ();
            assert fileList != null;
            System.out.println ("fileList Length = " + fileList.length);
            for (int i = 0; i < fileList.length; i++) {
                if (fileList[i].isDirectory ()) {
                    System.out.println ("i=" + i + " fileList : " + fileList[i].getName () + " dir");
                    dirCount++;
                } else if (fileList[i].isFile ()) {
                    System.out.println ("i=" + i + " fileList : " + fileList[i].getName () + " file");
                    fileCount++;
                }
            }

            System.out.println ("dirCount = " + dirCount);
            System.out.println ("fileCount = " + fileCount);
        }

    }


    /*
    public void findFileWithMask (String dirName, String mask) {
        File file = new File(dirName);
        FilenameFilter filter = new FilenameFilter(){

            @Override
            public boolean accept(File dir, String name){
                System.out.println ("Name indexOF Mask = "  + name.indexOf(mask));
                if (name.indexOf(mask) > 0)
                    return true;
                else
                    return false;
            }
        };
        File[] files = file.listFiles(filter);
        for(int i=0; i<files.length; i++){
            System.out.println ("Name : " + files[i].getName ());
        }
    }
    */

   /* public void findFileWithMask (String dirName, String mask) {
        File file = new File(dirName);
        FilenameFilter filter = (dir, name) -> {
            if (name.indexOf(mask) > 0)
                return true;
            else
                return false;
        };
        File[] files = file.listFiles(filter);
        for(int i=0; i<files.length; i++){
            System.out.println("AbsolutPath : " + files[i].getAbsolutePath());
            System.out.println ("Name : " + files[i].getName ());
        }
    }*/


    public List<String> findFileWithMask (String dirName, String mask) {
        File file = new File(dirName);
        List<String> fileList = new ArrayList<> ();
        File[] files = file.listFiles();
        assert files != null;
        for (File fileIndex : files) {
            System.out.println ("Name : " + fileIndex.getName ());
            if (fileIndex.getName ().indexOf (mask) > 0)
                fileList.add (fileIndex.getName ());
        }
        return  fileList;
    }
}
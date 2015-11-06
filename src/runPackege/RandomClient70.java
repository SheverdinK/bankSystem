/** all right received  @ Sheverdin Konstantin  */

package runPackege;

import bin.bank.Bank;
import bin.client.Client;
import myLabrairy.Util;

import static java.lang.System.out;

public class RandomClient70 {

    public void setRandomClient(Bank bank) {

        Util util = new Util ();

        String [] nameArr = {"qqq", "www", "eee", "rrr", "ttt", "fff", "yyy" ,"uuu", "iii", "ooo",
                "ppp", "aaa", "sss", "ddd", "fff", "ggg", "jjj", "kkk", "lll", "zzz",
                "xxx", "ccc", "vvv", "bbb", "nnn", "mmm", };
        out.println ("****************   Adding Client Random *******************************************");
        for (int j=0; j<70; j++) {
            int id = util.getRandomNum (300000000, 899999999);
            int index = util.getRandomNum (0,25);      // get a random String from nameArr
            float balance = util.getRandomNum (100, 1000000);

            Client client = util.setTypeOfClient (id, nameArr[index], balance);

            bank.addClient (client);
        }

    }
}






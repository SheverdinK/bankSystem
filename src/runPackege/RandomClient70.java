/** all right received  @ Sheverdin Konstantin  */

package runPackege;

import bin.bank.Bank;
import bin.client.Client;
import bin.client.Gold;
import bin.client.Platinum;
import bin.client.Regular;
import myLabrairy.MyUtil;

import static java.lang.System.out;

public class RandomClient70 {

    public void setRandomClient(Bank bank) {

        MyUtil myUtil = new MyUtil ();

        String [] nameArr = {"qqq", "www", "eee", "rrr", "ttt", "fff", "yyy" ,"uuu", "iii", "ooo",
                "ppp", "aaa", "sss", "ddd", "fff", "ggg", "jjj", "kkk", "lll", "zzz",
                "xxx", "ccc", "vvv", "bbb", "nnn", "mmm", };
        out.println ("****************   Adding Client Random *******************************************");
        for (int j=0; j<70; j++) {

            int i = myUtil.getRandomNum (0,99);           // get a random  index to fill the Client Array
            int id = myUtil.getRandomNum (300000000, 899999999);
            int index = myUtil.getRandomNum (0,25);      // get a random String from nameArr
            float balance = myUtil.getRandomNum (100, 1000000);

            Client client = myUtil.getTypeOfClient (id,  nameArr[index],  balance);

            bank.addClient (client, i);
        }

    }
}






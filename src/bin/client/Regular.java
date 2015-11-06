/** all right received  @ Sheverdin Konstantin  */

package bin.client;


import java.io.Serializable;

public class Regular extends  Client implements Serializable {

    private static final float commissionRateRate = 0.03f;  // 3 %
    private static final float dailyIR = 0.001f;       // 0.1 %

   /* public Regular (int id, int nId){
        super (id, nId);
    }*/
    public Regular (int id, String name, float balance) {
        super( id, name, balance);
    }

    /*@Override
    public String toString () {
        return "Client Type : " + getClass ().getName () + "  ID : " + getId () ;
    }*/
}


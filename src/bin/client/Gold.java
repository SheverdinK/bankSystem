/** all right received  @ Sheverdin Konstantin  */

package bin.client;

public class Gold extends  Client {

    private final float commissionRate = 0.02f;    // 2 %
    private final float dailyIR = 0.003f;         // 0.3 %

    public Gold (int id,int nId)  {
        super (id, nId);
    }
    public Gold (int id, String name, float balance) {
        super( id, name, balance);
    }

    /*@Override
    public String toString () {
        return "Client Type : " + getClass ().getName () + "  ID : " + getId () ;
    }*/

}


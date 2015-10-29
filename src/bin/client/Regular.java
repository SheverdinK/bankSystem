/** all right received  @ Sheverdin Konstantin  */

package bin.client;


public class Regular extends  Client {

    private static final float comissionRate = 0.03f;  // 3 %
    private static final float dailyIR = 0.001f;       // 0.1 %

    public Regular (int id) {
        super (id);
    }
    public Regular (int id, String name, float balance) {
        super( id, name, balance);
    }

    /*@Override
    public String toString () {
        return "Client Type : " + getClass ().getName () + "  ID : " + getId () ;
    }*/
}


/* all right received  @ Sheverdin Konstantin*/

package bin.client;

public class Platinum extends  Client {

    private final float comissionRate = 0.01f;  // 1 %
    private final float dailyIR = 0.005f;       // 0.5 %

    public Platinum (int id, int nId ) throws Exception {
        super (id, nId);
    }

    public Platinum (int id, String name, float balance) {
        super( id,  name,  balance);
    }

    /*@Override
    public String toString () {
        return "  Client Type : " + getClass().getName() + "  ID : " + getId ();
    }*/
}

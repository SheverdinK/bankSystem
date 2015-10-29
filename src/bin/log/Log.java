/** all right received  @ Sheverdin Konstantin  */

package bin.log;

public class Log {

    private static int clientId;
    private static String description;
    private static float amount;
    private static  String clientType;
//    public long timeStamp;

    /*public  Log (int clientId, String description,float amount ) {
        this.clientId = clientId;
        this.description = description;
        this.amount = amount;
    }*/

    public static int getClientId () {
        return clientId;
    }
    public static void setClientId (int clientId) {
        Log.clientId = clientId;
    }
    public static String getDescription () {
        return description;
    }
    public static String getClientType () {
        return clientType;
    }
    public static float getAmount () {
        return amount;
    }

    static public String getData(int clientId, String description, float amount, String clientType) {

        setClientId(clientId);
        setDescription(description);
        setAmount(amount);
        setClientType(clientType);

        return "Client ID:  >>" + getClientId()
                + "<<  Description: >>" + getDescription()
                + "<<   amount:  >>" + getAmount() + "<<"
                + "Type of Client is : " + getClientType();
    }

    public static void setDescription (String description) {
        Log.description = description;
    }
    public static void setAmount (float amount) {
        Log.amount = amount;
    }
    public static void setClientType (String clientType) {
        Log.clientType = clientType;
    }
}

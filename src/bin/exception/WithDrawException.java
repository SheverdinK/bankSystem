package bin.exception;

public class WithDrawException extends  Exception{
    private int clientID;
    private float currentBalance;
    private float withdrawAmount;

    public WithDrawException (String message, int clientID, float currentBalance, float withdrawAmount) {
        super (message);
        this.clientID = clientID;
        this.currentBalance = currentBalance;
        this.withdrawAmount = withdrawAmount;
    }

    public int getClientID () {
        return clientID;
    }

    public float getCurrentBalance () {
        return currentBalance;
    }

    public float getWithdrawAmount () {
        return withdrawAmount;
    }
}

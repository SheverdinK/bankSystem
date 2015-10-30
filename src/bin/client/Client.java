/** all right received  @ Sheverdin Konstantin  */

package bin.client;

import bin.log.Log;

public abstract class Client {
    public Account[] accountArr = new Account[5];
    protected int id;
    private String name;
    private float balance;

    public Client (int id){
        this.id = id;
    }

    public Client (int id, int nId)  {
//        MyUtil myUtil = new MyUtil ();

//        if ( myUtil.isId (id,nId)) {
        this.id = id;
//            System.out.println ("id = " +this.id);
//        } else {
//           throw new Exception (">>>>>>>> Wrong ID. Try again!!! <<<<<<<<<<<<<<<");
//        }
    }

    public Client (int id, String name, float balance) {
        this.id = id;
        setName (name);
        setBalance (balance);
    }

    public int     getId () {
        return id;
    }
    public float   getBalance () {
        return balance;
    }
    public String  getName () {
        return name;
    }
    public Account getAccount ( int index){
        if (accountArr[index] != null) return accountArr[index];
        else return null;
    }

    public void setName (String name) {
        this.name = name;
    }
    public void setBalance (float balance) {
        this.balance = balance;
    }

    public void addAccount (Account account) {
        System.out.println("***IN addAccount**** id = " + id);

        int numberOfAccount = 5;
        for (int i = 0; i < accountArr.length; i++) {     // Loop to find the Account is NULL
            if (accountArr[i] == null) {
                accountArr[i] = new Account (account.getId (), account.getBalance ());
                String descriptionAccount = "ACCOUNT ADDED ";
                System.out.println (Log.getData (accountArr[i].getId (),
                        descriptionAccount ,
                        accountArr[i].getBalance (),
                        getClass ().getSimpleName ()));
                numberOfAccount = numberOfAccount -1;
                break;
            }
        }
        if (numberOfAccount == 0 || numberOfAccount == 5)  {
            System.out.println (" ***ERROR*** --- You Have already 5  Accounts");
        }
    }
    public void removeAccount ( Account account){

        System.out.println ("ACCOUNT REMOVED");
    }

    @Override
    public boolean equals (Object obj) {
        if (obj instanceof  Client){
            Client client = (Client) obj;
            if (this.getId() == client.getId() )
                return  true;
        }
        return  false;
    }

    @Override
    public String toString () {
        return "Client { "
                + "  id= "  + getId ()
                + ", name= " + getName ()
                + ", balance= " + getBalance ()
                + ", Type of Client is :" + getClass().getSimpleName () +  "}";
    }
}


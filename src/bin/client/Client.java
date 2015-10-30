/** all right received  @ Sheverdin Konstantin  */

package bin.client;

import bin.bank.Bank;
import myLabrairy.MyUtil;

import static java.lang.System.out;

public abstract class Client {
    public Account[] accountArr = new Account[5];
    protected int id;
    private String name;
    private float balance;

    public Client (int id, int nId) throws Exception {
        MyUtil myUtil = new MyUtil ();
        if ( myUtil.isId (id,nId)) {
            this.id = id;
            System.out.println ("id = " +this.id);
        } else {
           throw new Exception (">>>>>>>> Wrong ID. Try again!!! <<<<<<<<<<<<<<<");
        }
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
        return accountArr[index] != null ? accountArr[index] : null;
    }

    public void setName (String name) {
        this.name = name;
    }
    public void setBalance (float balance) {
        this.balance = balance;
    }

    public void addAccount (Account account) {
        Bank bank = Bank.getBank ();
        Client[] clients = bank.getClients ();
        MyUtil myUtil = new MyUtil ();

        System.out.println("***IN addAccount**** id = " + id);
        int i = 0;
        while (i < clients.length) {                                             // Loop to find the client with ID
            if (clients[i] != null) {
                if (clients[i].getId () == id) {
                    int index = i;
                    out.println ("Client is Found: index =  " + index);
                    int numberOfAccount = 0;                                     // Loop to find the Account not NULL
                    for (int j = 0; j < clients[i].accountArr.length; j++) {
                        if (clients[index].accountArr[j] == null) {
                            out.println ("Check is accountArr is NULL");
                            out.println ("j = " + j);
//                            clients[index].accountArr[j] = new Account (0, 0);
                            clients[index].accountArr[j] = new Account (account.getId (), account.getBalance ());
                            String discriptionAccount = "ACCOUNT ADDED ";
                            /*Log logAccount = new Log (account.getId (), discriptionAccount, account.getBalance ());
                            out.println (logAccount.getData ());*/
                            numberOfAccount = j + 1;
                            j = clients[i].accountArr.length;
                        }
                    }
                    if (numberOfAccount == 0 || numberOfAccount == 5)
                        out.println (" ***ERROR*** --- You Have already 5  Accounts");
                    i = clients.length;
                } else i++;
            } else i++;
        }
    }
    public void removeAccount ( Client client){
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
                + ", Type of Client is :" + getClass().getName() +  "}";
    }
}


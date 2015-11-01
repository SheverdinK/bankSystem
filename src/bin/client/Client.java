/** all right received  @ Sheverdin Konstantin  */

package bin.client;

import java.util.ArrayList;
import java.util.List;

public abstract class Client {
    int ensureCapacity = 5;
   List <Account> accountList = new ArrayList<> (ensureCapacity);

    protected int id;
    private String name;
    private float balance;

    public Client (int id){
        this.id = id;
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

    public void setName (String name) {
        this.name = name;
    }
    public void setBalance (float balance) {
        this.balance = balance;
    }

    public void addAccount (Account account) {
        if (accountList.size () < ensureCapacity) {
            accountList.add (account);
        }
        else {
            System.out.println ("SIZE IS " + accountList.size ());
        }
    }
    public void removeAccount ( Account account){
        accountList.remove (account);
        System.out.println ("ACCOUNT REMOVED");
    }

    public List <Account> getAccountList () {
        return accountList;
    }
    public void printAccountList (){
        int i=1;
        for (Account account: accountList) {

            System.out.println (i++ +""+ account);
        }
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
        return
                  " ID =   >> "     + getId ()                     + " <<"
                + " name = >> "     + getName ()                   + " <<"
                + " balance = >> "  + getBalance ()                + " <<"
                + " Type:  >>"      + getClass().getSimpleName ()  + " <<\n";
    }
}


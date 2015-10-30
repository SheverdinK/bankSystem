/** all right received  @ Sheverdin Konstantin  */

package bin.client;


public class Account {

	private  int id;
	private float balance;

	public Account (int id) {
		this.id = id;
	}

	public Account(int id, float balance) {
		this.id = id;
		setBalance (balance);
	}

	public float getBalance () {
		return balance;
	}
	public int getId () {
		return id;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	@Override
	public boolean equals (Object obj) {
		if (obj instanceof  Account){
			Account account = (Account) obj;
			if (this.getId() == account.getId() )
				return  true;
		}
		return  false;
	}



}

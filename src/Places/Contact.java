package Places;

import java.io.Serializable;

/**
* <h1>El�rhet�s�g</h1>
* Az el�rhet�s�g oszt�lya.
* <p>
*
* @author  Csord�s M�rk
* @version 1.0
* @since   2017-10-15
*/

public class Contact implements Serializable{
	private Address addr;		//C�m, b�vebben: Address class
	private String phonenumb;	//Telefonsz�m
	private String email;		//E-Mail c�m
	private String web;			//Weboldal
	
	/**
	 * Egy kapcsolatot l�trehoz� konstruktor.
	 * @param addr C�m
	 * @param phonenumb Telefonsz�m
	 * @param email E-mail c�m
	 * @param web Weboldal
	 */
	public Contact(Address addr, String phonenumb, String email, String web) {
		super();
		this.addr = addr;
		this.phonenumb = phonenumb;
		this.email = email;
		this.web = web;
	}

	public Address getAddr() {
		return addr;
	}
	public void setAddr(Address addr) {
		this.addr = addr;
	}
	public String getPhonenumb() {
		return phonenumb;
	}
	public void setPhonenumb(String phonenumb) {
		this.phonenumb = phonenumb;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getWeb() {
		return web;
	}
	public void setWeb(String web) {
		this.web = web;
	}

	/**
	 * A toString() met�dus fel�ldefini�l�sa. Kii�r egy kapcsolatot.
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "C�m: " + addr + "\n" +
				"Telefonsz�m: " + phonenumb + "\n" +
				"E-Mail: " + email + "\n" +
				"Web: " + web + "\n" ;
	}		
}
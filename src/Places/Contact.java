package Places;

import java.io.Serializable;

/**
* <h1>Elérhetõség</h1>
* Az elérhetõség osztálya.
* <p>
*
* @author  Csordás Márk
* @version 1.0
* @since   2017-10-15
*/

public class Contact implements Serializable{
	private Address addr;		//Cím, bõvebben: Address class
	private String phonenumb;	//Telefonszám
	private String email;		//E-Mail cím
	private String web;			//Weboldal
	
	/**
	 * Egy kapcsolatot létrehozó konstruktor.
	 * @param addr Cím
	 * @param phonenumb Telefonszám
	 * @param email E-mail cím
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
	 * A toString() metódus felüldefiniálása. Kiiír egy kapcsolatot.
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Cím: " + addr + "\n" +
				"Telefonszám: " + phonenumb + "\n" +
				"E-Mail: " + email + "\n" +
				"Web: " + web + "\n" ;
	}		
}
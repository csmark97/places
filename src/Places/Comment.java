package Places;

import java.io.Serializable;

/**
* <h1>Komment</h1>
* A kommentek osztálya.
* <p>
*
* @author  Csordás Márk
* @version 1.0
* @since   2017-10-15
*/

public class Comment implements Serializable{
	private Place place = new Place();
	private Account acc = new Account();
	private String comment;
	
	/**
	 * Egy kommentet létrehozó konstruktor.
	 * @param plc A hely, amihez hozzá akarjuk adni a kommentet.
	 * @param acc A fiók, aki által hozzá akarjuk adni a kommentet.
	 * @param comment A komment szövege.
	 */
	public Comment(Place plc, Account acc, String comment) {
		super();
		this.place = plc;
		this.acc = acc;
		this.comment = comment;
	}
	
	/**
	 * Kommentet létrehozó egyparamtéres konstruktor.
	 * @param comment Komment szövege.
	 */
	public Comment(String comment) {
		this.comment = comment;
	}
	
	public Place getPlace() {
		return place;
	}
	public void setPlace(Place plc) {
		this.place = plc;
	}
	public Account getAcc() {
		return acc;
	}
	public void setAcc(Account acc) {
		this.acc = acc;
	}
	public String getComement() {
		return comment;
	}
	public void setComement(String comement) {
		this.comment = comement;
	}

	/**
	 * A toString() metódus felüldefiniálása. Kiír egy kommentet.
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Írta: " + acc.getFelhaszn().toString() + '\n' + comment + '\n' + '\n';
	}	
}

package Places;

import java.io.Serializable;

/**
* <h1>Komment</h1>
* A kommentek oszt�lya.
* <p>
*
* @author  Csord�s M�rk
* @version 1.0
* @since   2017-10-15
*/

public class Comment implements Serializable{
	private Place place = new Place();
	private Account acc = new Account();
	private String comment;
	
	/**
	 * Egy kommentet l�trehoz� konstruktor.
	 * @param plc A hely, amihez hozz� akarjuk adni a kommentet.
	 * @param acc A fi�k, aki �ltal hozz� akarjuk adni a kommentet.
	 * @param comment A komment sz�vege.
	 */
	public Comment(Place plc, Account acc, String comment) {
		super();
		this.place = plc;
		this.acc = acc;
		this.comment = comment;
	}
	
	/**
	 * Kommentet l�trehoz� egyparamt�res konstruktor.
	 * @param comment Komment sz�vege.
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
	 * A toString() met�dus fel�ldefini�l�sa. Ki�r egy kommentet.
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "�rta: " + acc.getFelhaszn().toString() + '\n' + comment + '\n' + '\n';
	}	
}

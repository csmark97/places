package Places;
import java.io.Serializable;


/**
* <h1>Hely</h1>
* A helyek oszt�lya.
* <p>
*
* @author  Csord�s M�rk
* @version 1.0
* @since   2017-10-15
*/

public class Place implements Serializable {
	private String name;			//A hely neve
	private Contact cntct;			//El�rhet�s�g, b�vebben: Contact oszt�ly
	private Opening opening;		//Nyitvatart�s, b�vebben: Opening oszt�ly
	private PlaceType type;			//A hely t�pusa, b�vebben: Type enum
	private Account tulajdonos;		//A hely tulajdonosa
	
	private double rating;			//A hely �rt�kel�se 
	private int countofratings;
	
	public Place() {}
	
	/**
	 * L�trehoz egy csak n�vvel ell�tott helyet.
	 * @param name A hely neve.
	 */
	public Place(String name) {
		this.name = name;
	}
	
	/**
	 * L�trehoz egy helyet, minden attributum�val.
	 * @param name A hely neve.
	 * @param cntct A hely el�rhet�s�ge.
	 * @param opening A hely niytvatart�sa.
	 * @param type A hely t�pusa.
	 * @param acc A hely tulajdonos�nak felhaszn�l�i fi�kja.
	 */
	public Place(String name, Contact cntct, Opening opening, PlaceType type, Account acc) {
		super();
		this.name = name;
		this.cntct = cntct;
		this.opening = opening;
		this.type = type;
		this.tulajdonos = acc;
		rating = 0;
		countofratings = 0;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Contact getCntct() {
		return cntct;
	}
	public void setCntct(Contact cntct) {
		this.cntct = cntct;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}	
	public Opening getOpening() {
		return opening;
	}
	public void setOpening(Opening opening) {
		this.opening = opening;
	}
	public PlaceType getType() {
		return type;
	}
	public void setType(PlaceType type) {
		this.type = type;
	}
	
	public Account getTulajdonos() {
		return tulajdonos;
	}

	public void setTulajdonos(Account tulajdonos) {
		this.tulajdonos = tulajdonos;
	}

	public int getCountofratings() {
		return countofratings;
	}

	public void setCountofratings(int countofratings) {
		this.countofratings = countofratings;
	}

	/**
	 * A toString() met�dus fel�ldefini�l�sa. Ki�rja egy hely �sszes adat�t.
	 * �ltal�ban nincs erre sz�ks�g. De a fejleszt�s sor�n j� ellen�rz�si lehet�s�g.
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name + "\n\n" + 
				cntct + "\n" + 
				opening + "\n" + 
				type + "\n";
	}
		
}
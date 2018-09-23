package Places;
import java.io.Serializable;


/**
* <h1>Hely</h1>
* A helyek osztálya.
* <p>
*
* @author  Csordás Márk
* @version 1.0
* @since   2017-10-15
*/

public class Place implements Serializable {
	private String name;			//A hely neve
	private Contact cntct;			//Elérhetõség, bõvebben: Contact osztály
	private Opening opening;		//Nyitvatartás, bõvebben: Opening osztály
	private PlaceType type;			//A hely típusa, bõvebben: Type enum
	private Account tulajdonos;		//A hely tulajdonosa
	
	private double rating;			//A hely értékelése 
	private int countofratings;
	
	public Place() {}
	
	/**
	 * Létrehoz egy csak névvel ellátott helyet.
	 * @param name A hely neve.
	 */
	public Place(String name) {
		this.name = name;
	}
	
	/**
	 * Létrehoz egy helyet, minden attributumával.
	 * @param name A hely neve.
	 * @param cntct A hely elérhetõsége.
	 * @param opening A hely niytvatartása.
	 * @param type A hely típusa.
	 * @param acc A hely tulajdonosának felhasználói fiókja.
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
	 * A toString() metódus felüldefiniálása. Kiírja egy hely összes adatát.
	 * Általában nincs erre szükség. De a fejlesztés során jó ellenõrzési lehetõség.
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
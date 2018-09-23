package Places;
import java.io.Serializable;
import java.time.LocalTime;

/**
* <h1>Nyivatartás</h1>
* A nyitvatartás tárolását segítõ osztály.
* <p>
*
* @author  Csordás Márk
* @version 1.0
* @since   2017-10-15
*/

public class Opening implements Serializable{	
	private MyTime mondayA;
	private MyTime mondayB;
	private MyTime tuesdayA;
	private MyTime tuesdayB;
	private MyTime wednesdayA;
	private MyTime wednesdayB;
	private MyTime thursdayA;
	private MyTime thursdayB;
	private MyTime fridayA;
	private MyTime fridayB;
	private MyTime saturdayA;
	private MyTime saturdayB;
	private MyTime sundayA;
	private MyTime sundayB;
	
	/**
	 * Nyitvatartást beállító konstruktor.
	 * @param mondayA Hétfõn ettõl az idõponttól van nyitva.
	 * @param mondayB Hétfõn ettõl az idõponttól van zárva.
	 * @param tuesdayA Kedden ettõl az idõponttól van nyitva. 
	 * @param tuesdayB Kedden ettõl az idõponttól van zárva.
	 * @param wednesdayA Szerdán ettõl az idõponttól van nyitva. 
	 * @param wednesdayB Szerdán ettõl az idõponttól van zárva.
	 * @param thursdayA Csütörtökön ettõl az idõponttól van nyitva.
	 * @param thursdayB Csütörtökön ettõl az idõponttól van zárva.
	 * @param fridayA Pénteken ettõl az idõponttól van nyitva.
	 * @param fridayB Pénteken ettõl az idõponttól van zárva.
	 * @param saturdayA Szombaton ettõl az idõponttól van nyitva.
	 * @param saturdayB Szombaton ettõl az idõponttól van zárva.
	 * @param sundayA Vasárnap ettõl az idõponttól van nyitva.
	 * @param sundayB Vasárnap ettõl az idõponttól van zárva.
	 */
	public Opening(MyTime mondayA, MyTime mondayB, MyTime tuesdayA, MyTime tuesdayB, MyTime wednesdayA,
			MyTime wednesdayB, MyTime thursdayA, MyTime thursdayB, MyTime fridayA, MyTime fridayB, MyTime saturdayA,
			MyTime saturdayB, MyTime sundayA, MyTime sundayB) {
		super();
		this.mondayA = mondayA;
		this.mondayB = mondayB;
		this.tuesdayA = tuesdayA;
		this.tuesdayB = tuesdayB;
		this.wednesdayA = wednesdayA;
		this.wednesdayB = wednesdayB;
		this.thursdayA = thursdayA;
		this.thursdayB = thursdayB;
		this.fridayA = fridayA;
		this.fridayB = fridayB;
		this.saturdayA = saturdayA;
		this.saturdayB = saturdayB;
		this.sundayA = sundayA;
		this.sundayB = sundayB;
	}

	public MyTime getMondayA() {
		return mondayA;
	}
	public void setMondayA(MyTime mondayA) {
		this.mondayA = mondayA;
	}
	public MyTime getMondayB() {
		return mondayB;
	}
	public void setMondayB(MyTime mondayB) {
		this.mondayB = mondayB;
	}
	public MyTime getTuesdayA() {
		return tuesdayA;
	}
	public void setTuesdayA(MyTime tuesdayA) {
		this.tuesdayA = tuesdayA;
	}
	public MyTime getTuesdayB() {
		return tuesdayB;
	}
	public void setTuesdayB(MyTime tuesdayB) {
		this.tuesdayB = tuesdayB;
	}
	public MyTime getWednesdayA() {
		return wednesdayA;
	}
	public void setWednesdayA(MyTime wednesdayA) {
		this.wednesdayA = wednesdayA;
	}
	public MyTime getWednesdayB() {
		return wednesdayB;
	}
	public void setWednesdayB(MyTime wednesdayB) {
		this.wednesdayB = wednesdayB;
	}
	public MyTime getThursdayA() {
		return thursdayA;
	}
	public void setThursdayA(MyTime thursdayA) {
		this.thursdayA = thursdayA;
	}
	public MyTime getThursdayB() {
		return thursdayB;
	}
	public void setThursdayB(MyTime thursdayB) {
		this.thursdayB = thursdayB;
	}
	public MyTime getFridayA() {
		return fridayA;
	}
	public void setFridayA(MyTime fridayA) {
		this.fridayA = fridayA;
	}
	public MyTime getFridayB() {
		return fridayB;
	}
	public void setFridayB(MyTime fridayB) {
		this.fridayB = fridayB;
	}
	public MyTime getSaturdayA() {
		return saturdayA;
	}
	public void setSaturdayA(MyTime saturdayA) {
		this.saturdayA = saturdayA;
	}
	public MyTime getSaturdayB() {
		return saturdayB;
	}
	public void setSaturdayB(MyTime saturdayB) {
		this.saturdayB = saturdayB;
	}
	public MyTime getSundayA() {
		return sundayA;
	}
	public void setSundayA(MyTime sundayA) {
		this.sundayA = sundayA;
	}
	public MyTime getSundayB() {
		return sundayB;
	}
	public void setSundayB(MyTime sundayB) {
		this.sundayB = sundayB;
	}

	/**
	 * A toString() metódus felüldefiniálása. Kiír egy niytvatartást. 	
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return  mondayA + " - " + mondayB + "\n" +
		tuesdayA + " - " + tuesdayB + "\n" +
		wednesdayA + " - " + wednesdayB + "\n" +
		thursdayA + " - " + thursdayB + "\n" +
		fridayA + " - " + fridayB + "\n" +
		saturdayA + " - " + saturdayB + "\n" +
		sundayA + " - " + sundayB + "\n"
				;
	}	
}
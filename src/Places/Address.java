package Places;

import java.io.Serializable;

/**
* <h1>Cím</h1>
* A címekhez szükséges osztály.
* <p>
*
* @author  Csordás Márk
* @version 1.0
* @since   2017-10-15
*/

public class Address implements Serializable{
	private int zip;			//Irányitószám
	private String city;		//Város
	private String street;		//Utca
	private int hnumber;		//Házszám
	
	/**
	 * Egy címet létrehozó konstruktor.
	 * @param zip Irányítószám
	 * @param city Város
	 * @param street Utca 
	 * @param hnumber Házszám
	 */
	public Address(int zip, String city, String street, int hnumber) {
		super();
		this.zip = zip;
		this.city = city;
		this.street = street;
		this.hnumber = hnumber;
	}	

	public int getZip() {
		return zip;
	}
	public void setZip(int zip) {
		this.zip = zip;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public int getHnumber() {
		return hnumber;
	}
	public void setHnumber(int hnumber) {
		this.hnumber = hnumber;
	}
	
	/**
	 * toString() metódus felüldefiniálása. Kiír egy címet.
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return zip + " " + city + ", " + street + " " + hnumber + ".";
	}
	
	
}
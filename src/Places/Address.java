package Places;

import java.io.Serializable;

/**
* <h1>C�m</h1>
* A c�mekhez sz�ks�ges oszt�ly.
* <p>
*
* @author  Csord�s M�rk
* @version 1.0
* @since   2017-10-15
*/

public class Address implements Serializable{
	private int zip;			//Ir�nyit�sz�m
	private String city;		//V�ros
	private String street;		//Utca
	private int hnumber;		//H�zsz�m
	
	/**
	 * Egy c�met l�trehoz� konstruktor.
	 * @param zip Ir�ny�t�sz�m
	 * @param city V�ros
	 * @param street Utca 
	 * @param hnumber H�zsz�m
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
	 * toString() met�dus fel�ldefini�l�sa. Ki�r egy c�met.
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return zip + " " + city + ", " + street + " " + hnumber + ".";
	}
	
	
}
package Places;

import java.io.Serializable;

/**
* <h1>Felhasználói fiók</h1>
* A felhasználói fiók osztályának megvalósítása.
* Felhasználói fiók a következõkbõl áll: felhasználó név, jelszó, teljes név, e-mail cím és a fiók típusa.
* <p>
*
* @author  Csordás Márk
* @version 1.0
* @since   2017-10-15
*/

public class Account implements Serializable {
	private String felhaszn;
	private String jlsz;
	private String name;
	private String email;
	private AccType tipus;
	
	public Account(){	}
	
	/**
	 * Néha szükségünk lehet csak átmeneti felhasználói fiókokra.
	 * Például összehasonlítás stb. Ennek a konstruktornak elég csak egy felhasználói nevet és jelszót adnunk.
	 * Természetesen a program használói, a felhasználók nem hozhatnak létre ilyen "fél" fiókokat.
	 * @param felhaszn Felhasználói név.
	 * @param jlsz Jelszó.
	 */
	public Account(String felhaszn, String jlsz) {
		super();
		this.felhaszn = felhaszn;
		this.jlsz = jlsz;
	}
	
	/**
	 * Egy felhasználói fiókot létrehozó konstruktor.
	 * @param felhaszn Felhasználói név.
	 * @param jlsz Jelszó.
	 * @param name Név.
	 * @param email A személy e-mail címe.
	 * @param tipus A személy típusa.
	 */
	public Account(String felhaszn, String jlsz, String name, String email, AccType tipus) {
		super();
		this.felhaszn = felhaszn;
		this.jlsz = jlsz;
		this.name = name;
		this.email = email;
		this.tipus = tipus;
	}

	public String getFelhaszn() {
		return felhaszn;
	}
	public void setFelhaszn(String felhaszn) {
		this.felhaszn = felhaszn;
	}
	public String getJlsz() {
		return jlsz;
	}
	public void setJlsz(String jlsz) {
		this.jlsz = jlsz;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public AccType getTipus() {
		return tipus;
	}
	public void setTipus(AccType tipus) {
		this.tipus = tipus;
	}

	/**
	 * A toString() metódus felüldefiniálása. Kiír egy teljes felhasználói fiókot.
	 * A programban soha ne írjunk ki egész fiókot, ugyanis tartalmazza a jelszót is!
	 * A fejlesztés során viszont ellenõrzés szempontjából jól jöhet. 
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return felhaszn + "\n" + jlsz + "\n" 
				+ name + "\n" + email + "\n" + tipus + "\n\n";		
	}		
}

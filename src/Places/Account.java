package Places;

import java.io.Serializable;

/**
* <h1>Felhaszn�l�i fi�k</h1>
* A felhaszn�l�i fi�k oszt�ly�nak megval�s�t�sa.
* Felhaszn�l�i fi�k a k�vetkez�kb�l �ll: felhaszn�l� n�v, jelsz�, teljes n�v, e-mail c�m �s a fi�k t�pusa.
* <p>
*
* @author  Csord�s M�rk
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
	 * N�ha sz�ks�g�nk lehet csak �tmeneti felhaszn�l�i fi�kokra.
	 * P�ld�ul �sszehasonl�t�s stb. Ennek a konstruktornak el�g csak egy felhaszn�l�i nevet �s jelsz�t adnunk.
	 * Term�szetesen a program haszn�l�i, a felhaszn�l�k nem hozhatnak l�tre ilyen "f�l" fi�kokat.
	 * @param felhaszn Felhaszn�l�i n�v.
	 * @param jlsz Jelsz�.
	 */
	public Account(String felhaszn, String jlsz) {
		super();
		this.felhaszn = felhaszn;
		this.jlsz = jlsz;
	}
	
	/**
	 * Egy felhaszn�l�i fi�kot l�trehoz� konstruktor.
	 * @param felhaszn Felhaszn�l�i n�v.
	 * @param jlsz Jelsz�.
	 * @param name N�v.
	 * @param email A szem�ly e-mail c�me.
	 * @param tipus A szem�ly t�pusa.
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
	 * A toString() met�dus fel�ldefini�l�sa. Ki�r egy teljes felhaszn�l�i fi�kot.
	 * A programban soha ne �rjunk ki eg�sz fi�kot, ugyanis tartalmazza a jelsz�t is!
	 * A fejleszt�s sor�n viszont ellen�rz�s szempontj�b�l j�l j�het. 
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return felhaszn + "\n" + jlsz + "\n" 
				+ name + "\n" + email + "\n" + tipus + "\n\n";		
	}		
}

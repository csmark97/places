package Places;

import java.io.Serializable;

/**
* <h1>Idõ</h1>
* A saját idõ típusom osztálya.
* <p>
*
* @author  Csordás Márk
* @version 1.0
* @since   2017-10-15
*/

public class MyTime implements Serializable{
	int h;
	int m;
	
	public MyTime() {}
	
	/**
	 * Egy idõt beállító konstruktor.
	 * @param h Óra
	 * @param m Perc
	 */
	public MyTime(int h, int m) {
		super();
		this.h = h;
		this.m = m;
	}
	
	public int getH() {
		return h;
	}
	public void setH(int h) {
		this.h = h;
	}
	public int getM() {
		return m;
	}
	public void setM(int m) {
		this.m = m;
	}
	
	/**
	 * Leteszteli a formátum helyességét.
	 * @param ido A beállítandó idõ sztringje.
	 * @return true/false Visszaadja, hogy helyes-e a megadott formátum.
	 */
	public boolean isOkay(String ido) {
		if (ido.length() == 5) {
			char o1 = ido.charAt(0);
			char o2 = ido.charAt(1);
			char m1 = ido.charAt(3);
			char m2 = ido.charAt(4);
			StringBuilder oraSB = new StringBuilder();
			String ora;
			oraSB.append(o1);
			oraSB.append(o2);
			ora = oraSB.toString();
			
			StringBuilder percSB = new StringBuilder();
			String perc;
			percSB.append(m1);
			percSB.append(m2);
			perc = percSB.toString();
			
			h = Integer.parseInt(ora);
			m = Integer.parseInt(perc);	
			
			if(h >= 0 & h < 24 & m >= 0 & m < 60)
				return true;
			else
				return false;
		} else {
			return false;
		}
	}
	
	/**
	 * Idõt állít be.
	 * @param ido A beállítandó idõ sztringje.
	 */
	public void setIdo(String ido) {
			char o1 = ido.charAt(0);
			char o2 = ido.charAt(1);
			char m1 = ido.charAt(3);
			char m2 = ido.charAt(4);
			StringBuilder oraSB = new StringBuilder();
			String ora;
			oraSB.append(o1);
			oraSB.append(o2);
			ora = oraSB.toString();
			
			StringBuilder percSB = new StringBuilder();
			String perc;
			percSB.append(m1);
			percSB.append(m2);
			perc = percSB.toString();
			
			h = Integer.parseInt(ora);
			m = Integer.parseInt(perc);	
	}	
	
	/**
	 * A toString() metódus felüldefiniálása. Kiiír egy idõt, a megfelelõ formátumban.
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		if(h < 10) {		
			if(m < 10) return "0" + h + ":" + "0" + m;
			else return "0" + h + ":" + m;			
		}else{
			if(m < 10) return h + ":" + "0" + m;
			else return h + ":" + m;	
		}
	}
}	
		
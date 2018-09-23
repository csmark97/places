package Places;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
* <h1>Felhasználói fiókok listája</h1>
* A felhasználói fiókokat ez az osztály rendezi listába a megfelelõ függvényekkel.
* <p>
*
* @author  Csordás Márk
* @version 1.0
* @since   2017-10-15
*/

public class AccountRegister {
	private ArrayList<Account> accs;
	
	public AccountRegister() {
		accs = new ArrayList<>();
	}
	/**
	 * Hozzáad egy fiókot a listához.
	 * @param a A fiók, amelyet hozzá akarjuk adni.
	 */
	public void add(Account a) {
		accs.add(a);
	}
	/**
	 * Visszaadja a lista elsõ fiókját.
	 * Ellenõrzés szempontjából a fejlesztés során jól jöhet.
	 * @return accs.get(0) Az elsõ elem.
	 */
	public Account first(){
		return accs.get(0);
	}
	
	/**
	 * Megvizsgálja, hogy a paramtéerül kapott felhasználói fiók benne van-e a listában.
	 * @param a Felhasználói fiók, amelyet le akarunk csekkolni.
	 * @return true/false Visszatér igaz/hamis értékkel, benne van, vagy nincs.
	 */
	public boolean check(Account a) {
		for(int i = 0; i < accs.size(); i++) 
			if (accs.get(i).getFelhaszn().equals(a.getFelhaszn()) 
					&& accs.get(i).getJlsz().equals(a.getJlsz())
					&& !accs.get(i).getFelhaszn().equals("") 
					&& !accs.get(i).getJlsz().equals(""))
				return true;
		return false;		
	}
	
	/**
	 * Ha a listában benne van a paraméterül kapott felhasználói fiók, akkor visszaadja azt.
	 * A beléptetéshez szükséges ez a függvény.
	 * @param a A felhasználói fiók.
	 * @return accs.get(i) Visszaadja a fiókot.
	 */
	public Account beenged(Account a) {
		for(int i = 0; i < accs.size(); i++) 
			if (accs.get(i).getFelhaszn().equals(a.getFelhaszn()) 
					&& accs.get(i).getJlsz().equals(a.getJlsz()))
				return accs.get(i);
		return new Account("senki", "jelszonélkül"); // teljesen mindegy, sosem történik meg
	}
	
	/**
	 * Fájlból betölti a felhasználói fiókokat tartalmazó listát.
	 * @param filename A fájl neve, ahonnan be akarjuk tölteni.
	 */
	public void load(String filename){
		try {
			File file = new File(filename);
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
			accs=(ArrayList<Account>)in.readObject();
			in.close();
		} catch(NullPointerException e){
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Fájlba elmenti a felhasználói fiókokat tartalmazó listát.
	 * @param filename A fájl neve, ahova el akarjuk menteni az adatokat.
	 */
	public void save(String filename) {		
		try {
			File file = new File(filename);
			FileOutputStream fis = new FileOutputStream(file);
			ObjectOutputStream out = new ObjectOutputStream(fis);
			out.writeObject(accs);
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
}

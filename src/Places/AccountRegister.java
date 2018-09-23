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
* <h1>Felhaszn�l�i fi�kok list�ja</h1>
* A felhaszn�l�i fi�kokat ez az oszt�ly rendezi list�ba a megfelel� f�ggv�nyekkel.
* <p>
*
* @author  Csord�s M�rk
* @version 1.0
* @since   2017-10-15
*/

public class AccountRegister {
	private ArrayList<Account> accs;
	
	public AccountRegister() {
		accs = new ArrayList<>();
	}
	/**
	 * Hozz�ad egy fi�kot a list�hoz.
	 * @param a A fi�k, amelyet hozz� akarjuk adni.
	 */
	public void add(Account a) {
		accs.add(a);
	}
	/**
	 * Visszaadja a lista els� fi�kj�t.
	 * Ellen�rz�s szempontj�b�l a fejleszt�s sor�n j�l j�het.
	 * @return accs.get(0) Az els� elem.
	 */
	public Account first(){
		return accs.get(0);
	}
	
	/**
	 * Megvizsg�lja, hogy a paramt�er�l kapott felhaszn�l�i fi�k benne van-e a list�ban.
	 * @param a Felhaszn�l�i fi�k, amelyet le akarunk csekkolni.
	 * @return true/false Visszat�r igaz/hamis �rt�kkel, benne van, vagy nincs.
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
	 * Ha a list�ban benne van a param�ter�l kapott felhaszn�l�i fi�k, akkor visszaadja azt.
	 * A bel�ptet�shez sz�ks�ges ez a f�ggv�ny.
	 * @param a A felhaszn�l�i fi�k.
	 * @return accs.get(i) Visszaadja a fi�kot.
	 */
	public Account beenged(Account a) {
		for(int i = 0; i < accs.size(); i++) 
			if (accs.get(i).getFelhaszn().equals(a.getFelhaszn()) 
					&& accs.get(i).getJlsz().equals(a.getJlsz()))
				return accs.get(i);
		return new Account("senki", "jelszon�lk�l"); // teljesen mindegy, sosem t�rt�nik meg
	}
	
	/**
	 * F�jlb�l bet�lti a felhaszn�l�i fi�kokat tartalmaz� list�t.
	 * @param filename A f�jl neve, ahonnan be akarjuk t�lteni.
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
	 * F�jlba elmenti a felhaszn�l�i fi�kokat tartalmaz� list�t.
	 * @param filename A f�jl neve, ahova el akarjuk menteni az adatokat.
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

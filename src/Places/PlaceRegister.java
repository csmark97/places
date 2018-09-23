package Places;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;

/**
* <h1>Helyek lista</h1>
* A helyeket listába rendezõ osztály.
* <p>
*
* @author  Csordás Márk
* @version 1.0
* @since   2017-10-15
*/

public class PlaceRegister {
	private ArrayList<Place> places;
	
	public PlaceRegister() {
		places = new ArrayList<>();
	}
	
	/**
	 * Hozzáad egy helyet a listához.
	 * @param p A hely, amit hozzá akarunk adni a listához.
	 */
	public void add(Place p) {
		places.add(p);
	}
	
	/**
	 * Visszaadja az elsõ elemét a listának.
	 * @return places.get(0) Az elsõ elem.
	 */
	public Place first(){
		return places.get(0);
	}
	
	/**
	 * Betölti a fájlból a helyekbõl álló listát.
	 * @param filename A fájl neve, ahonnan be akarjuk tölteni az adatokat.
	 */
	public void load(String filename){
		try {
			File file = new File(filename);
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
			places=(ArrayList<Place>)in.readObject();
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
	 * Elmenti a paraméterül kapott fájlba a helyekbõl álló listát.
	 * @param filename A fájl neve, ahova el akarjuk menteni az adatokat.
	 */
	public void save(String filename) {		
		try {
			File file = new File(filename);
			FileOutputStream fis = new FileOutputStream(file);
			ObjectOutputStream out = new ObjectOutputStream(fis);
			out.writeObject(places);
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	/**
	 * Keresés elõtt lecsekkolja, hogy benne van-e a keresetthely a listában.
	 * @param keresetthely A keresett hely neve.
	 * @return true/false Visszaadja, hogy van-e találat vagy nincs.
	 */
	public boolean searchCheck(String keresetthely) {
		for (int i = 0; i < places.size(); i++) {
			if (places.get(i).getName().equals(keresetthely))
				return true;
		}
		return false;
	}
	
	/**
	 * A helyek megkeresésére szolgáló függvény. A for cikluson kívüli hely sosem jöhet létre,
	 * mivel a függvény csak akkor hívjuk, meg ha csekkolva lett a searchCheck függvénnyel.
	 * @param keresetthely A keresett hely neve.
	 * @return places.get(i) Visszaadja helyet.
	 */
	
	public Place search(String keresetthely) {
		for (int i = 0; i < places.size(); i++) {
			if (places.get(i).getName().equals(keresetthely))
				return places.get(i);
		}
		return new Place("Sosem jöhet létre ez a hely!");
	}
	
	/**
	 * Kitöröl egy helyet a listából.
	 * @param plc A törölni kívánt hely.
	 */
	public void delete(Place plc){
		for (int i = 0; i < places.size(); i++){
			if(places.get(i).equals(plc)) {
				places.remove(i);
			}
		}
	}

	public ArrayList<Place> getPlaces() {
		return places;
	}

	public void setPlaces(ArrayList<Place> places) {
		this.places = places;
	}
	
	
}

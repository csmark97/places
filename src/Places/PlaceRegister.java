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
* A helyeket list�ba rendez� oszt�ly.
* <p>
*
* @author  Csord�s M�rk
* @version 1.0
* @since   2017-10-15
*/

public class PlaceRegister {
	private ArrayList<Place> places;
	
	public PlaceRegister() {
		places = new ArrayList<>();
	}
	
	/**
	 * Hozz�ad egy helyet a list�hoz.
	 * @param p A hely, amit hozz� akarunk adni a list�hoz.
	 */
	public void add(Place p) {
		places.add(p);
	}
	
	/**
	 * Visszaadja az els� elem�t a list�nak.
	 * @return places.get(0) Az els� elem.
	 */
	public Place first(){
		return places.get(0);
	}
	
	/**
	 * Bet�lti a f�jlb�l a helyekb�l �ll� list�t.
	 * @param filename A f�jl neve, ahonnan be akarjuk t�lteni az adatokat.
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
	 * Elmenti a param�ter�l kapott f�jlba a helyekb�l �ll� list�t.
	 * @param filename A f�jl neve, ahova el akarjuk menteni az adatokat.
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
	 * Keres�s el�tt lecsekkolja, hogy benne van-e a keresetthely a list�ban.
	 * @param keresetthely A keresett hely neve.
	 * @return true/false Visszaadja, hogy van-e tal�lat vagy nincs.
	 */
	public boolean searchCheck(String keresetthely) {
		for (int i = 0; i < places.size(); i++) {
			if (places.get(i).getName().equals(keresetthely))
				return true;
		}
		return false;
	}
	
	/**
	 * A helyek megkeres�s�re szolg�l� f�ggv�ny. A for cikluson k�v�li hely sosem j�het l�tre,
	 * mivel a f�ggv�ny csak akkor h�vjuk, meg ha csekkolva lett a searchCheck f�ggv�nnyel.
	 * @param keresetthely A keresett hely neve.
	 * @return places.get(i) Visszaadja helyet.
	 */
	
	public Place search(String keresetthely) {
		for (int i = 0; i < places.size(); i++) {
			if (places.get(i).getName().equals(keresetthely))
				return places.get(i);
		}
		return new Place("Sosem j�het l�tre ez a hely!");
	}
	
	/**
	 * Kit�r�l egy helyet a list�b�l.
	 * @param plc A t�r�lni k�v�nt hely.
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

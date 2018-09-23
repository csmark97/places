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
* <h1>Kommentek listája</h1>
* Ez az osztály a kommenteket rendezi listába.
* <p>
*
* @author  Csordás Márk
* @version 1.0
* @since   2017-10-15
*/

public class CommentRegister {
	private ArrayList<Comment> comments;
	
	public CommentRegister() {
		comments = new ArrayList<>();
	}
	
	/**
	 * A kommentekbõl áló listához hozzáad egy kommentet.
	 * @param c A hozzáadandó komment.
	 */
	public void add(Comment c) {
		comments.add(c);
	}
	
	/**
	 * Betölti egy fájlból a kommentekbõl álló listát.
	 * @param filename A fájl neve, ahonnan be akarjuk tölteni az adatokat.
	 */
	public void load(String filename){
		try {
			File file = new File(filename);
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
			comments=(ArrayList<Comment>)in.readObject();
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
	 * Elmenti egy fájlba a kommentekbõl álló listát.
	 * @param filename A fájl neve, ahova el akarjuk menteni az adatokat.
	 */
	public void save(String filename) {		
		try {
			File file = new File(filename);
			FileOutputStream fis = new FileOutputStream(file);
			ObjectOutputStream out = new ObjectOutputStream(fis);
			out.writeObject(comments);
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	/**
	 * Megszámolja a találatokat: a paraméterül kapott hely nevére hány komment van.
	 * @param keresetthely A keresett hely.
	 * @return db A találatok darabszáma.
	 */
	
	public int numberofSearchResults(Place keresetthely) {
		int db = 0;
		for (int i = 0; i < comments.size(); i++) {
			if (comments.get(i).getPlace().getName().equals(keresetthely.getName()));
				db++;
		}
		return db;
	}
	
	/**
	 * A keresést megvalósító függvény. 
	 * @param keresett A keresett kommentet ez a felhasználó írta..
	 * @return talalatok A találatok listája.
	 */
	public CommentRegister searching(String keresett) {
		CommentRegister talalatok = new CommentRegister();
		ArrayList<Comment> keresettKommentek = new ArrayList<>();
		for( int i = 0; i < comments.size(); i++) {
			if(comments.get(i).getPlace().getName().equals(keresett))
				keresettKommentek.add(comments.get(i));
		}
		talalatok.setComments(keresettKommentek);
		return talalatok;		
	}

	/**
	 * A toString() metódus felüldefiniálása. A teljes listából készít egy nagy Stringet.
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuilder builder = new StringBuilder();
		for( int i = 0; i < comments.size(); i++) {
			builder.append(comments.get(i).toString());
		}
		String str = builder.toString();
		return str;
	}

	public ArrayList<Comment> getComments() {
		return comments;
	}

	public void setComments(ArrayList<Comment> comments) {
		this.comments = comments;
	}		
}

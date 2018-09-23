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
* <h1>Kommentek list�ja</h1>
* Ez az oszt�ly a kommenteket rendezi list�ba.
* <p>
*
* @author  Csord�s M�rk
* @version 1.0
* @since   2017-10-15
*/

public class CommentRegister {
	private ArrayList<Comment> comments;
	
	public CommentRegister() {
		comments = new ArrayList<>();
	}
	
	/**
	 * A kommentekb�l �l� list�hoz hozz�ad egy kommentet.
	 * @param c A hozz�adand� komment.
	 */
	public void add(Comment c) {
		comments.add(c);
	}
	
	/**
	 * Bet�lti egy f�jlb�l a kommentekb�l �ll� list�t.
	 * @param filename A f�jl neve, ahonnan be akarjuk t�lteni az adatokat.
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
	 * Elmenti egy f�jlba a kommentekb�l �ll� list�t.
	 * @param filename A f�jl neve, ahova el akarjuk menteni az adatokat.
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
	 * Megsz�molja a tal�latokat: a param�ter�l kapott hely nev�re h�ny komment van.
	 * @param keresetthely A keresett hely.
	 * @return db A tal�latok darabsz�ma.
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
	 * A keres�st megval�s�t� f�ggv�ny. 
	 * @param keresett A keresett kommentet ez a felhaszn�l� �rta..
	 * @return talalatok A tal�latok list�ja.
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
	 * A toString() met�dus fel�ldefini�l�sa. A teljes list�b�l k�sz�t egy nagy Stringet.
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

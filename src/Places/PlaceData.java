package Places;

import GUI.FelhasznaloiFelulet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.table.AbstractTableModel;

/**
* <h1>Helyek t�b�zat</h1>
* A helyek t�bl�zat�hoz sz�ks�ges oszt�ly.
* <p>
*
* @author  Csord�s M�rk
* @version 1.0
* @since   2017-10-15
*/

/*
 * A helyek adatait t�rol� oszt�ly.
 */
public class PlaceData extends AbstractTableModel {

	ArrayList<Place> places;
	private String[] colNames = { "N�v", "Hely", "�rt�k", "T�pus" };
	
	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return colNames[column];
	}
	
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		// TODO Auto-generated method stub
		return String.class;
	}
	
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return places.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 4;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		if(rowIndex != -1){
			Place place = places.get(rowIndex);
			switch (columnIndex) {
			case 0:
				return place.getName();
			case 1:
				return place.getCntct().getAddr().toString();
			case 2:
				return String.valueOf(place.getRating()); 
			case 3:
				return place.getType().toString();
			default:
				return place.getType().toString();
			}		
		}
		return "hiba";
	}

	public ArrayList<Place> getPlaces() {
		return places;
	}

	/**
	 * Helyet �ll�t be.
	 * @param places Ezt a helyet �ll�tja be.
	 */
	public void setPlaces(ArrayList<Place> places) {
		this.places = places;
	}
	
	/**
	 * Megsz�molja, hogy az adott felhaszn�l�nak h�ny darab �ltala l�trehozott helye van a list�ban.
	 * @param keresettfelhasznalo A keresett felhaszn�l� neve.
	 * @return db A tal�latok darabsz�ma.
	 */
	public int numberofSearchResults_Account(String keresettfelhasznalo) {
		int db = 0;
		for (int i = 0; i < places.size(); i++) {
			if(places.get(i).getTulajdonos().getName().equals(keresettfelhasznalo))
				db++;
		}
		return db;
	}
	
	/**
	 * Megkeresi a param�ter�l kapott felhaszn�l� neve alapj�n a felhaszn�l� helyeit.
	 * @param keresettfelhasznalo A keresett felhaszn�l� neve.
	 * @return talalatok A tal�latok list�ja.
	 */
	public PlaceData searchAccount(String keresettfelhasznalo) {
		PlaceData talalatok = new PlaceData();
		ArrayList<Place> keresettHelyek = new ArrayList<>();
		for (int i = 0; i < places.size(); i++) {
			if(places.get(i).getTulajdonos().getName().equals(keresettfelhasznalo)) {
				keresettHelyek.add(places.get(i));
			}
		}
		talalatok.setPlaces(keresettHelyek);
		return talalatok;
	}
	
	/**
	 * Megkeresi a param�ter�l kapott sz� alapj�n a helyeket. 
	 * @param keresett A keresett sz� (t�pus, n�v, hely stb.).
	 * @return talalatok Visszaadja a tal�latok list�j�t.
	 */
	public PlaceData search(String keresett) {
		PlaceData talalatok = new PlaceData();
		if(!keresett.equals("")) {			
			ArrayList<Place> keresettHelyek = new ArrayList<>();
			for (int i = 0; i < places.size(); i++) {
				if(places.get(i).getCntct().getAddr().getCity().equals(keresett)) {
					keresettHelyek.add(places.get(i));
				}
				if(places.get(i).getName().equals(keresett)) {
					keresettHelyek.add(places.get(i));
				}
				if(places.get(i).getType().toString().equals(keresett)) {
					keresettHelyek.add(places.get(i));
				}
				try{
					if(places.get(i).getRating() > Double.parseDouble(keresett)){
						keresettHelyek.add(places.get(i));
					}
				}catch(NumberFormatException e){
				}
				
			}
			talalatok.setPlaces(keresettHelyek);
		} else {
			talalatok.setPlaces(places);
		}
		return talalatok;
	}
	
}

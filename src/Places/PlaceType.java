package Places;
/**
* <h1>Hely t�pusa</h1>
* A helyek t�pus�t le�r� enumer�ci�.
* <p>
*
* @author  Csord�s M�rk
* @version 1.0
* @since   2017-10-15
*/

public enum PlaceType {
	BOLT{
		public String toString(){
			return "Bolt";
		}
	}, KOZTERULET{
		public String toString(){
			return "K�zter�let";
		}
	}, INTEZMENY{
		public String toString(){
			return "Int�zm�ny";
		}
	}, ETTEREM{
		public String toString(){
			return "�tterem";
		}
	}, SZALLAS{
		public String toString(){
			return "Sz�ll�s";
		}
	}, SZORAKOZAS{
		public String toString(){
			return "Sz�rakoz�s";
		}
	}, BEVASARLOKOZPONT{
		public String toString(){
			return "Bev�s�rl�k�zpont";
		}
	};		
	abstract public String toString();			
}
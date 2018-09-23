package Places;
/**
* <h1>Hely típusa</h1>
* A helyek típusát leíró enumeráció.
* <p>
*
* @author  Csordás Márk
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
			return "Közterület";
		}
	}, INTEZMENY{
		public String toString(){
			return "Intézmény";
		}
	}, ETTEREM{
		public String toString(){
			return "Étterem";
		}
	}, SZALLAS{
		public String toString(){
			return "Szállás";
		}
	}, SZORAKOZAS{
		public String toString(){
			return "Szórakozás";
		}
	}, BEVASARLOKOZPONT{
		public String toString(){
			return "Bevásárlóközpont";
		}
	};		
	abstract public String toString();			
}
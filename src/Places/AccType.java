package Places;

/**
* <h1>Felhasználói fiók típusa</h1>
* A felhasználói fiókok típusának enumerációja.
* <p>
*
* @author  Csordás Márk
* @version 1.0
* @since   2017-10-15
*/

public enum AccType {
	TERMESZETES{
		public String toString(){
			return "Természetes személy";
		}
	}, TULAJDONOS{
		public String toString(){
			return "Tulajdonos";
		}
	};		
	abstract public String toString();	
}

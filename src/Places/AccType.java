package Places;

/**
* <h1>Felhaszn�l�i fi�k t�pusa</h1>
* A felhaszn�l�i fi�kok t�pus�nak enumer�ci�ja.
* <p>
*
* @author  Csord�s M�rk
* @version 1.0
* @since   2017-10-15
*/

public enum AccType {
	TERMESZETES{
		public String toString(){
			return "Term�szetes szem�ly";
		}
	}, TULAJDONOS{
		public String toString(){
			return "Tulajdonos";
		}
	};		
	abstract public String toString();	
}

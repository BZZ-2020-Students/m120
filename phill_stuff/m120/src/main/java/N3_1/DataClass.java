package N3_1;

/**
 * Die Klasse DataClass reprensentiert ein Datenobjekt mit diversen Attributen. Ein solches
 * Datenobjekt kann als ein Record einer DB betrachtet werden.
 * Für die Ausgabe eignet sich hier eine Tabelle in der das Datenobjekt in einer Zeile
 * dargestellt wird.
 * Für dieses Beispiel wird ein Automobil abgebildet.
 * 
 * Ein Objekt kann entweder mittels dem parametrierten Konstruktor oder über die set-Methoden
 * beschrieben werden. Mittels der get-Methoden werden die Werte ausgelesen.
 * 
 * @author  René Probst
 * @date    25.4.2015
 * @version 1.0
 *
 */
public class DataClass {
	// die Attribute des Datenobjekts
	private String    hersteller;
	private float     hubraum;
	private int       leistung;
	
	/** 
	 * Leerer Konstrukter für ein Objekt der Daten-Klasse
	 */
	public DataClass(){
	}
	
	/**
	 * Parametrierter Konstruktor der Data-Klasse
	 */
	public DataClass(String hersteller, float hubraum, int leistung){
		this.hersteller = hersteller;
		this.hubraum    = hubraum;
		this.leistung   = leistung;
	}
	
	public void setHersteller(String hersteller){
		this.hersteller = hersteller;
	}
	
	public void setHubraum(float hubraum){
		this.hubraum = hubraum;
	}
	
	public void setLeistung(int leistung){
		this.leistung = leistung;
	}
	
	public String getHersteller(){
		return this.hersteller;
	}
	
	public float getHubraum(){
		return this.hubraum;
	}
	
	public float getLeistung(){
		return this.leistung;
	}
}

import java.util.*;

public class CarteRecharge {
	
	enum Etat{Utilis�,Inutilis�}
	private String numSerie;
	private Date datevalidit�;
	private int montant;
	private Etat etat;
	
	//Get
	public String getNumSerie() {return numSerie;}
	public Date getDateval() {return datevalidit�;}
	public int getMontant() {return montant;}
	public String getetat() {return this.etat.toString();}
	
	//Set
	public void setNumSerie(String  numSerie) {this.numSerie = numSerie;}
	public void setDateval(Date dateval) {	this.datevalidit�= dateval;}
	public void setMontant(int montant) {this.montant = montant;}
	
	//Construteur sans param�tres
	
	public CarteRecharge() {
		this.numSerie=this.GenNumSer();
		this.setdateexp(this.datevalidit�, 1);
		this.montant=0;
		this.etat=Etat.Inutilis�;
	}
	
	//Constructeur avec Param�tres 
	public CarteRecharge(Date datevalidit�, int montant) {
		this.numSerie =this.GenNumSer(); 
		this.datevalidit� = datevalidit�;
		this.montant = montant;
		this.etat=Etat.Inutilis�;
	}
	
	//Methode Gen�rante de Numero de serie de carte de recharge
	public String GenNumSer() {
		char[] chars = "0123456789".toCharArray();
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		// Exemple d'une chaine al�atoire de 20 caract�res
		for (int i = 0; i < 14; i++) {
		    char c = chars[random.nextInt(chars.length)];
		    sb.append(c);
		}
		return sb.toString();
	}
	
	public void setdateexp(Date d,int duree) //date d'aujourd'hui + un nombre de mois
	{  Calendar cal=Calendar.getInstance();
	   cal.add(Calendar.MONTH, duree);
	   d=new Date(cal.get(Calendar.DATE),Date.Convert2(cal.get(Calendar.MONTH)+1),cal.get(Calendar.YEAR));
		this.datevalidit�=d;
	}
	
	//Methode �tat carte de recharge  // true == utulis�
	public boolean �tat() {
		if (this.etat.toString().compareTo("Utilis�")==0)
			return true;
		else  return false;
	}
	
	//Methode Activ� carte de recharge
	public void Activ�CarteRech(){
		this.etat = Etat.Utilis�;
	}
	
	//Methode Verifier la validit� de la carte de recharge
	public boolean Verifvalcarte() {
		
		Date dt=new Date();
		dt=Date.Datepc();
		if (dt.compare(this.datevalidit�)<0) 
			return true;
		else 
			return false;
	}
	//methode To String
	public String toString() {
		return (" Numero de serie : "+this.numSerie+"\nDate de validit� : "+this.datevalidit�.toString()+"\nMontant : "+this.montant+"\nEtat : "+this.etat.toString());
	}
	
	//Methode Afficher
		public void afficher() {
			System.out.println(this.toString());
		}
}
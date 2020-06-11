import java.util.*;

public class CarteRecharge {
	
	enum Etat{Utilisé,Inutilisé}
	private String numSerie;
	private Date datevalidité;
	private int montant;
	private Etat etat;
	
	//Get
	public String getNumSerie() {return numSerie;}
	public Date getDateval() {return datevalidité;}
	public int getMontant() {return montant;}
	public String getetat() {return this.etat.toString();}
	
	//Set
	public void setNumSerie(String  numSerie) {this.numSerie = numSerie;}
	public void setDateval(Date dateval) {	this.datevalidité= dateval;}
	public void setMontant(int montant) {this.montant = montant;}
	
	//Construteur sans paramétres
	
	public CarteRecharge() {
		this.numSerie=this.GenNumSer();
		this.setdateexp(this.datevalidité, 1);
		this.montant=0;
		this.etat=Etat.Inutilisé;
	}
	
	//Constructeur avec Paramétres 
	public CarteRecharge(Date datevalidité, int montant) {
		this.numSerie =this.GenNumSer(); 
		this.datevalidité = datevalidité;
		this.montant = montant;
		this.etat=Etat.Inutilisé;
	}
	
	//Methode Genérante de Numero de serie de carte de recharge
	public String GenNumSer() {
		char[] chars = "0123456789".toCharArray();
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		// Exemple d'une chaine aléatoire de 20 caractères
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
		this.datevalidité=d;
	}
	
	//Methode état carte de recharge  // true == utulisé
	public boolean état() {
		if (this.etat.toString().compareTo("Utilisé")==0)
			return true;
		else  return false;
	}
	
	//Methode Activé carte de recharge
	public void ActivéCarteRech(){
		this.etat = Etat.Utilisé;
	}
	
	//Methode Verifier la validité de la carte de recharge
	public boolean Verifvalcarte() {
		
		Date dt=new Date();
		dt=Date.Datepc();
		if (dt.compare(this.datevalidité)<0) 
			return true;
		else 
			return false;
	}
	//methode To String
	public String toString() {
		return (" Numero de serie : "+this.numSerie+"\nDate de validité : "+this.datevalidité.toString()+"\nMontant : "+this.montant+"\nEtat : "+this.etat.toString());
	}
	
	//Methode Afficher
		public void afficher() {
			System.out.println(this.toString());
		}
}
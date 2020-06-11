
public class CarteRechargeUtilisé extends CarteRecharge {
	private Date datevalidation;
	private String numutulisateur;
	
	//Get
	Date getDateValidation() {return this.datevalidation;}
	String getnumutulisateur() {return this.numutulisateur;}
	
	//Set
	void SetDateValidation(Date dt) {this.datevalidation=dt;}
	void setnumutulisateur(String num) {this.numutulisateur=num;}
	
	
	//Constructeur
	CarteRechargeUtilisé(CarteRecharge cr){
		this.setNumSerie(cr.getNumSerie());
		this.setDateval(cr.getDateval());
		this.setMontant(cr.getMontant());
		this.ActivéCarteRech();
		this.datevalidation=Date.Datepc();
	}
	
	//Methode To String
	public String toString() {
		return ("Numero de telephone de l'utilisateur : "+this.numutulisateur+super.toString()+" Date de validation : "+this.datevalidation);
	}
	
	//Methode Afficher
		public void afficher() {
			System.out.println(this.toString());
		}
}//Fin Classe

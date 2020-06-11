import java.util.Vector;

public class Abonnementprépayé extends Abonnement {
	
	int montant;
	private Vector <CarteRechargeUtilisé> CRU=new Vector<CarteRechargeUtilisé>();

	//get
	int getmontant() {return this.montant;}
	public Vector <CarteRechargeUtilisé> getCRU() {
		return CRU;
	}
	
	//set
	void setCRU(Vector <CarteRechargeUtilisé> cRU) {
		CRU = cRU;
	}
	void setmontant(int somme) {this.montant=somme;}
	
	//Constructeur Sans Paramétres
	Abonnementprépayé(){
		super("PREPAYE");
		this.montant=100;
		this.setdateexp(this.getexpdate(), 1);
	}
	
	//Constructeur avec paramétres

	//Méthodes Saisie
	public void saisie() {
		System.out.println("");
	}
	//Menu Static Pour rechargement du compte
	public static void MenuRecharg() {
		System.out.println("1)200Da");
		System.out.println("2)500Da");
		System.out.println("3)1000Da");
		System.out.println("4)2000Da");
	}
	
	//methode ajouter au montant 
	public void AjoutMontant(int somme) {
	this.montant+=somme;
	}

	public void debiter(int a)
	{
		this.montant -=a;
	}
}
import java.util.Vector;

public class Abonnementpr�pay� extends Abonnement {
	
	int montant;
	private Vector <CarteRechargeUtilis�> CRU=new Vector<CarteRechargeUtilis�>();

	//get
	int getmontant() {return this.montant;}
	public Vector <CarteRechargeUtilis�> getCRU() {
		return CRU;
	}
	
	//set
	void setCRU(Vector <CarteRechargeUtilis�> cRU) {
		CRU = cRU;
	}
	void setmontant(int somme) {this.montant=somme;}
	
	//Constructeur Sans Param�tres
	Abonnementpr�pay�(){
		super("PREPAYE");
		this.montant=100;
		this.setdateexp(this.getexpdate(), 1);
	}
	
	//Constructeur avec param�tres

	//M�thodes Saisie
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
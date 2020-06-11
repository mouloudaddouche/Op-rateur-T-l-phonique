import java.util.Scanner;
public class AppelSortant extends Appel {
	private int montant;
	
	//Get
	int getmont(){return this.montant;}
	//Set
	void setmont(int mnt) {this.montant=mnt;}
	
	//Constructeur Sans Paramétre
	AppelSortant(){
		super();
		this.montant=0;
	}
	//Constructeur Avec Paramétre
	AppelSortant(String num,Date date,Heure heure,Durée durée,int tarif)
	{
		super(num,date,heure,durée);
		this.calculmontant(tarif);
	}
	
	public void Saisie() {
		boolean c=true;String numtel;
		Scanner e=new Scanner(System.in);
		System.out.println("Entrer le numero Destinataire");
		do {
			numtel=e.nextLine();
			
			c=Operateur.ValiditeNum(numtel);
			if(c==false)
			System.out.println("Entrer un numéro de téléphone valide !!!");
			}while(c==false);
		this.setnum(numtel);
		
		this.setdate(Date.Datepc());
		this.setheure(Heure.heurepc());
		System.out.println("Durée de l'appel:");
		Durée dré=new Durée();
		dré.Saisir();
		this.setdurée(dré);
	}
	
	//Methode Calcul Montant
	public void calculmontant(int tarif) {
		int k;
		k=(this.getdurée().getHeure()*60)*tarif+(this.getdurée().getMinute())*tarif;
		if(this.getdurée().getseconde()>0) {
			k=k+tarif;
		}
		this.montant=k;
	}
		//Methode to string
		public String toString() {
			return ("Numero appelé : "+this.getnum()+" "+"\nDate :"+this.getdate().toString()+"\nHeure d'appel: "+this.getheure().toString()+"\nDurée d'appel: "+this.getdurée().toString());

		}
		
		
}//Fin Classe

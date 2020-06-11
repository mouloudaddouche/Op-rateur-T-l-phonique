import java.util.Scanner;
public class AppelSortant extends Appel {
	private int montant;
	
	//Get
	int getmont(){return this.montant;}
	//Set
	void setmont(int mnt) {this.montant=mnt;}
	
	//Constructeur Sans Param�tre
	AppelSortant(){
		super();
		this.montant=0;
	}
	//Constructeur Avec Param�tre
	AppelSortant(String num,Date date,Heure heure,Dur�e dur�e,int tarif)
	{
		super(num,date,heure,dur�e);
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
			System.out.println("Entrer un num�ro de t�l�phone valide !!!");
			}while(c==false);
		this.setnum(numtel);
		
		this.setdate(Date.Datepc());
		this.setheure(Heure.heurepc());
		System.out.println("Dur�e de l'appel:");
		Dur�e dr�=new Dur�e();
		dr�.Saisir();
		this.setdur�e(dr�);
	}
	
	//Methode Calcul Montant
	public void calculmontant(int tarif) {
		int k;
		k=(this.getdur�e().getHeure()*60)*tarif+(this.getdur�e().getMinute())*tarif;
		if(this.getdur�e().getseconde()>0) {
			k=k+tarif;
		}
		this.montant=k;
	}
		//Methode to string
		public String toString() {
			return ("Numero appel� : "+this.getnum()+" "+"\nDate :"+this.getdate().toString()+"\nHeure d'appel: "+this.getheure().toString()+"\nDur�e d'appel: "+this.getdur�e().toString());

		}
		
		
}//Fin Classe

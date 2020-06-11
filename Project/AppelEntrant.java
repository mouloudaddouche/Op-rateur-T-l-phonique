import java.util.Scanner;
public class AppelEntrant extends Appel {
	
	//Constructeur 
	AppelEntrant(String num,Date date,Heure heure,Durée durée){
		super(num,date,heure,durée);
	}
	
	//constructeur
	AppelEntrant(){
		super();
	}
	
	public void Saisie() {
		boolean c=true;String numtel;
		Scanner e=new Scanner(System.in);
		System.out.println("Entrer le numero appelant");
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
	//Methode to string
	public String toString() {
		return ("Numero appelant : "+this.getnum()+" "+"\nDate :"+this.getdate().toString()+"\nHeure d'appel: "+this.getheure().toString()+" \nDurée d'appel: "+this.getdurée().toString());
	}
}//Fin Classe

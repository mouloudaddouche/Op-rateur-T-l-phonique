import java.util.Scanner;
public class AppelEntrant extends Appel {
	
	//Constructeur 
	AppelEntrant(String num,Date date,Heure heure,Dur�e dur�e){
		super(num,date,heure,dur�e);
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
	//Methode to string
	public String toString() {
		return ("Numero appelant : "+this.getnum()+" "+"\nDate :"+this.getdate().toString()+"\nHeure d'appel: "+this.getheure().toString()+" \nDur�e d'appel: "+this.getdur�e().toString());
	}
}//Fin Classe

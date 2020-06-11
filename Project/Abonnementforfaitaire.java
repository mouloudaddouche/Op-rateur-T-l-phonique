import java.util.Scanner;

public class Abonnementforfaitaire extends Abonnement {
private int montant;
	
	public int getmontant() {return montant;}

	public void setmontant(int d) {montant=d;}
	
	Abonnementforfaitaire()
	{ 
		super("FORFAITAIRE");
		this.saisie();
		
	}
	
	public void saisie()
	{   Scanner e=new Scanner(System.in);
	    Abonnementforfaitaire.menustatic();
	    System.out.println("Choisissez un forfait: ");
	    int x=e.nextInt();
	    while(x>3 || x<1)
	    {
	    	System.out.println("Choisissez un forfait valide: ");
	    	x=e.nextInt();
	    }
	    //Choix du montant
	    switch(x)
	    {
	     case 1:this.setmontant(1200);	            
	     case 2:this.setmontant(2300);
	     case 3:this.setmontant(3500);   	
	    }
	    this.setdateexp(Date.Datepc(), 1);
		
	}
	
	public static void menustatic()
	{
		System.out.println("Cher client , Notre opérateur vous prepose 3 types d'abonnement forfaitaire: ");
		System.out.println("1-Maxy1200 : 1200DA vers tous les reseaux pour 1 mois");
		System.out.println("2-Maxy2300 : 2300DA vers tous les reseaux pour 1 mois");
		System.out.println("3-Maxy3500 : 3500DA vers tous les reseaux pour 1 mois");
	
	}
	
	Abonnementforfaitaire(int montant,Date datef)
	{   
		super("FORFAITAIRE",datef);
		this.setmontant(montant);
	}
	
	public void debiter(int a)
	{
		this.montant -=a;
	}
	
}

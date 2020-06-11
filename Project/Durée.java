import java.util.Calendar;
import java.util.Scanner;

public class Durée extends Heure {
	private int seconde;
	
	int getseconde() {return this.seconde;}
	void setseconde(int sec) {this.seconde=sec;}
	
	//Constructeur Sans Paramétre
	Durée(){
		super();
		this.seconde=0;
	}
	
	//Constructeur Avec Paramétre
	Durée(int heure,int min,int sec){
		super(heure,min);
		this.seconde=sec;
	}
	
	//Methode Saisir
	public void Saisir() {
		int i;
		Scanner e=new Scanner(System.in);
		System.out.println("Entrer le nombre d'heures de l'appel");
		do {
			i=e.nextInt();
			if(i>23 || i<0)
				System.out.println("Enter un nombre d'heure valide !!");
		}while(i>23 || i<0);
		this.setheure(i);
		System.out.println("Entrer le nombre de minutes de l'appel");
		do {
			i=e.nextInt();
			if(i>59 || i<0)
				System.out.println("Enter un nombre de minutes valide !!");
		}while(i>59 || i<0);
		this.setminute(i);
		System.out.println("Entrer le nombre de secondes de l'appel");
		do {
			i=e.nextInt();
			if(i>59 || i<0)
				System.out.println("Enter un nombre de seconde valide !!");
		}while(i>59 || i<0);
		this.seconde=i;
	}
	
	//methode ajouter une durée a une autre
	public void AjoutTemps(Durée dr) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, this.getHeure());
		cal.set(Calendar.MINUTE, this.getMinute());
		cal.set(Calendar.SECOND, this.getseconde());
		cal.add(Calendar.HOUR, +dr.getHeure());
		cal.add(Calendar.MINUTE, +dr.getMinute());
		cal.add(Calendar.SECOND, +dr.getseconde());
		this.setheure(cal.get(Calendar.HOUR_OF_DAY));
		this.setminute(cal.get(Calendar.MINUTE));
		this.setseconde(cal.get(Calendar.SECOND));
	}
	
	//Methode Convertir Durée arrondi pour calculer le tarif
			public static Heure duréeToheure(Durée dr) {
				Heure hr=new Heure();
				if (dr.getseconde()==0) {
					hr.setheure(dr.getHeure());
					hr.setminute(dr.getMinute());
					return hr;
				}
				else if(dr.getMinute()!=59) {
					hr.setminute(dr.getMinute()+1);
					hr.setheure(dr.getHeure());
				}
				else {
					hr.setminute(0);
					hr.setheure(dr.getHeure()+1);
			}
				return hr;
			}
			
	//Methode to string
			public String toString() {
				if(this.getHeure()==0) {
					if (this.getMinute()<10) {
				
					if(this.seconde<10) 
				return("0"+this.getMinute()+":"+"0"+this.getseconde());
					else
						return("0"+this.getMinute()+":"+this.getseconde());}
				else 
					if(this.seconde<10)
						return(this.getMinute()+":"+"0"+this.getseconde());
					else
						return(this.getMinute()+":"+this.getseconde());}
				
			else {
				if(this.getHeure()<10) {
				if (this.getMinute()<10) {
					if(this.seconde<10) 
				return("0"+this.getHeure()+":"+"0"+this.getMinute()+":"+"0"+this.getseconde());
					else
						return("0"+this.getHeure()+":"+"0"+this.getMinute()+":"+this.getseconde());}
				else 
					if(this.seconde<10)
						return("0"+this.getHeure()+":"+this.getMinute()+":"+"0"+this.getseconde());
					else
						return("0"+this.getHeure()+":"+this.getMinute()+":"+this.getseconde());}
				else {
					if (this.getMinute()<10) {
						if(this.seconde<10) 
					return(this.getHeure()+":"+"0"+this.getMinute()+":"+"0"+this.getseconde());
						else
							return(this.getHeure()+":"+"0"+this.getMinute()+":"+this.getseconde());}
					else 
						if(this.seconde<10)
							return(this.getHeure()+":"+this.getMinute()+":"+"0"+this.getseconde());
						else
							return(this.getHeure()+":"+this.getMinute()+":"+this.getseconde());}
				}
			
			 }
	
	  //Methode Afficher
	public void afficher() {
		System.out.println(this.toString());
	}
}//Fin Classe

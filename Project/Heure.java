import java.util.Calendar;
import java.util.Scanner;
public class Heure {
	private int heure;
	private int minute;
	
	//Get
	int getHeure() {return this.heure;}
	int getMinute() {return this.minute;}
	
	//Set
	void setheure(int heure) {this.heure=heure;}
	void setminute(int minute) {this.minute=minute;}

	//Constructeur sans paramétre
	Heure(){
		this.heure=0;
		this.minute=0;
	}
	
	//Constructeur avec paramétre
	Heure (int heure,int minute){
		if(heure>23 || heure<0)
			throw new IllegalArgumentException("l'heure est fausse");
		else this.heure=heure;
		if(minute<0 || minute >59) 
			throw new IllegalArgumentException("les minutes sont fasses");
		else 
			this.minute=minute;
		}
	
	//Methode Saisir
	public void Saisir() {
		int i;
		Scanner e=new Scanner(System.in);
		System.out.println("Entrer l'heure de l'appel");
		do {
			i=e.nextInt();
			if(i>23 || i<0)
				System.out.println("Enter une heure valide !!");
		}while(i>23 || i<0);
		this.heure=i;
		System.out.println("Entrer minute de l'appel");
		do {
			i=e.nextInt();
			if(i>59 || i<0)
				System.out.println("Enter une minute valide !!");
		}while(i>59 || i<0);
		this.minute=i;
	}
	
	//Methode Static retourner Heure Pc
	public static Heure heurepc() {
		Calendar cal = Calendar.getInstance();
		Heure dr=new Heure();
		dr.heure=cal.get(Calendar.HOUR_OF_DAY);
		dr.minute=cal.get(Calendar.MINUTE);
		return dr;
	}
	
	
	//Methode Ajouter Temps
	public void AjoutTemps(Heure hr) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, this.getHeure());
		cal.set(Calendar.MINUTE, this.getMinute());
		cal.add(Calendar.HOUR, +hr.heure);
		cal.add(Calendar.MINUTE, +hr.minute);
		this.heure=cal.get(Calendar.HOUR_OF_DAY);
		this.minute=cal.get(Calendar.MINUTE);
	}
	
	//Methode Soustraire Temps
		public void SoustraireTemps(int min) {
			Calendar cal = Calendar.getInstance();
			cal.set(Calendar.HOUR_OF_DAY, this.getHeure());
			cal.set(Calendar.MINUTE, this.minute);
			cal.add(Calendar.MINUTE, -min);
			this.heure=cal.get(Calendar.HOUR_OF_DAY);
			this.minute=cal.get(Calendar.MINUTE);
		}
		
		//Methode Comparer
		public int comparer(Heure hr) {
			if (this.heure>hr.heure)return 1;
			else if (this.heure<hr.heure) return -1;
			else {
				if (this.minute>hr.minute)return 1;
				else if (this.minute<hr.minute) return -1;
				else return 0;
			}
		}
		//Methode convertir minute to heure
		public void minToheu(int min) {
			this.setheure(min/60);
			this.setminute(min%60);
		}
	
	//Methode to string
	public String toString() {
		if(this.heure<10)
		{
			if(this.minute<10)
		return("0"+this.heure+":"+"0"+this.minute);
			else
			return("0"+this.heure+":"+this.minute);}
			
	else {
		if(this.minute<10)
			return(this.heure+":"+"0"+this.minute);
				else
				return(this.heure+":"+this.minute);}
	}
	
	//Methode Afficher
	public void Afficher() {
		System.out.println(this.toString());
	}
	}//Fin de la classe
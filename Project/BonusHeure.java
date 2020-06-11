import java.util.Calendar;
import java.util.Scanner;

public class BonusHeure implements Bonus{ // Les bonus ont une validité de 30jours
	private Heure nbh;
	 private Date datelimite;
    
	
	//Get
	public int getval() {return this.nbh.getHeure()*60+this.nbh.getMinute();}
	public Date getdatelimite() {return this.datelimite;}
	//Set
	public void setval(int min) {this.nbh.setheure(this.nbh.getHeure()/60);
	this.nbh.setminute(this.nbh.getHeure()%60);}
	public void setdatel(Date d) {datelimite=d;}
	
	//Constructeur Sans Paramétres
		BonusHeure(){
			this.ActualiserDateExp();
			
			this.nbh=new Heure (0,0);
		}
		
		//Constructeur Avec paramétres dir bih les collections
		BonusHeure(Date d,Heure nbh){
			this.datelimite=d;
			this.nbh=nbh;
		}
		
		//Methode Ajouter un Bonus
		public void Ajouterbonus() {
			Scanner e=new Scanner(System.in);
			System.out.println("Entrer le nombre d'heure ");
			int hr=e.nextInt();
			e.nextLine();
			Heure temps=new Heure(hr,0);
			this.nbh.AjoutTemps(temps);
			this.ActualiserDateExp();
			
		}
		
		//Methode Soustraire du bonus
		public void SoustraireBonus(int min) {
			this.nbh.SoustraireTemps(min);
		}
		
		//Methode verifier si il'a un bonus actuellement
		public boolean VerifBonus() {
			if (this.nbh.getHeure()!=0 || this.nbh.getMinute()!=0) return true;
			else return false;
		}
		
		//Methode Actualiser la date d'éxpr
		   public void ActualiserDateExp() {
			   Date dt=new Date();
			   Calendar cal = Calendar.getInstance();
			   cal.add(Calendar.DATE, 30);
			   dt=Date.CalToDate(cal);
			   this.datelimite=dt;
		   }
		   
		   public boolean bonusexp()
			{	if(Date.Datepc().compare(datelimite)==-1) return false;
				else return true;
			}
		
		//Methode Synchronisation du bonus
		public void SynchBonus() {
			if (this.bonusexp()==true) {
				this.nbh.setheure(0);
				this.nbh.setminute(0);
			}
		}
		
		//Methode to String
		   public String toString() {
			  return ("Temps réstant : "+this.nbh.toString()+"   Date limite du bonus : "+this.getdatelimite().toString());
		   }
		   
		 //Methode Afficher
		 	public void Afficher() {
		 		System.out.println(this.toString());
		 	}
}
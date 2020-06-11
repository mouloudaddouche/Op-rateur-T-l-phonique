import java.util.Calendar;
import java.util.Scanner;

public class BonusSMS implements Bonus{// Les bonus ont une validité de 30jours
	private int nbSMS;
	 private Date datelimite;
   

	
	//Get
	public int getval() {return this.nbSMS;}
	public Date getdatelimite() {return this.datelimite;}
	
	
	//Set
	public void setval(int nb) {this.nbSMS = nb;}
	public void setdatel(Date d) {datelimite=d;}
	
	//Constructeur Sans Paramétres
	BonusSMS(){
		this.ActualiserDateExp();
		this.nbSMS=0;
	}
	
	//Constructeur Avec paramétres dir bih les collections
	BonusSMS(Date d,int nb){
		this.datelimite=d;
		this.nbSMS=nb;
	}
	
	//Methode Ajouter un Bonus 
	public void Ajouterbonus() {
		Scanner e=new Scanner(System.in);
		System.out.println("Entrer le nombre de SMS ");
		this.nbSMS=this.nbSMS+e.nextInt();
		this.ActualiserDateExp();

	}
	
	//Methode Soustraire du bonus
	public void SoustraireBonus(int nb) {
		this.nbSMS=this.nbSMS-nb;
	}
	
	//Methode verifier si il'a un bonus actuellement
	public boolean VerifBonus() {
		if (this.nbSMS>0) return true;
		else return false;
	}
	
	//Methode Actualiser la date d'éxpr
	   public void ActualiserDateExp() {
		   Date dt=new Date();
		   Calendar cal = Calendar.getInstance();
		   cal.add(Calendar.DATE, 20);
		   dt=Date.CalToDate(cal);
		   this.datelimite=dt;
	   }
	   
	   public boolean bonusexp()
		{	if(Date.Datepc().compare(datelimite)==-1) return false;
			else return true;
		}
	
	//Methode Synchronisation du bonus
			public void SynchBonus() {
				if (this.bonusexp()==true)
					this.nbSMS=0;
			}
			
			//Methode to String
			   public String toString() {
				   return ("Nombre De SMS gratuit :"+this.nbSMS+"   Date limite du bonus : "+this.datelimite.toString() );
			   }
			   
			 //Methode Afficher
			 	public void Afficher() {
			 		System.out.println(this.toString());
			 	}
}
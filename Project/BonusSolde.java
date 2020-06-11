import java.util.Calendar;
import java.util.Scanner;

public class BonusSolde implements Bonus{ // Les bonus ont une validité de 30jours
	private int soldebonus;
	 private Date datelimite;
	

	
	//Get
	public int getval() {return this.soldebonus;}
	public Date getdatelimite() {return this.datelimite;}
	
	
	//Set
	public void setval(int sld) {this.soldebonus=sld;}
	public void setdatel(Date d) {datelimite=d;}

	
	//Constructeur Sans Paramétres
		BonusSolde(){
			this.ActualiserDateExp();
			this.soldebonus=0;
		}
		
		//Constructeur Avec paramétres dir bih les collections
		BonusSolde(Date d,int sld){
			this.datelimite=d;
			this.soldebonus=sld;
		}
	
		
		//Methode Ajouter un Bonus
		  public void Ajouterbonus() {
			Scanner e=new Scanner(System.in);
			System.out.println("Entrer le solde ");
			this.soldebonus=this.soldebonus+e.nextInt();
			this.ActualiserDateExp();
		}
		
		//Methode Soustraire du bonus
		public void SoustraireBonus(int tarif) {
			this.soldebonus=this.soldebonus-tarif;
		}
		
		//Methode verifier si il'a un bonus actuellement
		public boolean VerifBonus() {
			if (this.soldebonus>0) return true;
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
					if (this.bonusexp()==true) this.soldebonus=0;
				}
				
				//Methode to String
				   public String toString() {
					   return ("Bonus solde : "+ this.soldebonus+"\nDate limite : "+this.datelimite.toString());
				   }
				   
				 //Methode Afficher
				 	public void Afficher() {
				 		System.out.println(this.toString());
				 	}
}
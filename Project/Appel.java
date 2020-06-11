
 abstract public class Appel { 
	private String num;
	private Date date;
	private Heure heure;
	private Durée durée; 
		//Get
		String getnum() {return this.num;}
		Date getdate() {return this.date;}
		Heure getheure() {return this.heure;}
		Durée getdurée() {return this.durée;}
		
		//Set
		void setnum(String num) {this.num=num;}
		void setdate(Date date) {this.date=date;}
		void setheure(Heure heure) {this.heure=heure;}
		void setdurée(Durée durée) {this.durée=durée;}
	
		//Constructeur Sans Paramétres
		Appel(){
			this.num=null;
			this.date=null;
			this.heure=null;
			this.durée=null;
		}
		
		//Constructeur Avec Parametres
		Appel(String num,Date date,Heure heure,Durée durée){
			this.num=num;
			this.date=date;
			this.heure=heure;
			this.durée=durée;
		}
		
		//Methode Saisie
		abstract public void Saisie();
		
		//Methode to string
		abstract public String toString();
		
		//Methode Afficher
		public void Afficher(){
			System.out.println(this.toString());
		}
	}//Fin de la classe
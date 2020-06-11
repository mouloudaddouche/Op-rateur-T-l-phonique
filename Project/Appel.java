
 abstract public class Appel { 
	private String num;
	private Date date;
	private Heure heure;
	private Dur�e dur�e; 
		//Get
		String getnum() {return this.num;}
		Date getdate() {return this.date;}
		Heure getheure() {return this.heure;}
		Dur�e getdur�e() {return this.dur�e;}
		
		//Set
		void setnum(String num) {this.num=num;}
		void setdate(Date date) {this.date=date;}
		void setheure(Heure heure) {this.heure=heure;}
		void setdur�e(Dur�e dur�e) {this.dur�e=dur�e;}
	
		//Constructeur Sans Param�tres
		Appel(){
			this.num=null;
			this.date=null;
			this.heure=null;
			this.dur�e=null;
		}
		
		//Constructeur Avec Parametres
		Appel(String num,Date date,Heure heure,Dur�e dur�e){
			this.num=num;
			this.date=date;
			this.heure=heure;
			this.dur�e=dur�e;
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
import java.util.Scanner;
	public class SMS {
		private enum Status {ENVOYE,RECU,ECHEC}
		private String numexp;
		private String numdest;
		private Date date;
		private Heure heure;
		private Status statuss;
		private String textmes;
 
		//get
		String getnumexp(){return this.numexp;}
		String getnumdest(){return this.numdest;}
		Date getdate() {return this.date;}
		Heure getheure() {return this.heure;}
		String getstatus() {return this.statuss.toString();}
		String gettextmes() {return this.textmes;}
		
		//set
        void setstatus(String S) {statuss=Status.valueOf(S);}
        void setNumexp(String numexp) {this.numexp = numexp;}
		void setNumdest(String numdest) {this.numdest = numdest;}
		void setDate(Date date) {this.date = date;}
		void setHeure(Heure heure) {this.heure = heure;}
		void setTextmes(String textmes) {this.textmes = textmes;}
		
		//Constructeur Sans Paramétres
		SMS(){
			this.numexp=null;
			this.numdest=null;
			this.date=null;
			this.heure=null;
			this.statuss=null;
			this.textmes=null;
		}
		
		//Constructeur Avec Paramétres
		SMS(String numexp,String numdest,Date date,Heure heure,String status,String textmes){
			this.numexp=numexp;
			this.numdest=numdest;
			this.date=date;
			this.heure=heure;
			this.statuss=Status.valueOf(status);
			this.textmes=textmes;
		}
		
		//Méthode Saisir
		public void Saisir(Client cl) {
			boolean c=true;
			boolean c1=true;
			String temps;
			Scanner e=new Scanner (System.in);
			System.out.println("Entrer le numero de telephone de l'expéditeur ");
			do {
				temps=e.nextLine();
				c=Operateur.ValiditeNum(temps);
				if(temps.substring(0,2).compareTo("02")==0)
					c1=false;
				if(c==false || c1==false)
				System.out.println("Vous pouvez pas envoyer un message a partir d'un telephone fixe");
				}while(c==false || c1==false);
			this.numexp=temps;
			this.setNumdest(cl.getNDT());
			this.date=Date.Datepc();
			this.heure=Heure.heurepc();
		System.out.println("Entrer le texte du message");
		this.textmes=e.nextLine();
		}
		
		
		//Methode to String
		public String toString() {
			return("Numéro Expéditeur : "+this.numexp+"\nNuméro Destinataire : "+this.numdest+"\nDate : "+this.date+"\nHeure : "
					+ this.heure+"\nStatus : "+this.statuss+"\nMessage : "+this.textmes);
		}
		
		//Methode Afficher
		public void afficher() {
			System.out.println(this.toString()+"\n");
		}
		
}//Fin Classe
import java.util.Scanner;

public class SMSSortant extends SMS {

	private int montant;
	
	//Get
	int getmont() {return this.montant;}
	
	
	//set
	void setmontant(int m) {montant=m;}
	//Constructeur sans paramétres
	
	SMSSortant(){
		super();
		this.montant=0;
	}
	
	//Méthode Saisir
			public void Saisir(Client cl) {
				boolean c=true;
				boolean c1=true;
				String temps;
				Scanner e=new Scanner (System.in);
				this.setNumexp(cl.getNDT());
				System.out.println("Entrer le numero de destinataire");
				do {
					temps=e.nextLine();
					c=Operateur.ValiditeNum(temps);
					if(this.getnumexp().substring(0,2).compareTo("02")==0)
						c1=false;
					if(c==false || c1==false)
					System.out.println("Vous pouvez pas envoyer un message vers un telephone fixe !!!");
					}while(c==false || c1==false);
				this.setNumdest(temps);
				this.setDate(Date.Datepc());
				this.setHeure(Heure.heurepc());
			System.out.println("Entrer le texte du message");
			this.setTextmes(e.nextLine());
			}
	
	//Constructeur avec paramétres
	SMSSortant(String numexp,String numdest,Date date,Heure heure,String status,String textmes,
			int mont){
		super(numexp,numdest,date,heure,status,textmes);
		this.montant=mont;
	}
	
	
	public int tarifmessage() //Déterminer le tarif du message
	{
		 String id1=this.getnumexp().substring(0,2);
		 String id2=this.getnumdest().substring(0,2);
		 
		 if(id1.equals(id2)) return 4; //Même opérateur
		 else {
			 boolean local=false;
			 
			 for(NomOperateur op : NomOperateur.values())
			 {
				 if(id2.equals(op.Identifiant())) {local=true;break;}
			 }
			 if(local) return 5; //opérateur local
			 else return 15;//étranger
		 }
	}
	
	//Methode Calcul Montant  // On A Supposer qu'un message est constituné de 120lettres
	public void Calculmontant() {
		
		int trf=this.tarifmessage();
		if (this.gettextmes().length()%120!=0)
			this.montant=((this.gettextmes().length()/120)+1)*trf;
		else
			this.montant=(this.gettextmes().length()/120)*trf;
	}
	
	//Methode to String
	public String toString() {
		return(super.toString()+"\nMontant: "+this.montant);
	}
	
	//Methode Afficher
	public void afficher() {
		System.out.println(this.toString()+"\n");
	}
}//Fin Classe

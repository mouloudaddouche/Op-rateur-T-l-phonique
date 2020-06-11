import java.util.Scanner;
import java.util.Vector;

public class Client {
	private String NDT;
	private Vector<Date> Relance;
	private Abonnement abn;
	private String NDC;
	private Date DDC;
	private String nom;
	private String pr�nom;
	private Adresse adresse;
	private AdresseMail adm;
	private EtatClient etat;
	private Vector<AppelSortant> AS;
	private Vector<AppelEntrant> AE;// 
	private Vector<SMSSortant> SMSS;
	private Vector<SMS> SMSE;
	private Bonus bonus;
	
	//Get
	String getNDT() {return this.NDT;}
	Vector<Date> getRelance(){return this.Relance;}
	Abonnement getabn() {return this.abn;}
	String getNDC() {return this.NDC;}
	Date getDDC() {return this.DDC;}
	String getnom() {return this.nom;}
	String getprenom() {return this.pr�nom;}
	Adresse getadresse() {return this.adresse;}
	AdresseMail getadm() {return this.adm;}
	EtatClient getetatt() {return this.etat;}
	String getetat() {return this.etat.toString();}
	Vector<AppelSortant> getAS(){return this.AS;}
	Vector<AppelEntrant> getAE(){return this.AE;} //Verfifier !!!
	Vector<SMSSortant> getSMSS(){return this.SMSS;}
	Vector<SMS> getSMSE(){return this.SMSE;}
	Bonus getBonus() {return this.bonus;}
	
	//Set
	void setEtat(String str) {this.etat=EtatClient.valueOf(str);}
	void setNDT(String num) {this.NDT=num;}
	void setRelance(Vector<Date> r) {this.Relance=r;}
	
	
	//Constructeur Sans Param�tre
	Client(){
		this.NDT=null;
		this.Relance=null;
		this.abn=null;
		this.NDC=null;
		this.DDC=new Date();
		this.nom=null;
		this.pr�nom=null;
		this.adresse=new Adresse();
		this.adm=new AdresseMail();
		this.etat=null;
		this.AS=new Vector<AppelSortant>();
		this.AE=new Vector<AppelEntrant>();
		this.SMSS=new Vector<SMSSortant>();
		this.SMSE=new Vector<SMS>();
		this.bonus=null;
	}
	
	//Constructeur Avec Param�tre
	Client(String NDT,Vector<Date> relance,Abonnement abn,String NDC,Date DDC,String nom,String
			prenom,Adresse adresse,AdresseMail adm,EtatClient etat,Vector<AppelSortant> AS,
			Vector<AppelEntrant> AE,Vector<SMSSortant> SMSS,Vector<SMS> SMSE,Bonus bonus){
		
		this.NDT=NDT;
		this.Relance=relance;
		this.abn=abn;
		this.NDC=NDC;
		this.DDC=DDC;
		this.nom=nom;
		this.pr�nom=prenom;
		this.adresse=adresse;
		this.adm=adm;
		this.etat=etat;
		this.AS=AS;
		this.AE=AE;
		this.SMSS=SMSS;
		this.SMSE=SMSE;
		//this.Bonus=bonus; // A revoir ( il faut je pense 0
	}
	
	//Instanciation de l'abonnement en fonction du type
			public void instanabo(String type) {
				switch(type) {
				case "LIBRE":{this.abn=new AbonnementLibre();
				break;
				}
				case "FORFAITAIRE":{
					this.abn=new Abonnementforfaitaire();					
				}
				case "PREPAYE":this.abn=new Abonnementpr�pay�();break;
			}
			}
			
			//Choisir le type d'abo du client
			public void choixtype()
			{
				String k;boolean v=false;
				Scanner e=new Scanner(System.in);
				System.out.println("Veillez donner le type d'abonnement du client : (Libre/Forfaitaire/Pr�pay�)");
		   do  {     
			    k=e.nextLine();        
		        for(TypeAbonnement a:TypeAbonnement.values()) {
		        	if(k.toUpperCase().equals(a.toString())) {v=true;break;}
		        }
		        if(!v) {System.out.println("Veuillez donner un type d'abonnement existant");}
		        }while(!v);	
		       instanabo(k.toUpperCase());
			}
	
	//M�thode Saisie
	public void Saisie() {
		String k;
		Scanner e=new Scanner(System.in);
		System.out.println("Veillez entrer le num�ro de telephone du client");
		do {
			k=e.nextLine();
			if (Operateur.ValiditeNum(k)==false)
				System.out.println("Entrer un num�ro de telephone valide !!");
				
			}while(Operateur.ValiditeNum(k)==false);
		this.NDT=k;
		System.out.println("Veillez entrer le num�ro de contrat du client");
		this.NDC=e.nextLine();
		this.choixtype();
		this.Relance=null;
		this.DDC=Date.Datepc();
		System.out.println("Veillez entrer le nom du client");
		this.nom=e.nextLine();
		System.out.println("Veillez entrer le prenom du client");
		this.pr�nom=e.nextLine();
		this.adresse.Saisir();
		this.adm.Saisir();
		this.etat=EtatClient.valueOf("DEBLOQUE");
	}
	//M�thode modifier adresse client
	public void Modifadr() {
		this.adresse.Modifier();
		
	}
	//M�thode modifier Etat
	public void Modifetat() {
		if(this.etat.toString().compareTo("BLOQUE")==0)
			this.etat=EtatClient.valueOf("DEBLOQUE");
	}
	
	public static void MenuModifClient() { //Menu modification client
		System.out.println("***************Menu modification client***************");
		System.out.println("1-Modifier l'adresse du client");
		System.out.println("2-D�bloquer le client s'il est bloqu�");
	}
	
	public static void MenuAjoutAppel() { //Menu ajout d'appel
		System.out.println("***************Menu ajout d'appel***************");
		System.out.println("1-Ajouter un appel entrant");
		System.out.println("2-Ajouter un appel sortant");
	}
	
	private static void MenuAjoutSMS() {//Menu ajout d'sms
		System.out.println("***************Menu d'ajout d'sms***************");
		System.out.println("1-Ajouter un sms entrant");
		System.out.println("2-Ajouter un sms sortant");
		
	}
	
	//Methode Mofifier
	public void Modifier() {
		Client.MenuModifClient();
		Scanner e=new Scanner(System.in);
		int i;
		System.out.println("Veillez Choisir une Op�ration");
		do {
		i=e.nextInt();
		e.nextLine();
		if(i>2 || i<0)
			System.out.println("Entrer un choix valide !!");
		
		}while(i>2 || i<1);
		
		switch(i) {
		case 1:{
			this.Modifadr();
			break;}
		case 2:{
			this.Modifetat();
			this.abn.setdateexp(this.abn.getexpdate(), 2);
			System.out.println("Le client est d�bloqu�");
			break;}
		default : break;
		}
	}
	
	//M�thode To String
	public String toString() {
	return("  Nom : "+this.nom+"\n  Pr�nom : "+this.pr�nom+"\n  Num�ro de telephone : "+this.NDT+"\n  Adresse : "+this.adresse+"\n  Adresse Mail : "
			+this.adm+"\n"+this.abn.toString());
	}
	
	//M�thode afficher
	public void afficher() {
		System.out.println(this.toString());
	}
	 
	//Ajouter Appel Sortant
	public void ajouterappelsortant() throws ExceptionSoldeIns
	{
		AppelSortant as=new AppelSortant();
		as.Saisie();
		int tarif=this.tarifappel(as.getnum());
		as.calculmontant(tarif);
		Heure dureebonus=null;
		if(this.bonus!=null && this.bonus.VerifBonus() && !bonus.bonusexp()) 
		{  
			switch(this.bonus.getClass().toString().substring(6))
			{
			case "BonusHeure":
				Heure hrdur�e=new Heure();
				Heure hrbonus=new Heure();
				Heure hrdur�e1=new Heure();
				int temps;
				hrdur�e=Dur�e.dur�eToheure(as.getdur�e()); // on r�cup�re la dur�e(arrondi) d'un appel dans un attribut de type Heure				
					temps=this.bonus.getval(); //on r�cup�re la valeur du bonus ( en minute )
					hrbonus.minToheu(temps); // convertir les minutes en heures ...
					if(hrbonus.comparer(hrdur�e)==1 ||hrbonus.comparer(hrdur�e)==0) { // si heure bonus >= la dur�e
						hrbonus.SoustraireTemps(hrdur�e.getHeure()*60+hrdur�e.getMinute()); // on fait la soustration
					this.bonus.setval(hrbonus.getHeure()*60+hrbonus.getMinute()); // on change la valeur du bonus
					as.setmont(0); // on met le tarif de l'appel a z�ro vu que on a utulis� le bonus ( Wach rayek hna samy !!)
					break;}
					else
					{
						hrdur�e.SoustraireTemps(hrbonus.getHeure()*60+hrbonus.getMinute()); //Dur�e d'appel restant
						hrdur�e1=hrbonus; // Dur�e 1�er appel
						dureebonus=hrbonus;
						this.bonus.setval(0);	// on met le bonus a z�ro
						as.setmont(as.getmont()-(hrdur�e1.getHeure()*60+hrdur�e.getMinute())*tarif);
						
					}
					
			case "BonusSolde":
				if(bonus.getval()>=as.getmont())
				{
					bonus.SoustraireBonus(as.getmont()); //Le bonus prend en charge le cout de l'appel
                       as.setmont(0);
				}
				else
				{   
					as.setmont(as.getmont()-bonus.getval()); //Le bonus prend en charge une partie du cout de l'appel l'abonnement se chargera du reste
					dureebonus=new Heure((bonus.getval()/tarif)/60,(bonus.getval()/tarif)%60);
					bonus.setval(0);						
					
				}
				
			case "BonusSMS":break;
			}
		    }
		  if(as.getmont()!=0)//si le bonus n'a pas pris en charge tout l'appel
		  {
			if(this.abn.expir�()) {
				if(dureebonus!=null)
				{
				Dur�e dr=new Dur�e(dureebonus.getHeure(),dureebonus.getMinute(),0);
				as.setdur�e(dr);
				}
				else
				{
					System.out.println("Votre Abonnement est expir�");
					return;
				}
			}
			else
			{
      			     switch(this.getabn().gettype()) 
		            {
	             	case LIBRE:break;
             		case FORFAITAIRE:Abonnementforfaitaire af=(Abonnementforfaitaire)this.abn;
             		
		        	 if(af.getmontant()<as.getmont()) 
		            	 { 
		        		 if(af.getmontant()<tarif) {
		        			 throw new ExceptionSoldeIns("Votre solde est insuffisant");
		        		 }
		        		    int minpossible=af.getmontant()/tarif;
							af.setmontant(af.getmontant()%tarif);
							Heure hr2=new Heure(0,0);
							hr2.minToheu(minpossible);
							Dur�e dr;
							if(dureebonus==null) {dr=new Dur�e(hr2.getHeure(),hr2.getMinute(),0);}
							else {
							 dureebonus.AjoutTemps(hr2);
							 dr=new Dur�e(dureebonus.getHeure(),dureebonus.getMinute(),0);
							}
							as.setdur�e(dr);// on met la dur�e de l'appel
							
			             }
			         else { af.debiter(as.getmont());
			                ;
			            }								 
			            break;
		
		            case PREPAYE:Abonnementpr�pay� ap=(Abonnementpr�pay�)this.abn;
		        	 if(ap.getmontant()<as.getmont()) 
	            	 { 
	        		    int minpossible=ap.getmontant()/tarif;
						ap.setmontant(ap.getmontant()%tarif);
						Heure hr2=new Heure(0,0);
						hr2.minToheu(minpossible);
						Dur�e dr;
						if(dureebonus==null) {dr=new Dur�e(hr2.getHeure(),hr2.getMinute(),0);}
						else {
						 dureebonus.AjoutTemps(hr2);
						 dr=new Dur�e(dureebonus.getHeure(),dureebonus.getMinute(),0);
						}
						as.setdur�e(dr);// on met la dur�e de l'appel
						
		             }
		         else { ap.debiter(as.getmont());
		                ;
		            }break;
			        }    
		      }
		}
		
		this.AS.add(as);
	}
	
	//D�terminer le tarif de l'appel
	private int tarifappel(String num) 
	{
		 String id1=this.NDT.substring(0,2);
		 String id2=num.substring(0,2);
		 
		 if(id1.equals(id2)) return 4; //M�me op�rateur
		 else {
			 boolean local=false;
			 
			 for(NomOperateur op : NomOperateur.values())
			 {
				 if(id2.equals(op.Identifiant())) {local=true;break;}
			 }
			 if(local) return 5; //op�rateur local
			 else return 20;//�tranger
		 }
	}
	
	//Ajouter AppelEntrant
	public void ajouterappelentrant() {
		AppelEntrant as=new AppelEntrant();
		as.Saisie();
		this.AE.add(as);
	}
	
	//Ajouter Appel
	public void ajouterappel()
	{   
		if(this.getetat()=="BLOQUE") {System.out.println("Ce client est bloqu�, l'ajout d'appel est impossible jusqu'"
				+ "au renouvellement de l'abonnement");}
		else {
		Client.MenuAjoutAppel();
		Scanner e=new Scanner(System.in);
		int i;
		System.out.println("Veillez Choisir une op�ration");	
		do {
		i=e.nextInt();
		if(i>2 || i<1)
			System.out.println("Entrer un choix valide !!");
		}while(i>2 || i<1);
		e.nextLine();
		
		switch(i) {
		case 1:{
			this.ajouterappelentrant();
			break;}
		case 2:{
			try {
			this.ajouterappelsortant();}
			catch(ExceptionSoldeIns k) {
				System.out.println(k.getMessage());
			}
			break;}
		default :break;
		}
	        }
	}
	
	//Ajouter un sms entrant
		public void ajoutersmsentrant()
		{
			SMS se=new SMS();
			se.Saisir(this);
			se.setstatus("RECU");
			this.SMSE.add(se);
		}
		
		//Ajouter Sms Sortant
		public void ajoutersmssortant() throws ExceptionSoldeIns
		{   
			SMSSortant ss=new SMSSortant();
			ss.Saisir(this);
			ss.Calculmontant();
			if(this.bonus!=null && this.bonus.VerifBonus() && !bonus.bonusexp()) 
			{  
				switch(this.bonus.getClass().toString().substring(6))
				{
				case "BonusHeure":break;
				case "BonusSolde":
					if(bonus.getval()>=ss.getmont())
					{
						bonus.SoustraireBonus(ss.getmont()); //Le bonus prend en charge le cout du SMS
	                       ss.setmontant(0);
	                       ss.setstatus("ENVOYE");
					}
					else
					{
						ss.setmontant(ss.getmont()-bonus.getval()); //Le bonus prend en charge une partie du cout du sms l'abonnement se chargera du reste
						bonus.setval(0);
					}
					
				case "BonusSMS":
					int taille=ss.getmont()/ss.tarifmessage();
					
					                       if(bonus.getval()>=taille) {
					                       bonus.SoustraireBonus(taille); //Le bonus prend en charge le cout du SMS
					                       ss.setmontant(0);
					                       ss.setstatus("ENVOYE");
			                        	   }
					                       else {
					                    	   taille -=bonus.getval();bonus.setval(0);  //Le bonus prend en charge une partie du cout du sms l'abonnement se chargera du reste
					   						
					                    	   ss.setmontant(ss.getmont()-ss.tarifmessage()*taille);
					                       }
				                        
					break;
				}
			    }
			  if(ss.getmont()!=0)//si le bonus n'a pas pris en charge tout le sms
			  {
				if(this.abn.expir�())ss.setstatus("ECHEC");
				else
				{
          			     switch(this.getabn().gettype()) 
			            {
		             	case LIBRE:break;
			   
	             		case FORFAITAIRE:Abonnementforfaitaire af=(Abonnementforfaitaire)this.abn;
			        	 if(af.getmontant()<ss.getmont()) 
			            	 { 
			        		    ss.setstatus("ECHEC");
			        		    this.SMSS.add(ss);
			        		    throw new ExceptionSoldeIns("Solde Insuffisant");
					            
				             }
				         else { af.debiter(ss.getmont());
				                ss.setstatus("ENVOYE");
				            }								 
				            break;
			
			            case PREPAYE:Abonnementpr�pay� ap=(Abonnementpr�pay�)this.abn;
			        	 if(ap.getmontant()<ss.getmont()) 
		            	 { 
		        		    ss.setstatus("ECHEC");
		        		    throw new ExceptionSoldeIns("Solde Insuffisant");
				            
			             }
			         else { ap.debiter(ss.getmont());
			                ss.setstatus("ENVOYE");
			            }break;
				        }    
			      }
			}
			
			
			this.SMSS.add(ss);
		}
		//ajouter un sms au client
		public void ajoutersms()//ajouter un sms au client
		{
			if(this.getetat()=="BLOQUE") {System.out.println("Ce client est bloqu�, l'envoie ou la r�c�ption de sms est impossible jusqu'"
					+ "au renouvellement de l'abonnement");}
			else {
			Client.MenuAjoutSMS();
			Scanner e=new Scanner(System.in);
			int i;
			System.out.println("Veillez Choisir une op�ration");	//verifier le choix d'une op�ration existante
			do {
			i=e.nextInt();
			if(i>2 || i<1)
				System.out.println("Entrer un choix valide !!");
			e.nextLine();
			}while(i>2 || i<1);
			switch(i) {
			case 1:
				this.ajoutersmsentrant(); //ajouter un sms entrant
				break;
			case 2://ajouter un sms sortant
				try {
				this.ajoutersmssortant();}
				catch(ExceptionSoldeIns k) {
					System.out.println(k.getMessage());
				}
				break;
			}
		        }		
		}
	
		//Calcul dur�e cumul�e appel sortant
		public Dur�e dureeas() {
			Dur�e dr=new Dur�e(0,0,0);
			 for(AppelSortant s: AS)
			  {
				  dr.AjoutTemps(s.getdur�e());
			  }
		    return dr;
		}
		
		//Calcul dur�e cumul�e appel entrant
        public Dur�e dureeae() {
					Dur�e dr=new Dur�e(0,0,0);
					 for(AppelEntrant s: AE)
					  {
						  dr.AjoutTemps(s.getdur�e());
					  }
				    return dr;
				}
	    
		//Afficher les dur�es cumul�es
		public void affdur�e()
		{
			System.out.println("Dur�e cumul�e des appels sortants: "+this.dureeas().toString());
			System.out.println("Dur�e cumul�e des appels entrants: "+this.dureeae().toString());

		}
		
		//Menu Bonus
		public void MenuBonus() {
			System.out.println("********** Menu Bonus **********");
			System.out.println("1-Bonus Heure");
			System.out.println("2-Bonus Solde");
			System.out.println("3-Bonus SMS");
			
		}
		
		//Ajouter Bonus
		public void AjoutBonus() {
			this.MenuBonus();
			int k;
			Scanner e=new Scanner(System.in);
			System.out.println("Choisissez le type de bonus");
			do {
				 k=e.nextInt();
				if(k<1 ||k>3)
					System.out.println("Entrer un choix valide !!!");
			}while(k<1 ||k>3);
			switch(k){
				case 1:{
					this.bonus=new BonusHeure();
					this.bonus.Ajouterbonus();
					break;
			}
				case 2:{
					this.bonus=new BonusSolde();
					this.bonus.Ajouterbonus();
					break;
				}
				case 3:{
					this.bonus=new BonusSMS();
					this.bonus.Ajouterbonus();
					break;
				}
				}
			
		}

	}//Fin de la classe
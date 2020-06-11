import java.util.Scanner;
import java.util.Vector;
	
	public class Operateur {
	private NomOperateur Nom;
	private Vector<PointDeVente> PDV;
	private Vector<PcWilaya> PCW;
	private Vector<Client> CL;
	private Vector<CarteRechargeUtilis�> CRU;
	
	//Get & Set
	String getNom() {return this.Nom.toString();}
	Vector<PointDeVente> getPDV() {return this.PDV;}
	Vector<PcWilaya> getPCW(){return this.PCW;}
	Vector<Client> getCL(){return this.CL;}
	NomOperateur getNomOp() {return this.Nom;}
	Vector<CarteRechargeUtilis�> getCRU() {return this.CRU;}
	
	
	//Constructeur Sans Param�tre
	Operateur(){
		this.Nom=null;
		this.PDV=null;
		this.PCW=null;
		this.CL=null;
		}
	
	//Constructeur Avec Param�tre
	Operateur(String nom,Vector<PointDeVente> PDV,Vector<PcWilaya> PCW,Vector<Client> CL){
		this.Nom=NomOperateur.valueOf(nom.toUpperCase());
		this.PDV=PDV;
		this.PCW=PCW;
		this.CL=CL;
		}
	
	//M�thode Ajouter Point De Vente
	public void AjoutPDV() {
		Scanner e=new Scanner(System.in);
		int k;
		int k1;
		int o=1;
		boolean l;
		boolean l1;
		int f;
		String num;
		PointDeVente pdv=new PointDeVente();
		pdv.Saisie();
		k1=this.RecherchPCW(pdv.getAdresse().getWilaya());
		l=this.Exist(pdv.getNumTel());
		l1=this.VerifCors(pdv.getNumTel());
		while (l1==false) {
			System.out.println("Entrer un numero de telephone qui appartient a l'op�rateur !!");
			num=e.nextLine();
			pdv.setnumTel(num);
			l1=this.VerifCors(pdv.getNumTel());
		}
		if(l==false) {
			if(k1!=-1)
			this.PDV.add(pdv);
		else {
			System.out.println("La wilaya de votre point de vente n'�xiste pas dans cet op�rateur , Veullez l'ajouter");
			PcWilaya pc=new PcWilaya();
			System.out.println("Entrer le pourcentage de la couverture");
			do {
				f=e.nextInt();
				if(f>100 || f<0)
					System.out.println("Pourcentage non valide !!");
			}while(f>100 || f<0);
			pc.SetPourcentage(f);
			pc.SetWilaya(pdv.getAdresse().getWilaya());
			this.PCW.add(pc);
			this.PDV.add(pdv);
		}
		}
		else {
			for (int i=0;i<this.PDV.size();i++) {
				if (this.PDV.elementAt(i).getNumTel().compareTo(pdv.getNumTel())==0) {
					o=i;
					break;
				}}
					if (o!=-1) {
						System.out.println("Le num�ro est d�ja utilis�, Voulez vous faire une modification ?");
						System.out.println("1-Oui");
						System.out.println("2-Non");
						k=e.nextInt();
						e.nextLine();
						do {
							if(k>2 ||k<1)
								{System.out.println("Entrer un choix correcte !!");}
							}while(k>2 ||k<1);
						switch(k)
						{
						case 1:{this.PDV.elementAt(o).Modif();}
						case 2:break;
						}
					}
					else 
						System.out.println("Le Num�ro est d�ja utulis� par un client, Op�ration Impossible");
			}
		
		}
	//M�thode Recherche Point De Vente
	public int RecherchPDV(String num) {
		int j;
		int i=-1;
		for(j=0;j<PDV.size();j++)
		{
			if (PDV.elementAt(j).getNumTel().compareTo(num)==0)
			{i=j;
			break;}
		}
		return(i);
	}
		
	//M�thode Modifier Point De Vente
	public void ModifPDV(String num) {
		Scanner e=new Scanner(System.in);
		int i,l;
		int k=-1;
		i=this.RecherchPDV(num);
		if (i!=-1)
		{
			this.PDV.elementAt(i).Modif();
			k=this.RecherchPCW(this.PDV.elementAt(i).getAdresse().getWilaya());
			if (k==-1) {
				System.out.println("La wilaya de votre point de vente n'�xiste pas dans cet op�rateur , Veullez l'ajouter");
				PcWilaya pc=new PcWilaya();
				System.out.println("Entrer le pourcentage de la couverture");
				do {
					l=e.nextInt();
					if(l>100 || l<0)
						System.out.println("Pourcentage non valide !!");
				}while(l>100 || l<0);
				pc.SetPourcentage(l);
				pc.SetWilaya(this.PDV.elementAt(i).getAdresse().getWilaya());
				this.PCW.add(pc);
			}
		}
		
		else 
			System.out.println("Op�ration Impossbile : Point de vente Non disponible");
	}
	
	
	//M�thode Supprimer Point De Vente
	public void SupprimPDV(String num) {
		int i;
		i=this.RecherchPDV(num);
		if (i!=-1)
		{
			this.PDV.removeElementAt(i);
		}
		else 
			System.out.println("Op�ration Impossbile : Point de vente Non disponible");
	}
	
	//M�thode Ajouter Wilaya()
	public void AjoutWil() {
		Scanner e=new Scanner(System.in);
		int k;
		PcWilaya wil=new PcWilaya();
		wil.SaisirWil();
		if(this.PCW!=null) {
		k=this.RecherchPCW(wil.getWilaya());
		if(k==-1)	// La Wilaya n'existe pas
		this.PCW.add(wil);
		else {
			
			System.out.println("La wilaya existe d�ja, Voulez vous faire une modification ?");
			System.out.println("1-Oui");
			System.out.println("2-Non");
			do
			{	k=e.nextInt();
				if(k>2 ||k<1)
					{System.out.println("Entrer un choix correcte !!");}
				}while(k>2 ||k<1);
			switch(k)
			{
			case 1:{this.ModifPCW(wil.getWilaya(),wil.getPourcentage());
			break;}
			case 2:break;
			}
	}
	}
		else this.PCW.add(wil);
	}
		//M�thode Recherche Wilaya
		public int RecherchPCW(String wilaya) {
		int j;
		boolean k=false;
		int i=-1;
		for(Wilaya l: Wilaya.values()) {
			if (l.toString().compareTo(wilaya.toUpperCase())==0)
			{
				k=true;
				break;
			}
		}
		if (k==false)
		{
			System.out.println("Le nom de la wilaya n'est pas correcte !!");
		}
		else {
			
		for(j=0;j<PCW.size();j++)
		{
			
			if (PCW.elementAt(j).getWilaya().toUpperCase().compareTo(wilaya.toUpperCase())==0)
			{i=j;
			break;}
		}
		}
		return(i);
	}
	
		//M�thode Modifier Pourcentage d'une 

		public void ModifPCW(String  wilaya,int k) {
			int i;
			i=this.RecherchPCW(wilaya);
			if(i==-1)
				System.out.println("Op�ration impossible : la wilaya n'existe pas");
			else if
				(k<0 || k>100)
				{
				throw new IllegalArgumentException("Pourcentage non valide !!");
				}
			else
				PCW.elementAt(i).SetPourcentage(k);
				}
		
		//Methode Supprimer Wilaya
		public void SuppWilaya(String wilaya) {
			int k=this.RecherchPCW(wilaya);
			if(k==-1)
				System.out.println("Operation Impossible : Wilaya non disponible");
				else
					PCW.removeElementAt(k);
		}
		
			//Methode Verifier la corr�spondance du num�ro avec l'op�rateur
			public boolean VerifCors(String nm) {
			String str;
			str=nm.substring(0, 2);
			if (this.Nom.Identifiant().compareTo(str)==0)
					return true;
				else return false;
				}
		
				//Methode Recherche Client
				public int RechercheClient(String nmt ) {
				boolean c1=false,c2=false;
				int j=-1;
				c1=ValiditeNum(nmt);
				if(c1==false) {
				System.out.println("Num�ro de telephone n'est pas valide");
				return j;
				}
				c2=this.VerifCors(nmt);
				if (c2==false) {
			    System.out.println("Ce Num�ro de telephone n'appartient pas a cet operateur");
			    return j;
				}
					for(int i=0;i<this.CL.size();i++) {
						if (this.CL.elementAt(i).getNDT().compareTo(nmt)==0)
						{j=i;
						break;
						}
					}
					return j;
				}
				
				//Methode Ajouter Client
				public void AjoutClient() {
					Scanner e=new Scanner(System.in);
					int k;
					int o=1;
					boolean l;
					boolean m1=false;
					Client cl=new Client();
					cl.Saisie();
					l=this.Exist(cl.getNDT());
					if(l==false) {
						for (int i=0;i<this.PCW.size();i++) {
							if(cl.getadresse().getWilaya().compareTo(this.PCW.elementAt(i).getWilaya())==0) {
								this.CL.add(cl);
								m1=true;
								break;}
							}
						if (m1==false) {
							System.out.println("Ajout impossible la wilaya n'est pas couvert");
						}
					}
						
					else {
						for (int i=0;i<this.CL.size();i++) {
							if (this.CL.elementAt(i).getNDT().compareTo(cl.getNDT())==0) {
								o=i;
								break;
							}}
								if (o!=-1) {
									System.out.println("Le num�ro est d�ja utilis�, Voulez vous faire une modification ?");
									System.out.println("1-Oui");
									System.out.println("2-Non");
									k=e.nextInt();
									e.nextLine();
									do {
										if(k>2 ||k<1)
											{System.out.println("Entrer un choix correcte !!");}
										}while(k>2 ||k<1);
									switch(k)
									{
									case 1:{this.CL.elementAt(o).Modifier();break;}
									case 2:break;
									}
								}
								else 
									System.out.println("Le Num�ro est d�ja utulis� par un op�rateur, Op�ration Impossible");
						}
					
					}
					
				//Methode Modifier Client
				public void ModifClient(String num) {
					int k=this.RechercheClient(num);
					if (k==-1)
						System.out.println("Operation Impossible : Client non disponible");
					else {
						this.CL.elementAt(k).Modifier();
						if(this.CL.elementAt(k).getetat().compareTo("BLOQUE")==0)
							this.BloquerClient(num);
						if(this.CL.elementAt(k).getetat().compareTo("DEBLOQUE")==0) {
							Client ko=new Client();
							ko=this.ClbToCl(k);
							this.CL.add(ko);
							this.CL.remove(k);
						}
					}
				}
				
				//Methode Supprimer Client
				public void SuppClient(String num) {
					int k=this.RechercheClient(num);
					if(k==-1)
						System.out.println("Operation Impossible : Client non disponible");
						else
							CL.removeElementAt(k);
				}
				
				//Methode Num Existe ( il verifier tout les points de vente et les cilent )
				public boolean Exist(String num) {
					int i;
					int j;
					i=this.RecherchPDV(num);
					j=this.RechercheClient(num);
					if (i==-1 && j==-1)
						return false;
					else return true;
					
				}
				
				//M�thode static pour verifier la validit� d'un num�ro
				public static boolean ValiditeNum(String numtel)
				{
					boolean c1=true,c2=true,c3=true;
					
					if(numtel.length()!=10)
					{c1=false;}
					
					for (char temps: numtel.toCharArray())
					{
					    if(!(Character.isDigit(temps))) {
					    	c2=false;}
					}
					    if(numtel.charAt(0)!='0')
					    {c3=false;}
					    
					if (c1==false || c2==false || c3==false) 
					return false;
					else return true;
				}
				
				//Convertir element Client to CientBloqu�
				public ClientBloqu� ClToClb(int i){
					Scanner e=new Scanner(System.in);
					System.out.println("Entrez le motif de blocage: ");
					String mtf=e.nextLine();				
					ClientBloqu� k=new ClientBloqu� (this.CL.elementAt(i),Date.Datepc(),mtf);
					return k;
				}
				
				//Convertir element ClientBloqu� to Client
				public Client ClbToCl(int i) {
					Client kl=new Client();
					kl=this.CL.elementAt(i);
					return kl;
					}
				
				
				//Bloquer Client
				public void BloquerClient(String num) {
					int k=this.RechercheClient(num);
					if(k==-1)
					System.out.println("Operation Impossible : Client non disponible");
					else
						this.CL.elementAt(k).setEtat("BLOQUE");
					ClientBloqu� kl=new ClientBloqu�();
					
					kl=this.ClToClb(k);
					this.CL.add(kl);
					this.CL.remove(k);
					
				}
				
				
				// Afficher les clients d'abonnement libre
				public void AffichCLL() {
					int i=0;int k=0;
					System.out.println("");
					System.out.println("Liste des clients ayant un abonnement Libre :");
					for(i=0;i<this.CL.size();i++) {
						
						if(this.CL.elementAt(i).getabn() instanceof AbonnementLibre) {
							System.out.println("Client N� :"+(k+1));k++;				
							this.CL.elementAt(i).afficher();
						}
						
					}
				}
				
				//Afficher les clients d'abonnement Prepaye
				public void AffichCLP() {
					int i=0;int k=0;
					System.out.println("");
					System.out.println("Liste des clients ayant un abonnement Prepaye :");
					for(i=0;i<this.CL.size();i++) {
						if(this.CL.elementAt(i).getabn() instanceof Abonnementpr�pay�) {
							System.out.println("Client N� :"+(k+1));k++;				
							this.CL.elementAt(i).afficher();
						}
						
					}}
				
				//Afficher les clients d'abonnement Forfaitaire
				public void AffichCLF() {
					int i=0;int k=0;
					System.out.println("");
					System.out.println("Liste des clients ayant un abonnement Forfaitaire :");
					for(i=0;i<this.CL.size();i++) {
						if(this.CL.elementAt(i).getabn() instanceof Abonnementforfaitaire) {
							System.out.println("Client N� :"+(k+1));k++;				
							this.CL.elementAt(i).afficher();
						}
						
					}
					}
				
				
		//Afficher Liste des clients Par type d'abonnement
		public void AffichParType() {
			this.AffichCLL();
			this.AffichCLP();	
			this.AffichCLF();
				}
		
		//Afficher Liste Des Num�ros Bloqu�s
		public void AffichNumBloqu�() {
			int k=0;
			System.out.println("********** Liste des clients Bloqu�s ********** ");
			for(int i=0;i<this.CL.size();i++) {
				if (this.CL.elementAt(i).getetat().compareTo("BLOQUE")==0)
					System.out.println((k+1)+")"+this.CL.elementAt(i).getNDT());k++;
			}
		}
		
		//Afficher les num�ros relanc�s
		public void AffichNumRelanc�() {
			int k=0;
			System.out.println("********** Liste des num�ros relanc�s **********");
			for(int i=0;i<this.CL.size();i++) {
				if(this.CL.elementAt(i).getRelance().size()>0)
					System.out.println((k+1)+")"+this.CL.elementAt(i).getNDT());k++;
			}
		}
				
			//Afficher les clients par wilaya
				public void AfficheParWilaya() {
					System.out.println("********** Liste des clients par wilaya **********");
					for (Wilaya wil: Wilaya.values()) {
						int k;
						int l=1;
						k=this.RecherchPCW(wil.toString());
						if(k!=-1) {
							System.out.println(wil.toString()+" :");
						for(int i=0;i<this.CL.size();i++) {
							if(this.CL.elementAt(i).getadresse().getWilaya().compareTo(wil.toString())==0) {
								System.out.print((l+")"));
								this.CL.elementAt(i).afficher();}
							l++;
						}
						System.out.println("");
						}
					}
				}
				
				//Relancer les clients qui n'ont pas pay�
				public void relancerclient() {
					Client c;
				   for(int i=0;i<CL.size();i++) {//parcours de clients
					c=CL.elementAt(i);
					if(c.getetat().equals("DEBLOQUE"))
					{
					if(c.getabn().expir�()) 
					{int jours;
					switch(c.getabn().gettype()) 
					{	
					 case LIBRE:
					    jours=10*(c.getRelance().size()+1);
					    
						if(c.getabn().expir�depuis(jours)) {
							//bloquer si 3eme relance
							if(c.getRelance().size()==2) {
								System.out.println("Le client d�tenant le num�ro "+c.getNDT()+" a atteint le nombre maximal d"
										+ "e relances, ce num�ro est d�sormais bloqu�.");
								this.BloquerClient(c.getNDT());
								c.getRelance().removeAllElements();
								i--;		
								}
							else {
							//relancer client							
							c.getRelance().add(Date.Datepc());
							System.out.println("Num�ro "+c.getNDT()+" relanc�!");
							}
						}
						break;
					 default:
						jours=30*(c.getRelance().size()+1);
					    if(c.getabn().expir�depuis(jours)) {
						//bloquer si 3eme relance
						if(c.getRelance().size()==2) {
							System.out.println("Le client d�tenant le num�ro "+c.getNDT()+" a atteint le nombre maximal d"
									+ "e relances, ce num�ro est d�sormais bloqu�.");
							this.BloquerClient(c.getNDT());			
							c.getRelance().removeAllElements();	
							i--;
							
							}
						else {
						//relancer client
						c.getRelance().add(Date.Datepc());
						System.out.println("Num�ro "+c.getNDT()+" relanc�!");
						}
					 }
					    break;
				 	}
				   }
				 }
					}
				
				}	
				
				//Methode Rechargement du compte pour client Prepay�
				public void RechargerCompte(String num) {
					int i=this.RechercheClient(num);
					if (i!=-1) {
						if(this.CL.elementAt(i).getabn().toString().compareTo("PREPAYE")==0) {
							Abonnementpr�pay� ap=(Abonnementpr�pay�)this.CL.elementAt(i).getabn();
							Abonnementpr�pay�.MenuRecharg();
							Scanner e=new Scanner(System.in);
							System.out.println("Veuillez Choisir la carte de recharge qui vous convient");
							int temps;
							do {
								temps=e.nextInt();
								if (temps<1 || temps>4)
									System.out.println("Veuillez choisir une carte de recharge disponbile !!");
							}while(temps<1 || temps>3);
							e.nextLine();
							CarteRecharge c=new CarteRecharge();
								switch(temps) {
								case 1:{
			
									c.setMontant(200);
									c.Activ�CarteRech();
									CarteRechargeUtilis� cr=new CarteRechargeUtilis�(c);
									cr.setnumutulisateur(num); 
									this.CRU.add(cr);
									((Abonnementpr�pay�)this.CL.elementAt(i).getabn()).getCRU().add(cr);
									ap.AjoutMontant(200);
									break;
								}
								case 2:{
									c.setMontant(500);
									c.Activ�CarteRech();
									CarteRechargeUtilis� cr=new CarteRechargeUtilis�(c);
									this.CRU.add(cr);
									ap.AjoutMontant(500);
									break;
								}
								case 3:{
									c.setMontant(1000);
									c.Activ�CarteRech();
									CarteRechargeUtilis� cr=new CarteRechargeUtilis�(c);
									this.CRU.add(cr);
									ap.AjoutMontant(1000);
									break;
								}
								case 4:{
									c.setMontant(2000);
									c.Activ�CarteRech();
									CarteRechargeUtilis� cr=new CarteRechargeUtilis�(c);
									this.CRU.add(cr);
									ap.AjoutMontant(2000);
									break;
								}
								}
						}
						else 
							System.out.println("votre type d'abonnement n'admet pas l'option de recharge");
					}
					else
						System.out.println("Ce client n'a pas un abonnement valide pour la recharge du compte");
				}
				
				//Afficher client ayant b�n�fici� d'un bonus
				public void affclientbonus()
				{
					for(Client c:this.CL) {
						if(c.getBonus()!=null) c.afficher();
					}
				}
				
				//Afficher client ayant un abonnement expir�
				public void affclientexp()
				{
					for(Client c:this.CL) {
						if(c.getabn().expir�()) { c.afficher();System.out.println();}
					}
				}
				
			    //Etablir facture
				public void etablirfacture(String num)
				{
					int k=this.RechercheClient(num);
					if(k==-1) {
						System.out.println("Ce numero n'existe pas dans cet operateur");
					}
					else
					{ 
					  Client c=this.CL.elementAt(k);
					  if(c.getabn().gettype().toString().equals("LIBRE")) {
						  AbonnementLibre al=(AbonnementLibre)c.getabn();
						  al.Calculfacture(c.getAS(), c.getSMSS());
						  System.out.println("Facture �tablie pour le client titulaire du num�ro: "+num);
						  System.out.println("");
						  this.afficherfacture(c);
					  }
					  else {
						  System.out.println("Ce client n'a pas un abonnement avec facture");
					  }
					}
				}
				
				
				//Affcher les d�tails d'une facture
				public void afficherfacture(Client c)
				{
					System.out.println("Nom: "+c.getnom());
					System.out.println("Prenom: "+c.getprenom());
					System.out.println("Num�ro de contrat: "+c.getNDC());
					System.out.println("Liste des appels �mis:");
					this.AffichAS(c.getNDT());		
					AbonnementLibre al=(AbonnementLibre)c.getabn();
					System.out.println("Total du montant � payer: "+al.getfacture()+" DA");				
				}
				
				
				//Afficher les factures en instance de payement
				public void afffactureinst()
				{   TypeAbonnement ta=TypeAbonnement.valueOf("LIBRE");
					for(Client c:this.CL) {
						if(c.getetat().equals("DEBLOQUE") && c.getabn().expir�() && c.getabn().gettype()==ta) {
							this.etablirfacture(c.getNDT());
							this.afficherfacture(c);
						}
					}
				}
				
				//Afficher appels sortant
				public void AffichAS(String num) {
					int i=this.RechercheClient(num);
					if (i!=-1) {
					for (int k=0;k<this.CL.elementAt(i).getAS().size();k++) {
						System.out.print("\n"+(k+1)+")");
						this.CL.elementAt(i).getAS().elementAt(k).Afficher();
					}
				}
					else
						System.out.println("Ce num�ro n'appartient pas a cet op�rateur");
				}
				
					//Afficher appels entrants
					public void AffichAE(String num) {
						int i=this.RechercheClient(num);
						if (i!=-1) {
						for (int k=0;k<this.CL.elementAt(i).getAE().size();k++) {
							System.out.print("\n"+(k+1)+")");
							this.CL.elementAt(i).getAE().elementAt(k).Afficher();
						}
					}
						else
							System.out.println("Ce num�ro n'appartient pas � cet op�rateur");}
					
					//Afficher SMS Sortant
					public void AffichSMSS(String num) {
						int i=this.RechercheClient(num);
						if (i!=-1) {
						for (int k=0;k<this.CL.elementAt(i).getSMSS().size();k++) {
							System.out.print("\n"+(k+1)+")");
							this.CL.elementAt(i).getSMSS().elementAt(k).afficher();
						}
					}
						else
							System.out.println("Ce num�ro n'appartient pas � cet op�rateur");}
					
					//Afficher SMS Entrant
					public void AffichSMSE(String num) {
						int i=this.RechercheClient(num);
						if (i!=-1) {
						for (int k=0;k<this.CL.elementAt(i).getSMSE().size();k++) {
							System.out.print("\n"+(k+1)+")");
							this.CL.elementAt(i).getSMSE().elementAt(k).afficher();
						}
					}
						else
							System.out.println("Ce num�ro n'appartient pas � cet op�rateur");}
					
					//Afficher Client
					public void AffichClient(String num) {
						Scanner e=new Scanner(System.in);
						int k;
						int i=this.RechercheClient(num);
						if(i!=-1) {
							System.out.println("****** Afficher Client ******");
							System.out.println("1)Informations Client");
							System.out.println("2)Appels Client");
							System.out.println("3)SMS");
							do {
								k=e.nextInt();
								if(k<1 || k>3)
									System.out.println("Entrer un choix valide !!");
							}while(k>3 || k<1);
							e.nextLine();
							switch(k) {
							case 1:this.CL.elementAt(i).afficher();;break;
							case 2 :
								System.out.print("Appels Entrant :");
								this.AffichAE(num);
								System.out.println();
								System.out.print("Appels Sortant : ");
								this.AffichAS(num);
							break;
							case 3 :
								System.out.print("SMS Entrant:");
								this.AffichSMSE(num);
								System.out.println();
								System.out.print("SMS Sortant:");
								this.AffichSMSS(num);
								break;
							}
							
								
							}
						
						else System.out.println("Ce num�ro n'appartient pas � cet op�rateur");
						}
					
					//A
					
					
					//Afficher Dur�e Cumul�
					public void AffichDur�eCumul�(String num) {
						int i=this.RechercheClient(num);
						if(i!=-1) {
							this.CL.elementAt(i).affdur�e();
						}
						else
							System.out.println("Ce num�ro n'appartient pas � cet op�rateur");}
					
					//Afficher Les Points De Vente
					public void AfficherPDV() {
						int i=1;
						if (this.PDV!=null) {
							for(PointDeVente pdv:this.PDV) {
								System.out.print("\n"+i+")");
								pdv.Afficher();
								i++;}
						}
					}
					
					//Afficher Les wilaya avec Pourcentage de couverture
					public void Afficherwilaya() {
						int i=1;
						if (this.PCW!=null) {
							for(PcWilaya pcw:this.PCW) {
								System.out.print(i+")");
								pcw.Afficher();
								i++;
						}
						}
					}
					
					//AfficherOp�rateur
					public void AfficherOp�rateur() {
						System.out.println(this.toString());
						System.out.println("Les Points De Ventes : ");
						this.AfficherPDV();
						System.out.println("\nLew wilayas avec leur pourcentage de couverture : \n");
						this.Afficherwilaya();
				        
					}
					
					//ToString
					public String toString() {
						return "Nom Operateur: "+this.getNom()+"\nIdentifiant: "+this.Nom.Identifiant();}
					
					//AjouterBonus
					public void AjouterBonus(String num) {
						int i=this.RechercheClient(num);
						if(i!=-1) {
							this.CL.elementAt(i).AjoutBonus();
						}
						else
							System.out.println("Ce num�ro n'appartient pas � cet op�rateur");
					}
					
					//AjouterAppel
					public void AjouterAppel(String num) {
						int i=this.RechercheClient(num);
						if(i!=-1) {
							this.CL.elementAt(i).ajouterappel();
						}
						else
							System.out.println("Ce num�ro n'appartient pas a cet op�rateur");
					}
					
					//AjouterSMS
					public void AjouterSMS(String num) {
						int i=this.RechercheClient(num);
						if(i!=-1) {
							this.CL.elementAt(i).ajoutersms();
						}
						else
							System.out.println("Ce num�ro n'appartient pas a cet op�rateur");
					}
					
					
					
					
	
}//Fin Classe Op�rateur
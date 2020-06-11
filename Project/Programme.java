import java.util.Scanner;
import java.util.Vector;

public class Programme {
    public static void RempAuto(Operateur op) {
    	
    	//Client 1
		   Client cl1=(new Client("0557149278",new Vector<Date>(),new AbonnementLibre(new Date(2,"janvier",2018)),"2",Date.Datepc(),"Djezairi",
				     "Samy",new Adresse(0,"jr","Oran"),new AdresseMail("sal@hotmail.fr"),EtatClient.DEBLOQUE,
				     new Vector<AppelSortant>(),
					new Vector<AppelEntrant>(),new Vector<SMSSortant>(),new Vector<SMS>(),null));
		   
		   //Appel Sortant
		     AppelSortant aps1=new AppelSortant ("0547895412",new Date(14,"NOVEMBRE",2017),new Heure(14,17),new Durée(0,5,15),4);
		     AppelSortant aps2=new AppelSortant ("0777548963",new Date(24,"Janvier",2018),new Heure(7,15),new Durée(0,2,45),5);
		     AppelSortant aps3=new AppelSortant ("0558369810",new Date(1,"Mars",2018),new Heure(20,10),new Durée(0,12,11),4);
		     cl1.getAS().add(aps1);
		     cl1.getAS().add(aps2);
		     cl1.getAS().add(aps3);
		     
		   //Appel Entrant
		     AppelEntrant ape1=new AppelEntrant("0547895412",new Date(2,"FEVRIER",2018),new Heure(10,17),new Durée(0,1,17));
		     AppelEntrant ape2=new AppelEntrant("0647211036",new Date(7,"NOVEMBRE",2017),new Heure(00,05),new Durée(0,14,15));
		     cl1.getAE().add(ape1);
		     cl1.getAE().add(ape2);
		     
		     //SMS Sortant
		     SMSSortant smss1=new SMSSortant ("0557149278","0662102478",new Date(14,"AVRIL",2015),new Heure(10,22),"ENVOYE","HELLO From the other side",
		 			10);
		     SMSSortant smss2=new SMSSortant ("0557149278","0777854120",new Date(1,"MAI",2018),new Heure(9,22),"ENVOYE","SAHA AIDKOM",
		    		 5);
		     cl1.getSMSS().add(smss1);
		     cl1.getSMSS().add(smss2);
		     
		     //SMS Entrant
		     SMS smse1=new SMS("0662102478","0557149278",new Date(10,"DECEMBRE",2017),new Heure(6,22),"RECU","ou est tu ?");
		     SMS smse2=new SMS("0762102378","0557149278",new Date(1,"SEPTEMBRE",2016),new Heure(17,38),"RECU","MABROK EL BAC ?");
		     cl1.getSMSE().add(smse1);
		     cl1.getSMSE().add(smse2);
		     
		   //Client 2
			   Client cl2=(new Client("0540874123",new Vector<Date>(),new AbonnementLibre(),"2",Date.Datepc(),"Addouche",
					     "Mouloud",new Adresse(23,"Kouba","Alger"),new AdresseMail("mouloudaddouche53@gmail.com"),EtatClient.DEBLOQUE,
					     new Vector<AppelSortant>(),
						new Vector<AppelEntrant>(),new Vector<SMSSortant>(),new Vector<SMS>(),null));
			   
			   //Appel Sortant
			     AppelSortant aps4=new AppelSortant ("0547895412",new Date(8,"NOVEMBRE",2016),new Heure(11,10),new Durée(0,8,15),4);
			     AppelSortant aps5=new AppelSortant ("0778236010",new Date(30,"Janvier",2017),new Heure(1,18),new Durée(0,23,05),5);
			     AppelSortant aps6=new AppelSortant ("0552369874",new Date(2,"Mars",2018),new Heure(23,10),new Durée(0,10,19),4);
			     cl2.getAS().add(aps4);
			     cl2.getAS().add(aps5);
			     cl2.getAS().add(aps6);
			     
			   //Appel Entrant
			     AppelEntrant ape3=new AppelEntrant("0550505050",new Date(2,"FEVRIER",2018),new Heure(10,17),new Durée(0,1,39));
			     AppelEntrant ape4=new AppelEntrant("0666666621",new Date(7,"NOVEMBRE",2017),new Heure(00,05),new Durée(0,1,15));
			     cl2.getAE().add(ape3);
			     cl2.getAE().add(ape4);
			     
			     //SMS Sortant
			     SMSSortant smss3=new SMSSortant ("0540874123","0664102478",new Date(30,"AVRIL",2015),new Heure(10,0),"ENVOYE","Ou est la voiture",
			 			10);
			     SMSSortant smss4=new SMSSortant ("0540874123","0762854120",new Date(20,"FEVRIER",2017),new Heure(7,22),"ECHEC","WACH NAKLO?",
			    		 5);
			     cl2.getSMSS().add(smss3);
			     cl1.getSMSS().add(smss4);
			     
			     //SMS Entrant
			     SMS smse3=new SMS("0551102030","0540874123",new Date(8,"Janvier",2014),new Heure(10,22),"RECU","saha mouloudkom");
			     SMS smse4=new SMS("0777897410","0540874123",new Date(22,"SEPTEMBRE",2012),new Heure(17,38),"RECU","okay");
			     cl2.getSMSE().add(smse3);
			     cl2.getSMSE().add(smse4);
			     
		     //Client 3
			    
			     Client cl3=(new Client("0555737912",new Vector<Date>(),new Abonnementforfaitaire(10,new Date(19,"MAI",2018)) ,"2",Date.Datepc(),"Bouabid",
					     "Idir",new Adresse(10,"Boufarik","Blida"),new AdresseMail("Bouabid10@hotmail.com"),EtatClient.DEBLOQUE,
					     new Vector<AppelSortant>(),
						new Vector<AppelEntrant>(),new Vector<SMSSortant>(),new Vector<SMS>(),null));
			   
			   //Appel Sortant
			     AppelSortant aps7=new AppelSortant ("0771020308",new Date(8,"NOVEMBRE",2016),new Heure(21,10),new Durée(0,28,15),5);
			     AppelSortant aps8=new AppelSortant ("0577121214",new Date(10,"Janvier",2017),new Heure(17,11),new Durée(0,23,05),5);
			     AppelSortant aps9=new AppelSortant ("0668203987",new Date(2,"Juin",2017),new Heure(2,19),new Durée(0,41,19),5);
			     cl3.getAS().add(aps7);
			     cl3.getAS().add(aps8);
			     cl3.getAS().add(aps9);
			     
			   //Appel Entrant
			     AppelEntrant ape5=new AppelEntrant("0666231410",new Date(2,"FEVRIER",2018),new Heure(12,17),new Durée(0,51,23));
			     AppelEntrant ape6=new AppelEntrant("0772874521",new Date(7,"NOVEMBRE",2017),new Heure(22,05),new Durée(1,10,15));
			     cl3.getAE().add(ape5);
			     cl3.getAE().add(ape6);
			     
			     //SMS Sortant
			     SMSSortant smss5=new SMSSortant ("0555737912","0668741478",new Date(10,"AVRIL",2018),new Heure(10,45),"ENVOYE","Bonjour !!",
			 			10);
			     SMSSortant smss6=new SMSSortant ("0555737912","0778201120",new Date(17,"FEVRIER",2017),new Heure(12,22),"ECHEC","t'as ramené le projet ?",
			    		 5);
			     cl3.getSMSS().add(smss5);
			     cl3.getSMSS().add(smss6);
			     
			   //SMS Entrant
			     SMS smse5=new SMS("0555108030","0555737912",new Date(8,"Janvier",2017),new Heure(14,22),"RECU","A demain alors");
			     SMS smse6=new SMS("0777897410","0555737912",new Date(22,"SEPTEMBRE",2016),new Heure(22,38),"RECU","ok, j'attends");
			     cl3.getSMSE().add(smse5);
			     cl3.getSMSE().add(smse6);
			     
			    //Client 4
			     Client cl4=(new Client("0552303987",new Vector<Date>(), new Abonnementforfaitaire(2000,new Date(24,"Avril",2017)),"2",Date.Datepc(),"Mansouri",
					     "Yanis",new Adresse(10,"Rouiba","BOUMERDES"),new AdresseMail("Yanisman@gmail.com"),EtatClient.DEBLOQUE,
					     new Vector<AppelSortant>(),
						new Vector<AppelEntrant>(),new Vector<SMSSortant>(),new Vector<SMS>(),null));
			   
			   //Appel Sortant
			     AppelSortant aps10=new AppelSortant ("0772103069",new Date(8,"NOVEMBRE",2016),new Heure(21,10),new Durée(0,28,15),5);
			     AppelSortant aps11=new AppelSortant ("0555541120",new Date(10,"Janvier",2017),new Heure(17,11),new Durée(0,23,05),5);
			     AppelSortant aps12=new AppelSortant ("0669874102",new Date(2,"Juin",2017),new Heure(2,19),new Durée(0,41,19),5);
			     cl4.getAS().add(aps10);
			     cl4.getAS().add(aps11);
			     cl4.getAS().add(aps12);
			     
			   //Appel Entrant
			     AppelEntrant ape7=new AppelEntrant("0554547896",new Date(22,"Mars",2018),new Heure(16,17),new Durée(0,10,23));
			     AppelEntrant ape8=new AppelEntrant("0778201036",new Date(10,"Mai",2018),new Heure(23,05),new Durée(0,59,15));
			     cl4.getAE().add(ape7);
			     cl4.getAE().add(ape8);
			     
			     //SMS Sortant
			     SMSSortant smss7=new SMSSortant ("0552303987","0662232478",new Date(27,"MARS",2018),new Heure(23,25),"ENVOYE","Bonwiii",
			 			10);
			     SMSSortant smss8=new SMSSortant ("0552303987","0772254120",new Date(26,"FEVRIER",2017),new Heure(7,22),"ENVOYE","j'arrivee !!",
			    		 5);
			     cl4.getSMSS().add(smss7);
			     cl4.getSMSS().add(smss8);
			     
			   //SMS Entrant
			     SMS smse7=new SMS("0556982030","0552303987",new Date(8,"Janvier",2014),new Heure(19,22),"RECU","saha mouloudkom");
			     SMS smse8=new SMS("0777847410","0552303987",new Date(22,"SEPTEMBRE",2012),new Heure(07,38),"RECU","reponds moi");
			     cl4.getSMSE().add(smse7);
			     cl4.getSMSE().add(smse8);
			     
			     //Client 5
			     Client cl5=(new Client("0562737912",new Vector<Date>(),new Abonnementprépayé(),"2",Date.Datepc(),"Ounadi",
					     "Katia",new Adresse(11,"Draria","Alger"),new AdresseMail("Katiaoun@hotmail.com"),EtatClient.DEBLOQUE,
					     new Vector<AppelSortant>(),
						new Vector<AppelEntrant>(),new Vector<SMSSortant>(),new Vector<SMS>(),null));
			   
			   //Appel Sortant
			     AppelSortant aps13=new AppelSortant ("0554236987",new Date(8,"NOVEMBRE",2016),new Heure(21,10),new Durée(0,28,15),4);
			     AppelSortant aps14=new AppelSortant ("0542792287",new Date(26,"Janvier",2017),new Heure(17,11),new Durée(0,23,05),4);
			     AppelSortant aps15=new AppelSortant ("0668201117",new Date(24,"Juin",2017),new Heure(6,19),new Durée(0,41,19),5);
			     cl5.getAS().add(aps13);
			     cl5.getAS().add(aps14);
			     cl5.getAS().add(aps15);
			     
			   //Appel Entrant
			     AppelEntrant ape9=new AppelEntrant("0542792287",new Date(2,"FEVRIER",2018),new Heure(11,17),new Durée(0,41,23));
			     AppelEntrant ape10=new AppelEntrant("0541036524",new Date(14,"NOVEMBRE",2017),new Heure(20,05),new Durée(2,10,15));
			     cl5.getAE().add(ape9);
			     cl5.getAE().add(ape10);
			     
			     //SMS Sortant
			     SMSSortant smss9=new SMSSortant ("0562737912","0664102478",new Date(30,"AVRIL",2015),new Heure(10,0),"ENVOYE","Ou est la voiture",
			 			10);
			     SMSSortant smss10=new SMSSortant ("0562737912","0762854120",new Date(20,"FEVRIER",2017),new Heure(7,22),"ECHEC","WACH NAKLO?",
			    		 5);
			     cl5.getSMSS().add(smss9);
			     cl5.getSMSS().add(smss10);
			     
			     //SMS Entrant
			     SMS smse9=new SMS("0551102030","0562737912",new Date(8,"Janvier",2017),new Heure(10,22),"RECU","j'ai reuissi a avoir un visa ");
			     SMS smse10=new SMS("0665412036","0562737912",new Date(22,"SEPTEMBRE",2017),new Heure(17,48),"RECU","mabrok el bac");
			     cl5.getSMSE().add(smse9);
			     cl5.getSMSE().add(smse10);
			     
			     //Ajouter
			     op.getCL().add(cl1);
			     op.getCL().add(cl2);
			     op.getCL().add(cl3);
			     op.getCL().add(cl4);
			     op.getCL().add(cl5);
			     
			   //Remplissage wilaya
				   PcWilaya pw=new PcWilaya(90,"alger");
				   op.getPCW().add(pw);
				   pw=new PcWilaya(14,"blida");
				   op.getPCW().add(pw);
				   pw=new PcWilaya(62,"oran");
				   op.getPCW().add(pw);
				   pw=new PcWilaya(75,"Boumerdes");
				   op.getPCW().add(pw);
				   
				   //Remplissage Point De Vente
				   PointDeVente pv=new PointDeVente("OOREDOO ALGER","Principale",41,"Casbah","Alger","0550000000");
				   op.getPDV().add(pv);
				   pv=new PointDeVente("OOREDOO ORAN","principale",12,"Glycines","Oran","0550000001");
				   op.getPDV().add(pv);
				   pv=new PointDeVente("OOREDOO ADRAR","secondaire",7,"el ham","adrar","0550000002");
				   op.getPDV().add(pv);
				   pv=new PointDeVente("OOREDOO TIPAZA","secondaire",80,"le port","tipaza","0550000003");
				   op.getPDV().add(pv);
				   pv=new PointDeVente("OOREDOO BLIDA","principale",7,"la placette","blida","0550000004");
				   op.getPDV().add(pv);
				   pv=new PointDeVente("OOREDOO SETIF","secondaire",80,"ain el tar","setif","0550000005");
				   op.getPDV().add(pv);	   
				   
    }

	public static void MenuP() {
		System.out.println("\n***************Menu de gestion***************");
		System.out.println("1-Remplissage automatique des données");
		System.out.println("2-Gestion de l'opérateur");
		System.out.println("3-Gestion des clients");
		System.out.println("4-Gestion des factures");
		System.out.println("5-Gestion des bonus");
		System.out.println("6-Quitter\n");

	}
	public static void Menupdv() {
		System.out.println("***************Gestions de l'opérateur***************");
		System.out.println("1-Afficher les informations de l'opérateur");
		System.out.println("2-Ajouter point de vente");
		System.out.println("3-Supprimer point de vente");
		System.out.println("4-Modifier point de vente");
		System.out.println("5-Afficher points de ventes");
		System.out.println("6-Ajouter une wilaya");
		System.out.println("7-Supprimer une wilaya");
		System.out.println("8-Changer pourcentage de couverture d'une wilaya");
		System.out.println("9-Afficher les wilaya avec pourçentage de couverture");
		System.out.println("10-Retour");
	}
	public static void Menuclient() {
		System.out.println("***************Gestion des clients***************");
		System.out.println("1-Ajouter clients");
		System.out.println("2-Modifier clients");
		System.out.println("3-Supprimer clients");
		System.out.println("4-Afficher les clients par type d'abonnement");
		System.out.println("5-Afficher les numéros bloqués");
		System.out.println("6-Afficher les clients par wilaya");
		System.out.println("7-Afficher les numéros relancés");
		System.out.println("8-Afficher un client");
		System.out.println("9-Afficher les durées cumulées d'un client");
		System.out.println("10-Ajouter un appel pour un client");
		System.out.println("11-Ajouter un SMS pour un client");
		System.out.println("12-Retour");

	}
	
	public static void Menufacture() {
		System.out.println("***************Gestion des factures***************");
		System.out.println("1-Etablir facture pour un numéro donné"); 
		System.out.println("2-Afficher tous les numéros arrivés à échéance de paiement");
		System.out.println("3-Toutes les factures en instance de paiement");
		System.out.println("4-Relancer les numéros pour les rechargements/ paiements");
		System.out.println("5-Retour");

	}
	public static void Menubonus() {
		System.out.println("***************Gestion des bonus***************");
		System.out.println("1-Affecter bonus à un client");
		System.out.println("2-Afficher les clients ayant bénéficié de bonus");
		System.out.println("3-Retour");

	}
	
	public static void main(String[] args) {
	      String num;int x;Operateur op=new Operateur("OOREDOO",new Vector<PointDeVente>(),new Vector<PcWilaya>(),new Vector<Client>());
	      Scanner e=new Scanner(System.in);
	      boolean remplis=false;
	   while(true) {
		   Programme.MenuP(); //Menu principal
		   System.out.println("Choisir une opération");
		   x=e.nextInt();
		   while(x>6 || x<1) {
			   System.out.println("Veuillez choisir une opération existante.");
			   x=e.nextInt();
		   }
		   
		   switch(x) {
		   case 1://Remplissage automatique
			   
			   Programme.RempAuto(op);    
			   remplis=true;
			   break;
		   case 2://Gestion de l'opérateur
			   if(!remplis)System.out.println("Veuillez remplir les données au préalable");
			   else {
			   Programme.Menupdv(); 
			   System.out.println("Choisir une opération");
			   x=e.nextInt();
			   while(x>10 || x<1) {
				   System.out.println("Veuillez choisir une opération existante.");
				   x=e.nextInt();
			   }
			   
			   switch(x){
			   case 1:op.AfficherOpérateur();;break;//informations de l'opérateur
			   case 2:op.AjoutPDV();;break; //Ajouter un point de vente
			   case 3:System.out.println("Donnez le numéro du point de vente à supprimer:"); //Supprimer un point de vente
			   e.nextLine();
			   num=e.nextLine();
				   op.SupprimPDV(num);break;
			   case 4:System.out.println("Donnez le numéro du point de vente à modifier:"); //Modifier le point de vente
			   e.nextLine();
			   num=e.nextLine();
			    op.ModifPDV(num);break;
			   case 5:op.AfficherPDV();break; //Afficher les informations du point de vente
			   case 6:op.AjoutWil();break; //Ajouter wilaya
			   case 7:System.out.println("Donnez le nom de la wilaya a supprimer ");
			   e.nextLine();
			   String kl=e.nextLine();
			   op.SuppWilaya(kl);
			   break;
			   case 8:System.out.println("Donnez la wilaya:"); //Changer pourcentage de couverture d'une wilaya
			   	e.nextLine();
			               String wilaya=e.nextLine();
			               System.out.println("Donnez le nouveau pourcentage:");
			               int k=e.nextInt();e.nextLine();
			              op.ModifPCW(wilaya, k);
			               break;
			   case 9:op.Afficherwilaya();
			   case 10:break;

			   }
			   }
			   break;
		   case 3://Menu des clients
			   if(!remplis)System.out.println("Veuillez remplir les données au préalable");
			   else {
			   Programme.Menuclient(); 
			   System.out.println("Choisir une opération");
			   x=e.nextInt();
			   while(x>12 || x<1) {
				   System.out.println("Veuillez choisir une opération existante.");
				   x=e.nextInt();
			   }
			   switch(x) {
			   case 1://Ajouter un client
				   op.AjoutClient();
				   break;
			   case 2://Modifier un client
				   System.out.println("Donnez le numéro de client à modifier:");
				   e.nextLine();
				   num=e.nextLine();
				   op.ModifClient(num);
				  break;
			   case 3://Supprimer un client
				   System.out.println("Donnez le numéro de client à supprimer:");
				   e.nextLine();
				   num=e.nextLine();
				   op.SuppClient(num);
				   break;
			   case 4:op.AffichParType();	//Afficher les clients par type			   
			   break;
			   case 5:op.AffichNumBloqué(); // Afficher la liste des numéros bloqués
				   break;
			   case 6:op.AfficheParWilaya(); // Afficher les clients par wilaya
			   break;
			   case 7:op.AffichNumRelancé(); // Afficher les numéros relancées
			   break;
			   case 8:System.out.println("Donnez le numéro de client à afficher:"); // Afficher client
			   e.nextLine();
			   num=e.nextLine();
			   op.AffichClient(num);
				   break;
			   case 9:System.out.println("Donnez le numéro de client pour lequel vous voulez afficher les durées cumulées d'appels:"); // Durée Cumuléés
			   e.nextLine();     
			   num=e.nextLine();
				   op.AffichDuréeCumulé(num);break;
			   case 10:System.out.println("Donnez le numéro de client pour lequel vous voulez ajouter un appel:"); //Ajouter appel a un client
			   e.nextLine();		
			   num=e.nextLine();
				   op.AjouterAppel(num);break; 
			   case 11:System.out.println("Donnez le numéro de client pour lequel vous voulez ajouter un SMS:"); //Ajouter un SMS a un client
			   e.nextLine();
			   num=e.nextLine();
			   op.AjouterSMS(num);break; 
			   case 12:break;
			   }
			   }
			   break;
		   case 4://Menu des factures
			   if(!remplis)System.out.println("Veuillez remplir les données au préalable");
			   else {
			   Programme.Menufacture(); 
			   System.out.println("Choisir une opération");
			   x=e.nextInt();
			   while(x>5 || x<1) {
				   System.out.println("Veuillez choisir une opération existante.");
				   x=e.nextInt();
			   }
			   
			   switch(x) {
			   case 1:System.out.println("Donnez le numéro de client pour lequel vous voulez établir la facture :"); //Etablir facture
			   e.nextLine();num=e.nextLine();
			   op.etablirfacture(num);
				   break;
			   case 2:op.affclientexp(); //Afficher tous les numéros arrivés à échéance de paiement
			   break;
			   case 3:op.afffactureinst(); //Toutes les factures en instance de paiement
				   break;
     		   case 4:op.relancerclient(); //Relancer les numéros pour les rechargements/ paiements
     		   break;
			   case 5:break;
			   
			   }
			   }
			   break;
		   case 5://Menu des bonus
			   if(!remplis)System.out.println("Veuillez remplir les données au préalable");
			   else {
			   Programme.Menubonus(); 
			   System.out.println("Choisir une opération");
			   x=e.nextInt();
			   while(x>3 || x<1) {
				   System.out.println("Veuillez choisir une opération existante.");
				   x=e.nextInt();
			   }
			   switch(x)
			   {
			   case 1:System.out.println("Donnez le numéro de client pour lequel vous voulez ajouter un bonus :");// Ajouter un bonus
				  e.nextLine(); num=e.nextLine();
			   op.AjouterBonus(num);break;
			   case 2:op.affclientbonus();break; //Afficher les clients ayant bénéficié de bonus
			   case 3:break;

			   }
			   }
			   break;
		   case 6:System.exit(0);

			   

			   
			   
		   }
	   }
	        

	}

}

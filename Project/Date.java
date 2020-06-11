import java.util.Calendar;
	public class Date {
	private int jour;
	private Mois mois;
	private int ann�e;
	int getjour() {return jour;}
	String getmois() {return mois.toString();}
	int getann�e() {return ann�e;}

	// Constructeur Sans Param�tre
	Date()
	{
	this.jour=03;
	this.mois=Mois.valueOf("MARS");
	this.ann�e=00;
	}

	//Constructeur Avec Param�tre
	Date(int jour,String mois,int ann�e)
	{
	this.jour=jour;
	this.mois=Mois.valueOf(mois.toUpperCase());
	this.ann�e=ann�e;
	}

	

	//M�thode Conversion Mois pour l'affichage
	public String Convert1() 
	{
	switch(this.getmois())
	{
	case "JANVIER" : return ("01");
	case "FEVRIER" : return ("02");
	case "MARS" : return ("03");
	case "AVRIL" : return ("04");
	case "MAI" : return ("05");
	case "JUIN" : return("06");
	case "JUILLET" : return ("07");
	case "AOUT" : return ("08");
	case "SEPTEMBRE" : return ("09");
	case "OCTOBRE" : return("10");
	case "NOVEMBRE" :return ("11");
	case "DECEMBRE" : return ("12");
	default : return ("00");
	}	
	}
	
	//M�thode Conversion Mois pour la manipulation
	public int Convert3() 
	{
	switch(this.getmois())
	{
	case "JANVIER" : return (01);
	case "FEVRIER" : return (02);
	case "MARS" : return (03);
	case "AVRIL" : return (04);
	case "MAI" : return (05);
	case "JUIN" : return(06);
	case "JUILLET" : return (07);
	case "AOUT" : return (8);
	case "SEPTEMBRE" : return (9);
	case "OCTOBRE" : return(10);
	case "NOVEMBRE" :return (11);
	case "DECEMBRE" : return (12);
	default : return (00);
	}	
	}

	public static String Convert2(int k)
	{
	switch(k)
	{
	case 1 : return"JANVIER";
	case 2 : return"FEVRIER";
	case 3 : return"MARS";
	case 4 : return"AVRIL";
	case 5 : return"MAI";
	case 6 : return"JUIN";
	case 7 : return"JUILLET";
	case 8 : return"AOUT";
	case 9 : return"SEPTEMBRE";
	case 10 : return"OCTOBRE";
	case 11 : return"NOVEMBRE";
	case 12 :return"DECEMBRE";
	default : return("ok");
	
	}
	}
	
	//M�thode to string
	public String toString() {
	if (this.jour<9)
	return("0"+this.jour+"/"+this.Convert1()+"/"+this.getann�e());
	else 
		return(this.jour+"/"+this.Convert1()+"/"+this.getann�e());
}
	
	//M�thode afficher
	public void Affich() {
		System.out.println(this.toString());
	}
	
	//Methode Date Pc
	public static Date Datepc() {
		
		 Calendar cal = Calendar.getInstance();
	      int k=cal.get(Calendar.MONTH)+1;
	      Date Dt=new Date(cal.get(Calendar.DATE),Date.Convert2(k),cal.get(Calendar.YEAR));
	      return Dt;
	}
	
	//Methode Ajouter une date a une autre
	public void AddDate(Date dt) {
		 Calendar cal = Calendar.getInstance();
		 Date dt2=new Date();
		 cal.set(Calendar.YEAR, this.ann�e);
		 cal.set(Calendar.MONTH, this.Convert3()-1);
		 cal.set(Calendar.DATE, this.jour);
		 cal.add(Calendar.DATE, dt.jour);
		 cal.add(Calendar.MONTH, dt.Convert3());
		 cal.add(Calendar.YEAR, dt.ann�e);
		 dt2=CalToDate(cal);
		 this.jour=dt2.jour;
		 this.mois=dt2.mois;
		 this.ann�e=dt2.ann�e;
	}
	
	
	//Methode Convertir Calendar to date
	public static Date CalToDate(Calendar cal) {
		Date dt=new Date();
	      int k=cal.get(Calendar.MONTH)+1;
		dt.ann�e=cal.get(Calendar.YEAR);
		 dt.mois=Mois.valueOf(Convert2(k));
		 dt.jour=cal.get(Calendar.DATE);
		 return dt;
	}
	
	//M�thode Compare
 	public int compare(Date dt) {
	String m1;
	String m2;
	if(this.getann�e()<dt.getann�e()) return -1;
	else if (this.getann�e()>dt.getann�e()) return 1;
	else {
	m1=this.Convert1();
	m2=dt.Convert1();
	if(m1.compareTo(m2)<0) return -1;
	else if (m1.compareTo(m2)>0) return 1;
	else {
		if(this.getjour()<dt.getjour()) return -1;
		else if(this.getjour()>dt.getjour()) return 1;
		else return 0;
	}}}
	}//Fin de la Classe Date
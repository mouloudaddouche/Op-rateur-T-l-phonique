import java.util.Calendar;

public abstract class Abonnement {
	
	private TypeAbonnement type;
	private Date Expdate;	
	public TypeAbonnement gettype() {return type;}
	public Date getexpdate() {return Expdate;}
	
	
	Abonnement(String type){this.type=TypeAbonnement.valueOf(type);}
	Abonnement(String type,Date d)
	{
		this.type=TypeAbonnement.valueOf(type);
		this.Expdate=d;
	}
	
	public String toString() 
	  {
		  return "Abonnement "+type.toString()+"  Date d'expiration: "+Expdate.toString();
	  }
	
	 
	 
	public void Afficher()
	{
		System.out.println(this.toString());
	}
	
	public boolean expiré()
	{	if(Date.Datepc().compare(Expdate)==-1) return false;
		else return true;
	}
	
	public boolean expirédepuis(int j)
	{	
		Calendar c=Calendar.getInstance();
		c.set(Calendar.DATE, Expdate.getjour());c.set(Calendar.MONTH, Expdate.Convert3()-1);c.set(Calendar.YEAR, Expdate.getannée());
		c.add(Calendar.DATE, j);
		Calendar cal=Calendar.getInstance();
		if(c.after(cal)) return false;
		else return true; 
		   
	}
	
	public void setdateexp(Date d,int duree) //date d'aujourd'hui + un nombre de mois
	{  Calendar cal=Calendar.getInstance();
	   cal.add(Calendar.MONTH, duree);
	   d=new Date(cal.get(Calendar.DATE),Date.Convert2(cal.get(Calendar.MONTH)+1),cal.get(Calendar.YEAR));
		this.Expdate=d;
	}
}

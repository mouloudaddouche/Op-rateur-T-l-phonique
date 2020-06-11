import java.util.Vector;

public class AbonnementLibre extends Abonnement {
       
	  private double facture;
	  private final float TVA=(float) 0.19;
	  public double getfacture() {return facture;}
	  	  
	  AbonnementLibre(){
		  super("LIBRE");
		  facture=0;
		  this.setdateexp(super.getexpdate(), 2);
	  }
	  
	  AbonnementLibre(Date datef)
	  {   super("LIBRE",datef);
		  facture=0;
	  }
	  
	  public void Calculfacture(Vector<AppelSortant> as,Vector<SMSSortant> sms){
		  facture=0;
		  for(AppelSortant s: as)
		  {
			  facture+=s.getmont();
		  }
		  for(SMSSortant s: sms)
		  {
			  facture+=s.getmont();
		  }
		  
		  facture=facture*(1+TVA)+500;
	  }
	
}

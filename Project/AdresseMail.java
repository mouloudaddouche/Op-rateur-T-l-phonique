import java.util.Scanner; 	
public class AdresseMail {
	
	   private enum Nomsite {USTHB,YAHOO,HOTMAIL,GMAIL,OUTLOOK}
	   private String nomuser;
	   private String extension;
	   private Nomsite s;
	   
	   //Get
	   String getnom() {return nomuser;}
	   String getextension() {return extension;}
	   String getsite() {return s.toString();}
	   
	   // Méthode Retourne le Site
	   public String Site() {
		   return(this.getsite()+"."+this.extension);
	   }
	   
	   //Verifier si une adresse est valide
	  private boolean Verif(String am) 
	   { 
		   int inda=am.indexOf('@');
		  
		   if(inda==-1 || inda==0)return false; //Verification de l'@
		  
		   int indp=am.lastIndexOf('.');
		  
		   if(indp==-1) return false;  //Verification du point
		   
		   String site=am.substring(inda+1, indp);
		   boolean sit=false;                       //Verification du site
		   for(Nomsite s : Nomsite.values()) 
		   {
			   if(site.toUpperCase().equals(s.toString())) {sit=true;break;} 
		   }
		   
		   if (sit==false) return false;
		 
		   String ext=am.substring(indp+1,am.length());
		   switch(ext)                     //Verification de l'extension
		   {  case "dz" : return true;
		      case "fr" : return true;
		      case "com" : return true;
		      default : return false; 
		   }
	   }
		   
	   //Constructeur sans paramètres 
	   AdresseMail()
	   {
		   this.nomuser=null;
		   this.extension=null;
		   this.s=null;
	   }
	   
	   AdresseMail(String am){
		   int inda=am.indexOf('@');
		   int indp=am.lastIndexOf('.');
		   this.nomuser=am.substring(0,inda);
		   this.extension=am.substring(indp+1,am.length());
		   this.s=Nomsite.valueOf((am.substring(inda+1,indp)).toUpperCase());
	   }
	   
	   //Méthode de saisie
	   public void Saisir() 
	   {
		   Scanner e=new Scanner(System.in);
		   System.out.println("Donnez votre adresse mail :");
		   String adr=e.nextLine();
		   while(!Verif(adr)) {
			   System.out.println("Adresse mail érroné");
			   System.out.println("Veuillez donner une adresse mail correcte: ");
			   adr=e.nextLine();
		   }
		   int inda=adr.indexOf('@');
		   int indp=adr.lastIndexOf('.');
		   this.nomuser=adr.substring(0,inda);
		   this.extension=adr.substring(indp+1,adr.length());
		   this.s=Nomsite.valueOf((adr.substring(inda+1,indp)).toUpperCase());
		  
	   } 
	   
	   public String toString() {
		   return(nomuser+"@"+s.toString()+"."+extension);  //Retourner l'adresse mail sous forme d'une chaine de caractères
	   }
	   
	   public void Afficher() {
		   System.out.println("Adresse mail : "+this.toString());   //Afficher l'adresse mail
	   }
	  
	 
}
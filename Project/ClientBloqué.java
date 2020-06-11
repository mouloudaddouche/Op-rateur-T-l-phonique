

public class ClientBloqu� extends Client {
	private Date DateDeBloquage;
	private String MotifDeBloquage;
	
	//Get
	String getDate() {return this.DateDeBloquage.toString();}
	String getMotif() {return this.MotifDeBloquage;}
	
	//Constructeur Sans Param�tre
	ClientBloqu�(){
		super();
		this.DateDeBloquage=null;
		this.MotifDeBloquage=null;
	}
	
	//Constructeur Avec Param�tre
	ClientBloqu�(Client cl,Date dt,String Mtf){
		super(cl.getNDT(),cl.getRelance(),cl.getabn(),cl.getNDC(),cl.getDDC(),cl.getnom(),cl.getprenom(),
				cl.getadresse(),cl.getadm(),cl.getetatt(),cl.getAS(),cl.getAE(),cl.getSMSS(),
				cl.getSMSE(),cl.getBonus());
			this.DateDeBloquage=dt;
			this.MotifDeBloquage=Mtf;
	}

}//Fin Classe
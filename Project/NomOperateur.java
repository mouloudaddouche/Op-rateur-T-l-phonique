public enum NomOperateur {
	OOREDOO("05"),DJEZZY("07"),MOBILIS("06"),ALGERIETELECOM("02");
	private String numident;
	
	//Constructeur Sans Param�tre
	NomOperateur() {}
	
	//Constructeur Avec Param�tre
	NomOperateur(String in)
	{
		this.numident=in;
	}
	
	public String Identifiant() {
		return(this.numident);
	}
}
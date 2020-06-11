

 public interface Bonus {
	 
	 //get
	 public Date getdatelimite();
	 public int getval();
	 
	 //set
	   public void setdatel(Date d);
	   public void setval(int val);
	   	abstract public void Ajouterbonus();
	 		
	 		//Methode Soustraire du bonus
			public void SoustraireBonus(int temps);
	 		
	 		//Methode Actualiser la date d'éxpr
			   public void ActualiserDateExp();
			   
			 //Methode verifier si il'a un bonus actuellement
				public boolean VerifBonus();
				
				public boolean bonusexp();
				
				//Methode Synchronisation du bonus
				public void SynchBonus();
				
				//Methode to String
				   public String toString();
				   
				 //Methode Afficher
				 	public void Afficher();

}// Fin De Classe
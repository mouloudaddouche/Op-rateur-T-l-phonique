import java.util.Scanner;

public class Adresse {
	    
		private int num;
		private String nomrue;
		private Wilaya wilaya;
		
		//Get
		String getWilaya() {return this.wilaya.toString();}
		
		
		//Constructeur Sans Paramétre
		Adresse(){
			this.num=0;
			this.nomrue=null;
			this.wilaya=null;
			}
		
		//Constructeur Avec Paramétre
		Adresse(int num,String nomrue,String wilaya)
		{
			this.num=num;
			this.nomrue=nomrue;
			this.wilaya=Wilaya.valueOf(wilaya.toUpperCase());
		}
		
		//les methodes
		
		//Methode Saisir
		public void Saisir() {
			String wil;
			boolean k=false;
			Scanner e=new Scanner(System.in);
			System.out.println("Entrer le numéro de la rue");
			this.num=e.nextInt();
			e.nextLine();
			System.out.println("Entrer le nom de la rue");
			this.nomrue=e.nextLine().toUpperCase();
			System.out.println("Entrer le nom de la wilaya");
			do {
			wil=e.nextLine();
			for(Wilaya l:Wilaya.values()) {
				if (l.toString().compareTo(wil.toUpperCase())==0)
				{
					k=true;
					break;
				}
				
			}
			if (k==false)
			{
				System.out.println("Entrer un nom de wilaya correcte !!!");
			}
			}while(k==false);
			this.wilaya=Wilaya.valueOf(wil.toUpperCase());
		}
		
		//Methode To String
		public String toString() {
		return("Adresse ; "+this.num+"éme Rue "+this.nomrue+","+this.wilaya);
		}
		
		//Méthode Afficher
		public void afficher()
		{
			System.out.println(toString());
		}
		
		//Methode Modif Num
		public void ModifNum() {
			Scanner e=new Scanner(System.in);
			System.out.println("Entrer le numéro de la rue");
			this.num=e.nextInt();
			e.nextLine();
		}
		
		//Methode Modif Nom
		public void ModifNom() {
			Scanner e=new Scanner(System.in);
			System.out.println("Entrer le nom de la rue");
			this.nomrue=e.nextLine();
		}
		
		//Methode Modif Wilaya
		public void ModifWilaya() {
			Scanner e=new Scanner(System.in);
			System.out.println("Entrer le nom de la wilaya");
			String wilaya=e.nextLine();
			boolean k=false;
			for(Wilaya l:Wilaya.values()) {
				if (l.toString().compareTo(wilaya.toUpperCase())==0)
				{
					k=true;
					break;
				}
				
				}
			if(k==false)
				System.out.println("Modification échouée !!");
			else
				this.wilaya=Wilaya.valueOf(wilaya.toUpperCase());
			
			}
		
		
		// Méthode Modifier
		public void Modifier() {
				this.ModifNum();
				this.ModifNom();
				this.ModifWilaya();
			}
			
		
		}//Fin de la classe
	
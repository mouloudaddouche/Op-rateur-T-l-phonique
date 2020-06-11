import java.util.Scanner;
public class PointDeVente {
	
	private enum TypePDV {PRINCIPALE,SECONDAIRE;}
	private String NomAgence;
	private TypePDV type;
	private Adresse adresse;
	private String NumTel;
	
	// Get & Set
	
	String getNomAgence(){return this.NomAgence;}
	String getType(){return this.type.toString();} 
	Adresse getAdresse() {return this.adresse;}
	String getNumTel() {return this.NumTel;}
	
	void setnumTel(String numtel) {this.NumTel=numtel;}
	
	//Constructeur Sans Param�tre
	
	PointDeVente(){
		this.NomAgence=null;
		this.type=null;
		this.adresse=null;
		this.NumTel=null;
	}
	
	// Constructeur Avec Param�tre
	PointDeVente(String NomAgence,String type,int num,String nomrue,String wilaya,String NumTel){
		this.NomAgence=NomAgence;
		this.type=TypePDV.valueOf(type.toUpperCase());
		this.adresse= new Adresse(num,nomrue,wilaya);
		if(Operateur.ValiditeNum(NumTel)==false)
		{
			throw new IllegalArgumentException("Num�ro de tel�phone non valide");
		}
		else
			this.NumTel=NumTel;
	}
	
	//Methode Saisie
	void Saisie() {
		String typeagnc;
		boolean k=false;
		String numtel;
		boolean c;
		Scanner e=new Scanner(System.in);
		System.out.println("Entrer le nom de l'agence");
		this.NomAgence=e.nextLine();
		System.out.println("Entrer le type de l'agence");
		do {
			typeagnc=e.nextLine();
			for(TypePDV l:TypePDV.values()) {
			if (l.toString().compareTo(typeagnc.toUpperCase())==0)
			{
				k=true;
				break;
			}
			}
			if (k==false)
			{
				System.out.println("Entrer un type correcte !!!");
			}
	}while(k==false);
		this.type=TypePDV.valueOf(typeagnc.toUpperCase());
		this.adresse=new Adresse();
		this.adresse.Saisir();
		System.out.println("Entrer le num�ro de telephone de l'agence");
		do {
			
			numtel=e.nextLine();
			c=Operateur.ValiditeNum(numtel);
			if(c==false)
			System.out.println("Entrer un num�ro de t�l�phone valide !!!");
			}while(c==false);
		this.NumTel=numtel;

	}
	
	
	//M�thode Modifier Type
	public void Modiftype() {
		if (this.type.toString().compareTo("PRINCIPALE")==0)
			this.type=TypePDV.valueOf("SECONDAIRE");
		else
			this.type=TypePDV.valueOf("PRINCIPALE");
	}
	
	//M�thode Modifier l'adresse
	public void ModifAdresse() {
		this.adresse.Modifier();
	}
	
	//Methode Static Menu Modif
	public static void MenuModif() {
	
		System.out.println("***************Menu Modification Point De Vente***************");
		System.out.println("1-Modifier l'adresse");
		System.out.println("2-Modifier le type");
	}
	//M�thode Modifier
	public void Modif(){
					Scanner e=new Scanner(System.in);
					int i;
					MenuModif();
					
					System.out.println("Veillez Choisir une Op�ration");
					do {
					i=e.nextInt();
					e.nextLine();
					if(i>3 || i<0)
						System.out.println("Entrer un choix valide !!");
					
					}while(i>2 || i<1);
					switch(i) {
					case 1:{this.ModifAdresse();
					break;
					}
					case 2:{
					this.Modiftype();		
					break;
					}
				}		
		}
	public String toString() {
		return("Nom Agence : "+this.NomAgence+"  Type : "+this.type.toString()+"  Adresse : "+this.adresse.toString()+"  Numero de "
				+ "telephone : "+this.NumTel);
	}
	public void Afficher() {
		System.out.println(this.toString());
	}
	}//Fin de la classe
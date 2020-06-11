import java.util.Scanner;
public class PcWilaya {
private int Poucentage;
private Wilaya nomwilaya;

//Get
int getPourcentage() {return this.Poucentage;}
String getWilaya() {return this.nomwilaya.toString();}

//Set
void SetPourcentage(int prc) {this.Poucentage=prc;}
void SetWilaya(String nm) {this.nomwilaya=Wilaya.valueOf(nm);}


// Constructeur Sans paramétre 
	PcWilaya(){
		this.Poucentage=0;
		this.nomwilaya=null;
	}
	
	// Constructeur Avec paramétre 
	PcWilaya(int pourcentage,String wilaya ){
		if(this.Poucentage>100 || this.Poucentage<0)
			throw new IllegalArgumentException("Pourcentage non valide !!");
		else this.Poucentage=pourcentage;
		this.nomwilaya=Wilaya.valueOf(wilaya.toUpperCase());
	}
	
	//Méthode Saisir
	public void SaisirWil() {
		boolean k=false;
		String wil;
		Scanner e=new Scanner(System.in);
		int i;
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
		this.nomwilaya=Wilaya.valueOf(wil.toUpperCase());
		
		System.out.println("Entrer le pourcentage de la couverture");
		do
		{
			i=e.nextInt();
			if (i>100 || i<0)
				System.out.println("Entrer un pourcentage Correcte");
		}while (i>100 || i<0);
		this.Poucentage=i;
	}
	
	//Methode to String
	public String toString() {
		
		return("Nom Wilaya : "+this.nomwilaya.toString()+"  Pourcentage : "+this.Poucentage+"%");
	}
	
	public void Afficher() {
		System.out.println(this.toString());
	}
	}
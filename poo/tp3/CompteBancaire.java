package tp3;

import java.util.Scanner;

public class CompteBancaire {
    private static int currentNumber = 0;
    private int numCompte;
    private String nomClient;
    private String prenomClient;
    private double solde;
    private static String nomBanque = "AL-BARAKA";
    private static String codeAgence = "AGENCE-CODE-107";
    private final  String typeCompte;

    

    public CompteBancaire(String nomClient, String prenomClient, double solde, String typeCompte) {
        this.nomClient = nomClient;
        this.prenomClient = prenomClient;
        this.solde = solde;
        this.typeCompte = typeCompte;
        this.numCompte = currentNumber++;
    }

    public CompteBancaire(){
        Scanner sc = new Scanner(System.in);
        System.out.println("entrer le nom : ");
        this.nomClient = sc.nextLine();
        System.out.println("entrer le prenom : ");  
        this.prenomClient = sc.nextLine();
        System.out.println("entrer le solde : ");
        this.solde = sc.nextDouble();
        this.numCompte = currentNumber++;
        System.out.println("enter le type de compte : ");
        System.out.println("1- compte courant");
        System.out.println("2- compte epargne");
        int choix = sc.nextInt();
        this.typeCompte = choix == 1 ? "compteCourant" : "compteEpargne";

       
    }


    public int getNumCompte() {
        return numCompte;
    }

    public String getNomClient() {
        return nomClient;
    }

    public String getPrenomClient() {
        return prenomClient;
    }

    public double getSolde() {
        return solde;
    }

    public static String getNomBanque() {
        return nomBanque;
    }

    public static String getCodeAgence() {
        return codeAgence;
    }

    public String getTypeCompte() {
        return typeCompte;
    }

  
    public void setNumCompte(int numCompte) {
        this.numCompte = numCompte;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

    public void setPrenomClient(String prenomClient) {
        this.prenomClient = prenomClient;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    @Override
    public String toString() {
        return "CompteBancaire [numCompte=" + numCompte + ", nomClient=" + nomClient + ", prenomClient=" + prenomClient
                + ", solde=" + solde + ", typeCompte=" + typeCompte + "]";
    }

  

}

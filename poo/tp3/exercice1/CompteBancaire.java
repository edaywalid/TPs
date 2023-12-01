package tp3.exercice1;

import java.util.Scanner;

public class CompteBancaire {
    private static int currentId = 0;
    private static int nombreDuCompteCrees = 0;
    private int numCompte;
    private String nomClient;
    private String prenomClient;
    private double solde;
    private static String nomBanque = "AL-BARAKA";
    private static String codeAgence = "AGENCE-CODE-107";
    private final String typeCompte;

    public CompteBancaire(int numCompte, String nomClient, String prenomClient, double solde, String typeCompte) {
        this.nomClient = nomClient;
        this.prenomClient = prenomClient;
        this.solde = solde;
        this.typeCompte = typeCompte;
        this.numCompte = numCompte;
        nombreDuCompteCrees++;
    }

    // after question f part1 , using static variable currentId
    public CompteBancaire(String nomClient, String prenomClient, double solde, String typeCompte) {
        this.nomClient = nomClient;
        this.prenomClient = prenomClient;
        this.solde = solde;
        this.typeCompte = typeCompte;
        this.numCompte = currentId++;
        nombreDuCompteCrees++;
    }

    public CompteBancaire() {
        Scanner sc = new Scanner(System.in);
        System.out.println("entrer le nom : ");
        this.nomClient = sc.nextLine();
        System.out.println("entrer le prenom : ");
        this.prenomClient = sc.nextLine();
        System.out.println("entrer le solde : ");
        this.solde = sc.nextDouble();
        this.numCompte = currentId++;
        System.out.println("enter le type de compte : ");
        System.out.println("1- compte courant");
        System.out.println("2- compte epargne");
        int choix = sc.nextInt();
        this.typeCompte = choix == 1 ? "compteCourant" : "compteEpargne";
        nombreDuCompteCrees++;

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

    public static int getNombreDuCompteCrees() {
        return nombreDuCompteCrees;
    }

    public void affichage() {
        System.out.println("numCompte : " + numCompte);
        System.out.println("nomClient : " + nomClient);
        System.out.println("prenomClient : " + prenomClient);
        System.out.println("solde : " + solde);
        System.out.println("nomBanque : " + nomBanque);
        System.out.println("codeAgence : " + codeAgence);
        System.out.println("typeCompte : " + typeCompte);
    }

    @Override
    public String toString() {
        return "CompteBancaire [numCompte=" + numCompte + ", nomClient=" + nomClient + ", prenomClient=" + prenomClient
                + ", solde=" + solde + ", typeCompte=" + typeCompte + "]";
    }

    public static void main(String[] args) {
        final String CompteCourrant = "compteCourant";
        final String CompteEpargne = "compteEpargne";

        // partie 1
        CompteBancaire compte1 = new CompteBancaire(1, "Bouakkaz", "Samra", 1000, CompteCourrant);
        CompteBancaire compte2 = new CompteBancaire(2, "aberbour", "rima", 103213, CompteEpargne);

        System.out.println("affichage compte1 : ");
        compte1.affichage();
        System.out.println();

        System.out.println("affichage compte2 : ");
        compte2.affichage();
        System.out.println();

        System.out.println("le nombre de compte crees : " + CompteBancaire.getNombreDuCompteCrees());
        // question f , we used static variable currentId

        CompteBancaire compte3 = new CompteBancaire("Bouakkaz", "Samra", 1000, CompteCourrant);
        CompteBancaire compte4 = new CompteBancaire("aberbour", "rima", 103213, CompteEpargne);

        System.out.println("affichage compte3 : ");
        compte3.affichage();
        System.out.println();

        System.out.println("affichage compte4 : ");
        compte4.affichage();
        System.out.println();
        
        System.out.println("le nombre de compte crees : " + CompteBancaire.getNombreDuCompteCrees());

        // partie 2
        CompteBancaire compte5 = new CompteBancaire();

        System.out.println("affichage compte5 : ");
        compte5.affichage();
        System.out.println();
    }

}

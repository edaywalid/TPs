package tp3;

public class AppliCompteTab {
    CompteBancaire[] comptes ;

    public AppliCompteTab(int n) {
        comptes = new CompteBancaire[n];
        LireLeTableau();
    }

    public void afficherAvecForClassic(){
        for (int i = 0; i < comptes.length; i++) {
            System.out.println(comptes[i]+ "\n");
        }
    }

    public void afficherAvecForEtundu(){
        for (CompteBancaire compteBancaire : comptes) {
            System.out.println(compteBancaire + "\n");
        }
    }

    private void LireLeTableau(){
        for (int i = 0; i < comptes.length; i++) {
            comptes[i] = new CompteBancaire();
        }
    }
}

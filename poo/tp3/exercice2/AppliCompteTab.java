package tp3.exercice2;

import java.util.Scanner;

import tp3.exercice1.CompteBancaire;

public class AppliCompteTab {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        CompteBancaire[] comptes = new CompteBancaire[n];

        for (int i = 0; i < comptes.length; i++) {
            comptes[i] = new CompteBancaire();
        }

        // public void afficherAvecForClassic
        for (int i = 0; i < comptes.length; i++) {
            comptes[i].affichage();
            System.out.println();
        }

        // public void afficherAvecForEtundu
        for (CompteBancaire compteBancaire : comptes) {
            compteBancaire.affichage();
            System.out.println();
        }

        scanner.close();

    }
}

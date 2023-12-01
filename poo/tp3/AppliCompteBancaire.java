package tp3;

import java.util.Scanner;

public class AppliCompteBancaire {
    public static void main(String[] args) {
        System.out.print("entrer le nombre de comptes : ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        AppliCompteTab appliCompteTab = new AppliCompteTab(n);
        System.out.println("affichage avec for classic : ");
        appliCompteTab.afficherAvecForClassic();
        System.out.println("affichage avec for each : ");
        appliCompteTab.afficherAvecForEtundu();
        sc.close();
        
    }
}

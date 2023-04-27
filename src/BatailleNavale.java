import java.util.Scanner;

public class BatailleNavale {
    public static void main(String[] args) {
        char[][] plateau = new char[10][10];
        initialiserPlateau(plateau);
        placerNavires(plateau);
        jouer(plateau);
    }

    public static void initialiserPlateau(char[][] plateau) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                plateau[i][j] = '0'; // '~' représente l'eau
            }
            for (int j =0; j<9; j++)
            { int num = 65;
                plateau[0][j+1] = (char)num;
                System.out.print(plateau[0][j]);
                num += 1;
            }
        }
    }

    public static void placerNavires(char[][] plateau) {
        placerNavire(plateau, "porte-avions", 5);
        placerNavire(plateau, "croiseur", 4);
        placerNavire(plateau, "destroyer 1", 3);
        placerNavire(plateau, "destroyer 2", 3);
        placerNavire(plateau, "torpilleur", 2);
    }

    public static void placerNavire(char[][] plateau, String nom, int taille) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Placement du navire " + nom + " (" + taille + " cases)");
        for (int i = 0; i < taille; i++) {
            int ligne = -1, colonne = -1;
            while (ligne < 0 || ligne > 9 || colonne < 0 || colonne > 9 || plateau[ligne][colonne] != '~') {
                System.out.print("Coordonnées (ligne, colonne) de la case " + (i + 1) + " : ");
                ligne = sc.nextInt();
                colonne = sc.nextInt();
                if (ligne < 0 || ligne > 9 || colonne < 0 || colonne > 9 || plateau[ligne][colonne] != '~') {
                    System.out.println("Case invalide, veuillez choisir une autre case.");
                }
            }
            plateau[ligne][colonne] = nom.charAt(0); // Le premier caractère du nom représente le navire sur le plateau
        }
    }

    public static void jouer(char[][] plateau) {
        Scanner sc = new Scanner(System.in);
        int coups = 0, naviresRestants = 5;
        while (naviresRestants > 0) {
            int ligne = -1, colonne = -1;
            while (ligne < 0 || ligne > 9 || colonne < 0 || colonne > 9) {
                System.out.print("Coordonnées (ligne, colonne) de votre coup : ");
                ligne = sc.nextInt();
                colonne = sc.nextInt();
                if (ligne < 0 || ligne > 9 || colonne < 0 || colonne > 9) {
                    System.out.println("Coordonnées invalides, veuillez choisir d'autres coordonnées.");
                }
            }
            if (plateau[ligne][colonne] == '~') {
                System.out.println("Coup dans l'eau !");
                plateau[ligne][colonne] = 'O'; // 'O' représente un coup dans l'eau
            } else if (plateau[ligne][colonne] == 'X' || plateau[ligne][colonne] == 'O') {
                System.out.println("Case déjà jouée, veuillez choisir d'autres coordonnées.");
            }
        }
    }
}
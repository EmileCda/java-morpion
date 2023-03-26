import java.util.Scanner;
import java.lang.Math;


public class Main {

// déclaration de constant : pour éviter de confondre les lettres 
// majuscules (exmeple X) et minuscule (et x)

final static  char CAR_V = ' ';
final static  char CAR_X = 'X';
final static  char CAR_O = 'O';
final static char MATCH_NULL = '=' ;
final static char PAS_FINI =  '?' ;

// ----------------------------------------------------------------------------
// cette fonction affiche un tableau  de caractere.
// chaque caratere est délimité par [] pour la visibilite 
    public static void affiche_tableau(char[] my_array) {
        for (char my_char : my_array){
             System.out.printf("[%c]",my_char);
        }
        System.out.println();
    }
// ----------------------------------------------------------------------------
    public static int lire_colonne (char[][] grille_jeu) {
        Scanner my_scan = new Scanner(System.in);

        System.out.print("colonne svp :");
        int numero_colonne = my_scan.nextInt(); 
        int index_colonne = numero_colonne-1 ;
        if ((index_colonne>=0) && (index_colonne<grille_jeu[0].length )){
            return index_colonne ; 
        }
        else
            return -1 ; 

    }
// ----------------------------------------------------------------------------
    public static int lire_ligne (char[] ligne)  {
        Scanner my_scan = new Scanner(System.in);
        System.out.print("ligne svp :");

        int numero_ligne = my_scan.nextInt(); 
        int index_ligne = numero_ligne-1 ;
        if ((index_ligne>=0) && (index_ligne<ligne.length )){
            return index_ligne ; 
        }
        else
            return -1 ; 

    }
// ----------------------------------------------------------------------------
// cette fonction affiche une matrice(tableau de tableau) de caractere.
// chaque caratere est délimité par [] pour la visibilite 
    public static void affiche_grille_jeu(char[][] matrix) {
        for (char[] ligne : matrix){
            affiche_tableau(ligne); 
        }
        System.out.println();
    }
// ----------------------------------------------------------------------------
// Créer une fonction get_column prenant en paramètre un int c (l’index de la 
// colonne) et la grille de jeu. Elle retournera un Array des cases de cette
// colonne.
// on considere que grille_jeu est constitué de la facon suivante 
// grille_jeu[ligne][colonne]
    public static char[] get_column(int index_colonne, char[][] grille_jeu) {

        char[] colum_return = new char[grille_jeu.length];
        for (int nb_ligne= 0 ; nb_ligne < grille_jeu.length; nb_ligne ++)
        {
            char[] ligne = grille_jeu[nb_ligne] ;

            if (index_colonne < ligne.length)
                colum_return[nb_ligne] = grille_jeu[nb_ligne][index_colonne];
        }
        return colum_return;

    }
// ----------------------------------------------------------------------------
// Créer une fonction free_cell prenant en paramètre la grille de jeu et 
// retournant le nombre de cases libres.
// une  case libre est définit par la constante CAR_VIDE
    public static int free_cell(char[][] grille_jeu ) {
        int nb_free_cell = 0 ;
        for (int nb_ligne= 0 ; nb_ligne < grille_jeu.length; nb_ligne ++)
        {
            for (int nb_colonne= 0 ; nb_colonne < grille_jeu[0].length; nb_colonne ++){
                if (grille_jeu[nb_ligne][nb_colonne]==CAR_V){
                    nb_free_cell++;
                }
            }
        }
        return nb_free_cell;
    }
// ----------------------------------------------------------------------------
// 1. Préparation de fonctions
// a. Créer une fonction « count » prenant en paramètre un char x et un tableau t. Elle
// retournera le nombre de x dans t
    public static int count(char myChar, char[] tableau ) {
        int nombreOccurence = 0 ;
        for (int index = 0 ; index < tableau.length; index++){
            if (tableau[index] == myChar) {
                nombreOccurence++ ; 
            }
        }
        return nombreOccurence ; 
    }
    

// ----------------------------------------------------------------------------
// Conditions de fin de jeu
// a. Créer une fonction prenant en paramètre notre grille et retournant 
// jusqu’à 3 valeurs différentes : le caractère du joueur ayant gagné si 
// on détecte 3 de ses pions sur une même ligne ou colonne, une autre valeur 
// signifiant que la partie est nulle (toutes les cases sont remplies sans
//  victoire), ou enfin une autre valeur signifiant qu’il n’y a aucune
// condition de fin de jeu.
    public static char controler_grille (char[][] grille_jeu) {
   // X =>joueur X gagne 
   // O =>joueur X gagne 
   // = => match nul
   // ? => partie interrompu
        
        int nbOccurence = 0 ;
        char joueur = CAR_X;
//---------------- Joueur O -------------------------------------------------
// controle ligne par ligne s'il y a une ligne gagnante.
// le return permet de ne pas tester les autres lignes si 
// on a déja une ligne gagnante.
        for (char[] ligne :  grille_jeu){
            nbOccurence = count (joueur,ligne);
            if (nbOccurence >=3)
                return joueur  ;
        }
// controle colonne par colone s'il y a une colone gagnante.
// le return permet de ne pas tester les autres colonnes si 
// on a déja une colonne gagnante.
        for (int nb_colonne = 0; nb_colonne < grille_jeu[0].length; nb_colonne++){
            char[] colonne = get_column(nb_colonne,grille_jeu);
            nbOccurence = count (joueur,colonne);
            if (nbOccurence >=3)
                return joueur  ;
        }
// controle les 2 diagonales s'il y a une diagonnale  gagnante.
// première diagonale 
        char[] diagonal1 = {grille_jeu[0][0],grille_jeu[1][1],grille_jeu[2][2]};
        char[] diagonal2 = {grille_jeu[0][2],grille_jeu[1][1],grille_jeu[2][0]};
        nbOccurence = count (joueur,diagonal1);
        if (nbOccurence >=3)
            return joueur  ;
// controle les 2 diagonales s'il y a une diagonnale  gagnante.
// deuxième diagonale 
        nbOccurence = count (joueur,diagonal2);
        if (nbOccurence >=3)
            return joueur  ;
//---------------- Joueur O -------------------------------------------------
        joueur = CAR_O;
        for (char[] ligne :  grille_jeu){
            nbOccurence = count (joueur,ligne);
            if (nbOccurence >=3)
                return joueur  ;
        }
        for (int nb_colonne = 0 ; nb_colonne < grille_jeu[0].length; nb_colonne++){
            char[] colonne = get_column(nb_colonne,grille_jeu);
            nbOccurence = count (joueur,colonne);
            if (nbOccurence >=3)
                return joueur  ;
        }

        nbOccurence = count (joueur,diagonal1);
        if (nbOccurence >=3)
            return joueur  ;

        nbOccurence = count (joueur,diagonal2);
        if (nbOccurence >=3)
            return joueur  ;
    
        nbOccurence = 0 ;
        for (char[] ligne :  grille_jeu){
            for (char mon_car :  ligne){
                if (mon_car == CAR_V)
                   nbOccurence ++;  ;
            }
        }
        if (nbOccurence <=0)
            return MATCH_NULL ;
        
        return  PAS_FINI ;
    }
// ----------------------------------------------------------------------------
// %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    public static void main(String[] args) {
        
        Scanner my_scan = new Scanner(System.in);
// Préparation du jeu : a. Créer une grille de 3 x 3 case. Il s’agira d’un Array 
// à 2 dimensions (lignes / colonnes) contenant des chars. Par défaut, on 
// initialisera chaque case à une valeur neutre (pas les symboles ‘O’ et ‘X’ 
// des joueurs donc).
        char[][] grille_jeu = {   {CAR_V,CAR_V,CAR_V},
                                  {CAR_V,CAR_V,CAR_V},
                                  {CAR_V,CAR_V,CAR_V}};


// Préparation du jeu b. Créer une variable joueur (contiendra le caractère ‘O’ 
//  ou ‘X’ selon le tour. Choisir l’un des deux comme premier joueur par défaut
        char joueur = CAR_X ; 
// Préparation du jeu c. Créer un compteur de tours de jeu initialisé à 1
        int compteur_tours = 1 ; 
        char resultat = PAS_FINI;

        System.out.println("Morpion");
        do{
// Tour de jeu: a. Afficher le numéro du tour ainsi que le joueur qui 
// doit jouer (O ou X)
            System.out.println(String.format(
                    "le numéro du tour %d : joueur %c",
                    compteur_tours,joueur)); // changer de joueur ));

// Tour de jeu : b.Afficher la grille de jeu sous la forme de quadrillage 
// 2D ( afficher simplement le contenu des cases sous la forme de lignes 
// et de colonnes, afficher un « - » si case vide par exemple).
            affiche_grille_jeu(grille_jeu);

// Tour de jeu : c. Demander à l’utilisateur d’entrer ses coordonnées de jeu (colonne puis ligne)
            int index_colonne = lire_colonne ( grille_jeu);
            if (index_colonne <0 )                  // numero de colonne incorrect 
                continue;
            char []  ma_colonne= get_column(index_colonne, grille_jeu) ;

            int index_ligne = lire_ligne ( ma_colonne);
            if (index_ligne<0)                      // numero de ligne incorrect 
                continue;

            if (grille_jeu[index_ligne][index_colonne] != CAR_V )   // case non-vide
                continue ;
            
            
            grille_jeu[index_ligne][index_colonne] = joueur;

            compteur_tours ++; 
            if (joueur == CAR_X)  joueur =CAR_O; else joueur =CAR_X ; // changer de joueur 
            resultat = controler_grille(grille_jeu);


         }while (resultat == PAS_FINI);

        affiche_grille_jeu(grille_jeu);
        System.out.print(String.format("%s \n",
                resultat == MATCH_NULL ? "match nul" :  "gagnant : " + resultat) );

        my_scan.close();
    }
//-----------------------------------------------------------------------------------

}



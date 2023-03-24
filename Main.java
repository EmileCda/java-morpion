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
// Créer une fonction demande à l'utilisateur de rentrer les coordonnée d'une 
// matrice avec deux invite : coodonneeX et coodonneY
// recoit en parametre la matrice 
// les cooedonnée doivent être dans la matrice 
// utilisé dans : Tour de jeu : c. Demander à l’utilisateur d’entrer ses 
// coordonnées de jeu (colonne puis ligne)
    public static int ZentrerCoodonnees(char[][] grille_jeu ) {

        // System.out.print("colonne svp :");
        // int numero_colone = myScan.nextInt(); 
        // System.out.print("ligne svp :");
        // int numero_ligne = myScan.nextInt(); 
        return 0 ; 
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
    public static void test_controler_grille() {
        char[][] grille_jeu = {   {CAR_X,CAR_O,CAR_X},
                                  {CAR_O,CAR_O,CAR_X},
                                  {CAR_X,CAR_X,CAR_O}};
       affiche_grille_jeu(grille_jeu);

        System.out.printf("resultat [%c]\n",controler_grille ( grille_jeu));
    }
// ----------------------------------------------------------------------------
// %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    // public static void testmain() {
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
            // entrerCoodonnees();
            int index_colonne = lire_colonne ( grille_jeu);
            if (index_colonne <0 )                  // numero de colonne incorrect 
                continue;
            char []  ma_colonne= get_column(index_colonne, grille_jeu) ;
            afficheTab(ma_colonne);
            int index_ligne = lire_ligne ( ma_colonne);
            if (index_ligne<0)                      // numero de ligne incorrect 
                continue;

            if (grille_jeu[index_ligne][index_colonne] != CAR_V )   // case non-vide
                continue ;
            
            
            grille_jeu[index_ligne][index_colonne] = joueur;

            compteur_tours ++; 
            if (joueur == CAR_X)  joueur =CAR_O; else joueur =CAR_X ; // changer de joueur 
            affiche_grille_jeu(grille_jeu);
            resultat = controler_grille(grille_jeu);


         }while (resultat == PAS_FINI);

        System.out.print(String.format("%s \n",resultat == MATCH_NULL ? "match nul" :  " gagnant :" + resultat) );
        // testFreeCell();
        // System.out.println("debug--------testGetColumn------ ");
        my_scan.close();
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

        for (char[] ligne :  grille_jeu){
            nbOccurence = count (joueur,ligne);
            if (nbOccurence >=3)
                return joueur  ;
        }
        for (int nb_colonne = 0; nb_colonne < grille_jeu[0].length; nb_colonne++){
            char[] colonne = get_column(nb_colonne,grille_jeu);
            nbOccurence = count (joueur,colonne);
            if (nbOccurence >=3)
                return joueur  ;
        }
        char[] diagonal1 = {grille_jeu[0][0],grille_jeu[1][1],grille_jeu[2][2]};
        char[] diagonal2 = {grille_jeu[0][2],grille_jeu[1][1],grille_jeu[2][0]};
        nbOccurence = count (joueur,diagonal1);
        if (nbOccurence >=3)
            return joueur  ;

        nbOccurence = count (joueur,diagonal2);
        if (nbOccurence >=3)
            return joueur  ;


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


    public static int Zrecherche_ligne (char[][] grille_jeu,char car_recherche) {
        int nbOccurence = 0 ;
        char joueur = CAR_X;
        for (char[] ligne :  grille_jeu){

            nbOccurence = 0 ;
            for (char mon_car  :  ligne){
                if (joueur == mon_car ){
                    nbOccurence ++;
                }
            }
            if (nbOccurence >=3){ 
                break ;
            }
        }
        if (nbOccurence >=3 ) {
            return nbOccurence;
        }
        return 0 ; 
    }
// ----------------------------------------------------------------------------
    public static int lire_colonne (char[][] grille_jeu) {
        Scanner my_scan = new Scanner(System.in);

        System.out.print("colonne svp :");
        int numero_colonne = my_scan.nextInt(); 
        int index_colonne = numero_colonne-1 ;
        System.out.printf("index_colonne: %d",index_colonne);
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
// %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%



// ============================================================================
    public static void Testaffiche_grille_jeu(char[] tab) {
// Préparation du jeu : a. Créer une grille de 3 x 3 case. Il s’agira d’un Array 
// à 2 dimensions (lignes / colonnes) contenant des chars. Par défaut, on 
// initialisera chaque case à une valeur neutre (pas les symboles ‘O’ et ‘X’ 
// des joueurs donc).
        char[][] grille_jeu = {   {CAR_V,CAR_V,CAR_V},
                                  {CAR_V,CAR_V,CAR_V},
                                  {CAR_V,CAR_V,CAR_V}};

        char joueur = CAR_X ; 
        int compteur_tours = 1 ; 
        boolean fin = false;
        System.out.println("Morpion");
        int numero_ligne = 2;
        int numero_colonne =  1;
        affiche_grille_jeu(grille_jeu);
        grille_jeu[numero_ligne][numero_colonne] = joueur;
        affiche_grille_jeu(grille_jeu);

    }


// ============================================================================
    public static void afficheTab(char[] tab) {
        for (char myChar : tab){
             System.out.printf("[%c]",myChar);
        }
        System.out.println();
    }
// ============================================================================
    public static void trace(String text) {
        System.out.printf("%s [%d]: %s",Thread.currentThread().getStackTrace()[1].getFileName(),
        Thread.currentThread().getStackTrace()[1].getLineNumber(),
        text);
    }
// ============================================================================
    public static void afficheMatrix(char[][] matrix) {

        for (char[] ligne : matrix){
            afficheTab(ligne);
        }
        System.out.println();

    }
// ============================================================================
    public static void testFreeCell() {

        char[][] myMatrix = {   {CAR_V,CAR_V,CAR_V},
                                {CAR_X,CAR_V,CAR_X},
                                {CAR_O,CAR_V,CAR_O},
                                {CAR_O,CAR_V,CAR_X},
                                {CAR_V,CAR_O,CAR_X}
                            };
        afficheMatrix(myMatrix);
        System.out.printf("%s [%d]\n",Thread.currentThread().getStackTrace()[1].getFileName(),
        Thread.currentThread().getStackTrace()[1].getLineNumber());
        System.out.printf("freecell [%d]\n",free_cell(myMatrix));

    }
// ============================================================================
    public static void testGetColumn() {


        char[][] myMatrix = 
        // {   {CAR_V,CAR_V,CAR_V},
        //                         {CAR_X,CAR_V,CAR_X},
        //                         {CAR_O,CAR_V,CAR_O},
        //                         {CAR_O,CAR_V,CAR_X},
        //                         {CAR_V,CAR_O,CAR_X}
        //                     };

        //  char[][] my_maxtrix_char = 
         {
                    {'a','b','c','d','e'},
                    {'a','z','e','r','t'},
                    {'y','i','i','i','i','E'}
                };


        System.out.printf("%s [%d]\n",Thread.currentThread().getStackTrace()[1].getFileName(),
        Thread.currentThread().getStackTrace()[1].getLineNumber());
        afficheMatrix(myMatrix);

        char[] retour0 = get_column(0, myMatrix);
        System.out.printf("%s [%d]\n",Thread.currentThread().getStackTrace()[1].getFileName(),
        Thread.currentThread().getStackTrace()[1].getLineNumber());
        afficheTab(retour0);
        char[] retour1 = get_column(1, myMatrix);
        System.out.printf("%s [%d]\n",Thread.currentThread().getStackTrace()[1].getFileName(),
        Thread.currentThread().getStackTrace()[1].getLineNumber());
        afficheTab(retour1);

        char[] retour2 = get_column(2, myMatrix);
        System.out.printf("%s [%d]\n",Thread.currentThread().getStackTrace()[1].getFileName(),
        Thread.currentThread().getStackTrace()[1].getLineNumber());
        afficheTab(retour2);
        char[] retour4 = get_column(4, myMatrix);
        System.out.printf("%s [%d]\n",Thread.currentThread().getStackTrace()[1].getFileName(),
        Thread.currentThread().getStackTrace()[1].getLineNumber());
        afficheTab(retour4);
        char[] retour5 = get_column(5, myMatrix);
        System.out.printf("%s [%d]\n",Thread.currentThread().getStackTrace()[1].getFileName(),
        Thread.currentThread().getStackTrace()[1].getLineNumber());
        afficheTab(retour5);


    }

// ============================================================================
    public static void testAffiche() {

        char[] my_tab_char = {'a','b','c','d','e'};
        char[][] my_maxtrix_char = {
                    {'a','b','c','d','e'},
                    {'a','z','e','r','t'},
                    {'y','i','i','i','i'}
                };
        
        afficheTab(my_maxtrix_char[0]);
        afficheTab(my_maxtrix_char[1]);
        afficheTab(my_maxtrix_char[2]);
        afficheTab(my_tab_char);
    }

}



# java-morpion

Morpion

Objectif : Créer un jeu de morpion sous console. On représentera la grille de jeu sous la
forme d’un Array à 2 dimensions contenant des caractères. Le caractère ‘O’ représente le
joueur O, le caractère ‘X’ représente le joueur X.

1. Préparation de fonctions
   a. Créer une fonction « count » prenant en paramètre un char x et un tableau t. Elle
   retournera le nombre de x dans t
   b. Créer une fonction free_cell prenant en paramètre la grille de jeu et retournant le
   nombre de cases libres.
   c. Créer une fonction get_column prenant en paramètre un int c (l’index de la colonne) et
   la grille de jeu. Elle retournera un Array des cases de cette colonne.

2. Préparation du jeu
   a. Créer une grille de 3 x 3 case. Il s’agira d’un Array à 2 dimensions (lignes / colonnes)
   contenant des chars. Par défaut, on initialisera chaque case à une valeur neutre (pas les
   symboles ‘O’ et ‘X’ des joueurs donc).
   b. Créer une variable joueur (contiendra le caractère ‘O’ ou ‘X’ selon le tour. Choisir l’un
   des deux comme premier joueur par défaut
   c. Créer un compteur de tours de jeu initialisé à 1
3. Tour de jeu
   a. Afficher le numéro du tour ainsi que le joueur qui doit jouer (O ou X)
   b. Afficher la grille de jeu sous la forme de quadrillage 2D ( afficher simplement le contenu
   des cases sous la forme de lignes et de colonnes, afficher un « - » si case vide par
   exemple).
   c. Demander à l’utilisateur d’entrer ses coordonnées de jeu (colonne puis ligne)
   d. Placer le caractère de l’utilisateur à cette case si elle n’est pas déjà occupée, sinon,
   retourner au (3a)
4. Conditions de fin de jeu
   a. Créer une fonction prenant en paramètre notre grille et retournant jusqu’à 3 valeurs
   différentes : le caractère du joueur ayant gagné si on détecte 3 de ses pions sur une
   même ligne ou colonne, une autre valeur signifiant que la partie est nulle (toutes les
   cases sont remplies sans victoire), ou enfin une autre valeur signifiant qu’il n’y a aucune
   condition de fin de jeu.
   b. Si aucune condition de fin de jeu n’est détectée après un tour, retourner au (3a)
   c. Si une condition de fin de jeu est détectée, afficher un message l’indiquant
5. Améliorations
   a. Effectuer la détection de fin de jeu sur les diagonales également
   b. Permettre au joueur, en début de partie, de choisir la taille du quadrillage (on reste sur
   une dimension carrée, 3x3, 5x5, 10x10). On limite cette taille de 3x3 jusqu’à 15x15.
   c. Permettre à chaque joueur de choisir un pseudonyme et l’afficher en jeu (garder les
   pion ‘O’ et ‘X’ sur la grille de jeu
   d. Ajouter un menu principal avant le jeu dans lequel l’utilisateur choisi de faire une
   nouvelle partie ou de quitter (en cas de fin de partie, on revient à ce menu)

e. Ajouter un menu score dans lequel on sauvegardera le nombre de victoire de chaque
joueur (par leur pseudonyme).

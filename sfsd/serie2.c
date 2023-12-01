#include <stdio.h>

void exo1 (){
	// creer ficher "etudiant.txt"  contenant le 'prenom" suivi de "nom"
	

	// 1 - lire le premier caractere de prenom et lafficher a lecran
	FILE* file = fopen("etudiant.txt", "r") ;
	char firstPrenomChar = fgetc(file);
	printf("premier char %c\n" , firstPrenomChar);
	// lancer la fonction deux fois
	printf("deuxieme fois : %c\n" , fgetc(file));
	// elle va afficher le deuxieme char


	// affichage de tout les caractere du prenom, one by one 
	rewind(file);
	int count = 0 ;
	char charTmp ;
	while (fscanf(file, "%c" , &charTmp) && charTmp!= ' ') {
		printf("%c  "  , charTmp);
		count++;	
	}
	printf("\n");

	
	// le nombre de char ;
	printf("le nombre de char dans le prenom : %d\n" , count);

	fclose(file);
	
}
void exo2 (){

	FILE * file = fopen("exo2.txt", "w+");
	// demander a l'utilisateur de saisir des mots
	
	printf("entrez des mots :\n");
	char motTemp [100];
	// pour saisir le EOF entrer le caractere ctrl+z
	while (scanf("%s" , motTemp) != EOF) {
		fprintf(file, "%s\n" , motTemp);
	}

	// afficher le contenu de fichier 
	
	rewind(file); // returning the pointer to the start of the file 
	printf("le contenu de fichier :\n");
	while (fgets(motTemp, 100, file) != NULL) { 
		// storing each line until reaching the end of file (EOF)
		printf("%s" , motTemp);
	
	}
	// le nombre de lignes
	rewind(file);
	int count = 0;
	while (fgets(motTemp, 100, file) != NULL) {
		count++;
	}

	printf("le nombre de ligne est : %d\n" , count);

	// ajouter le nombre de  mots dans le fichier
	
	fprintf(file, "%s%d" , "le nombre de mots est : " , count);

	// copier le contenu de ficher dans un autre fichier 
	
	FILE* newFile = fopen("copy.txt", "w");
	rewind(file);
	while (fgets(motTemp, 100, file) != NULL)  {
		fprintf(newFile, "%s\n" , motTemp);
	}
	fclose(file);
	fclose(newFile);
}

int main()
{
	//exo1();
	//exo2();
	return 0;
}

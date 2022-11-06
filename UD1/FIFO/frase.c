#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <unistd.h>
#include <string.h>

void main(){
    int fp;
    char frase[50];
    printf("Escribe una frase\n");

    fgets(frase, 50, stdin);

    fp = open("FIFO2",1);
    if (fp == -1)
    {
        printf("Error al abrir el fichero\n");
        exit(1);
    }
    printf("Mandando informacion al FIFO...\n");
    write(fp, frase, strlen(frase));
    close(fp);
}
#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <unistd.h>
#include <string.h>

void main(){
    int fp;
    int num;

    while (num != 100)
    {
        printf("Escribe un numero\n");
        scanf("%d", &num);

        if (num == 100)
        {
            return;
        }

        write(fp, num, strlen(num));
    }
    
    fp = open("FIFO2",1);
    if (fp == -1)
    {
        printf("Error al abrir el fichero\n");
        exit(1);
    }
    printf("Mandando informacion al FIFO...\n");
    close(fp);
}
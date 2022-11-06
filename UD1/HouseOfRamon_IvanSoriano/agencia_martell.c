#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <unistd.h>
#include <string.h>

void main(){

    //creamos todas las variables
    int fp_martell;
    int bytesleidos;
    char buffer[80] = "";
    char esposa[80] = "Elia Martell";

    printf("     AGENCIA MATRIMONIAL DE LOS MARTELL\n");
    printf("  ASEGURAMOS DESCENDIENTES CON SANGRE DE RAMON!!\n");
    printf("NOS COLAMOS LOS MARTELL QUE QUEREMOS ALGO DE PODER!!\n");
    printf("-----------------------------------------------------\n\n");
    
    //Abrimos el FIFO, leemos y lo mostramos
    mkfifo("FIFOMar",S_IFIFO|0666);
    fp_martell = open("FIFOMar",0);
    bytesleidos = read(fp_martell, buffer, 80);
    printf(buffer);
    //cerramos el FIFO que lee
    close(fp_martell);
    //abrimos el FIFO en la otra direccion para pasarle el resultado que queramos
    fp_martell = open("FIFOMar",1);

    if (fp_martell == -1) // por si da error
    {
        printf("Error al abrir el fichero\n");
        exit(1);
    }
    printf("Solo queda %s... TE HA TOCADO!!!!\n",esposa);
    write(fp_martell, esposa, strlen(esposa));
    close(fp_martell);
}
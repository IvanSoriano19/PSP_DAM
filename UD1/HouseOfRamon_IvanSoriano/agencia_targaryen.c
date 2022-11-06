#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <unistd.h>
#include <string.h>

void main(){
    
    //creamos todas las variables
    int fp_targaryen;
    int bytesleidos;
    char buffer[80] = "";
    char esposa[80] = "";

    printf("    AGENCIA MATRIMONIAL DE LOS TARGARYEN\n");
    printf("ASEGURAMOS DESCENDIENTES CON SANGRE DE RAMON!!\n");
    printf("----------------------------------------------\n\n");
    //Abrimos el FIFO, leemos y lo mostramos
    fp_targaryen = open("FIFOTar",0);
    bytesleidos = read(fp_targaryen, buffer, 80);
    printf(buffer);
    //cerramos el FIFO que lee
    close(fp_targaryen);

    //abrimos el FIFO en la otra direccion para pasarle el resultado que queramos
    fp_targaryen = open("FIFOTar",1);

    fgets(esposa, 80, stdin);

    if (fp_targaryen == -1) //por si da error
    {
        printf("Error al abrir el fichero\n");
        exit(1);
    }
    write(fp_targaryen, esposa, strlen(esposa));
    close(fp_targaryen);
}
#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <unistd.h>
#include <string.h>

int main(int argc, char *argv[])
{
    pid_t pid, pid1, pid2, pid3, pid11, pid12;
    int bytesleidos;
    int fp_targaryen, fp_martell;
    char nom_padre[20] = "Aerys";
    char nom_hijo[20] = "";
    char busco_esposa[80] = "Soy ";
    char buffer[80] = " ";
    char esposa[80] = "";

    pid = getppid();
    pid1 = getpid();

    printf("Soy Aerys %d\n",pid);

    nom_hijo[] = "Rhaegar";

    printf("Soy %s (%d), hijo de %s",nom_hijo, pid1, nom_padre);

    //printf("Soy %d y busco un mujer targaryen fértil. Indique el nombre...\n", nom_padre);


}

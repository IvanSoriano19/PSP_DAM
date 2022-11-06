#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <unistd.h>
#include <string.h>
#include <sys/wait.h>

void holaPapa()
{
    printf("Hola padre, ya he nacido.\n");
}

int main(int argc, char *argv[])
{
    //creamos todas las variables
    pid_t pid1, pid2, pid3, pid11, pid12;
    int status;
    int bytesleidos;
    int fp_targaryen, fp_martell;
    char padre[20] = "Aerys";
    char hijo[20];
    char busco_esposa[80] = "Soy ";
    char esposa[80] = "";

    printf("Soy %s(%d)\n", padre, getpid());

    // Contacto con la agencia de los targaryen aqui mediante un FIFOTar

    mkfifo("FIFOTar", S_IFIFO | 0666);

    //le pasamos el paremetro del padre y le decimos que buscamos pareja
    strcat(busco_esposa, padre);
    strcat(busco_esposa, " y busco una mujer targaryen fertil. Indique el nombre...\n");
    printf(busco_esposa);

    //abrimos el FIFO en direccion la agencia para pasarle busco_esposa
    fp_targaryen = open("FIFOTar", 1);

    write(fp_targaryen, busco_esposa, strlen(busco_esposa));

    //cerramos el FIFO que manda
    close(fp_targaryen);

    //Abrimos el mismo pero en la otra direccion
    fp_targaryen = open("FIFOTar", 0);

    bytesleidos = read(fp_targaryen, esposa, 80);

    close(fp_targaryen);
    //Aqui comprobamos que se ha pasado bien con la variable esposa
    printf("Hola %s, perpetuemos la casa Targaryen\n", esposa);

    pid1 = fork();
    if (pid1 == 0)
    {
        strcpy(hijo, "Rhaegar");
        printf("--Soy %s,(%d, hijo de %s %d)\n", hijo, getpid(), padre, getppid());  
        holaPapa();  
        printf("-----------------------------------------------------\n\n");


        // Contacto con la agencia de los Martell aqui mediante un FIFOMar (Esto es mas rapido que tinder)
        mkfifo("FIFOMar", S_IFIFO | 0666);
        //Pasamos el nombre del buscador de la pareje y se lo enviamos al FIFO
        fp_martell = open("FIFOMar", 1);
        strcpy(busco_esposa, "Soy ");
        strcat(busco_esposa, hijo);
        strcat(busco_esposa, " y busco una mujer targaryen fertil. Indique el nombre...\n");
        printf(busco_esposa);

        write(fp_martell, busco_esposa, strlen(busco_esposa));
        //cerramos el FIFO
        close(fp_martell);
        //volvemos a abrir el FIFO en la otra direccion
        fp_martell = open("FIFOMar", 0);

        bytesleidos = read(fp_martell, esposa, 80);
        printf("Hola %s, perpetuemos la casa Targaryen\n", esposa);    
        printf("-----------------------------------------------------\n");

        pid11 = fork(); // creamos a Rhanenys
        if (pid11 == 0)
        {
            sleep(1);
            strcpy(padre, "Rhaegar");
            strcpy(hijo, "Rhanenys");
            printf("--Soy %s,(%d, hijo de %s %d)\n", hijo, getpid(), padre, getppid());
            holaPapa();    
            printf("-----------------------------------------------------\n");
        }
        else
        {
            pid12 = fork(); // creamos a Aegon
            if (pid12 == 0)
            {
                sleep(2);
                strcpy(padre, "Rhaegar");
                strcpy(hijo, "Aegon");
                printf("--Soy %s,(%d, hijo de %s %d)\n", hijo, getpid(), padre, getppid());
                holaPapa();    
                printf("-----------------------------------------------------\n");
            }
        }

        waitpid(pid11, &status, 0);
        waitpid(pid12, &status, 0);
    }
    else
    {
        pid2 = fork(); // creamos a Viserys
        if (pid2 == 0)
        {
            sleep(3);
            strcpy(hijo, "Viserys");
            printf("--Soy %s,(%d, hijo de %s %d)\n", hijo, getpid(), padre, getppid());
            holaPapa();    
            printf("-----------------------------------------------------\n");
        }
        else
        {
            pid3 = fork(); // creamos a Daenerys
            if (pid3 == 0)
            {
                sleep(4);
                strcpy(hijo, "Daenerys");
                printf("--Soy %s,(%d, hijo de %s %d)\n", hijo, getpid(), padre, getppid());
                holaPapa();    
                printf("-----------------------------------------------------\n");
            }
            else
            {
                // padre de todos
                waitpid(pid1, &status, 0);
                waitpid(pid2, &status, 0);
                waitpid(pid3, &status, 0);
            }
        }
    }
}

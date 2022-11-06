#include <stdio.h>

void main()
{
    int num = 0;
    int jugadorDos = 0;

    while ((num < 1) || (num > 100))
    {
        printf("Judador 1: Introdizca un numero del 1 al 100\n");
        scanf("%d", &num);
        if ((num < 1) || (num > 100))
        {
            printf("El numero %d no es valido\n", num);
        }
    };

    while (jugadorDos != num)
    {
        printf("Jugador 2: Adivina el numero\n");
        scanf("%d", &jugadorDos);
        
        if( jugadorDos > num )
        {
            printf("Mas bajo\n");
        }else if ( jugadorDos < num)
        {
            printf("Mas alto\n");
        }
                
    }
}
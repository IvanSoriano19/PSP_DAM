#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <unistd.h>
#include <string.h>

void main(){
    int fp;
    int bytesleidos;
    char buffer[50] = "";
    int cont_a = 0;
    int cont_e = 0;
    int cont_i = 0;
    int cont_o = 0;
    int cont_u = 0;

    mkfifo("FIFO2",S_IFIFO|0666);
    
    fp = open("FIFO2", 0);
    bytesleidos = read(fp, buffer, 1);
    printf("Obteniendo informacion...\n");

        while (bytesleidos != 0)
        {
                switch (buffer[0])
                {
                case 'a':
                    cont_a ++;
                    break;
                case 'e':
                    cont_e ++;
                    break;
                case 'i':
                    cont_i ++;
                    break;
                case 'o':
                    cont_o ++;
                    break;
                case 'u':
                    cont_u ++;
                    break;
                default:
                    break;
                }
                
            bytesleidos = read(fp, buffer, 1);

        }

        printf("Contador de a : %d\n", cont_a);
        printf("Contador de e : %d\n", cont_e);
        printf("Contador de i : %d\n", cont_i);
        printf("Contador de o : %d\n", cont_o);
        printf("Contador de u : %d\n", cont_u);
            
        int total = cont_a + cont_e + cont_i + cont_o + cont_u;
        printf("Total de vocales : %d\n", total);
        
close(fp);
    
    
    

}
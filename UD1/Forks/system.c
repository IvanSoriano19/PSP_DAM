#include <stdio.h>
#include <stdlib.h>

void main(){
    printf("Ejemplo de uso de system()");
    printf("%d",system("ls --format=single-column -i > listado.txt"));
    printf("%d",system("code listado.txt"));
    printf("Final");
}

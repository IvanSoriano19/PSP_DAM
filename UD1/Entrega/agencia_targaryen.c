#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <unistd.h>
#include <string.h>

void main(){
    int fp_targaryen;
    int bytesleidos;
    char buffer[80] = "";
    char resulado[80] = "";
    char esposa[80] = "";

    mkfifo("FIFO2",S_IFIFO|0666);
    
    fp_targaryen = open("FIFO2", 0);
    bytesleidos = read(fp_targaryen, buffer, 80);

    printf("%d",bytesleidos);
}
#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <unistd.h>
#include <string.h>

void main()
{
    int fp;
    int bytesleidos;
    int buffer;

    mkfifo("FIFO2", S_IFIFO | 0666);

    fp = open("FIFO2", 0);
    bytesleidos = read(fp, buffer, 1);
    printf("Obteniendo informacion...\n");

    while (bytesleidos != 0)
    {
        
    }
    close(fp);
}
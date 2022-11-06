#include <stdio.h>
#include <unistd.h>

void main(){
    pid_t id_actual, id_padre;

    id_actual = getpid();
    id_padre = getppid();

    printf("PID de este proceso es: %d\n",id_actual);
    printf("PID de este proceso es: %d\n",id_padre);
}
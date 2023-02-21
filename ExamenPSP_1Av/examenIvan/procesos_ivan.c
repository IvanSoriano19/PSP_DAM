#include <stdio.h>
#include <sys/stat.h>
#include <unistd.h>
#include <signal.h>
#include <sys/wait.h>
int main()
{
    pid_t pid1;
    pid_t pid2;

    void manejador()
    {
        printf("Soy un hijo cualquiera y acabo de recibr la señal pid=%d, hijo de pid=%d \n", getpid(), getppid());
    }

    printf("Padre.pid= %d\n", getpid());
    pid1 = fork();
    if (pid1 == 0)
    {
        signal(SIGUSR1, manejador);
        pause();
        printf("Soy hijo 1 y acabo\n");
    }
    else
    {
        sleep(1);
        kill(pid1, SIGUSR1);
        pid2 = fork();
        if (pid2 == 0)
        {
            signal(SIGUSR1, manejador);
            pause();
            printf("Soy hijo 2 y acabo\n");
        }
        else
        {
            sleep(1);
            kill(pid2, SIGUSR1);
            pid1 = wait(NULL);
            pid2 = wait(NULL);
            printf("Soy el hijo %d y he terminado\n",pid1);
            printf("Soy el hijo %d y he terminado\n",pid2);
            printf("Soy el padre %d y he terminado\n", getpid());
        }
    }
}
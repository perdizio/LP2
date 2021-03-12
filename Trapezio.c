#include <stdio.h>

typedef struct {
    int x, y;
    int w, h;
    int a;
} Trapezio;

void print(Trapezio* t) {
    printf("O Trapezio de tamanho (%d, %d) e que tem altura de %d cm está na posicao (%d,%d).\n",
        t->w, t->h, t->a, t->x, t->y);
}

int main() {
    Trapezio t1 = {5,10,4,10,10};
    print(&t1);
}
#include <stdio.h>
#include <stdlib.h>

typedef struct {
    int r,g,b;
} Color;

struct Figure;
typedef void (* Figure_Print) (struct Figure*);

typedef struct Figure {
    int x, y;
    int w, h;
    Color a;
    void (* print) (struct Figure*);
} Figure;



///////////////////////////////////////////////////////////////////////////////

typedef struct {
    Figure super;
    int w, h;
} Rect;

void rect_print (Rect* this) {
    Figure* sup = (Figure*) this;
    printf("Retangulo de tamanho (%d,%d) na posicao (%d,%d).\n",
           this->w, this->h, sup->x, sup->y);
}

Rect* rect_new (int x, int y, int w, int h) {
    Rect*   this  = malloc(sizeof(Rect));
    Figure* sup = (Figure*) this;
    sup->print = (Figure_Print) rect_print;
    sup->x = x;
    sup->y = y;
    this->w = w;
    this->h = h;
}

///////////////////////////////////////////////////////////////////////////////

typedef struct {
    Figure super;
    int w, h;
} Ellipse;

void Ellipse_print (Ellipse* this) {
    Figure* sup = (Figure*) this;
    printf("Elipse de tamanho (%d,%d) na posicao (%d,%d).\n",
           this->w, this->h, sup->x, sup->y);
}

Ellipse* ellipse_new (int x, int y, int w, int h) {
    Ellipse* this = malloc(sizeof(Ellipse));
    Figure* sup = (Figure*) this;
    sup->print = (Figure_Print) Ellipse_print;
    sup->x = x;
    sup->y = y;
    this->w = w;
    this->h = h;
}

///////////////////////////////////////////////////





typedef struct {
    Figure super;
    Color b;
    int x1[3];
    int x2[3];
} Triangulo;

void Triangulo_print (Triangulo* this) {
    Figure* sup = (Figure*) this;
    printf("Triangulo de tamanho (%d,%d) na posicao (%d,%d).\n",
           this->w, this->h, sup->x, sup->y);
}

Triangulo* new_Triangulo (int x, int y, int w, int h) {
    Triangulo*   this  = malloc(sizeof(Triangulo));
    Figure* sup = (Figure*) this;
    sup->print = (Figure_Print) Triangulo_print;
    sup->x = x;
    sup->y = y;
    this->w = w;
    this->h = h;
	this->x1[0] = x ;
    this->x1[1] = (w/2+x);
	this->x1[2]=w+h;
	
	this->x2[0] = y;
    this->x2[1] = y - h;
    this->x2[2] = y;
	
}

///////////////////////////////////////////////////////////////////////////////




typedef struct {
    Figure super;
    int w, h;
    int x1[5];
    int x2[5];
} Pentagono;

void Pentagono_print (Pentagono* this) {
    Figure* sup = (Figure*) this;
    printf("Pentagono de tamanho (%d,%d) na posicao (%d,%d).\n",
           this->w, this->h, sup->x, sup->y);
}

Pentagono* Pentagono_new (int x, int y, int w, int h) {
    Pentagono* this = malloc(sizeof(Pentagono));
    Figure* sup = (Figure*) this;
    sup->print = (Figure_Print) Pentagono_print;
    sup->x = x;
    sup->y = y;
    this->w = w;
    this->h = h;
    
    this->x1[0] = x ;
    this->x1[1] = x+25;
    this->x1[2] = x + 75;
    this->x1[3] = x + 100;
    this->x1[4] = x + 50;

    this->x2[0] = y;
    this->x2[1] = y + 50;
    this->x2[2] = y+50;
    this->x2[3] = y;
    this->x2[4] = y-50 ;
}

///////////////////////////////////////////////////////////////////////////////





void main (void) {
    Figure* figs[6] = {
        (Figure*) rect_new(10,10,100,100),
        (Figure*) ellipse_new(40,10,140,300),
        (Figure*) new_Triangulo(10,20,100,100),
        (Figure*) Pentagono_new(210,110,305,130),
        (Figure*) new_Triangulo(10,10,100,100),
        (Figure*) Pentagono_new(40,10,140,300)
    };

    ///

    for (int i=0; i<6; i++) {
        figs[i]->print(figs[i]);
    }

    ///

    for (int i=0; i<6; i++) {
        free(figs[i]);
    }
}

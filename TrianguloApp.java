  
public class TrianguloApp {
    public static void main (String[] args) {
        Triangulo tr= new Triangulo (11,11,5,7, 7);
         tr.print();
    }
}
class Triangulo{
    int x, y;
    int w, h;
    int altura;
    
    Triangulo(int x, int y, int w, int h, int altura) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
	this.altura = altura;

	
    }
    void print () {
        System.out.format("O triangulo tem lados (%d,%d) Altura: %d Posicao: (%d,%d).\n", this.x, this.y, this.altura, this.w, this.h);

    }
}



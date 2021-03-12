  public class RectApp{
    public static void main(String[] args) {
        Rect r1 = new Rect(1,1,10,10);

       r1.drag(1, 2);
       r1.print();
    }
}
class Rect{
    int x,y;
    int w,h;
    Rect(int x,int y,int w, int h){
        this.x=x;
        this.y=y;
        this.w=w;
        this.h=h;
    }
    void print(){
        System.out.format("Retangulo de tamanho (%d,%d) Posicao: (%d,%d) Area:%d \n",
		this.w,this.h,this.x,this.y, area());
    }
    int area(){
        int area=this.w * this.h;
   	return area;
    }
    void drag (int dx, int dy){
        int pos1 =this.x+dx;
        int pos2=this.y+dy;
               System.out.println("Nova posicao:"+ pos1+ ","+ pos2);

        
    }

}

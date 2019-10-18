
import java.awt.*;
import java.awt.Polygon;

import static java.lang.Math.sqrt;


@SuppressWarnings("Duplicates")
public class Triangle implements Shape {
    private int edge,height;
    private int x1, x2, x3, y1, y2, y3;
    private int x,y;

    /**
     *
     * @param X1
     * @param Y1
     * @param X2
     * @param Y2
     * @param X3
     * @param Y3
     * @param red
     * another constructor for triangle class. It is not used
     */
    public Triangle(int X1, int Y1, int X2, int Y2, int X3, int Y3, String red) {
        setX1_Y1( X1,  Y1);
        setX2_Y2( X2,  Y2);
        setX3_Y3( X3,  Y3);
    }

    /**
     *
     * @param e
     */
    public Triangle(int e) {

        if(e<0){
            throw new IllegalArgumentException("Error: Width and Height can not be negative..!");
        }
        setEdge(e);
        //System.out.println("edge : " + edge);
        setHeight((int) ((e/2)*sqrt(3)));
    }

    public void setHeight(int h){
        height=h;
    }

    public int getHeight(){
        return height;
    }

    public void setX1_Y1(int X1, int Y1) {
        x1=X1;
        y1=Y1;
    }

    public void setX2_Y2(int X2,int Y2) {
        x2=X2;
        y2=Y2;
    }
    public void setX3_Y3(int X3, int Y3) {
        x3=X3;
        y3=Y3;
    }


    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }


    @Override
    public double getArea() {
        return ((edge * edge) * sqrt(3) / 4);
    }
    @Override
    public int getPerimeter() {
        return (edge*3);
    }
    @Override
    public void Increment() {

    }
    @Override
    public void Decrement() {
        x+=1;
        y+=1;
    }

    /**
     *
     * @param S
     * @return
     */
    @Override
    public int compareTo(Shape S) {
        if(this.getArea()> S.getArea())
            return 1;
        else if (this.getArea()< S.getArea())
            return -1;
        else
            return 0;

    }

    /**
     *
     * @param inputShape
     */
    @Override
    public void Draw(Graphics inputShape) {

        Polygon Pol=new Polygon();
        Pol.addPoint(x+edge/2, y);
        Pol.addPoint(x+edge,y+height);
        Pol.addPoint(x, y+height);
        inputShape.setColor(Color.GREEN);
        inputShape.fillPolygon(Pol);

      /*int xArr[]={x1,x2,x3};
        int yArr[]={y1,y2,y3};

        inputShape.setColor(Color.GREEN);
        inputShape.fillPolygon(xArr, yArr, 3);
        inputShape.setColor(Color.BLACK);
        inputShape.drawPolygon(xArr, yArr, 3);
      */
    }

    /**
     *
     * @return
     */
    public int getEdge(){
        return edge;
    }
    public void setEdge(int edge) {
        this.edge = edge;
    }
}

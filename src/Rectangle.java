
import javax.swing.*;
import java.awt.*;

public class Rectangle extends JPanel implements Shape {

    private int width;
    private int height;
    private int x,y;
    private String color;
    private int CurrentArea;
    private int CurrentPerimeter;

    Rectangle(){
        //default constructor
    }

    /**
     *
     * @param X
     * @param Y
     * @param xPos
     * @param yPos
     * @param col
     */
    Rectangle(int X, int Y, int xPos, int yPos, String col){
        if(X<0 || Y<0){
            throw new IllegalArgumentException("Error: Width and Height can not be negative..!");
        }
        setWidth(X);
        setHeight(Y);
        setColor(col);
        //System.out.println("Rect oluştu");

    }

    /**
     *
     * @param g
     */
    public void paintComponent(Graphics g) {
        g.setColor(Color.orange);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(Color.red);
        g.fillOval(getWidth()/4, getHeight()/4,
                getWidth()/2, getHeight()/2);
    }

    /*public void paintComponent (Graphics g){

        Rectangle r=new Rectangle(getWidth(),getHeight(),getX(),getY(),getColor());
        g.drawRect(r.getWidth(),r.getHeight(),r.getX(),r.getY());

    }*/


 /*   public void paintComponent (Graphics g){
        //Graphics2D graphics2D = (Graphics2D)g;
        g.setColor(getColor());
        g.fillRect(g.getX(),g.getY(),g.getWidth(),g.getHeight());
        g.drawRect(g.getX(),g.getY(),g.getWidth(),g.getHeight());
    }*/

    /**
     *
     * @return
     */
    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }
    public void setWidth(int width) {
        this.width = width;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }

    /**
     *
     * @return
     */
    public int getX() {
        return x;
    }

    /**
     *
     * @return
     */
    public int getY() {
        return y;
    }
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    @Override
    public double getArea() {
        return (width*height);
    }
    @Override
    public int getPerimeter() {
        return (width*2+height*2);
    }

    @Override
    public void Increment() {
        x+=1;
        y+=1;
    }

    @Override
    public void Decrement() {
        x-=1;
        y-=1;
    }

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

        inputShape.setColor(Color.GREEN);
        inputShape.fillRect(x,y,width,height);
        inputShape.setColor(Color.BLACK);
        inputShape.drawRect(x,y,width,height);
/*
        int xArr[]={0,20,10};
        int yArr[]={0,10,20};

        inputShape.setColor(Color.GREEN);
        inputShape.fillPolygon(xArr, yArr, 3);
        inputShape.setColor(Color.BLACK);
        inputShape.drawPolygon(xArr, yArr, 3);
*/
    }



}

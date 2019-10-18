
import javax.swing.*;
import java.awt.*;

public class Circle implements Shape {
    private int radius;
    private int pi=3;
    private int width;
    private int height;
    private int x,y;
    private String color;

    public Circle(){
        //default constructor
    }

    public Circle(int radius, int i, int i1, String green) {
        System.out.println("default circle constructor");
    }

    /**
     *
     * @param X
     * @param Y
     * @param xPos
     * @param yPos
     * @param col
     */
    Circle(int X, int Y, int xPos, int yPos, String col){
        setWidth(X);
        setHeight(Y);
        setColor(col);
        //System.out.println("Circ oluştu");

    }

    /*public void paintComponent(Graphics g) {
        g.setColor(Color.orange);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(Color.red);
        g.fillOval(getWidth()/4, getHeight()/4,
                getWidth()/2, getHeight()/2);
    }*/

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
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }

    /**
     *
     * @return
     */
    @Override
    public double getArea() {
        return (pi*radius*radius);
    }

    /**
     *
     * @return
     */
    @Override
    public int getPerimeter() {
        return (2*pi*radius);
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



    @Override
    public void Draw(Graphics inputShape) {

        inputShape.setColor(Color.GREEN);
        inputShape.fillOval(x,y,width,height);
        inputShape.setColor(Color.BLACK);
        inputShape.drawOval(x,y,width,height);


    }

    /**
     *
     * @return
     */
    public int getRadius() {
        return radius;
    }

    /**
     *
     * @param radius
     */
    public void setRadius(int radius) {
        this.radius = radius;
    }
}

//Polygon implements Shape, too, because the hierarchy is like that in HW5 in c++
import java.awt.*;

public abstract class Polygon implements Shape {

    //There should be at least one abstract function
    abstract Shape myArr();

    public double getArea() {
        return 0;
    }

    public int getPerimeter() {
        return 0;
    }

    public class Point2D{
        private int x,y;


        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }
    }

}

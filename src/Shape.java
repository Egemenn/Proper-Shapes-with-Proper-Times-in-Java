import java.awt.*;

public interface Shape extends Comparable<Shape> {

    public int x = 0,y = 0;
    public double getArea();
    public int getPerimeter();
    public void Increment();
    public void Decrement();
    public int compareTo(Shape S);
    public void Draw(Graphics inputShape);

}

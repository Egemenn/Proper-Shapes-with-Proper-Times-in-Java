
import javax.swing.*;
import java.awt.*;
import java.awt.Polygon;
import java.util.Arrays;

public class Separate {

    public void drawAll(Shape A[]){
        JFrame mainMap= new JFrame();
        mainMap.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel p = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                for (int i = 0; i < A.length; i++) {
                    A[i].Draw(g);
                }
            }
        };
    }

    public void convertAll(Shape A[]){
        int x1,x2,x3,x4;
        int y1,y2,y3,y4;
        Polygon tempPol=new java.awt.Polygon();
        for(int i=0; i<A.length; i++){
            tempPol.addPoint(A[i].x, A[i].y);
            tempPol.addPoint(A[i].x, A[i].y);
            tempPol.addPoint(A[i].x, A[i].y);
        }

    }

    public void sortShapes(Shape A[]){
        double tempArr[]=new double[A.length];
        for (int i=0; i< A.length; i++){
            tempArr[i]= A[i].getArea();
        }
        Arrays.sort(tempArr);

    }


}

/** Egemen ÇAĞŞIRLI
 CSE241 HW7
 Driver fonksiyonu
 Hem farklı classların constructorları çağrılarak array'de tutuldu, hem de kulllanıcıdan input istendi.
 *
 */
import javax.swing.*;
import java.awt.*;

import java.awt.Polygon;
import java.util.Scanner;

import static java.lang.Math.sqrt;

public class Driver_161044101 {
    /**
     *
     * @param args
     */
    public static void main(String [] args){
        System.out.println("Start... \n");



        Rectangle Rarr[]=new Rectangle[10];
        Triangle Tarr[]=new Triangle[10];
        Circle Carr[]=new Circle[10];
        Rarr[0]=new Rectangle(600,400,0,0,"red");
        Rarr[1]=new Rectangle(200,100,0,0,"green");
        Rarr[2]=new Rectangle(40,20,0,0,"green");
        Rarr[3]=new Rectangle(800,300,0,0,"red");
        Rarr[4]=new Rectangle(500,350,0,0,"red");


        Tarr[0]=new Triangle(700);
        Tarr[1]=new Triangle(690);
        Tarr[2]=new Triangle(70);

        Carr[0]=new Circle(200,200,0,0,"green");
        Carr[1]=new Circle(45,45,0,0,"green");

        new ComposedShape(Rarr[0], Rarr[1]);
        new ComposedShape(Rarr[3], Rarr[2]);
        new ComposedShape(Rarr[4],Tarr[2]);
        new ComposedShape(Tarr[0], Tarr[1]);
        new ComposedShape(Rarr[3],Carr[0]);
        new ComposedShape(Rarr[3],Carr[1]);


        String FC,SC;
        System.out.println("Please enter the container shape :");
        Scanner input = new Scanner(System.in);
        FC=input.nextLine();
        if(!FC.equals("R") && !FC.equals("r") && !FC.equals("T") && !FC.equals("t") && !FC.equals("C") && !FC.equals("c")){
            throw new IllegalArgumentException("Error: Enter R or r..!");
        }

        /*--------------RECTANGLE ICINE R,T,C-------------------*/
        if(FC.equals("R") || FC.equals("r")){
            System.out.println("Please enter the width:");
            Scanner k = new Scanner(System.in);
            int w = k.nextInt();
            System.out.println("Please enter the height:");
            Scanner l = new Scanner(System.in);
            int h = l.nextInt();
            Rectangle Rect= new Rectangle(w,h,0,0,"red");//Rectangle Constructor

            System.out.println("Please enter the small shape :");
            Scanner input2 = new Scanner(System.in);
            SC=input2.nextLine();

            if(SC.equals("R") || SC.equals("r")){
                System.out.println("Please enter the width:");
                Scanner k2 = new Scanner(System.in);
                String str = "boş. silinecek";
                int w2 = k2.nextInt();
                System.out.println("Please enter the height:");
                Scanner l2 = new Scanner(System.in);
                int h2 = l2.nextInt();
                Rectangle InnerRect=new Rectangle(w2,h2,0,0,"red");
                new ComposedShape(Rect,InnerRect);

            }

            else if(SC.equals("T") || SC.equals("t")){
                System.out.println("Please enter the edge:");
                Scanner k2 = new Scanner(System.in);
                String str = "boş. silinecek";
                int e = k2.nextInt();
                Triangle InnerTri=new Triangle(e);
                new ComposedShape(Rect,InnerTri);

            }

            else if(SC.equals("C") || SC.equals("c")){
                System.out.println("Please enter the radius:");
                Scanner k2 = new Scanner(System.in);
                String str = "boş. silinecek";
                int radius = k2.nextInt();
                Circle InnerCirc=new Circle(radius, radius,0,0,"green");
                new ComposedShape(Rect,InnerCirc);

            }
        }
        /*--------------RECTANGLE ICINE R,T,C-------------------*/




        /*--------------TRIANGLE ICINE R,T,C-------------------*/
        else if(FC.equals("T") || FC.equals("t")){
            System.out.println("Please enter the edge:");
            Scanner k = new Scanner(System.in);
            int e = k.nextInt();
            Triangle Tri= new Triangle(e);

            System.out.println("Please enter the small shape :");
            Scanner input2 = new Scanner(System.in);
            SC=input2.nextLine();

            if(SC.equals("R") || SC.equals("r")){
                System.out.println("Please enter the width:");
                Scanner k2 = new Scanner(System.in);
                int w2 = k2.nextInt();
                System.out.println("Please enter the height:");
                Scanner l2 = new Scanner(System.in);
                int h2 = l2.nextInt();
                Rectangle InnerRect=new Rectangle(w2,h2,0,0,"red");
                new ComposedShape(Tri,InnerRect);

            }

            else if(SC.equals("T") || SC.equals("t")){
                System.out.println("Please enter the edge:");
                Scanner k2 = new Scanner(System.in);
                int w2 = k2.nextInt();
                Triangle InnerTri=new Triangle(w2);
                new ComposedShape(Tri,InnerTri);

            }

            else if(SC.equals("C") || SC.equals("c")){
                System.out.println("Please enter the radius:");
                Scanner k2 = new Scanner(System.in);
                int radius = k2.nextInt();
                Circle InnerCirc=new Circle(radius, radius,0,0,"green");
                new ComposedShape(Tri,InnerCirc);
            }
        }
        /*--------------TRIANGLE ICINE R,T,C-------------------*/




        /*--------------CIRCLE ICINE R,T,C-------------------*/
        else if(FC.equals("C") || FC.equals("c")){
            System.out.println("Please enter the radius:");
            Scanner k = new Scanner(System.in);
            int e = k.nextInt();
            Circle Circ= new Circle(e,e,0,0,"red");

            System.out.println("Please enter the small shape :");
            Scanner input2 = new Scanner(System.in);
            SC=input2.nextLine();

            if(SC.equals("R") || SC.equals("r")){
                System.out.println("Please enter the width:");
                Scanner k2 = new Scanner(System.in);
                int w2 = k2.nextInt();
                String str="silinecek...";
                System.out.println("Please enter the height:");
                Scanner l2 = new Scanner(System.in);
                int h2 = l2.nextInt();
                Rectangle InnerRect=new Rectangle(w2,h2,0,0,"red");
                new ComposedShape(Circ,InnerRect);

            }

            else if(SC.equals("T") || SC.equals("t")){
                System.out.println("Please enter the edge:");
                Scanner k2 = new Scanner(System.in);
                int w2 = k2.nextInt();
                String str="silinecek...";
                Triangle InnerTri=new Triangle(w2);
                new ComposedShape(Circ,InnerTri);

            }

            else if(SC.equals("C") || SC.equals("c")){
                System.out.println("Please enter the radius:");
                Scanner k2 = new Scanner(System.in);
                int radius = k2.nextInt();
                String str="silinecek...";

                Circle InnerCirc=new Circle(radius, radius,0,0,"green");
                new ComposedShape(Circ,InnerCirc);
            }
        }
        /*--------------CIRCLE ICINE R,T,C-------------------*/

    }
}

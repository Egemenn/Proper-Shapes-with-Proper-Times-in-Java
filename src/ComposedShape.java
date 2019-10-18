
import javax.swing.*;
import java.awt.*;
import java.awt.Polygon;
import java.util.Vector;

import static java.lang.StrictMath.sqrt;

public class ComposedShape implements Shape {

    public int bigWidth, bigHeight, smallWidth, smallHeight;
    public int bigEdge, smallEdge;
    public int bigRadius, smallRadius;
    public int RestArea, bigArea, smallArea;
    public int count=0;;
    private Vector<Rectangle> rVec= new Vector<Rectangle>();
    private Vector<Triangle> tVec= new Vector<Triangle>();
    private Vector<Circle> cVec= new Vector<Circle>();


    /*-------------------RECTANGLE ICINE R,T,C---------------------------*/
    ComposedShape(Rectangle ContainerShape, Rectangle InnerShapes){

        bigWidth=ContainerShape.getWidth();//bigWidth'e Buyuk Seklin width'ini atiyorum. Width Private oldugu icin getter kullaniyorum
        bigHeight=ContainerShape.getHeight();//Ayni islemi height icin yappiyorum
        smallWidth=InnerShapes.getWidth();//smallWidth ve smallHeight icin de getterlari kucuk sekle uyguluyorum
        smallHeight = InnerShapes.getHeight();
        int X = 0;//X ve Y kooordinatini 0'a esitledim, bunu buyuk sekil icin kullanacagim
        int Y = 0;
        int Y2=0;


        /*----------------------GUI yazdırma-------------------------*/
        JFrame mainMap= new JFrame();
        mainMap.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        for(int i=0; i< bigHeight/smallHeight; i++) {
            for (int j = 0; j < bigWidth / smallWidth; j++) {
                Rectangle rIN = new Rectangle(smallWidth, smallHeight, X, Y2, "GREEN");
                rVec.addElement(rIN);
                rIN.setX(X);
                X=X+smallWidth;
                Y2=smallHeight*(Y);
                rIN.setY(Y2);
            }
            Y++;
            X=0;
        }
        JPanel p = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.RED);
                g.fillRect(0,0,ContainerShape.getWidth(),ContainerShape.getHeight());

                for(int i=0; i< rVec.size(); i++){
                    rVec.get(i).Draw(g);
                }
            }
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(800, 600);
            }
        };
        mainMap.add(p);
        mainMap.pack();
        mainMap.setVisible(true);
        /*----------------------GUI yazdırma-------------------------*/


        /*ContainerShape.setColor("red");
        ContainerShape.fillRect(bigWidth,bigHeight,X,Y);
        g.drawRect(g.getX(),g.getY(),g.getWidth(),g.getHeight());
*/
    }
    ComposedShape(Rectangle ContainerShape, Triangle InnerShapes){

        bigWidth=ContainerShape.getWidth();//bigWidth'e Buyuk Seklin width'ini atiyorum. Width Private oldugu icin getter kullaniyorum
        bigHeight=ContainerShape.getHeight();//Ayni islemi height icin yappiyorum
        smallEdge=InnerShapes.getEdge();
        smallHeight= (int) ((smallEdge/2)*sqrt(3));
        int X = 0;//X ve Y kooordinatini 0'a esitledim, bunu buyuk sekil icin kullanacagim
        int Y = 0;
        int Y2=0;

        /*----------------------GUI yazdırma-------------------------*/
        JFrame mainMap= new JFrame();
        mainMap.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        for(int i=0; i< bigWidth / smallEdge; i++) {
            for (int j = 0; j < bigHeight/smallHeight; j++) {
                //System.out.println("smallEdge in composed" + smallEdge);
                Triangle tIN = new Triangle(smallEdge);
                tVec.addElement(tIN);
                tIN.setX(i*smallEdge);
                tIN.setY(j*smallHeight);
            }
            Y++;
            X=0;
        }

        JPanel p = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {

                super.paintComponent(g);
                g.setColor(Color.RED);
                //g.fillPolygon(poly);
                g.fillRect(0,0,ContainerShape.getWidth(),ContainerShape.getHeight());

                for(int i=0; i< tVec.size(); i++){
                    tVec.get(i).Draw(g);
                }
                /*for(int i=0; i< rVec.size(); i++){
                    g.setColor(Color.GREEN);
                    g.fillRect(rVec.get(i).getX(),rVec.get(i).getY(),rVec.get(i).getWidth(), rVec.get(i).getHeight());
                    g.setColor(Color.BLACK);
                    g.drawRect(rVec.get(i).getX(),rVec.get(i).getY(),rVec.get(i).getWidth(), rVec.get(i).getHeight());
                }*/
            }
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(800, 600);
            }
        };
        mainMap.add(p);
        mainMap.pack();
        mainMap.setVisible(true);
        /*----------------------GUI yazdırma-------------------------*/


    }
    ComposedShape(Rectangle ContainerShape, Circle InnerShapes){

        bigWidth=ContainerShape.getWidth();//bigWidth'e Buyuk Seklin width'ini atiyorum. Width Private oldugu icin getter kullaniyorum
        bigHeight=ContainerShape.getHeight();//Ayni islemi height icin yappiyorum
        smallWidth=InnerShapes.getWidth();//smallWidth ve smallHeight icin de getterlari kucuk sekle uyguluyorum
        smallHeight = InnerShapes.getHeight();
        int X = 0;//X ve Y kooordinatini 0'a esitledim, bunu buyuk sekil icin kullanacagim
        int Y = 0;
        int Y2=0;


        /*----------------------GUI yazdırma-------------------------*/
        JFrame mainMap= new JFrame();
        mainMap.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        for(int i=0; i< bigHeight/smallHeight; i++) {
            for (int j = 0; j < bigWidth / smallWidth; j++) {
                Circle rIN = new Circle(smallWidth, smallHeight, X, Y2, "GREEN");
                cVec.addElement(rIN);
                rIN.setX(X);
                X=X+smallWidth;
                Y2=smallHeight*(Y);
                rIN.setY(Y2);
            }
            Y++;
            X=0;
        }
        JPanel p = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.RED);
                g.fillRect(0,0,ContainerShape.getWidth(),ContainerShape.getHeight());

                for(int i=0; i< cVec.size(); i++){
                    cVec.get(i).Draw(g);
                }
            }
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(800, 600);
            }
        };
        mainMap.add(p);
        mainMap.pack();
        mainMap.setVisible(true);
        /*----------------------GUI yazdırma-------------------------*/


    }
    /*-------------------RECTANGLE ICINE R,T,C---------------------------*/




    /*-------------------TRIANGLE ICINE R,T,C---------------------------*/
    ComposedShape(Triangle ContainerShape, Rectangle InnerShapes){

        //System.out.println("ComposedShape constructor");
        bigEdge=ContainerShape.getEdge();//bigWidth'e Buyuk Seklin width'ini atiyorum. Width Private oldugu icin getter kullaniyorum
        bigHeight=ContainerShape.getHeight();//Ayni islemi height icin yappiyorum
        smallWidth=InnerShapes.getWidth();//smallWidth ve smallHeight icin de getterlari kucuk sekle uyguluyorum
        smallHeight = InnerShapes.getHeight();
        int X = bigEdge/2-smallWidth/2;//X ve Y kooordinatini 0'a esitledim, bunu buyuk sekil icin kullanacagim
        int Y = smallHeight;
        int Y2=smallHeight;
        int count=bigHeight/smallHeight;

        /*----------------------GUI yazdırma-------------------------*/
        JFrame mainMap= new JFrame();
        mainMap.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        for(int i=0; i< bigHeight/smallHeight; i++) {
            for (int j = 0; j < i; j++) {
                Rectangle rIN = new Rectangle(smallWidth, smallHeight, X, Y, "GREEN");
                rVec.addElement(rIN);
                rIN.setX(X);
                X = bigHeight/2 - i*smallWidth/2 + j*smallWidth+10;
                //X=X+smallWidth;
                //Y2=smallHeight*(Y);
                rIN.setY(Y);
            }
            Y+=smallHeight;
            //X=0;
        }
        JPanel p = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.RED);
                int xArr[]={0,bigEdge/2,bigEdge};
                int yArr[]={bigHeight,0,bigHeight};

                Polygon Pol=new Polygon();
                Pol.addPoint(0, bigHeight);
                Pol.addPoint(bigEdge/2,0);
                Pol.addPoint(bigEdge, bigHeight);
                g.setColor(Color.RED);
                g.fillPolygon(Pol);

                for (Rectangle aRVec : rVec) {
                    aRVec.Draw(g);
                }
            }
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(800, 600);
            }
        };
        mainMap.add(p);
        mainMap.pack();
        mainMap.setVisible(true);
        /*----------------------GUI yazdırma-------------------------*/

    }
    ComposedShape(Triangle ContainerShape, Triangle InnerShapes){


        bigEdge=ContainerShape.getEdge();//bigWidth'e Buyuk Seklin width'ini atiyorum. Width Private oldugu icin getter kullaniyorum
        bigHeight=ContainerShape.getHeight();//Ayni islemi height icin yappiyorum
        smallEdge=InnerShapes.getEdge();//smallWidth ve smallHeight icin de getterlari kucuk sekle uyguluyorum
        smallHeight = InnerShapes.getHeight();
        int X = 0;//X ve Y kooordinatini 0'a esitledim, bunu buyuk sekil icin kullanacagim
        int Y = 0;
        int Y2=0;


        /*----------------------GUI yazdırma-------------------------*/
        JFrame mainMap= new JFrame();
        mainMap.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        for(int i=0; i< bigHeight/smallHeight; i++) {
            for (int j = 0; j < bigEdge / smallEdge; j++) {
                Triangle tIN = new Triangle(smallEdge);
                tVec.addElement(tIN);
                tIN.setX(X);
                X=X+smallEdge;
                Y2=smallHeight*(Y);
                tIN.setY(Y2);
            }
            Y++;
            X=0;
        }
        JPanel p = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.RED);
                Polygon Pol=new Polygon();
                Pol.addPoint(0, bigHeight);
                Pol.addPoint(bigEdge/2,0);
                Pol.addPoint(bigEdge, bigHeight);
                g.setColor(Color.RED);
                g.fillPolygon(Pol);

                for(int i=0; i< tVec.size(); i++){
                    tVec.get(i).Draw(g);
                }
            }
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(800, 600);
            }
        };
        mainMap.add(p);
        mainMap.pack();
        mainMap.setVisible(true);
        /*----------------------GUI yazdırma-------------------------*/



    }
    ComposedShape(Triangle ContainerShape, Circle InnerShapes){

        bigEdge=ContainerShape.getEdge();//bigWidth'e Buyuk Seklin width'ini atiyorum. Width Private oldugu icin getter kullaniyorum
        bigHeight=ContainerShape.getHeight();//Ayni islemi height icin yappiyorum
        smallWidth=InnerShapes.getWidth();//smallWidth ve smallHeight icin de getterlari kucuk sekle uyguluyorum
        smallHeight = InnerShapes.getHeight();
        int X = 0;//X ve Y kooordinatini 0'a esitledim, bunu buyuk sekil icin kullanacagim
        int Y = 0;
        int Y2=0;


        /*----------------------GUI yazdırma-------------------------*/
        JFrame mainMap= new JFrame();
        mainMap.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        for(int i=0; i< bigHeight/smallHeight; i++) {
            for (int j = 0; j < bigEdge / smallWidth; j++) {
                Circle cIN = new Circle(smallWidth, smallHeight, X, Y2, "GREEN");
                cVec.addElement(cIN);
                cIN.setX(X);
                X=X+smallWidth;
                Y2=smallHeight*(Y);
                cIN.setY(Y2);
            }
            Y++;
            X=0;
        }
        JPanel p = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.RED);
                int xArr[]={0,bigEdge/2,bigEdge};
                int yArr[]={bigHeight,0,bigHeight};

                Polygon Pol=new Polygon();
                Pol.addPoint(0, bigHeight);
                Pol.addPoint(bigEdge/2,0);
                Pol.addPoint(bigEdge, bigHeight);
                g.setColor(Color.RED);
                g.fillPolygon(Pol);

                for(int i=0; i< cVec.size(); i++){
                    cVec.get(i).Draw(g);
                }
            }
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(800, 600);
            }
        };
        mainMap.add(p);
        mainMap.pack();
        mainMap.setVisible(true);
        /*----------------------GUI yazdırma-------------------------*/

    }
    /*-------------------TRIANGLE ICINE R,T,C---------------------------*/




    /*-------------------CIRCLE ICINE R,T,C---------------------------*/
    ComposedShape(Circle ContainerShape, Rectangle InnerShapes){

        bigWidth=ContainerShape.getWidth();//bigWidth'e Buyuk Seklin width'ini atiyorum. Width Private oldugu icin getter kullaniyorum
        bigHeight=ContainerShape.getHeight();//Ayni islemi height icin yappiyorum
        smallWidth=InnerShapes.getWidth();//smallWidth ve smallHeight icin de getterlari kucuk sekle uyguluyorum
        smallHeight = InnerShapes.getHeight();
        int X = 0;//X ve Y kooordinatini 0'a esitledim, bunu buyuk sekil icin kullanacagim
        int Y = 0;
        int Y2=0;


        /*----------------------GUI yazdırma-------------------------*/
        JFrame mainMap= new JFrame();
        mainMap.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        for(int i=0; i< bigHeight/smallHeight; i++) {
            for (int j = 0; j < bigWidth / smallWidth; j++) {
                Rectangle rIN = new Rectangle(smallWidth, smallHeight, X, Y2, "GREEN");
                rVec.addElement(rIN);
                rIN.setX(X);
                X=X+smallWidth;
                Y2=smallHeight*(Y);
                rIN.setY(Y2);
            }
            Y++;
            X=0;
        }
        JPanel p = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.RED);
                g.fillOval(0,0,ContainerShape.getWidth(),ContainerShape.getHeight());

                for(int i=0; i< rVec.size(); i++){
                    if(i!=0 && i!=1 && i!=rVec.size() && i!= rVec.size()-1)
                        rVec.get(i).Draw(g);
                }
            }
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(800, 600);
            }
        };
        mainMap.add(p);
        mainMap.pack();
        mainMap.setVisible(true);
        /*----------------------GUI yazdırma-------------------------*/

    }
    ComposedShape(Circle ContainerShape, Triangle InnerShapes){
        bigWidth=ContainerShape.getWidth();//bigWidth'e Buyuk Seklin width'ini atiyorum. Width Private oldugu icin getter kullaniyorum
        bigHeight=ContainerShape.getHeight();//Ayni islemi height icin yappiyorum
        smallEdge=InnerShapes.getEdge();
        smallHeight= (int) ((smallEdge/2)*sqrt(3));
        int X = 0;//X ve Y kooordinatini 0'a esitledim, bunu buyuk sekil icin kullanacagim
        int Y = 0;
        int Y2=0;

        /*----------------------GUI yazdırma-------------------------*/
        JFrame mainMap= new JFrame();
        mainMap.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        for(int i=0; i< bigWidth / smallEdge; i++) {
            for (int j = 0; j < bigHeight/smallHeight-2; j++) {
                //System.out.println("smallEdge in composed" + smallEdge);
                Triangle tIN = new Triangle(smallEdge);
                tVec.addElement(tIN);
                tIN.setX(i*smallEdge);
                tIN.setY(j*smallHeight);
            }
            Y++;
            X=0;
        }

        JPanel p = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {

                super.paintComponent(g);
                g.setColor(Color.RED);
                //g.fillPolygon(poly);
                g.fillOval(0,0,ContainerShape.getWidth(),ContainerShape.getHeight());

                for(int i=0; i< tVec.size(); i++){
                    tVec.get(i).Draw(g);
                }
            }
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(800, 600);
            }
        };
        mainMap.add(p);
        mainMap.pack();
        mainMap.setVisible(true);
        /*----------------------GUI yazdırma-------------------------*/



    }
    ComposedShape(Circle ContainerShape, Circle InnerShapes){

        bigWidth=ContainerShape.getWidth();//bigWidth'e Buyuk Seklin width'ini atiyorum. Width Private oldugu icin getter kullaniyorum
        bigHeight=ContainerShape.getHeight();//Ayni islemi height icin yappiyorum
        smallWidth=InnerShapes.getWidth();//smallWidth ve smallHeight icin de getterlari kucuk sekle uyguluyorum
        smallHeight = InnerShapes.getHeight();
        int X = 0;//X ve Y kooordinatini 0'a esitledim, bunu buyuk sekil icin kullanacagim
        int Y = 0;
        int Y2=0;

        /*----------------------GUI yazdırma-------------------------*/
        JFrame mainMap= new JFrame();
        mainMap.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        for(int i=0; i< bigHeight/smallHeight; i++) {
            for (int j = 0; j < bigWidth / smallWidth; j++) {
                Circle rIN = new Circle(smallWidth, smallHeight, X, Y2, "GREEN");
                cVec.addElement(rIN);
                rIN.setX(X);
                X=X+smallWidth;
                Y2=smallHeight*(Y);
                rIN.setY(Y2);
            }
            Y++;
            X=0;
        }
        JPanel p = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.RED);
                g.fillOval(0,0,ContainerShape.getWidth(),ContainerShape.getHeight());

                for(int i=0; i< cVec.size(); i++){
                    if(bigHeight/smallHeight<2) {
                        g.setColor(Color.GREEN);
                        g.fillOval(smallWidth/4-50,smallHeight/4-50,smallWidth,smallHeight);
                        g.setColor(Color.BLACK);
                        g.drawOval(smallWidth/4-50,smallHeight/4-50,smallWidth,smallHeight);
                        break;
                    }
                    if(bigHeight/smallHeight<=2 && bigHeight/smallHeight<3){
                        g.setColor(Color.GREEN);
                        g.fillOval(124,bigHeight/2,smallWidth,smallHeight);
                        g.setColor(Color.BLACK);
                        g.drawOval(124,bigHeight/2,smallWidth,smallHeight);
                        g.setColor(Color.GREEN);
                        g.fillOval(124,smallHeight/4-50,smallWidth,smallHeight);
                        g.setColor(Color.BLACK);
                        g.drawOval(124,smallHeight/4-50,smallWidth,smallHeight);
                        break;
                    }

                    cVec.get(i).Draw(g);
                }
            }
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(800, 600);
            }
        };
        mainMap.add(p);
        mainMap.pack();
        mainMap.setVisible(true);
        /*----------------------GUI yazdırma-------------------------*/
    }
    /*-------------------CIRCLE ICINE R,T,C---------------------------*/


    @Override
    public double getArea() {
        return 0;
    }

    @Override
    public int getPerimeter() {
        return 0;
    }

    @Override
    public void Increment() {
    }

    @Override
    public void Decrement() {

    }

    @Override
    public int compareTo(Shape S) {
        return 0;
    }

    @Override
    public void Draw(Graphics inputShape) {
        //composedShape Draw fonksiyonu. Polygona göre
        Vector<java.awt.Polygon> p = new Vector<java.awt.Polygon>();
        for(int i=0; i< rVec.size(); i++){
            java.awt.Polygon Pol=new java.awt.Polygon();
            Pol.addPoint(rVec.get(i).getX(),rVec.get(i).getY());
            Pol.addPoint(rVec.get(i).getX()+rVec.get(i).getWidth(),rVec.get(i).getY());
            Pol.addPoint(rVec.get(i).getX()+rVec.get(i).getWidth(),rVec.get(i).getY()+rVec.get(i).getHeight());
            Pol.addPoint(rVec.get(i).getX(),rVec.get(i).getY()+rVec.get(i).getHeight());
            p.addElement(Pol);
            for(int j=0; j< p.size(); j++){
                inputShape.setColor(Color.GREEN);
                inputShape.fillPolygon(p.get(j));
                inputShape.setColor(Color.BLACK);
                inputShape.drawPolygon(p.get(j));
            }
        }
    }

}


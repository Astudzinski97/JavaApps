import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Color;


class Odcinek{
    private int x0, y0, x1, y1;
    public Odcinek(int x0, int y0, int x1, int y1) {
        this.x0=x0; this.y0=y0; this.x1=x1; this.y1=y1;
    }
    public int x0() { return this.x0; }
    public int y0() { return this.y0; }
    public int x1() { return this.x1; }
    public int y1() { return this.y1; }
}


class Rysuj extends JComponent {
    private static ArrayList<Odcinek> rys =
            new ArrayList<Odcinek>();

    public Rysuj(Odcinek odc) {
        rys.add(odc);
    }

    public void paintComponent(Graphics g) {
        g.setColor(Color.red);
        for (Odcinek odc : rys)
            g.drawLine(odc.x0(),odc.y0(), odc.x1(),odc.y1());
    }
}
class Zielony extends JComponent {
    private static ArrayList<Odcinek> rys =
            new ArrayList<Odcinek>();

    public Zielony(Odcinek odc) {
        rys.add(odc);
    }

    public void paintComponent(Graphics g) {
        g.setColor(Color.green);
        for (Odcinek odc : rys)
            g.drawLine(odc.x0(),odc.y0(), odc.x1(),odc.y1());
    }
}
class Niebieski extends JComponent {
    private static ArrayList<Odcinek> rys =
            new ArrayList<Odcinek>();

    public Niebieski(Odcinek odc) {
        rys.add(odc);
    }

    public void paintComponent(Graphics g) {
        g.setColor(Color.blue);
        for (Odcinek odc : rys)
            g.drawLine(odc.x0(),odc.y0(), odc.x1(),odc.y1());
    }
}

public class App2 extends JComponent {
    private static final int poprX=-5, poprY=-30;
    private static int x0, y0;

    public static void main(String[] args) {
        JFrame ramka = new JFrame();
        ramka.setBounds(500,0,300,200);
//    ramka.setBounds(0,700,600,400);
        ramka.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
        ramka.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ramka.addMouseListener(
                new MouseAdapter() {
                    public void mousePressed(MouseEvent ev) {

                        x0 = ev.getX()+poprX;  y0 = ev.getY()+poprY;
                    }
                    public void mouseReleased(MouseEvent ev) {
                        if(ev.getButton() == MouseEvent.BUTTON1) {

                            int x1 = ev.getX()+poprX,  y1 = ev.getY()+poprY;
                            ramka.add(new Rysuj(new Odcinek(x0,y0, x1,y1)));
                            ramka.revalidate();
                        }
                        if(ev.getButton() == MouseEvent.BUTTON2) {

                            int x1 = ev.getX()+poprX,  y1 = ev.getY()+poprY;
                            ramka.add(new Zielony(new Odcinek(x0,y0, x1,y1)));
                            ramka.revalidate();
                        }
                        if(ev.getButton() == MouseEvent.BUTTON3) {

                            int x1 = ev.getX()+poprX,  y1 = ev.getY()+poprY;
                            ramka.add(new Niebieski(new Odcinek(x0,y0, x1,y1)));
                            ramka.revalidate();
                        }
                    }
                }
        );

        ramka.setVisible(true);
    }
}
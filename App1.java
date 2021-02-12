import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class App1 {

    public static void main(String args[]) {
        App1 a = new App1();
    }

    public App1() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new MyPanel());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class MyPanel extends JPanel {

        private int n = 0;
        private int m = 0;
        private int i = 170;
        private int j = 340;
        private int a = 60;
        private int b = 20;

        public MyPanel() {
            InputMap im = getInputMap(WHEN_IN_FOCUSED_WINDOW);
            ActionMap am = getActionMap();

            im.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0), "Action.down");
            am.put("Action.down", new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    m += 4;
                    repaint();
                }
            });
            im.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), "Action.right");
            am.put("Action.right", new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    n += 4;
                    repaint();
                }
            });
            im.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), "Action.left");
            am.put("Action.left", new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    n -= 4;
                    repaint();
                }
            });
            im.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0), "Action.up");
            am.put("Action.up", new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    m -= 4;
                    repaint();
                }
            });
            im.put(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0), "Action.space");
            am.put("Action.space", new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    n = 0;
                    m = 0;
                    repaint();
                }
            });
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(400, 400);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            g2.setColor(Color.red);
            g2.fillOval(n, m, 15, 15);
        }
    }

}
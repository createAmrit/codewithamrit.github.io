import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GracyHeart extends JPanel implements ActionListener {
    private int size = 100;
    private boolean growing = true;
    private Timer timer;

    public GracyHeart() {
        timer = new Timer(100, this);
        timer.start();
    }

    public void actionPerformed(ActionEvent e) {
        if (growing) {
            size += 2;
            if (size >= 120) growing = false;
        } else {
            size -= 2;
            if (size <= 100) growing = true;
        }
        repaint();
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(new Color(255, 230, 240));
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.PINK);
        g2d.fillArc(100, 100, size, size, 0, 180);
        g2d.fillArc(100 + size / 2, 100, size, size, 0, 180);
        Polygon triangle = new Polygon();
        triangle.addPoint(100, 100 + size / 2);
        triangle.addPoint(100 + size + size / 2, 100 + size / 2);
        triangle.addPoint(100 + size, 100 + size + 50);
        g2d.fillPolygon(triangle);

        g2d.setColor(Color.WHITE);
        g2d.setFont(new Font("Serif", Font.BOLD, 24));
        g2d.drawString("For Gracy ❤️", 130, 280);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Heart for Gracy");
        frame.setDefaultClose

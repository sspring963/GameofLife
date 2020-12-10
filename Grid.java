package life;

import javax.swing.*;
import java.awt.*;

public class Grid extends JPanel {



    public Grid() {
        setBounds(1,21,400,400);
    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;


        for (int i = 1; i < GameOfLife.universe.getSize(); i++) {

            g.drawLine(20 * i, 0, 20 * i, 400);
            g.drawLine(0, 20 * i, 400, 20 * i);

        }

        for (int i = 0; i < GameOfLife.universe.getSize(); i++) {

            for (int j = 0; j < GameOfLife.universe.getSize(); j++) {

                if (GameOfLife.universe.getUniverse()[i][j] == ' ') {

                    g.fillRect(j * 20, i * 20, 20, 20);

                }
            }
        }
    }
}

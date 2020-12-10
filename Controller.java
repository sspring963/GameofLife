package life;

import life.GameOfLife;
import java.io.IOException;
import static life.GameOfLife.worldPanel;


public class Controller extends Thread {

    private int generations = 1;


    public void run() {


            generations++;
            System.out.println("Generation: " + generations);
            GameOfLife.generationLabel.setText(("Generation: " + generations));

            Algorithm alg = new Algorithm(GameOfLife.universe.getUniverse()); // sends current universe to algorithm
            GameOfLife.universe.setUniverse(alg.nextGeneration());  ; // changes old universe to new universe

            System.out.println("Alive: " + GameOfLife.universe.howManyAlive()); //prints how many cells are alive
            GameOfLife.generationLabel.setText(("Alive: " + GameOfLife.universe.howManyAlive()));
            worldPanel.repaint();


    }
}

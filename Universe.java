package life;

import java.util.Random;

public class Universe {


    private char[][] universe;
    private final Random random;
    private int generationNumber = 1;

    Universe(int N) {

        universe = new char[N][N];
        random = new Random();

        boolean alive;
        for (char[] arr: universe) { //creates the universe with random alive and dead cells
            for (int j = 0; j < arr.length; j++) {
                alive = random.nextBoolean();
                if (alive) {
                    arr[j] = 'O';
                } else {
                    arr[j] = ' ';
                }
            }
        }

    }

    public void printUniverse() { //prints the universe

        for (char[] arr: universe) {
            for (char cell: arr) {
                System.out.print(cell);
            }
            System.out.println();
        }
    }

    public char[][] generations() {
        for(int i = 0; i < 10; i++) {
            System.out.println("Generation: " + (i + 1));
            generationNumber = i + 1;

            Algorithm alg = new Algorithm(universe); // sends current universe to algorithm
            this.universe = alg.nextGeneration(); // changes old universe to new universe

            System.out.println("Alive: " + howManyAlive()); //prints how many cells are alive
            printUniverse();
        }

        return universe;
    }

    public int howManyAlive() { //prints how many cells are alive in current universe
        int alive = 0;
        for (char[] arr: this.universe) {
            for (char cell: arr) {
                if (cell == 'O') {
                    alive++;
                }
            }
        }
        return alive;
    }

    public void setUniverse(char[][] arr) { this.universe = arr;}

    public char[][] getUniverse() {
        return universe;
    } //returns this universe

    public int getGenerationNumber() {
        return generationNumber;
    }

    public int getSize() { return universe.length;}
}


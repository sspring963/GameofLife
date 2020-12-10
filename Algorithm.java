package life;

public class Algorithm {

    private char[][] universe;
    private char[][] algUniverse;
    private int N;


    Algorithm(char[][] universe) {
        this.universe = universe;
        N = universe.length;
        algUniverse = new char[N + 2][N + 2]; //creates a universe n+2 bigger to mirror the sides

        //make Corners
        algUniverse[0][0] = universe[N - 1][N - 1]; //NW corner
        algUniverse[0][N+1] = universe[N - 1][0]; // NE
        algUniverse[N+1][0] = universe[0][N-1]; // SW
        algUniverse[N+1][N+1] = universe[0][0]; // SE

        //make sides
        for (int i = 0; i < N ; i++) {
            algUniverse[0][i + 1] = universe[N - 1][i]; //north side
            algUniverse[N + 1][i + 1] = universe[0][i]; //south side
            algUniverse[i + 1][0] = universe[i][N - 1]; //west side
            algUniverse[i + 1][N + 1] = universe[i][0]; //east side
        }

        //make center
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                algUniverse[i+1][j+1] = universe[i][j];
            }
        }

    }

    public char[][] nextGeneration() { //changes the copy of the old universe than passes the center of the alg universe after evolution

        for (int i = 1; i < N + 1; i ++) {
            for (int j = 1; j < N + 1; j++) {
                universe[i - 1][j - 1] = evolution(i, j);
            }
        }
        return universe;
    }

    public char evolution(int i, int j) { // determines whether the cell lives or dies based on its neighbors
        int countLiveCells = 0;

        if (algUniverse[i - 1][j - 1] == 'O') { //NW
            countLiveCells++;
        }
        if (algUniverse[i - 1][j] == 'O') { //N
            countLiveCells++;
        }
        if (algUniverse[i - 1][j + 1] == 'O') { //NE
            countLiveCells++;
        }
        if (algUniverse[i][j - 1] == 'O') { //W
            countLiveCells++;
        }
        if (algUniverse[i][j + 1] == 'O') { //E
            countLiveCells++;
        }
        if (algUniverse[i + 1][j - 1] == 'O') { //SW
            countLiveCells++;
        }
        if (algUniverse[i + 1][j] == 'O') { //S
            countLiveCells++;
        }
        if (algUniverse[i + 1][j + 1] == 'O') { //SE
            countLiveCells++;
        }

        if (countLiveCells < 2) {
            return ' ';
        } else if(countLiveCells == 2 && algUniverse[i][j] == 'O') {
            return 'O';
        } else if(countLiveCells == 3) {
            return 'O';
        } else if(countLiveCells > 3) {
            return ' ';
        }
        return ' ';
    }

}

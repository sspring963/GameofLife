package life;
import java.util.Scanner;
import java.util.Random;
import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        Thread t = new Thread();
        Scanner scn = new Scanner(System.in);

        GameOfLife game = new GameOfLife();
        game.run();
    }
}



package life;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;


public class GameOfLife extends JFrame {

    public static JPanel LabelPanel;
    public static JPanel buttonPanel;
    public static JLabel generationLabel;
    public static JLabel aliveLabel;
    public static JPanel worldPanel;
    public static Universe universe;
    public static JToggleButton PlayToggleButton;
    public static JButton ResetButton;
    public static Controller menu;


    public GameOfLife() {
        universe = new Universe(20);
        menu = new Controller();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400,440);
        setLayout(null);
        setVisible(true);


        buttonPanel = new JPanel();
        buttonPanel.setBounds(0, 0, 400, 20);
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        add(buttonPanel);

        LabelPanel = new JPanel();
        LabelPanel.setBounds(0, 20, 400, 20);
        LabelPanel.setLayout(new BoxLayout(LabelPanel, BoxLayout.Y_AXIS));
        LabelPanel.setName("LabelPanel");
        add(LabelPanel);

        generationLabel = new JLabel();
        generationLabel.setName("GenerationLabel");
        generationLabel.setText("Generation #1");
        generationLabel.setBounds(0, 21, 400, 10);
        LabelPanel.add(generationLabel);

        aliveLabel = new JLabel();
        aliveLabel.setName("AliveLabel");
        aliveLabel.setText("Alive" + universe.howManyAlive());
        aliveLabel.setBounds(0,40,400,10);
        LabelPanel.add(aliveLabel);



        PlayToggleButton = new JToggleButton();
        PlayToggleButton.setName("PlayToggleButton");
        PlayToggleButton.setBounds(1, 1, 40, 20);

        ItemListener itemListener = new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                int state = e.getStateChange();


                if(state == ItemEvent.SELECTED) {
                    try {
                        menu.wait();
                    } catch (InterruptedException interruptedException) {
                        interruptedException.printStackTrace();
                    }
                } else {
                    try {
                        menu.notifyAll();
                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }
                }
            }
        } ;

        PlayToggleButton.addItemListener(itemListener);
        buttonPanel.add(PlayToggleButton);

        ResetButton = new JButton();
        ResetButton.setName("ResetButton");
        ResetButton.setBounds(42, 1, 40, 20);
        ResetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                universe = new Universe(20);
                menu = new Controller();
                menu.run();
            }
        });
        buttonPanel.add(ResetButton);




        worldPanel = new Grid();
        worldPanel.setName("Grid");
        add(worldPanel);


    }

    public void run() {
        menu.run();
    }


}


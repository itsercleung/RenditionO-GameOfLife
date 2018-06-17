package gameOfLife;

import javax.swing.JFrame;

public class GUIFrame implements Runnable {

    public void run() {
        //Create and set up the Window
        JFrame frame = new JFrame("Eric's Rendition of Conway's GOL");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Create and set up the content Pane based on our MainPanel class
        MainPanel newContentPane = new MainPanel();

        //Main frame window settings
        frame.setContentPane(newContentPane);
        frame.setBounds(10,10,1000,1000);
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
    }
}

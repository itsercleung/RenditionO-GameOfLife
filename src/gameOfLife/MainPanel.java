package gameOfLife;

import javax.swing.JPanel;
import java.awt.BorderLayout;

public class MainPanel extends JPanel {

    private static Board board;
    private static Menu menu;
    //private static Counter counter;

    public MainPanel() {
        setLayout(new BorderLayout());
        menu = new Menu();
        board = new Board();
        //counter = new Counter();

        //Add all the panels with their respective content to the different areas of the main JPanel
        add(menu,BorderLayout.NORTH);
        add(board,BorderLayout.CENTER);
        //add(counter,BorderLayout.SOUTH);
    }

    public static Board getBoard() {
        return board;
    }

    /*public static Counter getCounter(){
        return counter;
    }
    */
}
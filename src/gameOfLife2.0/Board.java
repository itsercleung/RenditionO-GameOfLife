package gameOfLife;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements ActionListener {

    private int column = 125, row = 125; //Size of board *maybe.. 200x200 is max otherwise everything slows down
    private  JButton[][] cells = new JButton[row][column];
    private Timer timer;
    private Boolean initialCheck = true; //If initial board has cells in them or not

    Board() {
        setLayout(new GridLayout(column, row, 0,0));

        //Make cells with default settings
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < column; j++) {
                cells[i][j] = new JButton();
                cells[i][j].setBackground(Color.BLACK);
                cells[i][j].setPreferredSize(new Dimension(5,5)); //Adjust the cells to its size! Really cool
                cells[i][j].setActionCommand("Clicked");
                cells[i][j].addActionListener(this);
                cells[i][j].setBorderPainted(false);
                cells[i][j].setFocusPainted(false);
                add(cells[i][j]);
            }
        }
        timer = new Timer(60, this); //Timer that essentially speeds or slows down behaviour of Cell life (dayum)..
        timer.setActionCommand("Timer");
        timer.setInitialDelay(0);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Clicked")) {
            //Find cell clicked and make changes outlined in selectedCells method
            for(int i = 0; i < row; i++){
                for(int j = 0 ;j < column; j++){
                    if(e.getSource() == cells[i][j]){
                        selectedCells(cells[i][j]);
                    }
                }
            }
        }
        if(e.getActionCommand().equals("Timer")) {
            //If starting grid is empty create random grid
            if(arrayCheck() && initialCheck){
                randomizeCells();
            }
            //If starting grid is not empty then life of the initially made cells count until all dies
            else if(!arrayCheck()){
                initialCheck = false;
            }
            //And thus if non empty starting grid cells all die out, then timer stops (count stops too)
            else if(arrayCheck() && !initialCheck) {
                timer.stop();
            }
            MainPanel.getCounter().incrementCount(); //Each increment of Counter
            RefreshCells refreshCells = new RefreshCells(); //Each increment of refreshing cells
        }
    }

    public void reset() {
        //Resets all cells back to original state
        for (int i = 0; i< row; i++) {
            for (int j = 0; j < column; j++) {
                cells[i][j].setSelected(false);
                cells[i][j].setBackground(Color.BLACK);
            }
        }
        initialCheck = true;
        timer.stop();
    }

    //Changes cell to selected when clicked
    private void selectedCells(JButton cell) {
        if (!cell.isSelected()) {
            cell.setBackground(Color.WHITE);
            cell.setSelected(true);
        }
        else {
            cell.setBackground(Color.BLACK);
            cell.setSelected(false);
        }
    }

    //Creates the random grid if starting grid is empty
    private void randomizeCells() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                Random cellRandom = new Random();
                if (!cellRandom.nextBoolean()){
                    cells[i][j].setSelected(false);
                    cells[i][j].setBackground(Color.BLACK);
                }
                else {
                    cells[i][j].setSelected(true);
                    cells[i][j].setBackground(Color.WHITE);
                }
            }
        }
    }

    //Checks whether grid is empty or not. Returns false if not.
    private boolean arrayCheck(){
        for(int i = 0; i < row; i++){
            for(int j = 0; j < column; j++){
                if(cells[i][j].isSelected()){
                    return false;
                }
            }
        }
        return true;
    }

    //Helper methods for specific methods above
    public JButton[][] getCells() {
        return cells;
    }
    public void setCells(JButton[][] cells) {
        this.cells = cells;
    }

    public Timer getTimer() {
        return timer;
    }

    public int getColumn() {
        return column;
    }
    public int getRow() {
        return row;
    }
}

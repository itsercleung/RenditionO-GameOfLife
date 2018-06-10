package gameOfLife;

import java.awt.Color;

import javax.swing.JButton;

public class RefreshCells {

    private Board board = MainPanel.getBoard();
    private JButton[][] cells = board.getCells();
    private int row = board.getRow(), column = board.getColumn();
    private boolean newCells[][] = new boolean[row][column];

    RefreshCells(){
        neighbours();
    }

    //Checks how many neighbours each cell has (wraps around)
    private void neighbours() {
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < column; j++) {
                int neighbours = 0;

                for(int x = -1; x < 2; x++){
                    for(int y = -1; y < 2; y++){
                        if(x == 0 && y == 0) {

                        }
                        else if(cells[(i + x + column) % column][(j + y + row) % row].isSelected()) {
                            neighbours++;
                        }
                    }
                }
                /*
                 * Store new cell in newCells boolean array, setCellStatus checks rules for cell life/death
                 * We need a separate array as otherwise as program loops through, previous cells would have
                 * changed before other cells have been checked against the rules. Need board to change as one.
                 */
                newCells[i][j] = setCellStatus(cells[i][j],newCells[i][j],neighbours);
            }
        }
        createNewBoard();
    }

    //REGULAR SETTING: Conways Game of Life
    private boolean setCellStatus(JButton cell, boolean newCell, int neighbours){

        if(cell.isSelected() && ((neighbours < 2) || (neighbours > 3))) {
            newCell = false;
        }
        else if(!cell.isSelected() && (neighbours==3)) {
            newCell = true;
        }
        else {
            newCell = cell.isSelected();
        }
        return newCell; //Return outcome to newCells index
    }


    //TRIPPY SETTING: RABBIT LIKE CELLS.
    /*
    private boolean setCellStatus(JButton cell, boolean newCell, int neighbours){

        if(cell.isSelected() && ((neighbours < 2))) {
            newCell = false;
        }
        else if(!cell.isSelected() && (neighbours==3) || (neighbours==2)) {
            newCell = true;
        }
        else if((neighbours == 2) || (neighbours == 3) || (neighbours == 4)) {
            newCell = cell.isSelected();
        }
        return newCell; //Return outcome to newCells index
    }
    */

    //Creates and sets the new board based on boolean array newCells
    private void createNewBoard(){

        for(int i = 0; i < row; i++){
            for(int j = 0; j < column; j++){

                if(newCells[i][j]) {
                    cells[i][j].setSelected(true);
                    cells[i][j].setBackground(Color.WHITE);
                }
                else {
                    cells[i][j].setSelected(false);
                    cells[i][j].setBackground(Color.BLACK);
                }
            }
        }
        board.setCells(cells);
    }
}

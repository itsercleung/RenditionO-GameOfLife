package gameOfLife;

import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Counter extends JLabel{

    private int count = 0;

    Counter(){
        //Creates the label's look and position
        setOpaque(true);
        setBackground(Color.BLACK);
        setText("<press start>");
        setHorizontalAlignment(JLabel.CENTER);
        setFont(getFont().deriveFont(10.f));
        setForeground(Color.GRAY);
        setBorder(new EmptyBorder(10,10,10,10));
    }

    public void incrementCount(){
        setText("time: " + String.valueOf(count++));
    }

    public void resetCount(){
        count = 0;
        setText("<press start>");
    }

}

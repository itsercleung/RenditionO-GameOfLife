package gameOfLife;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Menu extends JPanel implements ActionListener{

    private JButton run = new JButton("Start");
    private JButton pause = new JButton("Pause");
    private JButton reset = new JButton("Reset");

    Menu() {
        setLayout(new GridLayout(1,3,0,0));

        run.setBackground(Color.BLACK);
        run.setForeground(Color.GRAY);
        run.setFont(run.getFont().deriveFont(15.0f));
        run.setActionCommand("Start");
        run.addActionListener(this);
        run.setBorderPainted(false);
        run.setFocusPainted(false);

        pause.setBackground(Color.BLACK);
        pause.setFont(pause.getFont().deriveFont(15.0f));
        pause.setEnabled(false);
        pause.setActionCommand("Pause");
        pause.addActionListener(this);
        pause.setBorderPainted(false);
        pause.setFocusPainted(false);

        reset.setBackground(Color.BLACK);
        reset.setFont(reset.getFont().deriveFont(15.0f));
        reset.setEnabled(false);
        reset.setActionCommand("Reset");
        reset.addActionListener(this);
        reset.setBorderPainted(false);
        reset.setFocusPainted(false);

        add(run);
        add(pause);
        add(reset);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Board board = MainPanel.getBoard();
        //Counter counter = MainPanel.getCounter();

        if(e.getActionCommand().equals("Start")) {
            run.setEnabled(false);
            pause.setEnabled(true);
            reset.setEnabled(true);
            board.getTimer().start();
        }
        if (e.getActionCommand().equals("Pause")) {
            pause.setEnabled(false);
            run.setEnabled(true);
            board.getTimer().stop();
        }

        //Reset buttons to original states
        if (e.getActionCommand().equals("Reset")) {
            reset.setEnabled(false);
            pause.setEnabled(false);
            run.setEnabled(true);
            board.reset();
            //counter.resetCount();
        }
    }
}

package TicTacToe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class Tictactoe {

    public static void main(String[] args) {

        MainFrame frame = new MainFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,300);
        frame.setVisible(true);
    }
}

class MainFrame extends JFrame {

    public MainFrame() {
        setTitle("Tic-tac-toe");
        MainPanel panel = new MainPanel();
        Container pane = getContentPane();
        pane.add(panel);
        pack();
    }
}

class MainPanel extends JPanel {

    private JLabel display;
    private JPanel panel;
    private JPanel panel2;
    private JButton buttonNewgame;
    ArrayList<JButton> button;
    boolean winnerIs;
    Font font;

    public MainPanel() {

        this.setLayout(new BorderLayout());
        panel2 = new JPanel();
        display = new JLabel("Player vs Computer");
        panel2.add(display);
        panel2.setBackground(Color.GREEN);
        this.add(panel2, BorderLayout.SOUTH);
        buttonNewgame = new JButton("New game");
        buttonNewgame.setFont(font);
        buttonNewgame.addActionListener(new CommandAction());
        this.add(buttonNewgame, BorderLayout.NORTH);
        panel = new JPanel();
        panel.setLayout(new GridLayout(3,3));
        font = new Font("Monospased", Font.BOLD, 20);
        addButtons();
        this.add(panel, BorderLayout.CENTER);
    }

    private void addButtons() {

        button = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            JButton button1 = new JButton("");
            button1.addActionListener(new CommandAction());
            button1.setBackground(Color.cyan);
            button1.setFont(font);
            button.add(button1);
            panel.add(button1);
        }

    }

    private class CommandAction implements ActionListener {
        public void actionPerformed(ActionEvent event) {


            JButton theButton = (JButton) event.getSource();
            String label = event.getActionCommand();

            if (theButton == buttonNewgame) {
                for (int i = 0; i < button.size(); i++) {
                    button.get(i).setLabel("");
                    button.get(i).setEnabled(true);
                    button.get(i).setBackground(Color.cyan);
                    panel2.setBackground(Color.GREEN);
                }
                display.setText("Your turn!!!");
                winnerIs = false;
            }
            if (label == "") {
                theButton.setLabel("X");
                theWinner();
                if (winnerIs == false) {
                    computerMove();
                }
                theWinner();
            }
        }
    }

    //проверяет ряды и диагонали, если есть 2 занятоые клеточки, то ходит в третюю
    public void computerMove() {


        if ((button.get(0).getLabel() + button.get(1).getLabel() + button.get(2).getLabel()).equals("OO")) {

            if (button.get(0).getLabel().equals("")) {
                button.get(0).setLabel("O");
            } else if (button.get(1).getLabel().equals("")) {
                button.get(1).setLabel("O");
            } else if (button.get(2).getLabel().equals("")) {
                button.get(2).setLabel("O");
            }
        } else
        if ((button.get(3).getLabel() + button.get(4).getLabel() + button.get(5).getLabel()).equals("OO")) {

            if (button.get(3).getLabel().equals("")) {
                button.get(3).setLabel("O");
            } else if (button.get(4).getLabel().equals("")) {
                button.get(4).setLabel("O");
            } else if (button.get(5).getLabel().equals("")) {
                button.get(5).setLabel("O");
            }
        } else
        if ((button.get(6).getLabel() + button.get(7).getLabel() + button.get(8).getLabel()).equals("OO")) {

            if (button.get(6).getLabel().equals("")) {
                button.get(6).setLabel("O");
            } else if (button.get(7).getLabel().equals("")) {
                button.get(7).setLabel("O");
            } else if (button.get(8).getLabel().equals("")) {
                button.get(8).setLabel("O");
            }
        } else
        if ((button.get(0).getLabel() + button.get(3).getLabel() + button.get(6).getLabel()).equals("OO")) {

            if (button.get(0).getLabel().equals("")) {
                button.get(0).setLabel("O");
            } else if (button.get(3).getLabel().equals("")) {
                button.get(3).setLabel("O");
            } else if (button.get(6).getLabel().equals("")) {
                button.get(6).setLabel("O");
            }
        } else
        if ((button.get(1).getLabel() + button.get(4).getLabel() + button.get(7).getLabel()).equals("OO")) {

            if (button.get(1).getLabel().equals("")) {
                button.get(1).setLabel("O");
            } else if (button.get(4).getLabel().equals("")) {
                button.get(4).setLabel("O");
            } else if (button.get(7).getLabel().equals("")) {
                button.get(7).setLabel("O");
            }
        } else
        if ((button.get(2).getLabel() + button.get(5).getLabel() + button.get(8).getLabel()).equals("OO")) {

            if (button.get(2).getLabel().equals("")) {
                button.get(2).setLabel("O");
            } else if (button.get(5).getLabel().equals("")) {
                button.get(5).setLabel("O");
            } else if (button.get(8).getLabel().equals("")) {
                button.get(8).setLabel("O");
            }
        } else
        if ((button.get(0).getLabel() + button.get(4).getLabel() + button.get(8).getLabel()).equals("OO")) {

            if (button.get(0).getLabel().equals("")) {
                button.get(0).setLabel("O");
            } else if (button.get(4).getLabel().equals("")) {
                button.get(4).setLabel("O");
            } else if (button.get(8).getLabel().equals("")) {
                button.get(8).setLabel("O");
            }
        } else
        if ((button.get(2).getLabel() + button.get(4).getLabel() + button.get(6).getLabel()).equals("OO")) {

            if (button.get(2).getLabel().equals("")) {
                button.get(2).setLabel("O");
            } else if (button.get(4).getLabel().equals("")) {
                button.get(4).setLabel("O");
            } else if (button.get(6).getLabel().equals("")) {
                button.get(6).setLabel("O");
            }
        } else {
            closeDangerous();
        }
    }

    public void emptyCell() {

        int i = 0;
        while (i < 9) {
            if (button.get(i).getLabel().equals("")) {
                display.setText("Your turn!");
                break;
            }
            if (i == 8 && !button.get(i).getLabel().equals("")) {
                display.setText("It's draw!!! Press \"New game\" to try again!!!");
                for (int j = 0; j < 9; j++) {
                    button.get(j).setEnabled(false);
                    winnerIs = true;
                }
            }
            i++;
        }
    }

    public void closeDangerous() {

        if ((button.get(0).getLabel() + button.get(1).getLabel() + button.get(2).getLabel()).equals("XX")) {

            if (button.get(0).getLabel().equals("")) {
                button.get(0).setLabel("O");
            } else if (button.get(1).getLabel().equals("")) {
                button.get(1).setLabel("O");
            } else if (button.get(2).getLabel().equals("")) {
                button.get(2).setLabel("O");
            }
        } else
        if ((button.get(3).getLabel() + button.get(4).getLabel() + button.get(5).getLabel()).equals("XX")) {

            if (button.get(3).getLabel().equals("")) {
                button.get(3).setLabel("O");
            } else if (button.get(4).getLabel().equals("")) {
                button.get(4).setLabel("O");
            } else if (button.get(5).getLabel().equals("")) {
                button.get(5).setLabel("O");
            }
        } else
        if ((button.get(6).getLabel() + button.get(7).getLabel() + button.get(8).getLabel()).equals("XX")) {

            if (button.get(6).getLabel().equals("")) {
                button.get(6).setLabel("O");
            } else if (button.get(7).getLabel().equals("")) {
                button.get(7).setLabel("O");
            } else if (button.get(8).getLabel().equals("")) {
                button.get(8).setLabel("O");
            }
        } else
        if ((button.get(0).getLabel() + button.get(3).getLabel() + button.get(6).getLabel()).equals("XX")) {

            if (button.get(0).getLabel().equals("")) {
                button.get(0).setLabel("O");
            } else if (button.get(3).getLabel().equals("")) {
                button.get(3).setLabel("O");
            } else if (button.get(6).getLabel().equals("")) {
                button.get(6).setLabel("O");
            }
        } else
        if ((button.get(1).getLabel() + button.get(4).getLabel() + button.get(7).getLabel()).equals("XX")) {

            if (button.get(1).getLabel().equals("")) {
                button.get(1).setLabel("O");
            } else if (button.get(4).getLabel().equals("")) {
                button.get(4).setLabel("O");
            } else if (button.get(7).getLabel().equals("")) {
                button.get(7).setLabel("O");
            }
        } else
        if ((button.get(2).getLabel() + button.get(5).getLabel() + button.get(8).getLabel()).equals("XX")) {

            if (button.get(2).getLabel().equals("")) {
                button.get(2).setLabel("O");
            } else if (button.get(5).getLabel().equals("")) {
                button.get(5).setLabel("O");
            } else if (button.get(8).getLabel().equals("")) {
                button.get(8).setLabel("O");
            }
        } else
        if ((button.get(0).getLabel() + button.get(4).getLabel() + button.get(8).getLabel()).equals("XX")) {

            if (button.get(0).getLabel().equals("")) {
                button.get(0).setLabel("O");
            } else if (button.get(4).getLabel().equals("")) {
                button.get(4).setLabel("O");
            } else if (button.get(8).getLabel().equals("")) {
                button.get(8).setLabel("O");
            }
        } else
        if ((button.get(2).getLabel() + button.get(4).getLabel() + button.get(6).getLabel()).equals("XX")) {

            if (button.get(2).getLabel().equals("")) {
                button.get(2).setLabel("O");
            } else if (button.get(4).getLabel().equals("")) {
                button.get(4).setLabel("O");
            } else if (button.get(6).getLabel().equals("")) {
                button.get(6).setLabel("O");
            }
        } else {
            cornerMove();
        }
    }

    //Если есть свободные угловые клеточки, то компьютер делает свой ход в данную клеточку
    public void cornerMove() {

        int count = 0;
        int number;
        ArrayList<JButton> cornerButton = new ArrayList<>();
        ArrayList<JButton> anyButton = new ArrayList<>();
        if (button.get(4).getLabel().equals("")) {
            button.get(4).setLabel("O");
        } else
        if (button.get(0).getLabel().equals("") || button.get(2).getLabel().equals("") || button.get(6).getLabel().equals("")
                || button.get(8).getLabel().equals("")) {

            if (button.get(0).getLabel().equals("")) {
                cornerButton.add(button.get(0));
                count++;
            }
            if (button.get(2).getLabel().equals("")) {
                cornerButton.add(button.get(2));
                count++;
            }
            if (button.get(6).getLabel().equals("")) {
                cornerButton.add(button.get(6));
                count++;
            }
            if (button.get(8).getLabel().equals("")) {
                cornerButton.add(button.get(8));
                count++;
            }

            if (count > 0){
                number = (int) (Math.random() * count);
                cornerButton.get(number).setLabel("O");
            }

        } else if (!button.get(0).getLabel().equals("") && !button.get(2).getLabel().equals("") && !button.get(6).getLabel().equals("")
                && !button.get(8).getLabel().equals("")) {
            for (int i = 0; i < 9; i++) {

                if (button.get(i).getLabel().equals("")) {
                    anyButton.add(button.get(i));
                    count++;
                }
            }
            number = (int) (Math.random() * count);
            anyButton.get(number).setLabel("O");
        }
    }


    public void theWinner() {
        if ((button.get(0).getLabel() + button.get(1).getLabel() + button.get(2).getLabel()).equals("OOO") ||
                (button.get(3).getLabel() + button.get(4).getLabel() + button.get(5).getLabel()).equals("OOO") ||
                (button.get(6).getLabel() + button.get(7).getLabel() + button.get(8).getLabel()).equals("OOO") ||
                (button.get(0).getLabel() + button.get(3).getLabel() + button.get(6).getLabel()).equals("OOO") ||
                (button.get(1).getLabel() + button.get(4).getLabel() + button.get(7).getLabel()).equals("OOO") ||
                (button.get(2).getLabel() + button.get(5).getLabel() + button.get(8).getLabel()).equals("OOO") ||
                (button.get(0).getLabel() + button.get(4).getLabel() + button.get(8).getLabel()).equals("OOO") ||
                (button.get(2).getLabel() + button.get(4).getLabel() + button.get(6).getLabel()).equals("OOO")) {
            display.setText("We have a winner!!! The winner is computer!!!");
            panel2.setBackground(Color.RED);
            colorLine();
            for (int i = 0; i < 9; i++){
                button.get(i).setEnabled(false);
            }
        } else if ((button.get(0).getLabel() + button.get(1).getLabel() + button.get(2).getLabel()).equals("XXX") ||
                (button.get(3).getLabel() + button.get(4).getLabel() + button.get(5).getLabel()).equals("XXX") ||
                (button.get(6).getLabel() + button.get(7).getLabel() + button.get(8).getLabel()).equals("XXX") ||
                (button.get(0).getLabel() + button.get(3).getLabel() + button.get(6).getLabel()).equals("XXX") ||
                (button.get(1).getLabel() + button.get(4).getLabel() + button.get(7).getLabel()).equals("XXX") ||
                (button.get(2).getLabel() + button.get(5).getLabel() + button.get(8).getLabel()).equals("XXX") ||
                (button.get(0).getLabel() + button.get(4).getLabel() + button.get(8).getLabel()).equals("XXX") ||
                (button.get(2).getLabel() + button.get(4).getLabel() + button.get(6).getLabel()).equals("XXX")) {
            display.setText("We have a winner!!! The winner is player!!!");
            panel2.setBackground(Color.RED);
            colorLine();
            winnerIs = true;
            for (int i = 0; i < 9; i++){
                button.get(i).setEnabled(false);
            }
        } else emptyCell();
    }

    public void colorLine () {
        if ((button.get(0).getLabel() + button.get(1).getLabel() + button.get(2).getLabel()).equals("OOO")) {
            button.get(0).setBackground(Color.MAGENTA); button.get(1).setBackground(Color.MAGENTA); button.get(2).setBackground(Color.MAGENTA);
        } else if ((button.get(3).getLabel() + button.get(4).getLabel() + button.get(5).getLabel()).equals("OOO")) {
            button.get(3).setBackground(Color.MAGENTA); button.get(4).setBackground(Color.MAGENTA); button.get(5).setBackground(Color.MAGENTA);
        } else if ((button.get(6).getLabel() + button.get(7).getLabel() + button.get(8).getLabel()).equals("OOO")) {
            button.get(6).setBackground(Color.MAGENTA); button.get(7).setBackground(Color.MAGENTA); button.get(8).setBackground(Color.MAGENTA);
        } else if ((button.get(0).getLabel() + button.get(3).getLabel() + button.get(6).getLabel()).equals("OOO")) {
            button.get(0).setBackground(Color.MAGENTA); button.get(3).setBackground(Color.MAGENTA); button.get(6).setBackground(Color.MAGENTA);
        } else if ((button.get(1).getLabel() + button.get(4).getLabel() + button.get(7).getLabel()).equals("OOO")) {
            button.get(1).setBackground(Color.MAGENTA); button.get(4).setBackground(Color.MAGENTA); button.get(7).setBackground(Color.MAGENTA);
        } else if ((button.get(2).getLabel() + button.get(5).getLabel() + button.get(8).getLabel()).equals("OOO")) {
            button.get(2).setBackground(Color.MAGENTA); button.get(5).setBackground(Color.MAGENTA); button.get(8).setBackground(Color.MAGENTA);
        } else if ((button.get(0).getLabel() + button.get(4).getLabel() + button.get(8).getLabel()).equals("OOO")) {
            button.get(0).setBackground(Color.MAGENTA); button.get(4).setBackground(Color.MAGENTA); button.get(8).setBackground(Color.MAGENTA);
        } else if ((button.get(2).getLabel() + button.get(4).getLabel() + button.get(6).getLabel()).equals("OOO")) {
            button.get(2).setBackground(Color.MAGENTA); button.get(4).setBackground(Color.MAGENTA); button.get(6).setBackground(Color.MAGENTA);
        } else if ((button.get(0).getLabel() + button.get(1).getLabel() + button.get(2).getLabel()).equals("XXX")) {
            button.get(0).setBackground(Color.MAGENTA); button.get(1).setBackground(Color.MAGENTA); button.get(2).setBackground(Color.MAGENTA);
        } else if ((button.get(3).getLabel() + button.get(4).getLabel() + button.get(5).getLabel()).equals("XXX")) {
            button.get(3).setBackground(Color.MAGENTA); button.get(4).setBackground(Color.MAGENTA); button.get(5).setBackground(Color.MAGENTA);
        } else if ((button.get(6).getLabel() + button.get(7).getLabel() + button.get(8).getLabel()).equals("XXX")) {
            button.get(6).setBackground(Color.MAGENTA); button.get(7).setBackground(Color.MAGENTA); button.get(8).setBackground(Color.MAGENTA);
        } else if ((button.get(0).getLabel() + button.get(3).getLabel() + button.get(6).getLabel()).equals("XXX")) {
            button.get(0).setBackground(Color.MAGENTA); button.get(3).setBackground(Color.MAGENTA); button.get(6).setBackground(Color.MAGENTA);
        } else if ((button.get(1).getLabel() + button.get(4).getLabel() + button.get(7).getLabel()).equals("XXX")) {
            button.get(1).setBackground(Color.MAGENTA); button.get(4).setBackground(Color.MAGENTA); button.get(7).setBackground(Color.MAGENTA);
        } else if ((button.get(2).getLabel() + button.get(5).getLabel() + button.get(8).getLabel()).equals("XXX")) {
            button.get(2).setBackground(Color.MAGENTA); button.get(5).setBackground(Color.MAGENTA); button.get(8).setBackground(Color.MAGENTA);
        } else if ((button.get(0).getLabel() + button.get(4).getLabel() + button.get(8).getLabel()).equals("XXX")) {
            button.get(0).setBackground(Color.MAGENTA); button.get(4).setBackground(Color.MAGENTA); button.get(8).setBackground(Color.MAGENTA);
        } else if ((button.get(2).getLabel() + button.get(4).getLabel() + button.get(6).getLabel()).equals("XXX")) {
            button.get(2).setBackground(Color.MAGENTA); button.get(4).setBackground(Color.MAGENTA); button.get(6).setBackground(Color.MAGENTA);
        }
    }
}


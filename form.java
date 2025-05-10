import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class form extends JFrame {
    private JPanel pnlMain;
    private JTextField textField1;
    private JButton button1;
    private JTextArea textArea1;
    private JRadioButton rbRock;
    private JRadioButton rbPaper;
    private JRadioButton rbScissors;

    public form() {
        setTitle("Rock Paper Scissors");

        ButtonGroup group = new ButtonGroup();
        group.add(rbRock);
        group.add(rbPaper);
        group.add(rbScissors);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playGame();
            }
        });
    }

    public void playGame() {
        String name = textField1.getText().trim();
        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter your name.");
            return;
        }

        String move = null;
        if (rbRock.isSelected()) move = "Rock";
        else if (rbPaper.isSelected()) move = "Paper";
        else if (rbScissors.isSelected()) move = "Scissors";

        if (move == null) {
            JOptionPane.showMessageDialog(this, "Please select a move.");
            return;
        }

        Player player = new Player(name);
        player.setMove(move);

        Game game = new GameInfo(); // Polymorphism
        String result = game.play(player.getMove());

        String fullResult = "Player: " + player.getName() + "\n" + result;
        textArea1.setText(fullResult);

        saveResultToFile(fullResult); // File Handling
    }

    private void saveResultToFile(String result) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("rps_results.txt", true))) {
            writer.write(result);
            writer.newLine();
            writer.write("----------------------------");
            writer.newLine();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error saving result: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        form game = new form();
        game.setContentPane(game.pnlMain);
        game.setSize(400, 300);
        game.setDefaultCloseOperation(EXIT_ON_CLOSE);
        game.setVisible(true);
    }

    public abstract static class Game {
        public abstract String play(String playerMove);
    }

    public static class GameInfo extends Game {
        private final String[] moves = {"Rock", "Paper", "Scissors"};
        private final Random rand = new Random();

        @Override
        public String play(String playerMove) {
            if (playerMove == null || playerMove.isEmpty()) {
                return "Invalid move. Please choose Rock, Paper, or Scissors.";
            }

            String computerMove = moves[rand.nextInt(moves.length)];
            String result;

            if (playerMove.equals(computerMove)) {
                result = "It's a draw!";
            } else if (
                    (playerMove.equals("Rock") && computerMove.equals("Scissors")) ||
                            (playerMove.equals("Paper") && computerMove.equals("Rock")) ||
                            (playerMove.equals("Scissors") && computerMove.equals("Paper"))
            ) {
                result = "You win!";
            } else {
                result = "Computer wins!";
            }

            return "Your Move: " + playerMove + "\nComputer Move: " + computerMove + "\nResult: " + result;
        }
    }

    public static class Player {
        private final String name;
        private String move;

        public Player(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setMove(String move) {
            this.move = move;
        }

        public String getMove() {
            return move;
        }
    }
}

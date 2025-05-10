import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

class GameInfo extends Game {

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

        String finalResult = "Your Move: " + playerMove + "\nComputer Move: " + computerMove + "\nResult: " + result;

        // Save result to file
        saveResultToFile(finalResult);

        return finalResult;
    }

    private void saveResultToFile(String result) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("rps_results.txt", true))) {
            writer.write(result);
            writer.newLine();
            writer.write("----------------------------");
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Error saving game result: " + e.getMessage());
        }
    }
}

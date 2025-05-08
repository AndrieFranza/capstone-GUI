import java.util.Random;

 class GameInfo extends Game {

        private final String[] moves = {"Rock", "Paper", "Scissors"};
        private final Random rand = new Random();

        @Override
        public String play(String playerMove) {
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


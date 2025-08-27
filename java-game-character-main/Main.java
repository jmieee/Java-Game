import java.awt.HeadlessException;
import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        try {
            // Get user input for character names using JOptionPane
            String mageName = JOptionPane.showInputDialog(null, 
                "Enter Mage's name:", 
                "Character Creation", 
                JOptionPane.QUESTION_MESSAGE);
            
            if (mageName == null || mageName.trim().isEmpty()) {
                mageName = "Alfert"; // Default name
            }
            
            String warriorName = JOptionPane.showInputDialog(null, 
                "Enter Warrior's name:", 
                "Character Creation", 
                JOptionPane.QUESTION_MESSAGE);
            
            if (warriorName == null || warriorName.trim().isEmpty()) {
                warriorName = "Humphrey"; // Default name
            }

            // Create characters
            GameCharacter mage = new Mage(mageName.trim());
            GameCharacter warrior = new Warrior(warriorName.trim());

            // Show initial status
            String gameStart = """
                              🎮 GAME STARTS! 🎮

                              Both characters have 100 HP.

                              """ + mage.getHpStatus() + "\n" + warrior.getHpStatus();
            
            JOptionPane.showMessageDialog(null, gameStart, "Battle Arena", JOptionPane.INFORMATION_MESSAGE);

            // Battle loop
            startBattle(mage, warrior);
            
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(null, 
                "Game ended unexpectedly: " + e.getMessage(), 
                "Game Over", 
                JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void startBattle(GameCharacter player1, GameCharacter player2) {
        int turnCount = 1;
        GameCharacter currentPlayer = player1;
        GameCharacter opponent = player2;

        while (player1.isAlive() && player2.isAlive()) {
            // Show turn information
            String turnInfo = "Turn " + turnCount + "\n\n" +
                             "HP Status:\n" +
                             player1.getHpStatus() + "\n" +
                             player2.getHpStatus() + "\n\n" +
                             "It's " + currentPlayer.getName() + "'s turn!";
            
            JOptionPane.showMessageDialog(null, turnInfo, "Turn " + turnCount, JOptionPane.INFORMATION_MESSAGE);

            // Get move choice
            int moveChoice = getMoveChoice(currentPlayer);
            
            // Perform move and get damage
            int damage = currentPlayer.performMove(moveChoice);
            
            // Apply damage to opponent
            opponent.takeDamage(damage);

            // Show updated HP status
            String statusUpdate = "HP Status after attack:\n\n" +
                                 player1.getHpStatus() + "\n" +
                                 player2.getHpStatus();
            
            JOptionPane.showMessageDialog(null, statusUpdate, "Battle Status", JOptionPane.INFORMATION_MESSAGE);

            // Check if battle is over
            if (!opponent.isAlive()) {
                announceWinner(currentPlayer);
                return;
            }

            // Switch turns
            GameCharacter temp = currentPlayer;
            currentPlayer = opponent;
            opponent = temp;
            
            turnCount++;
        }
    }

    public static int getMoveChoice(GameCharacter player) {
        String movePrompt = player.getName() + ", choose your move:\n\n" +
                           "(1) Attack (" + player.getAttackDamage() + " damage)\n" +
                           "(2) Special Move (" + player.getSpecialDamage() + " damage)\n" +
                           "(3) Secret Power (" + player.getSecretPowerDamage() + " damage)\n\n" +
                           "Enter 1, 2, or 3:";

        String input = JOptionPane.showInputDialog(null, movePrompt, "Choose Move", JOptionPane.QUESTION_MESSAGE);
        
        // Handle null input (user clicked Cancel)
        if (input == null) {
            JOptionPane.showMessageDialog(null, "No choice made! Using Attack.", "Default Choice", JOptionPane.WARNING_MESSAGE);
            return 1;
        }
        
        try {
            int choice = Integer.parseInt(input.trim());
            if (choice >= 1 && choice <= 3) {
                return choice;
            }
        } catch (NumberFormatException e) {
            // Invalid input - will fall through to default
        }
        
        // Default to attack if invalid input
        JOptionPane.showMessageDialog(null, "Invalid choice! Using Attack.", "Invalid Input", JOptionPane.WARNING_MESSAGE);
        return 1;
    }

    public static void announceWinner(GameCharacter winner) {
        String winMessage = "🎉 " + winner.getName() + " wins the battle! 🎉\n\n" +
                           "Thanks for playing!";
        
        JOptionPane.showMessageDialog(null, winMessage, "Victory!", JOptionPane.INFORMATION_MESSAGE);
    }
}
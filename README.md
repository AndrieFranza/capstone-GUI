# capstone-GUI

Rock Paper Scissors (RPS) Game - Capstone Documentation

I created a class diagram to show how everything is connected. It has three main classes: Player, GameInfo, and form. Player stores the name and move, GameInfo has methods to compare moves and choose the computer's move, and form puts everything together in a simple interface. The diagram helps make the structure and flow of the code easier to understand.

Abstraction:
I used abstraction by putting the game rules inside the GameInfo class. The user doesn’t need to know how the game decides who wins—they just click a button, and the logic works behind the scenes.

Encapsulation:
I made the fields in the Player class private and used getters and setters to access them. This protects the data and avoids unexpected bugs. Only the methods that need to touch the data can access it.

Inheritance:
My GUI class extends JFrame from Java Swing. This means I get all the window features built-in and just add what I need for the game. It's a simple but effective example of inheritance.

Polymorphism:
I used polymorphism with event listeners, especially when clicking the play button. Even though the button always runs a method, what happens can change based on what the user chooses (rock, paper, or scissors). This shows runtime polymorphism in action.

I added exception handling to avoid crashes if the user doesn’t type their name or doesn’t pick a move. For example, if someone tries to play without choosing anything, I show a message using JOptionPane. Try-catch blocks help me catch and handle errors to keep the program running smoothly.

I used file handling to save the game results into a text file. Every time a round is played, the outcome gets saved. This way, I can look back at the game history or maybe use it to make a scoreboard in the future. Right now, it's just basic reading and writing using BufferedWriter.

I made a simple but user-friendly GUI using Java Swing. The interface has a text field for entering the player's name, radio buttons for rock/paper/scissors, a play button, and a text area to show the results. I used IntelliJ's GUI Designer to build it, so it looks neat and is easy to understand. I also added labels like "Enter Name:" to make the interface more clear for users.

The Final Project Submission by Akanksh(2022046) & Akshat(2022051) in Group-42 for AP course.

Command to run code - 1. javac HomeScreen.java -> java -cp . HomeScreen by going into CMD in the same directory as java files. (Have to Setup Java fx and java environment in system prior to this)

Design Patterns Used:
1. Singleton (In SinglePlayerGameScreenController to get instance of Player)
2. Adapter (In Music Adapter, to play different music for different scenes)

Junit Tests: SinglePlayerGameScreenControllerTest & PlayerTest to demonstrate singleton pattern.

Backgrounds, Buttons & Sounds: Non-Copyrighted Entities are used which are free to use for personal purposes, taken from the web.

Assumption:
1. During Movement of Character pausing the game might lead to end of the game run.
2. High score is set to zero after re-executing the Driver Class.(After termination of program)
3. Very quick flipping might lead to skipping cherries sometimes.
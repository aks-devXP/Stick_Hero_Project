# Stick_Hero_Project
This is AP-Project-1 Submission from Group Number: 42
Group Members: Akanksh Semar (2022046), Akshat Gian(2022051)

The PDF files have Skeleton Screens and UML Diagram in each file.
The Script/Source code for both skeleton screens as well as skeleton code/Class are also included in the folder - 2022046_2022051

Some Clarifications:
1. We have used Game's original background as Placeholder in our Diagram.
2. We have used some Copyright-free & free to use assets for non-commercial purpose from the internet.



In the UML Diagram:-

//Association
Player -> Platform

//Composition
TwoPlayerMode -> Player 
TwoPlayerMode -> Platform 

//Dependency
PauseController -> Player


//Interfaces
GameController                   -> DisplayScreens 
GameController                   -> MusicPlayer   
GameOverController               -> DisplayScreens  
GameOverController               -> MusicPlayer
HomeScreenController             -> DisplayScreens
HomeScreenController             -> MusicPlayer
PauseController                  -> DisplayScreens
PauseController                  -> MusicPlayer
SinglePlayerMode                 -> DisplayScreens
SinglePlayerMode                 -> MusicPlayer 
TwoPlayerMode                    -> DisplayScreens
TwoPlayerMode                    -> MusicPlayer


//Inheritance
GameController                   -> HomeScreenController
GameOverController               -> GameController
HomeScreenController             -> HomeScreen
LoadScreenController             -> HomeScreenController
PauseController                  -> GameController
Platform                         -> Player
SaveScreenController             -> PauseController
SinglePlayerGameScreenController -> SinglePlayerMode
SinglePlayerHomeScreenController -> SinglePlayerMode
SinglePlayerMode                 -> GameController
TwoPlayerMode                    -> GameController


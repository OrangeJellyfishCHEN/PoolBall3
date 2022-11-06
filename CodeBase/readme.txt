# Pool Game Builder

To run the application, please use:

gradle run

To generate a javadoc, please use:

gradle javadoc

# Game Notes
- In order to hit the ball, click and hold onto the edge of the cue ball where you'd like to hit. 
- Then, drag your cursor away (in the angle you'd like to hit), and then release.
- The power of your hit will be based on the length of your drag (although ball velocity is capped). 

# Config Notes
When entering config details, please note the following restrictions:
- Friction must be value between 0 - 1 (not inclusive). [Would reccomend switching between 0.95, 0.9, 0.85 to see changes].
- Ball X and Y positions must be within the size of the table width and length, including the ball radius (10).
- Ball colours must be Paint string values as expected.

# Switch Difficult Level
- Press A to set difficult level to easy (default level is easy/can change default level by args)
- Press B to set difficult level to normal
- Press C to set difficult level to hard
- after win you can do switching difficulty level
hard level initial grade is 1 because the config put one ball into the pocket when parse file.

# Timer
- When win the timer will disappear

# Undo
- after winning game u cannot do undo
- 可以撤回每次发球+cheat
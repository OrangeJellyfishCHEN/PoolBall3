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

# The features I finished
- Pockets and More Coloured Balls
- Difficulty Level
- Time and Score
- Undo and Cheat

# Design patterns I used in the extension
1. Observer Pattern
    Observer: src/main/java/PoolGame/observer/Observer.java
    Subject: src/main/java/PoolGame/observer/Subject.java
    Concrete Observers: src/main/java/PoolGame/objects/Ball.java, src/main/java/PoolGame/memento/Caretaker.java, src/main/java/PoolGame/singleton/GameTimer.java
    Concrete Subject: src/main/java/PoolGame/GameManager.java
2. Singleton Pattern
    Singleton: src/main/java/PoolGame/singleton/GameTimer.java
3. Memento Design Pattern
   Caretaker: src/main/java/PoolGame/memento/Caretaker.java
   Memento: src/main/java/PoolGame/memento/SnapShot.java
   Originator: src/main/java/PoolGame/GameManager.java
4. (extend existing design patterns)
    a.Factory method
      Product: src/main/java/PoolGame/config/Reader.java
      ConcreteProduct: src/main/java/PoolGame/config/BallReader.java, src/main/java/PoolGame/config/TableReader.java, src/main/java/PoolGame/config/PocketReader.java
      Creator: src/main/java/PoolGame/config/ReaderFactory.java
      ConcreteCreator: src/main/java/PoolGame/config/BallReaderFactory.java, src/main/java/PoolGame/config/TableReaderFactory.java, src/main/java/PoolGame/config/PocketReaderFactory.java
    b.Strategy method
      Strategy:src/main/java/PoolGame/strategy/PocketStrategy.java
      ConcreteStrategy: src/main/java/PoolGame/strategy/BallStrategy.java, src/main/java/PoolGame/strategy/BlueBallStrategy.java, src/main/java/PoolGame/strategy/BlackBallStrategy.java
      Context: src/main/java/PoolGame/objects/Ball.java

# Switch Difficult Level
- Press A to set difficult level to easy (default level is easy/can change default level by args)
- Press B to set difficult level to normal
- Press C to set difficult level to hard
- after win you can do switching difficulty level
In Hard level initial grade is 1 because the config put one ball into the pocket when parse file.

# Timer
- When players win the timer will reset to 0:00
- Change Difficulty also reset the timer.

# Undo
Players can press U to undo. It should be noted that players cannot press U twice or more in a row. After pressing U once, there is no change and pressing U again will not undo. At the same time, when the game is refreshed or the difficulty level is changed or the game is won, the player cannot undo it. The only thing the player can undo is the operation and cheat operation he made on the white ball.

# Cheat
- Press Q: get all red balls' scores.
- Press W: get all yellow balls' scores.
- Press E: get all green balls' scores.
- Press R: get all brown balls' scores.
- Press T: get all blue balls' scores.
- Press Y: get all purple balls' scores.
- Press I: get all orange balls' scores.
- Press O: get all black balls' scores.

# Javadoc Position
javadoc/

# json files position
in src/main/resources
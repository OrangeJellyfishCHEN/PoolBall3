package PoolGame;

import PoolGame.config.*;
import java.util.List;

import javafx.application.Application;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

/** Main application entry point. */
public class App extends Application {
    private static String currentDifficulty = "easy";
    /**
     * @param args First argument is the path to the config file
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    /**
     * Starts the application.
     *
     * @param primaryStage The primary stage for the application.
     */
    public void start(Stage primaryStage) {
        // READ IN CONFIG
        GameManager gameManager = new GameManager();

        List<String> args = getParameters().getRaw();
        String configPath = checkConfig(args);

        ReaderFactory tableFactory = new TableReaderFactory();
        Reader tableReader = tableFactory.buildReader();
        tableReader.parse(configPath, gameManager);

        ReaderFactory pocketFactory = new PocketReaderFactory();
        Reader pocketReader = pocketFactory.buildReader();
        pocketReader.parse(configPath, gameManager);

        ReaderFactory ballFactory = new BallReaderFactory();
        Reader ballReader = ballFactory.buildReader();
        ballReader.parse(configPath, gameManager);
        gameManager.buildManager();
        // START GAME MANAGER
        gameManager.run();
        primaryStage.setTitle("Pool");
        gameManager.getScene().setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.A) {
                System.out.println("Switch to easy mode");
                if (!currentDifficulty.equals("easy")){
                    currentDifficulty = "easy";
                    tableReader.parse("src/main/resources/config_easy.json", gameManager);
                    pocketReader.parse("src/main/resources/config_easy.json", gameManager);
                    ballReader.parse("src/main/resources/config_easy.json", gameManager);
                    gameManager.changeLevel();
                }
            } else if (e.getCode() == KeyCode.B) {
                System.out.println("Switch to normal mode");
                if (!currentDifficulty.equals("normal")){
                    currentDifficulty = "normal";
                    tableReader.parse("src/main/resources/config_normal.json", gameManager);
                    pocketReader.parse("src/main/resources/config_normal.json", gameManager);
                    ballReader.parse("src/main/resources/config_normal.json", gameManager);
                    gameManager.changeLevel();
                }
            } else if (e.getCode() == KeyCode.C) {
                System.out.println("Switch to hard mode");
                if (!currentDifficulty.equals("hard")){
                    currentDifficulty = "hard";
                    tableReader.parse("src/main/resources/config_hard.json", gameManager);
                    pocketReader.parse("src/main/resources/config_hard.json", gameManager);
                    ballReader.parse("src/main/resources/config_hard.json", gameManager);
                    gameManager.changeLevel();
                }
            }
            else if (e.getCode() == KeyCode.U){
                gameManager.recoverState(gameManager.getCaretaker().recover());

                System.out.println("recover");
            }
            // cheat
            else if (e.getCode() == KeyCode.Q){
                gameManager.cheat(Paint.valueOf("red"));
            }
            else if (e.getCode() == KeyCode.W){
                gameManager.cheat(Paint.valueOf("yellow"));
            }
            else if (e.getCode() == KeyCode.E){
                gameManager.cheat(Paint.valueOf("green"));
            }
            else if (e.getCode() == KeyCode.R){
                gameManager.cheat(Paint.valueOf("brown"));
            }
            else if (e.getCode() == KeyCode.T){
                gameManager.cheat(Paint.valueOf("blue"));
            }
            else if (e.getCode() == KeyCode.Y){
                gameManager.cheat(Paint.valueOf("purple"));
            }
            else if (e.getCode() == KeyCode.O){
                gameManager.cheat(Paint.valueOf("black"));
            }
            else if (e.getCode() == KeyCode.I){
                gameManager.cheat(Paint.valueOf("orange"));
            }
        });
        primaryStage.setScene(gameManager.getScene());
        primaryStage.show();
        gameManager.run();
    }

    /**
     * Checks if the config file path is given as an argument.
     *
     * @param args
     * @return config path.
     */
    private static String checkConfig(List<String> args) {
        String configPath;
        if (args.size() > 0) {
            configPath = args.get(0);
            if (configPath.equals("src/main/resources/config_normal.json")){
                currentDifficulty = "normal";
            }
            else if (configPath.equals("src/main/resources/config_hard.json")){
                currentDifficulty = "hard";
            }
        } else {
            configPath = "src/main/resources/config_easy.json";
        }
        return configPath;
    }
}
package src;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import src.Humanoid.Humanoid;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class GameController {
    private Tile currentTile;
    private Initializer initializer = new Initializer();
    private Settings settings = Settings.getSettings();
    private ArrayList<ArrayList<Humanoid>> humanoidArrayList = new ArrayList<>();
    private Tile[][] tiles = new Tile[settings.getBoardSize()][settings.getBoardSize()];
    @FXML
    private Button reset_button;
    @FXML
    private Button menu_button;
    @FXML
    private TextArea text_area;
    EventHandler<ActionEvent> buttonHandler = new EventHandler<>() {
        @Override
        public void handle(ActionEvent actionEvent) {
            if (currentTile == null) {
                currentTile = findTile(actionEvent);
                text_area.setText((currentTile.printAllHumanoids() + "\n" + text_area.getText()));
            } else {
                if (isValidMove(findTile(actionEvent))) {
                    findTile(actionEvent).placeHumanoid(currentTile.getHuman());
                    findTile(actionEvent).getButton().setText(findTile(actionEvent).toString());
                    tiles[currentTile.getXCoordinate()][currentTile.getYCoordinate()].removeHumanoid(currentTile.getHuman());
                    tiles[currentTile.getXCoordinate()][currentTile.getYCoordinate()].getButton().setText("   ");
                    doCombat();
                } else {
                    text_area.setText("Invalid Move" + "\n\n" + text_area.getText());
                }
                currentTile = null;
            }
        }
    };
    @FXML
    private GridPane grid_pane;

    @FXML
    public void initialize() {
        humanoidArrayList = initializer.initializeHumanoids(settings.getNumberOfHumans(), settings.getNumberOfGoblins(), settings.getBoardSize());
        tiles = initializer.inititializeGameBoard(settings.getBoardSize());
        initializer.initialPlacement(tiles, humanoidArrayList);
        for (int i = 0; i < settings.getBoardSize(); i++) {
            for (int j = 0; j < settings.getBoardSize(); j++) {
                Button button = new Button(tiles[i][j].toString());
                grid_pane.add(button, i, j, 1, 1);
                button.setOnAction(buttonHandler);
                tiles[i][j].setButton(button);
            }
        }
    }

    public void reInitialize() throws IOException {
        Stage stage = (Stage) reset_button.getScene().getWindow();
        stage.close();
        Stage mainStage = new Stage();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("game-view.fxml")));
        mainStage.setTitle("Humans VS Goblins");
        mainStage.setScene(new Scene(root, 600, 400));
        mainStage.show();
    }

    /**
     * Goes back to the main menu
     *
     * @throws IOException
     */
    public void backToMain() throws IOException {
        Stage stage = (Stage) menu_button.getScene().getWindow();
        stage.close();
        Stage mainStage = new Stage();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("main-view.fxml")));
        mainStage.setTitle("Humans VS Goblins");
        mainStage.setScene(new Scene(root, 600, 400));
        mainStage.show();
    }

    /**
     * Finds the tile which was pressed by the user
     *
     * @param actionEvent
     * @return tile : Tile
     */
    public Tile findTile(ActionEvent actionEvent) {
        for (Tile[] tiles : tiles) {
            for (Tile tile : tiles) {
                if (tile.getButton() == actionEvent.getSource()) {
                    return tile;
                }
            }
        }
        return null;
    }

    /**
     * Checks whether the tile the user wants the human to move to is valid
     *
     * @param movingTile : Tile
     * @return boolean
     */
    public boolean isValidMove(Tile movingTile) {
        if (currentTile.hasCombat()) return false;
        if (Objects.equals(movingTile.getXCoordinate(), currentTile.getXCoordinate())
                && Objects.equals(movingTile.getYCoordinate(), currentTile.getYCoordinate())) return false;
        if (movingTile.getXCoordinate() - currentTile.getXCoordinate() > 1) return false;
        if (movingTile.getXCoordinate() - currentTile.getXCoordinate() < -1) return false;
        if (movingTile.getYCoordinate() - currentTile.getYCoordinate() > 1) return false;
        if (movingTile.getYCoordinate() - currentTile.getYCoordinate() < -1) return false;
        if (movingTile.hasHumanoid()) {
            // you need to check both of the possible indexes for humans
            if (movingTile.getHumanoids().get(0).isHuman()) return false;
            return !movingTile.getHumanoids().get(movingTile.getHumanoids().size() - 1).isHuman();
        }
        return true;
    }

    /**
     * Does the combat for the current state of the board
     */
    public void doCombat() {
        for (Tile[] tiles : tiles) {
            for (Tile tile : tiles) {
                if (tile.hasCombat()) {
                    removeHumanoidsFromList(tile);
                    text_area.setText(tile.fight() + text_area.getText());
                    tile.getButton().setText(tile.toString());
                    if (tile.hasHumanoid()) {
                        for (Humanoid humanoid : tile.getHumanoids()) {
                            if (humanoid.isHuman()) humanoidArrayList.get(0).add(humanoid);
                            else humanoidArrayList.get(1).add(humanoid);
                        }
                    }
                }
            }
        }
        if (humanoidArrayList.get(0).size() == 0 || humanoidArrayList.get(1).size() == 0)
            text_area.setText("GAME OVER" + "\n\n" + text_area.getText());
    }

    /**
     * removes the used humanoids from their respective lists to be added back after the fight if they survive
     *
     * @param tile : Tile
     */
    public void removeHumanoidsFromList(Tile tile) {
        if (tile.getHumanoids().get(0).isHuman()) {
            humanoidArrayList.get(0).remove(tile.getHumanoids().get(0));
            humanoidArrayList.get(1).remove(tile.getHumanoids().get(1));
        }
        if (tile.getHumanoids().get(1).isHuman()) {
            humanoidArrayList.get(0).remove(tile.getHumanoids().get(1));
            humanoidArrayList.get(1).remove(tile.getHumanoids().get(0));
        }
    }
}

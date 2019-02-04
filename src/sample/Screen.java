package sample;

import javafx.scene.Scene;
import javafx.stage.Stage;

public interface Screen {
    //Interface that specifies the bare minimum each screen in the game must be able to do.
    public Scene getScene(Stage stage);
    public ColorPack getTheme();
}

package sample;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public interface Screen {
    //Interface that specifies the bare minimum each screen in the game must be able to do.
    public Scene getScene(Stage stage);
    public Theme getTheme();
    public Group getGroup();
    public void setTheme(Theme theme);
    public void setGroup(Group group);
}

package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminController implements Initializable {
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void userManager(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/UserManager.fxml"));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        root.getStylesheets().add("/style.css");
        stage.setResizable(false); // Disallow resizing of window
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void assetManager(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/AssetManager.fxml"));
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        root.getStylesheets().add("/style.css");
        stage.setResizable(false); // Disallow resizing of window
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}

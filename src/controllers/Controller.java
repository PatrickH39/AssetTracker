package controllers;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    // Header
    public Button btnLogo;
    public Label lblCurrentTime;
    public Label lblCurrentDate;

    // Launchpad Buttons
    public Button btnOverview;
    public Button btnReserve;
    public Button btnHistory;
    public Button btnAdmin;
    public Button btnSaveAll;
    public Button btnLoadData;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        timeNow();
    }


    private void timeNow(){
        Thread thread = new Thread(() -> {
            SimpleDateFormat time = new SimpleDateFormat("hh:mm aa");
            SimpleDateFormat date = new SimpleDateFormat("MMMM dd, yyyy");
            while(true){
                try{
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Platform.runLater(() ->{
                    lblCurrentDate.setText(date.format(new Date()));
                    lblCurrentTime.setText(time.format(new Date()));
                });
            }
        });
        thread.start();

    }
    /**
     * Requires:
     * Modifies:
     * Effects:
     *
     * @param mouseEvent
     */
    @FXML
    private void handleButtonClicks(javafx.event.ActionEvent mouseEvent) {
        if (mouseEvent.getSource() == btnOverview){
            loadStage("/fxml/Overview.fxml", "Overview", "/overview.png");
        } else if(mouseEvent.getSource() == btnReserve){
            loadStage("/fxml/Reserve.fxml", "Reserve", "/reserve.png");
        } else if(mouseEvent.getSource() == btnHistory){
            loadStage("/fxml/History.fxml", "History", "/history.png");
        } else if (mouseEvent.getSource() == btnAdmin){
            loadStage("/fxml/Admin.fxml", "Admin", "/admin.png");
        }
    }

    /**
     * Requires:
     * Modifies:
     * Effects:
     *
     * @param fxml
     */
    private void loadStage(String fxml, String title, String iconpath) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(fxml));
            root.getStylesheets().add("/style.css");

            Stage stage = new Stage();
            stage.setScene(new Scene(root, 900, 660));
            stage.getIcons().add(new Image(Controller.class.getResourceAsStream(iconpath))); // Adds an icon to the window
            stage.setTitle(title);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Requires: Nothing
     * Modifies: alert
     * Effects: Pops up general information about the program.
     *
     * @param actionEvent
     */
    public void showAbout(ActionEvent actionEvent) {
        String version = Runtime.class.getPackage().getImplementationVersion();
        Alert alert = new Alert(Alert.AlertType.NONE, "Created by Patrick Huynh for VLN CP-11.\n\n" + "Java Runtime: " + version, ButtonType.OK);
        alert.setTitle("About LabOPS v1.0");
        alert.showAndWait();
    }

    public void saveAll(ActionEvent actionEvent) {
        data.IOHandler.writeOut();
    }

    public void loadFile(ActionEvent actionEvent) {
        data.IOHandler.readIn();
    }
}

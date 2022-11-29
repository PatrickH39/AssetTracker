package controllers;

import data.Asset;
import data.IOHandler;
import data.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AssetManagerController implements Initializable {

    // Add Items
    ObservableList<String> typeList = FXCollections.observableArrayList("Beaker","Clamp","Compound Light Microscope","Gas Collection Tube","Graduated Cylinder","Hole Stopper","Pipette","Ring Stand","Rubber Tubes","Safety Goggles","Test Tubes");
    ObservableList<String> locationList = FXCollections.observableArrayList("1","2","3","4","5","6","7","8","9","10","11","12","13","14");
    public ChoiceBox choiceType;
    public TextField fieldVolume;
    public TextField fieldSize;
    public ChoiceBox choiceLocation;
    public TextField fieldNotes;

    // Display Items
    public Label lblType;
    public Label lblSize;
    public Label lblVolume;
    public Label lblLocation;
    public Label lblNotes;

    public ListView<data.Asset> listAssets = new ListView<>();
    public GridPane gridAssetInfo;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        choiceType.setItems(typeList);
        choiceLocation.setItems(locationList);
    }


    public void goBack(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Admin.fxml"));
        root.getStylesheets().add("/style.css");
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void showAssets(MouseEvent mouseEvent) {
        if (listAssets.getItems().isEmpty()){
            gridAssetInfo.setVisible(false);
            return;
        }

        gridAssetInfo.setVisible(true);

        Asset selected = listAssets.getSelectionModel().getSelectedItem();

        lblType.setText(selected.getType());
        lblVolume.setText(selected.getVolume());
        lblSize.setText(selected.getSize());
        lblLocation.setText(selected.getLocation());
        lblNotes.setText(selected.getNotes());
    }

    public void addAsset(ActionEvent actionEvent) {
        if (choiceType.getSelectionModel().isEmpty() || choiceLocation.getSelectionModel().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Missing Information");

            // Header Text: null
            alert.setHeaderText(null);
            alert.setContentText("Please check your entries");

            alert.showAndWait();
            return;
        }

        IOHandler.addItemAllAssets(new Asset(
                (String) choiceType.getValue(),
                fieldVolume.getText().isEmpty() ? "N/A" : fieldVolume.getText(),
                fieldSize.getText().isEmpty() ? "N/A" : fieldSize.getText(),
                (String) choiceLocation.getValue(),
                fieldNotes.getText().isEmpty() ? "N/A" : fieldNotes.getText()
        ));

        choiceType.setValue(null);
        fieldVolume.clear();
        fieldSize.clear();
        choiceLocation.setValue(null);
        fieldNotes.clear();

        updateAssetList();
    }

    private void updateAssetList() {
        listAssets.getItems().clear();

        for (data.Asset item : data.IOHandler.getAllAssets()) {
            listAssets.getItems().add(item);
        }

        Asset selected = listAssets.getSelectionModel().getSelectedItem();
        if (selected == null) gridAssetInfo.setVisible(false);

        listAssets.getSelectionModel().select(0);
    }

    public void deleteAsset(ActionEvent actionEvent) {
        Asset selected = listAssets.getSelectionModel().getSelectedItem();
        IOHandler.removeItemAllAssets(selected);
        updateAssetList();
    }
}

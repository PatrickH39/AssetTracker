package data;

import javafx.stage.FileChooser;

import java.io.*;
import java.util.ArrayList;

public class IOHandler {
    private static final ArrayList<User> allUsers = new ArrayList<>();
    private static final ArrayList<Asset> allAssets = new ArrayList<>();

    static final FileChooser fc =new FileChooser();

    public static void readIn(){
        allUsers.clear();
        allAssets.clear();

        try {
            fc.setTitle("Open a file");
            File openFile = fc.showOpenDialog(null);

            // Limits to text files only
            fc.getExtensionFilters().clear();
            fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Files", "*.txt"));


            // Saves path to String path
            String path = openFile.getAbsolutePath();

            FileReader fRead = new FileReader(path);
            BufferedReader bRead = new BufferedReader(fRead);

            String line;

            while ((line = bRead.readLine()) != "-user") {
                String[] data = line.split("\t");

                allUsers.add(new User(data[0], data[1], data [2], data [3]));

                line.equals(null);
            }

            while ((line = bRead.readLine()) != "-asset") {
                String[] data = line.split("\t");

                allAssets.add(new Asset(data[0], data[1], data[2], data[3],data[4],data[5],data[6]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeOut() {
        try {
            // Opens a FileChooser window
            fc.setTitle("Save a file");
            File saveFile = fc.showSaveDialog(null);

            // Limits to text files only
            fc.getExtensionFilters().clear();
            fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Files", "*.txt"));

            // Saves path to String path
            String path = saveFile.getAbsolutePath();

            FileWriter fWrite = new FileWriter(path, false);
            BufferedWriter bWrite = new BufferedWriter(fWrite);

            for (User f : allUsers) bWrite.write(f.toTSV() + "\n");
            bWrite.write("-user");

            for (Asset f : allAssets) bWrite.write(f.toTSV() + "\n");
            bWrite.write("-asset");

            bWrite.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addItemAllUsers(User user) {
        allUsers.add(user);
    }

    public static void addItemAllAssets(Asset asset) {
        allAssets.add(asset);
    }

    public static void removeItemAllUsers(User user) {
        allUsers.remove(user);
    }

    public static void removeItemAllAssets(Asset asset) {
        allAssets.remove(asset);
    }

    public static ArrayList<User> getAllUsers() {
        return allUsers;
    }

    public static ArrayList<Asset> getAllAssets() {
        return allAssets;
    }
}

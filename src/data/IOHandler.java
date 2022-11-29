package data;

import javafx.stage.FileChooser;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class IOHandler {
    private static final ArrayList<User> allUsers = new ArrayList<>();
    private static final ArrayList<Asset> allAssets = new ArrayList<>();

    static final FileChooser fc =new FileChooser();

    public static void readIn() {
        allUsers.clear();
        allAssets.clear();

        try {
            fc.setTitle("Open a file");

            // Limits to text files only
            fc.getExtensionFilters().clear();
            fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Files", "*.txt"));

            File openFile = fc.showOpenDialog(null);

            // Saves path to String path
            String path = openFile.getAbsolutePath();

            FileReader fRead = new FileReader(path);
            BufferedReader bRead = new BufferedReader(fRead);

            String line;

            while ((line = bRead.readLine()) != "\n") {
                String[] data1 = line.split("\t");

                allUsers.add(new User(data1[0], data1[1], data1[2], data1[3]));

                System.out.println(Arrays.toString(data1));

                bRead.mark(1);
            }

            bRead.reset();
            while ((line = bRead.readLine()) != null) {
                String[] data2 = line.split("\r");
                bRead.reset();
                allAssets.add(new Asset(data2[0], data2[1], data2[2], data2[3], data2[4]));

                System.out.println(Arrays.toString(data2));

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void writeOut() {
        try {
            fc.setTitle("Save a file");

            // Limits to text files only
            fc.getExtensionFilters().clear();
            fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Files", "*.txt"));

            // Opens a FileChooser window
            File saveFile = fc.showSaveDialog(null);


            // Saves path to String path
            String path = saveFile.getAbsolutePath();

            FileWriter fWrite = new FileWriter(path, false);
            BufferedWriter bWrite = new BufferedWriter(fWrite);

            for (User f : allUsers) bWrite.write(f.toTSV() + "\n");
            bWrite.write("\n-user");

            for (Asset f : allAssets) bWrite.write(f.toTSV() + "\r");
            bWrite.write("\n-asset");

            bWrite.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Requires: User
     * Modifies: allUsers
     * Effects: Adds User to allUsers
     *
     * @param user
     */
    public static void addItemAllUsers(User user) {
        allUsers.add(user);
    }

    /**
     * Requires: Asset
     * Modifies: allAssets
     * Effects: Adds Asset to allAssets
     * @param asset
     */
    public static void addItemAllAssets(Asset asset) {
        allAssets.add(asset);
    }

    /**
     * Requires: User
     * Modifies: allUsers
     * Effects: Removes a User from allUsers
     * @param user
     */
    public static void removeItemAllUsers(User user) {
        allUsers.remove(user);
    }

    /**
     * Requires: Asset
     * Modifies: allAssets
     * Effects: Removes an Asset from allAsset
     * @param asset
     */
    public static void removeItemAllAssets(Asset asset) {
        allAssets.remove(asset);
    }

    /**
     * Requires: Nothing
     * Modifies: Nothing
     * Effects: Returns allUsers (ArrayList)
     *
     * @return
     */
    public static ArrayList<User> getAllUsers() {
        return allUsers;
    }

    /**
     * Requires: Nothing
     * Modifies: Nothing
     * Effects: Returns allAssets (ArrayList)
     * 
     * @return
     */
    public static ArrayList<Asset> getAllAssets() {
        return allAssets;
    }
}

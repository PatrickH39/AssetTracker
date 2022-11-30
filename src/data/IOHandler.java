package data;

import javafx.stage.FileChooser;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class IOHandler {
    private static final ArrayList<User> allUsers = new ArrayList<>();
    private static final ArrayList<Asset> allAssets = new ArrayList<>();

    static final FileChooser fc =new FileChooser();

    /**
     * Reads Data
     *
     * Requires: Nothing
     * Modifies: allUsers, allAssets
     * Effects: Adds all users and assets from selected file to their specified classes
     *
     */
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

            while (!(line = bRead.readLine()).equals("--user")) {
                String[] data1 = line.split("\t");
                if (data1.length == 4)
                    allUsers.add(new User(data1[0], data1[1], data1[2], data1[3]));

                System.out.println(Arrays.toString(data1));
            }

            while (!(line = bRead.readLine()).equals("--asset")) {
                String[] data2 = line.split("\t");
                System.out.println(data2.length);
                if (data2.length == 5)
                    allAssets.add(new Asset(data2[0], data2[1], data2[2], data2[3], data2[4]));

                System.out.println(Arrays.toString(data2));

            }
            bRead.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Writes data
     *
     * Requires: Nothing
     * Modifies: Nothing
     * Effects: Writes user list then asset list to selected file
     *
     */
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
            bWrite.write("--user\n\n");

            for (Asset f : allAssets) bWrite.write(f.toTSV() + "\r");
            bWrite.write("--asset");

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
     * @param user User to add
     */
    public static void addItemAllUsers(User user) {
        allUsers.add(user);
    }

    /**
     * Requires: Asset
     * Modifies: allAssets
     * Effects: Adds Asset to allAssets
     *
     * @param asset Asset to add
     */
    public static void addItemAllAssets(Asset asset) {
        allAssets.add(asset);
    }

    /**
     * Requires: User
     * Modifies: allUsers
     * Effects: Removes a User from allUsers
     *
     * @param user User to remove
     */
    public static void removeItemAllUsers(User user) {
        allUsers.remove(user);
    }

    /**
     * Requires: Asset
     * Modifies: allAssets
     * Effects: Removes an Asset from allAsset
     *
     * @param asset Asset to remove
     */
    public static void removeItemAllAssets(Asset asset) {
        allAssets.remove(asset);
    }

    /**
     * Requires: Nothing
     * Modifies: Nothing
     * Effects: Returns allUsers (ArrayList)
     *
     * @return allUsers
     */
    public static ArrayList<User> getAllUsers() {
        return allUsers;
    }

    /**
     * Requires: Nothing
     * Modifies: Nothing
     * Effects: Returns allAssets (ArrayList)
     * 
     * @return allAssets
     */
    public static ArrayList<Asset> getAllAssets() {
        return allAssets;
    }

    /**
     * Clear all assets
     */
    public static void clearAssets() {
        allAssets.clear();
    }

    /**
     * Clear all users
     */
    public static void clearUsers() {
        allUsers.clear();
    }
}

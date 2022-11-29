package data;

public class Asset {

    // data.Asset Attributes
    private String type;
    private String volume;
    private String size;
    private String location;
    private String notes;

    /**
     * Constructor for Asset
     *
     * @param type
     * @param volume
     * @param size
     * @param location
     * @param notes
     */

    public Asset(String type, String volume, String size, String location, String notes) {
        this.type = type;
        this.volume = volume;
        this.size = size;
        this.location = location;
        this.notes = notes;
    }

    /**
     * Changes string to TSV (Tab-Separated Values)
     * @return
     */
    String toTSV() {
        return this.type + "\t" + this.volume + "\t" + this.size + "\t" + this.location + "\t" + this.notes;
    }

    /**
     * Getters
     *
     * @return
     */
    @Override
    public String toString(){
        return location + ": " + type;
    }

    public String getType() {
        return type;
    }

    public String getVolume() {
        return volume;
    }

    public String getSize() {
        return size;
    }

    public String getLocation() {
        return location;
    }

    public String getNotes() {
        return notes;
    }

}

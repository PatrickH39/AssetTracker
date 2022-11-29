package data;

public class Asset {

    // data.Asset Attributes
    private String type;
    private String volume;
    private String size;
    private String location;
    private String notes;

    public Asset(String type, String volume, String size, String location, String notes) {
        this.type = type;
        this.volume = volume;
        this.size = size;
        this.location = location;
        this.notes = notes;
    }

    String toTSV() {
        return this.type + "\t" + this.volume + "\t" + this.size + "\t" + this.location + "\t" + this.notes;
    }

    /**
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

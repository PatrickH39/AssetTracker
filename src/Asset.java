public class Asset {

    // Asset Attributes
    private String type;
    private String volume;
    private String size;
    private String location;
    private String borrower;
    private String dateTaken;
    private String notes;

    public Asset(String type, String volume, String size, String location, String borrower, String dateTaken, String notes) {
        this.type = type;
        this.volume = volume;
        this.size = size;
        this.location = location;
        this.borrower = borrower;
        this.dateTaken = dateTaken;
        this.notes = notes;
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

    public String getBorrower() {
        return borrower;
    }

    public String getDateTaken() {
        return dateTaken;
    }

    public String getNotes() {
        return notes;
    }
}

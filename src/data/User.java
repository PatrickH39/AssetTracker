package data;

public class User {

    // data.User Attributes
    private final String nickname;
    private final String firstName;
    private final String lastName;
    private final String homeroom;

    /**
     * Constructor for User
     *
     * @param nickname
     * @param firstName
     * @param lastName
     * @param homeroom
     */
    public User(String nickname, String firstName, String lastName, String homeroom) {
        this.nickname = nickname;
        this.firstName = firstName;
        this.lastName = lastName;
        this.homeroom = homeroom;
    }

    /**
     * Changes string to TSV (Tab-Separated Values)
     *
     * @return
     */
    String toTSV() {return this.nickname + "\t" + this.firstName + "\t" + this.lastName + "\t" + this.homeroom;}

    /**
     * Changes the object String identifier
     *
     * @return
     */
    public String toString() {
        return nickname;
    }

    /**
     * Getters
     *
     * @return
     */
    public String getNickname() {
        return nickname;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getHomeroom() {
        return homeroom;
    }
}

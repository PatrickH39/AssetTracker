package data;

public class User {

    private final String nickname;
    private final String firstName;
    private final String lastName;
    private final String homeroom;

    public User(String nickname, String firstName, String lastName, String homeroom) {
        this.nickname = nickname;
        this.firstName = firstName;
        this.lastName = lastName;
        this.homeroom = homeroom;
    }

    String toTSV() {return this.nickname + "\t" + this.firstName + "\t" + this.lastName + "\t" + this.homeroom;}

    public String toString() {
        return nickname;
    }

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

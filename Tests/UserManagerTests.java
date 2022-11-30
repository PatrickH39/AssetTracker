import data.IOHandler;
import data.User;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class UserManagerTests {
    @Before
    public void setup() {

    }

    @Test
    public void testAddUser() {
        IOHandler.clearUsers();

        User a = new User("Mr. Borges", "Danny", "Borges", "316");
        IOHandler.addItemAllUsers(a);

        IOHandler.getAllUsers();

        assertEquals(1, IOHandler.getAllUsers().size());
    }

    @Test
    public void testDeleteUser() {
        IOHandler.clearUsers();

        User a = new User("Mr. Borges", "Danny", "Borges", "316");

        IOHandler.addItemAllUsers(a);
        assertEquals(1, IOHandler.getAllUsers().size());
        IOHandler.removeItemAllUsers(a);
        assertEquals(0, IOHandler.getAllUsers().size());
    }
}

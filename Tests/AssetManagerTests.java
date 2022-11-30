import data.Asset;
import data.IOHandler;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class AssetManagerTests {
    @Before
    public void setup() {

    }

    @Test
    public void testAddAsset() {
        IOHandler.clearAssets();

        Asset a = new Asset("Graduated Cylinder", "500", "N/A", "5", "N/A");
        IOHandler.addItemAllAssets(a);

        IOHandler.getAllAssets();

        assertEquals(1, IOHandler.getAllAssets().size());
    }

    @Test
    public void testDeleteAsset() {
        IOHandler.clearAssets();

        Asset a = new Asset("Graduated Cylinder", "500", "N/A", "5", "N/A");

        IOHandler.addItemAllAssets(a);
        assertEquals(1, IOHandler.getAllAssets().size());
        IOHandler.removeItemAllAssets(a);
        assertEquals(0, IOHandler.getAllAssets().size());
    }
}

import com.utilities.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

import static com.utilities.DriverFactory.BrowserType.CHROME;
import static org.testng.Assert.assertTrue;

/**
 * Created by MisterVitoPro on 5/18/2015.
 */
public class TryCatchFinallyTest {

    public WebDriver driver;
    DriverFactory.BrowserType type = CHROME;

    @BeforeClass(alwaysRun = true)
    public void setup() throws Exception {
        this.driver = DriverFactory.getDriver(type);
    }

    @AfterClass(alwaysRun = true)
    public void teardown(){
        this.driver.quit();
    }

    @Test(groups={"p1", "pageLoads"})
    public void testTryCatchFinally()  {
        try{
            assertTrue(false);
            System.out.println("TRIED IT");
        }catch(AssertionError e){
            System.out.println("CAUGHT ME");
        }finally{
            driver.navigate().refresh();
        }
    }

}

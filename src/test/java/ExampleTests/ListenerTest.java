package ExampleTests;

import com.utilities.MyTestListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by MisterVitoPro on 8/16/2015.
 */
@Listeners(MyTestListener.class)
public class ListenerTest {

    @Test
    public void test1success(){
        assertTrue(true);
    }

    @Test
    public void test2fail(){
        assertTrue(false, "I am asserting false.");
    }

    @Test(dependsOnMethods = "test2fail")
    public void test3skip(){
        assertTrue(true);
    }
}

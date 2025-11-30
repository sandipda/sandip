package hooks;

import base.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.junit.BeforeClass;

public class Hook {

    @Before
    public void setup(){
        String browser = System.getProperty("browser", "chrome");
        BaseClass.initiatebrowser(browser);
    }

    @After
    public void tearDown(){
        BaseClass.quitbrowser();
    }
}

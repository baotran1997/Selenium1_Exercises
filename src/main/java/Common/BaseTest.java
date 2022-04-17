package Common;

import com.opencsv.CSVReader;
import org.testng.annotations.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BaseTest {
    @BeforeSuite
    @Parameters("browser")
    public void beforeSuite(String browserName) {
        Constants.BROWSER = browserName;
    }

    @BeforeMethod
    public void setUp() {
        WebDriverUtilities.initDriver();
        WebDriverUtilities.navigateTo(Constants.HOME_PAGE_URL);
    }

    @AfterMethod
    public void tearDown() {
        WebDriverUtilities.quitDriver();
    }

    @DataProvider
    public Iterator<Object[]> getData() throws IOException {
        String path = "src/main/java/DataObjects/" + this.getClass().getSimpleName()+ ".csv";
        Reader reader = new FileReader(path);
        CSVReader csvReader = new CSVReader(reader);

        List<Object[]> list = new ArrayList<>();
        String[]  nextLine = csvReader.readNext();

        while (nextLine != null) {
            Object[] objLine = nextLine;
            list.add(objLine);
            nextLine = csvReader.readNext();
        }

        Iterator<Object[]> data = list.iterator();
        return data;

    }
}

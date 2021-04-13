package test.com.ltp.shapes.service.impl;

import com.ltp.shapes.exception.ShapeException;
import com.ltp.shapes.service.ReadingService;
import com.ltp.shapes.service.impl.ReadingServiceImpl;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ReadingServiceImplTest {

    private ReadingService readingService;

    @BeforeClass
    public void init(){
        readingService = ReadingServiceImpl.getInstance();
    }

    @Test(expectedExceptions = ShapeException.class)
    public void readExceptionTest() throws ShapeException{
        readingService.read("INVALID FILENAME");
    }

    @Test
    public void readTest() throws ShapeException{
        String expected = "1 1,2 2,3 3";
        String actual = readingService.read("src/main/resources/data/input.txt");
        AssertJUnit.assertEquals(expected, actual);
    }

    @AfterClass
    public void terminate(){
        readingService = null;
    }

}

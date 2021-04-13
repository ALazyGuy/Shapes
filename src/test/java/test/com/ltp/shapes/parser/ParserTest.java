package test.com.ltp.shapes.parser;

import com.ltp.shapes.exception.ShapeException;
import com.ltp.shapes.model.entity.Point;
import com.ltp.shapes.model.entity.Triangle;
import com.ltp.shapes.parser.Parser;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

public class ParserTest {

    @Test
    public void parse() throws ShapeException {
        String line = "1 1,2 2,3 3";
        Triangle expected = new Triangle(new Point(1, 1), new Point(2, 2), new Point(3, 3), 0);
        Triangle actual = Parser.parse(line);
        AssertJUnit.assertEquals(expected, actual);
    }

}

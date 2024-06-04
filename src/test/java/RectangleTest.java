    import com.esde.rectangles.creator.RectangleFactory;
    import com.esde.rectangles.creator.impl.RectangleFactoryImpl;
    import com.esde.rectangles.exeption.InvalidRectangleDataException;
    import com.esde.rectangles.model.entity.Point;
    import com.esde.rectangles.model.entity.Rectangle;
    import com.esde.rectangles.model.entity.RectangleState;
    import com.esde.rectangles.service.RectangleService;
    import com.esde.rectangles.service.impl.RectangleServiceImpl;
    import com.esde.rectangles.util.TxtParser;
    import org.junit.jupiter.api.Test;

    import java.util.Arrays;
    import java.util.List;

    import static com.esde.rectangles.constant.RectangleConstant.*;
    import static org.junit.jupiter.api.Assertions.assertEquals;

    public class RectangleTest {

        private final static Rectangle expectedValidRectangle = new Rectangle(new Point(0.0,0.0), new Point(1.0,0.0),new Point(1.0,1.0), new Point(0.0,1.0));
        private final static  RectangleService rectangleService = new RectangleServiceImpl();

        //Test CubeService

        @Test
        void testArea() {
            assertEquals(1, rectangleService.area(expectedValidRectangle));
        }

        @Test
        void testPerimeter() {
            assertEquals(4, rectangleService.perimeter(expectedValidRectangle));
        }

        @Test
        void testInvalid() {
            Rectangle rectangle = new Rectangle(new Point(0.0,0.0), new Point(0.0,1.0),new Point(0.0,2.0), new Point(2.0,2.0));
            assertEquals(RectangleState.INVALID, rectangle.getState());
        }

        //Test CubeState
        @Test
        void testValid() {
            assertEquals(RectangleState.VALID, expectedValidRectangle.getState());
        }


        @Test
        void testCorrectTxtParser() throws InvalidRectangleDataException {
            Double[] rectangle = {0.0,0.0,1.0,0.0,1.0,1.0 ,0.0,1.0};
            List<Double[]> parameters = TxtParser.parseRectanglesTxt(TEST_DATA);

            assertEquals(Arrays.toString(rectangle), Arrays.toString(parameters.getFirst()));
        }

        @Test
        void testIncorrectTxtParser() throws InvalidRectangleDataException {
            List<Double[]> parameters = TxtParser.parseRectanglesTxt(INVALID_TEST_DATA);

            assertEquals("[]", parameters.toString());
        }

        //Test CubeFactory
        @Test
        void testRectangleFactory() {
            RectangleFactory rectangleFactory = new RectangleFactoryImpl();
            List<Rectangle> result = rectangleFactory.createRectangles(FACTORY_TEST_DATA);
            assertEquals(4, result.size());
            assertEquals(RectangleState.VALID, result.get(0).getState());
            assertEquals(RectangleState.VALID, result.get(1).getState()); //TODO
        }



        //Test CubeObserver
        @Test
        void testRectangleObserver() {
            assertEquals(1, rectangleService.area(expectedValidRectangle));
            expectedValidRectangle.setPointB(new Point(2.0,0.0));
            expectedValidRectangle.setPointC(new Point(2.0,1.0));
            assertEquals(2, rectangleService.area(expectedValidRectangle));
            expectedValidRectangle.setPointB(new Point(1.0,0.0));
            expectedValidRectangle.setPointC(new Point(1.0,1.0));

        }
    }

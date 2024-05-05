package java.come.esde.Cube.validator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.come.esde.Cube.model.entity.Point;
import java.come.esde.Cube.model.entity.Rectangle;
import java.come.esde.Cube.model.entity.RectangleState;
import java.come.esde.Cube.service.impl.RectangleServiceImpl;
import java.util.Arrays;

public class RectangleValidator {

    private static final Logger logger = LogManager.getLogger();
    public boolean isValid(Double[] params){
        boolean valid = true;
        RectangleServiceImpl service = new RectangleServiceImpl();
        Rectangle rectangle = new Rectangle(
                new Point(params[0],params[1]),
                        new Point(params[2],params[3]),
                                new Point(params[4],params[5]),
                                        new Point(params[6],params[7]));
        RectangleState currentState = service.state(rectangle);
        if (currentState == RectangleState.INVALID) {
            valid = false;
            logger.error("Invalid triangle data: " + Arrays.toString(params));
        }
        return valid;
    }
}

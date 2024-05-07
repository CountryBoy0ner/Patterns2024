package com.esde.rectangles.validator;

import com.esde.rectangles.model.entity.Rectangle;
import com.esde.rectangles.model.entity.RectangleState;
import com.esde.rectangles.service.impl.RectangleServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class RectangleValidator {
    private static final Logger logger = LogManager.getLogger();
    public boolean isValid(Double[] params){
        boolean valid = true;
        RectangleServiceImpl service = new RectangleServiceImpl();
        Rectangle rectangle = new Rectangle(params);// todo: watch entity/Rectangle
        RectangleState currentState = RectangleState.state(rectangle);
        if (currentState == RectangleState.INVALID) {
            valid = false;
            logger.error("Invalid triangle data: " + Arrays.toString(params));
         }
        return valid;
    }
}

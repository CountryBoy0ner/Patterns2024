package com.esde.rectangles.validator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Arrays;

public class InputValidator {
    private static final Logger logger = LogManager.getLogger();

    public boolean hasEightParameters(String[] param) {
        boolean valid = true;
        if (param.length != 8) {
            logger.error("There are not 8 params:" + Arrays.toString(param));
            valid = false;
        }
        return valid;
    }

    public Double[] validParams(String[] params) {
        double x1;
        double y1;
        double x2;
        double y2;
        double x3;
        double y3;
        double x4;
        double y4;
        try {
            x1 = Double.parseDouble(params[0]);
            y1 = Double.parseDouble(params[1]);
            x2 = Double.parseDouble(params[2]);
            y2 = Double.parseDouble(params[3]);
            x3 = Double.parseDouble(params[4]);
            y3 = Double.parseDouble(params[5]);
            x4 = Double.parseDouble(params[6]);
            y4 = Double.parseDouble(params[7]);
        } catch (NumberFormatException e) {
            logger.error("Invalid data: " + Arrays.toString(params));
            return null;
        }
        return new Double[]{x1, y1, x2, y2, x3,y3,x4,y4};
    }
}
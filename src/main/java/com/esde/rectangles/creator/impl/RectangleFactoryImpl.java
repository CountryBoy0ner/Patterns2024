package com.esde.rectangles.creator.impl;


import com.esde.rectangles.exeption.InvalidRectangleDataException;
import com.esde.rectangles.model.entity.Point;
import com.esde.rectangles.model.entity.Rectangle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.esde.rectangles.creator.RectangleFactory;

import com.esde.rectangles.util.TxtParser;
import com.esde.rectangles.validator.RectangleValidator;
import java.util.ArrayList;
import java.util.List;

public class RectangleFactoryImpl implements RectangleFactory {
    private static final Logger logger = LogManager.getLogger();

    @Override
    public Rectangle createRectangle(Point a, Point b, Point c, Point d) {
        return new Rectangle(a, b, c, d);
    }

    
    @Override
    public List<Rectangle> createRectangles(String file) {

        List<Rectangle> rectangles = new ArrayList<>();
        List<Double[]> rectangleData;
        RectangleValidator rectangleValidator = new RectangleValidator();
        try {
            rectangleData = TxtParser.parseRectanglesTxt(file);
        } catch (InvalidRectangleDataException e){
            logger.error(e);
            throw new RuntimeException(e);
        }
        for (Double[] params : rectangleData) {
            if (rectangleValidator.isValid(params)){
                Rectangle rectangle = new Rectangle(params); 
                rectangles.add(rectangle);
            }
        }
        logger.info("cubes created successfully");
        return rectangles;
    }
}

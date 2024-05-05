package java.come.esde.Cube.creator.impl;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.come.esde.Cube.model.entity.Point;
import java.come.esde.Cube.model.entity.Rectangle;
import java.come.esde.Cube.creator.RectangleFactory;

import java.util.List;

public class RectangleFactoryImpl implements RectangleFactory {
    private static final Logger logger = LogManager.getLogger();

    @Override
    public Rectangle createRectangle(Point a, Point b, Point c, Point d) {
        return new Rectangle(a, b, c, d);
    }

    @Override
    public List<Rectangle> createRectangles(String file) {
        return null;
    }




}

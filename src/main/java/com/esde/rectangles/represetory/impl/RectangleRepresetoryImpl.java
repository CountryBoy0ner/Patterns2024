package com.esde.rectangles.represetory.impl;

import com.esde.rectangles.model.entity.Rectangle;
import com.esde.rectangles.represetory.RectangleRepresetory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.List;


public class RectangleRepresetoryImpl implements RectangleRepresetory {

    private static final Logger logger = LogManager.getLogger();
    private HashMap<Integer, Rectangle> map = new HashMap<>(); //todo(final)

    private RectangleRepresetoryImpl() {
    }

    public HashMap<Integer, Rectangle> getMap() {
        return map;
    }




    @Override
    public void putRectangleRepresetory(Rectangle rectangle) {
        map.put(rectangle.getId(),rectangle);
    }

    @Override
    public Rectangle getRectangleFromRepresetory(Rectangle rectangle) {
        return map.get(rectangle.getId());
    }

    @Override
    public void deleteRectangleFromRepresetory(Rectangle rectangle) {
        map.remove(rectangle.getId());
    }
    //todo object methods
}

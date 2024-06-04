package com.esde.rectangles.represetory.service;

import com.esde.rectangles.model.entity.Rectangle;

import java.util.List;

public interface RectangleServiceSortRepresetory {
    List<Rectangle> sortRectanglesById();
    List<Rectangle> sortRectanglesByName();
    List<Rectangle> sortRectanglesByPointX();
    List<Rectangle> sortRectanglesByPointy();

}

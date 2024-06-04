package com.esde.rectangles.represetory.service;

import com.esde.rectangles.model.entity.Point;
import com.esde.rectangles.model.entity.Rectangle;

import java.util.List;

public interface RectangleServiceFindByRepresetory {
    List<Rectangle> FindRectanglesbyId (int id);
    List<Rectangle> FindRectanglesbyPointCoordinate (Point a, Point b);
    List<Rectangle> FindRectanglesbyArea (double area);
    List<Rectangle> FindRectanglesbyPerimetr (double minArea,double maxArea);



}

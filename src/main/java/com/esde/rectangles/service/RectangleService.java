package com.esde.rectangles.service;

import com.esde.rectangles.model.entity.Rectangle;

public interface RectangleService {
    double perimeter(Rectangle rectangle);
    double area(Rectangle rectangle);
    boolean isAllSidesEqual(Rectangle rectangle);

}

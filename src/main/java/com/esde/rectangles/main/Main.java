package com.esde.rectangles.main;

import com.esde.rectangles.model.entity.Point;
import com.esde.rectangles.model.entity.Rectangle;
import com.esde.rectangles.creator.RectangleFactory;
import com.esde.rectangles.creator.impl.RectangleFactoryImpl;
import com.esde.rectangles.model.entity.Warehouse;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        RectangleFactory rectangleFactory = new RectangleFactoryImpl();
        List<Rectangle> rectangles = rectangleFactory.createRectangles("/rectangles.txt");
        for (Rectangle rectangle : rectangles) {
            System.out.println(rectangle);
        }

        Warehouse warehouse= Warehouse.getInstance();
        Rectangle observer  = rectangles.getFirst();
        observer.setPointA(new Point(1,1));
        System.out.println(warehouse);
        observer.setPointA(new Point(5,5));
        System.out.println(warehouse);

    }
}
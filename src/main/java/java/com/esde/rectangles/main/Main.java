package java.com.esde.rectangles.main;

import java.com.esde.rectangles.model.entity.Rectangle;
import java.com.esde.rectangles.creator.RectangleFactory;
import java.com.esde.rectangles.creator.impl.RectangleFactoryImpl;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        RectangleFactory rectangleFactory = new RectangleFactoryImpl();
        List<Rectangle> rectangles = rectangleFactory.createRectangles("/rectangles.txt");
        for (Rectangle rectangle : rectangles) {
            System.out.println(rectangle);
        }

//        Warehouse = Warehouse.getInstance();
//        Rectangle observer  = rectangles.getFirst();
//        observer.getSide(1);
//        System.out.println(warehouse);
//        ob.setSide(40);
//        System.out.println(warehouse);

    }
}
package java.com.esde.rectangles.observer.impl;

import java.com.esde.rectangles.model.entity.Rectangle;
import java.com.esde.rectangles.observer.RectangleObserver;
import java.com.esde.rectangles.model.entity.Warehouse;
import java.com.esde.rectangles.service.RectangleService;
import java.com.esde.rectangles.service.impl.RectangleServiceImpl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class RectangleObserverImpl implements RectangleObserver {
    private static final Logger logger = LogManager.getLogger();

    @Override
    public void update(Rectangle rectangle) {
        RectangleService service = new RectangleServiceImpl();
        double area = service.area(rectangle);
        double volume = service.perimeter(rectangle);
        //RectangleState state = service.State(rectangle);
        //RectangleType type = service.type(rectangle);

        int key = rectangle.getId();
        Warehouse warehouse = Warehouse.getInstance();
        warehouse.put(key, volume, area);
        logger.info("warehouse updated");
    }
}
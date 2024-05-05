package java.come.esde.Cube.observer.impl;

import java.come.esde.Cube.model.entity.*;
import java.come.esde.Cube.observer.RectangleObserver;
import java.come.esde.Cube.service.RectangleService;
import java.come.esde.Cube.service.impl.RectangleServiceImpl;
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
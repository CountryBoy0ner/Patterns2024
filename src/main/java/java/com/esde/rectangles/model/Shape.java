package java.com.esde.rectangles.model;

import java.com.esde.rectangles.util.IdGenerator;

public abstract class Shape {
    private final int id = IdGenerator.increment();

    public int getId() {
        return id;
    }

}

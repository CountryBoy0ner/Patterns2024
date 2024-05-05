package java.come.esde.Cube.model;

import java.come.esde.Cube.util.IdGenerator;

public abstract class Shape {
    private final int id = IdGenerator.increment();

    public int getId() {
        return id;
    }

}

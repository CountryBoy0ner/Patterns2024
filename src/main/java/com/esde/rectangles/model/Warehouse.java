package com.esde.rectangles.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Warehouse {
    private static  Warehouse instance = new Warehouse(); //todo(final)
    private  HashMap<Integer, List<Double>> map = new HashMap<>(); //todo(final)

    private Warehouse() {
    }
    public static Warehouse getInstance() {
        return instance;
    }


    public List<Double> get(Integer key) {
        return map.get(key);
    }

    public List<Double> put(Integer key, Double volume, Double surfaceArea) {
        List<Double> parameters = new ArrayList<>();
        parameters.add(volume);
        parameters.add(surfaceArea);// todo watch whats more add (area volume...)
        return map.put(key, parameters);
    }

    @Override
    public String toString() {
        return "Warehouse{" +
                "map=" + map +
                '}';
    }
}

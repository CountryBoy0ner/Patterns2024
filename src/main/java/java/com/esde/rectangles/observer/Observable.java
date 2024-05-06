package java.com.esde.rectangles.observer;

public interface Observable {
    void attach();
    void detach();
    void notifyObservers();
}

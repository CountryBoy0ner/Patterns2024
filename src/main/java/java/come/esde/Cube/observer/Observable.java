package java.come.esde.Cube.observer;

public interface Observable {
    void attach();
    void detach();
    void notifyObservers();
}

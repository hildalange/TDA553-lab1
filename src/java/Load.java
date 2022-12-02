public interface Load {
    Car checkDistanceToLoadCar(Car car);
    void removedCarShouldEndUp(Car car);
    void loadingCar(Car car);
    void removingCar();
}

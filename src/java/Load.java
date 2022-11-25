public interface Load {
    Cars checkDistanceToLoadCar(Cars car);
    void removedCarShouldEndUp(Cars car);
    void loadingCar(Cars car);
    void removingCar();
}

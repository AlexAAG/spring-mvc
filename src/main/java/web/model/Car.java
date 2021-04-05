package web.model;

public class Car {
    String modelCar;
    int series;
    int price;
    String category;

    public Car(String modelCar, int series, int price, String category) {
        this.modelCar = modelCar;
        this.series = series;
        this.price = price;
        this.category = category;
    }

    public String getModelCar() {
        return modelCar;
    }

    public void setModel(String modelCar) {
        this.modelCar = modelCar;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }


}

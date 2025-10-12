public abstract class GeometricShape {
    protected String name;

    public GeometricShape() {
        this.name = "Неизвестная фигура";
    }
    public GeometricShape(String name) {
        this.name = name;
    }

    public abstract double calculateVolume();
    public abstract double calculateSurfaceArea();

    public void displayInfo() {
        System.out.println("Фигура:" + name);
        System.out.println("Объём фигуры:" + calculateVolume());
        System.out.println("Площадь поверхности фигуры:" + calculateSurfaceArea());
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
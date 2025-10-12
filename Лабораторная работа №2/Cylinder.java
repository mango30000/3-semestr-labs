public class Cylinder extends GeometricShape{
    private double radius;
    private double height;
    private double density;

    public Cylinder() {
        super("Цилиндр");
        this.radius = 1.0;
        this.height = 1.0;
        this.density = 1.0;
    }
        public Cylinder(double radius, double height, double density) {
        super("Цилиндр");
        this.radius = radius;
        this.height = height;
        this.density = density;
    }
    public Cylinder(String name, double radius, double height, double density) {
        super(name);
        this.radius = radius;
        this.height = height;
        this.density = density;
    }

    @Override
    public double calculateVolume() {
        return Math.PI * Math.pow(radius, 2) * height;
    }
    @Override
    public double calculateSurfaceArea() {
        return 2 * Math.PI * radius * (radius + height);
    }
    public double calculateMass() {
        return (Math.PI * Math.pow(radius, 2) * height) * density;
    }

    public double getRadius() {
        return radius;
    }
    public double getHeight() {
        return height;
    }
    public double getDensity() {
        return density;
    }

    public void setRadius(double radius) {
        if (radius > 0) {
            this.radius = radius;
        } else {
            System.out.println("Радиус должен быть положительным.");
        }
    }
    public void setHeight(double height) {
        if (height > 0) {
            this.height = height;
        } else {
            System.out.println("Высота должна быть положительной.");
        }
    }
    public void setDensity(double density) {
        if (density > 0) {
            this.density = density;
        } else {
            System.out.println("Плотность должна быть положительной.");
        }
    }
}

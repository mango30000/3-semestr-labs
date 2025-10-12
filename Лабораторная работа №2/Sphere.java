public class Sphere extends GeometricShape{
    private double radius; 
    private double mass;
    private double speed;

    private static int objectCount = 0;

    public Sphere() {
        super("Шар");
        this.radius = 1.0;
        this.mass = 1.0;
        this.speed = 0.0;
        objectCount++;
    }
    public Sphere(double radius, double mass, double speed) {
        super("Шар");
        this.radius = radius;
        this.mass = mass;
        this.speed = speed;
        objectCount++;
    }
    public Sphere(String name, double radius, double mass, double speed) {
        super(name);
        this.radius = radius;
        this.mass = mass;
        this.speed = speed;
        objectCount++;
    }

    @Override
    public double calculateSurfaceArea() {
        return 4 * Math.PI * Math.pow(radius, 2);
    }
    @Override
    public double calculateVolume() {
        return (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
    }
    public double calcKineticEnergy() {
        return 0.5 * mass * speed * speed;
    }

    public double getRadius() {
        return radius;
    }
    public double getMass() {
        return mass;
    }
    public double getSpeed() {
        return speed;
    }
    public void setRadius(double radius) {
        if (radius >= 0) {this.radius = radius;}
        else {System.out.println("Радиус должен быть положительным.");}
    }
    public void setMass(double mass) {
        if (mass >= 0) {this.mass = mass;}
        else {System.out.println("Масса должна быть положительной.");}
    }
    public void setSpeed(double speed) {
        if (speed >= 0) {this.speed = speed;}
        else {System.out.println("Скорость должна быть положительной.");}
    }

    public static int getObjectCount() {
        return objectCount;
    }
}

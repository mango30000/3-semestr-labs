public class Parallelepiped extends GeometricShape{
    private double width;
    private double height;
    private double depth;
    
    public Parallelepiped() {
        super("Параллелепипед");
        this.width = 1.0;
        this.height = 1.0;
        this.depth = 1.0;
    }
    public Parallelepiped(double width, double height, double depth) {
        super("Параллелепипед");
        this.width = width;
        this.height = height;
        this.depth = depth;
    }
    public Parallelepiped(String name, double width, double height, double depth) {
        super(name);
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    @Override
    public double calculateVolume() {
        return width * height * depth;
    }
    @Override
    public double calculateSurfaceArea() {
        return 2 * (width * height + width * depth + height * depth);
    }

    public double getWidth() {
        return width;
    }
    public double getHeight() {
        return height;
    }
    public double getDepth() {
        return depth;
    }

    public void setWidth(double width) {
        if (width >= 0) {this.width = width;}
        else {System.out.println("Ширина должна быть положительной.");}
    }
    public void setHeight(double height) {
        if (height >= 0) {this.height = height;}
        else {System.out.println("Высота должна быть положительной.");}
    }
    public void setDepth(double depth) {
        if (depth >= 0) {this.depth = depth;}
        else {System.out.println("Глубина должна быть положительной.");}
    }
}

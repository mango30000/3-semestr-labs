public class Main {
    public static void main(String[] args) {
        Sphere sphere1 = new Sphere(3.0, 400.7, 56.0);
        Sphere sphere2 = new Sphere("Второй шарик", 5.0, 46.0, 9.0);
        Parallelepiped box = new Parallelepiped("Коробка", 2.0, 3.0, 4.0);
        Cylinder can = new Cylinder("банка", 6.0, 7.9, 2700.0);

        GeometricShape[] shapes = {sphere1, sphere2, box, can};
        for (GeometricShape shape : shapes) {
            shape.displayInfo();
        }
        System.out.println("Кинетическая энергия первого шарика: " + sphere1.calcKineticEnergy());

        System.out.println("Всего создано объектов класса 'Sphere':" + Sphere.getObjectCount());
        //сеттеры и геттеры для класса Sphere
        System.out.println("Масса первого шара до изменения:" + sphere1.getMass());
        sphere1.setMass(200.0);
        double Masssphere1 = sphere1.getMass();
        System.out.println("Масса первого шара после изменения:" + Masssphere1);

        //сеттеры и геттеры для класса Parallelepiped
        System.out.println("Ширина коробки до изменения:" + box.getWidth());
        box.setWidth(10.4);
        double Widthbox = box.getWidth();
        System.out.println("Ширина коробки после изменения:" + Widthbox);

        //сеттеры и геттеры для класса Cylinder
        System.out.println("Плотность банки до изменения:" + can.getDensity());
        can.setDensity(-1800.0);;
        double Densitycan = can.getDensity();
        System.out.println("Плотность банки после изменения:" + Densitycan);

        System.out.println("Название первого шара:" + sphere1.getName());
        System.out.println("Название параллелепипеда:" + box.getName());
        System.out.println("Название цилиндра:" + can.getName());
        System.out.println("Название второго шара:" + sphere2.getName());
    }
}

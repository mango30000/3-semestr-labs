import java.util.ArrayList;
import java.util.List;

class Item {
    private final int id;
    private final int weight;

    public Item(int id, int weight) {
        this.id = id;
        this.weight = weight;
    }
    public int getId() {
        return id;
    }
    public int getWeight() {
        return weight;
    }
    @Override
    public String toString() {
        return "Item{id=" + id + ", weight=" + weight + "kg}";
    }
}

class Warehouse {
    private final List<Item> items;
    private int nextItemIndex = 0;

    public Warehouse(List<Item> items) {
        this.items = items;
    }

    public synchronized Item takeNextItem() {
        if (nextItemIndex < items.size()) {
            Item item = items.get(nextItemIndex);
            nextItemIndex++;
            return item;
        }
        return null;
    }

    public synchronized boolean hasItems() {
        return nextItemIndex < items.size();
    }
}

class Loader extends Thread {
    private final Warehouse sourceWarehouse;
    private final int loaderId;
    private int totalWeightCarried = 0;
    public static final int MAX_WEIGHT = 150;
    private static int currentWeight = 0;
    private static final Object lock = new Object();

    public Loader(Warehouse sourceWarehouse, int loaderId) {
        this.sourceWarehouse = sourceWarehouse;
        this.loaderId = loaderId;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Item item = sourceWarehouse.takeNextItem();
                if (item == null) break;
                
                synchronized (lock) {
                    if (currentWeight + item.getWeight() > MAX_WEIGHT) {
                        if (currentWeight > 0) {
                            System.out.println("Партия " + currentWeight + "кг отправляется на разгрузку");
                            Thread.sleep(800); 
                            System.out.println("Разгрузка завершена, можно возвращаться");
                            currentWeight = 0;
                            lock.notifyAll(); 
                        }
                        continue;
                    }
                    
                    currentWeight += item.getWeight();
                    totalWeightCarried += item.getWeight();
                    System.out.println("Грузчик " + loaderId + " взял " + item + " Общий вес партии: " + currentWeight + "кг");
                    
                    if (currentWeight >= MAX_WEIGHT) {
                        System.out.println("Набрано " + currentWeight + "кг, можно отправлять!");
                        Thread.sleep(800);
                        System.out.println("Разгрузка завершена");
                        currentWeight = 0;
                        lock.notifyAll();
                    }
                }
                Thread.sleep(100); 
            }
            
            synchronized (lock) {
                if (currentWeight > 0) {
                    System.out.println("Отправляем остаток " + currentWeight + "кг (последняя партия)");
                    Thread.sleep(800);
                    currentWeight = 0;
                }
            }
            
            System.out.println("Грузчик " + loaderId + " завершил работу. Перенесено: " + totalWeightCarried + "кг");
            
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        List<Item> items = new ArrayList<>();
        int[] weights = {30, 40, 80, 45, 60, 20, 20, 20, 20, 20, 25, 35};
        
        for (int i = 0; i < weights.length; i++) {
            items.add(new Item(i + 1, weights[i]));
        }
        System.out.println("На складе " + items.size() + " товаров:");
        items.forEach(item -> System.out.println("  " + item));
        
        int totalWeight = 0;
        for (Item item : items) {
            totalWeight += item.getWeight();
        }
        System.out.println("Общий вес всех товаров: " + totalWeight + "кг");

        Warehouse warehouse = new Warehouse(items);

        Loader[] loaders = new Loader[3];
        for (int i = 0; i < loaders.length; i++) {
            loaders[i] = new Loader(warehouse, i + 1);
        }
        for (Loader loader : loaders) {
            loader.start();
        }
        for (Loader loader : loaders) {
            try {
                loader.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Все товары перенесены ура");

    }
}
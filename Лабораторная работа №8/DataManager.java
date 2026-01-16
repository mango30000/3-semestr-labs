import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.lang.reflect.Method;
import java.util.concurrent.*;

public class DataManager {
    private List<String> data = new ArrayList<>();
    private final List<Object> processors = new ArrayList<>();
    private final ExecutorService executor;
    
    public DataManager() {
        this.executor = Executors.newCachedThreadPool();
    }
    
    public void registerDataProcessor(Object processor) {
        processors.add(processor);
        System.out.println("Зарегистрирован: " + processor.getClass().getSimpleName());
    }
    
    public void loadData(String source) throws IOException {
        data = Files.readAllLines(Paths.get(source));
        System.out.println("Загружено " + data.size() + " строк из " + source);
    }
    @SuppressWarnings("unchecked")
    public void processData() throws Exception {
        if (data.isEmpty() || processors.isEmpty()) return;
        System.out.println(" Запуск параллельной обработки через CompletableFuture...");
        
        CompletableFuture<List<String>> processingPipeline = 
            CompletableFuture.completedFuture(new ArrayList<>(data));
        
        for (Object processor : processors) {
            for (Method method : processor.getClass().getMethods()) {
                if (method.isAnnotationPresent(DataProcessor.class)) {
                    final Object proc = processor;
                    final Method meth = method;
                    
                    processingPipeline = processingPipeline.thenApplyAsync(
                        currentData -> {
                            try {
                                System.out.println(Thread.currentThread().getName() + 
                                                 " выполняет " + meth.getName());
                                return (List<String>) meth.invoke(proc, currentData);
                            } catch (Exception e) {
                                throw new RuntimeException(e);
                            }
                        },
                        executor 
                    );
                }
            }
        }
        
        data = processingPipeline.get();
        
        System.out.println("Параллельная обработка завершена.");
    }
    
    public void saveData(String destination) throws IOException {
        Files.write(Paths.get(destination), data);
        System.out.println("Сохранено " + data.size() + " строк в " + destination);
    }
    
    public void shutdown() {
        executor.shutdown();
    }
}

import java.util.*;
import java.util.stream.*;

public class FilterProcessor {
    @DataProcessor
    public List<String> removeEmpty(List<String> data) {
        return data.stream()
            .filter(line -> !line.trim().isEmpty())
            .collect(Collectors.toList());
    }
    
    @DataProcessor
    public List<String> removeShort(List<String> data) {
        return data.stream()
            .filter(line -> line.length() > 3)
            .collect(Collectors.toList());
    }
}
import java.util.*;
import java.util.stream.*;

public class TransformProcessor {
    @DataProcessor
    public List<String> toUpperCase(List<String> data) {
        return data.stream()
            .map(String::toUpperCase)
            .collect(Collectors.toList());
    }
    
    @DataProcessor
    public List<String> addNumbers(List<String> data) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            result.add((i + 1) + ". " + data.get(i));
        }
        return result;
    }
}
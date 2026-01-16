import java.util.*;
import java.util.stream.*;

public class SortProcessor {
    @DataProcessor
    public List<String> sortAlphabetically(List<String> data) {
        return data.stream()
            .sorted()
            .collect(Collectors.toList());
    }
}
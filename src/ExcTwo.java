import java.util.List;
import java.util.stream.Collectors;

public class ExcTwo {
    public static List<String> transformAndSort(List<String> inputList) {
        return inputList.stream()
                .map(String::toUpperCase)
                .sorted((a, b) -> b.compareTo(a))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<String> inputList = List.of("Ivan", "Peter", "John", "Alice", "Michael");

        List<String> transformedAndSorted = transformAndSort(inputList);
        transformedAndSorted.forEach(System.out::println);
    }
}

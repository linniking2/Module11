import java.util.Iterator;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Exc5 {
    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        Iterator<T> iterator1 = first.iterator();
        Iterator<T> iterator2 = second.iterator();

        Iterator<T> zippedIterator = new Iterator<T>() {
            boolean hasNext1 = iterator1.hasNext();
            boolean hasNext2 = iterator2.hasNext();

            @Override
            public boolean hasNext() {
                return hasNext1 && hasNext2;
            }

            @Override
            public T next() {
                T next1 = iterator1.next();
                T next2 = iterator2.next();
                hasNext1 = iterator1.hasNext();
                hasNext2 = iterator2.hasNext();
                return next1;
            }
        };

        Spliterator<T> spliterator = Spliterators.spliteratorUnknownSize(
                zippedIterator,
                Spliterator.ORDERED | Spliterator.IMMUTABLE
        );

        return StreamSupport.stream(spliterator, false);
    }

    public static void main(String[] args) {
        Stream<Integer> stream1 = Stream.of(1, 2, 3, 4);
        Stream<Integer> stream2 = Stream.of(5, 6, 7);

        Stream<Integer> zippedStream = zip(stream1, stream2);
        zippedStream.forEach(System.out::println);
    }
}

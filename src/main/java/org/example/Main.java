package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class Main {

    public static String first(List<String> names) {
        return java.util.stream.IntStream.range(0, names.size())
                .filter(i -> i % 2 == 1)
                .mapToObj(i -> i + ". " + names.get(i))
                .collect(java.util.stream.Collectors.joining(", "));
    }

    public static List<String> second(List<String> list) {
        return list.stream()
                .map(String::toUpperCase)
                .sorted(java.util.Comparator.reverseOrder())
                .toList();
    }

    public static String third(String[] arr) {
        return java.util.Arrays.stream(arr)
                .flatMap(s -> java.util.Arrays.stream(s.split(", ")))
                .map(Integer::parseInt)
                .sorted()
                .map(String::valueOf)
                .collect(java.util.stream.Collectors.joining(", "));
    }

    public static Stream<Long> forth(long seed, long a, long c, long m) {
        return Stream.iterate(seed, x -> (a * x + c) % m);
    }

    public static <T> Stream<T> fifth(Stream<T> first, Stream<T> second) {
        var it1 = first.iterator();
        var it2 = second.iterator();

        return Stream.generate(() -> {
                    if (it1.hasNext() && it2.hasNext()) {
                        return List.of(it1.next(), it2.next());
                    }
                    return null;
                })
                .takeWhile(Objects::nonNull)
                .flatMap(List::stream);
    }

    public static void main(String[] args) {

    }
}
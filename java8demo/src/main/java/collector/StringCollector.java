package collector;


import com.google.common.collect.ImmutableSet;

import java.util.Set;
import java.util.StringJoiner;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class StringCollector implements Collector<String, StringJoiner, String> {

    private String delimiter;
    private String prefix;
    private String suffix;

    public StringCollector(String delimiter, String prefix, String suffix) {
        this.delimiter = delimiter;
        this.prefix = prefix;
        this.suffix = suffix;
    }

    @Override
    public Supplier<StringJoiner> supplier() {
        return () -> new StringJoiner(delimiter, prefix, suffix);
    }

    @Override
    public BiConsumer<StringJoiner, String> accumulator() {
        return StringJoiner::add;
    }

    @Override
    public BinaryOperator<StringJoiner> combiner() {
        return StringJoiner::merge;
    }

    @Override
    public Function<StringJoiner, String> finisher() {
        return StringJoiner::toString;
    }


    @Override
    public Set<Characteristics> characteristics() {
        return ImmutableSet.of(Characteristics.CONCURRENT);
    }
}

package ru.job4j.stream;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class EasyStream {
    public List<Integer> sours;

    public static EasyStream of(List<Integer> source) {
        Function<List<Integer>, Object> i = x -> EasyStream.of(source);
        i.apply(source);
        throw new UnsupportedOperationException();
    }

    public EasyStream map(Function<Integer, Integer> fun) {
        throw new UnsupportedOperationException();
    }

    public static EasyStream filter(Predicate<Integer> fun) {
        throw new UnsupportedOperationException();
    }

    public List<Integer> collect() {

        throw new UnsupportedOperationException();
    }

    public static Builder newBuilder() {
        return new EasyStream().new Builder();
    }

    class Builder {

        private Builder() {
            // private constructor
        }
        public Builder of(List<Integer> source) {
            EasyStream.of(source) ;
            return this;
        }

        public Builder map(Function<Integer, Integer> fun) {
            new EasyStream().map(fun);
            return this;
        }

        public Builder filter(Predicate<Integer> fun) {
            new EasyStream().filter(fun) ;
            return this;
        }

        public Builder collect() {
            new EasyStream().collect() ;
            return this;
        }

        public EasyStream build() {
            return new EasyStream();
        }
    }

    public static void main(String[] args) {
    }
}

package ru.job4j.stream;

import java.util.*;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class EasyStream implements EasyStreamBuilder {
        private List<Integer> input;

        @Override
        public EasyStream of(List<Integer> source) {
            this.input = source;
            return this;
        }

        @Override
        public EasyStream map(Function<Integer, Integer> fun) {
            List<Integer> tmp = new ArrayList<>();
            Iterator<Integer> iterator = this.input.iterator();
            while (iterator.hasNext()) {
                tmp.add(fun.apply(iterator.next()));
            }
            this.input = tmp;
            return this;
        }

        @Override
        public EasyStream filter(Predicate<Integer> fun) {
            List<Integer> tmp = new ArrayList<>();
            for (int s: this.input) {
                if (fun.test(s)) {
                    tmp.add(s);
                }
            }
            this.input = tmp;
            return this;
        }

        @Override
        public List<Integer> collect() {
            return new ArrayList<>(this.input);
        }
}

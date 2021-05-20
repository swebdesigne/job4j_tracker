package ru.job4j.map;

import java.util.Objects;

public class NewSubject {
        private String name;

        private int score;

        public NewSubject(String name, int score) {
            this.name = name;
            this.score = score;
        }

        public String getName() {
            return name;
        }

        public int getScore() {
            return score;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            NewSubject subject = (NewSubject) o;
            return Objects.equals(name, subject.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }
}

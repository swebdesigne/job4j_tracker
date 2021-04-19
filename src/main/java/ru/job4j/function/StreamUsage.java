package ru.job4j.function;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamUsage {
    public static class Task {
        private final String name;
        private final long spent;

        public Task(String name, long spent) {
            this.name = name;
            this.spent = spent;
        }

        @Override
        public String toString() {
            return "Task{"
                    + "name='" + name + '\''
                    + ", spent=" + spent
                    + '}';
        }

        public static void main(String[] args) {
            List<Task> tasks = List.of(
                    new Task("Bug #1", 100),
                    new Task("Bug #2", 100),
                    new Task("Bug #3", 100)
            );
            List<Task> bugs = tasks.stream().filter(
                    task -> task.name.contains("ug")
            ).collect(Collectors.toList());
            bugs.forEach(System.out::println);
            List<String> names = tasks.stream().map(task -> task.name)
                    .collect(Collectors.toList());
            bugs.forEach(System.out::println);
            long total = tasks.stream().map(task -> task.spent)
                    .reduce(0L, Long::sum);
            System.out.println(total);
            List<Task> nBugs = tasks.stream().filter(
                    task -> task.name.contains("Bug")
            ).collect(Collectors.toList());
            System.out.println(nBugs);
            ArrayList<Integer> integers = new ArrayList<>();
            integers.add(1);
            integers.add(-1);
            integers.add(2);
            integers.add(-2);
            integers.add(3);
            integers.add(-3);
            integers.add(4);
            integers.add(-4);
            integers.add(5);
            integers.add(-5);
            List<Integer> newIntegers = integers.stream()
                    .filter(integer -> integer >= 0)
                    .collect(Collectors.toList());
            newIntegers.forEach(System.out::println);
            System.out.println("========== newTasks ===========");
            List<Task> newTasks = List.of(
                    new Task("Bug #1", 10),
                    new Task("Task #2", 20),
                    new Task("Bug #3", 40)
            );
            newTasks.stream()
                    .filter(task -> task.name.contains("Bug"))
                    .filter(task -> task.spent > 30)
                    .map(task -> task.name + " " + task.spent)
                    .forEach(System.out::println);
        }
    }
}

package ru.job4j.collection;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class JobTest {

    @Test
    public void whenCompatorByNameAndPrority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompatorByNameAndProrityAsc() {
        Comparator<Job> cmpNamePriority = new JobAscByName().thenComparing(new JobAscByPriority());
        int rsl = cmpNamePriority.compare(
            new Job("Impl task", 0),
            new Job("Fix bug", 1)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenNameAsc() {
        List<Job> job = Arrays.asList(
                new Job("Petr", 32),
                new Job("Ivan", 31)
        );
        Collections.sort(job, new JobAscByName());
        Iterator<Job> it = job.iterator();
        assertThat(it.next(), is(new Job("Ivan", 31)));
        assertThat(it.next(), is(new Job("Petr", 32)));
    }

    @Test
    public void whenNameDesc() {
        List<Job> job = Arrays.asList(
                new Job("Ivan", 31),
        new Job("Petr", 32)
        );
        Collections.sort(job, new JobDescByName());
        Iterator<Job> it = job.iterator();
        assertThat(it.next(), is(new Job("Petr", 32)));
        assertThat(it.next(), is(new Job("Ivan", 31)));
    }

    @Test
    public void whenPriorityAsc() {
        List<Job> job = Arrays.asList(
                new Job("Petr", 32),
                new Job("Ivan", 31)
        );
        Collections.sort(job, new JobAscByPriority());
        Iterator<Job> it = job.iterator();
        assertThat(it.next(), is(new Job("Ivan", 31)));
        assertThat(it.next(), is(new Job("Petr", 32)));
    }

    @Test
    public void whenPriorityDesc() {
        List<Job> job = Arrays.asList(
                new Job("Ivan", 31),
                new Job("Petr", 32)
        );
        Collections.sort(job, new JobDescByPriority());
        Iterator<Job> it = job.iterator();
        assertThat(it.next(), is(new Job("Petr", 32)));
        assertThat(it.next(), is(new Job("Ivan", 31)));
    }
}
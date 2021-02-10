package ru.job4j.tracker;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.w3c.dom.ls.LSOutput;

import javax.crypto.spec.PSource;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.IsNull.nullValue;

public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = Tracker.getInstance();
        Item item = new Item();
        item.setName("test1");
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    @Test
    public void whenReplace() {
        Tracker tracker = Tracker.getInstance();
        Item bug = new Item();
        bug.setName("Bug");
        tracker.add(bug);
        int id = bug.getId();
        Item bugWithDesc = new Item();
        bugWithDesc.setName("Bug with description");
        tracker.replace(id, bugWithDesc);
        assertThat(tracker.findById(id).getName(), is("Bug with description"));
    }

    @Test
    public void whenDelete() {
        Tracker tracker = Tracker.getInstance();
        Item bug = new Item();
        bug.setName("Bug");
        tracker.add(bug);
        int id = bug.getId();
        tracker.delete(id);
        assertThat(tracker.findById(id), is(nullValue()));
    }

    @Test
    public void whenFindByName() {
        Tracker tracker = Tracker.getInstance();
        Item item = new Item();
        item.setName("Igor");
        tracker.add(item);
        Item[] name = tracker.findByName("Igor");
        for (int i = 0; i < name.length; i++) {
            Item value = name[i];
            assertThat(value.getName(), is(item.getName()));
        }
    }

    @Test
    public void whenNotFindByName() {
        Tracker tracker = Tracker.getInstance();
        Item item = new Item();
        item.setName("Boris");
        tracker.add(item);
        Item[] name = tracker.findByName("Igor");
        System.out.println(name.length);
        for (int i = 0; i < name.length; i++) {
            Item value = name[i];
            assertThat(value, is(nullValue()));
        }
    }
}
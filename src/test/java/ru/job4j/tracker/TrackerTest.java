package ru.job4j.tracker;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.w3c.dom.ls.LSOutput;

import javax.crypto.spec.PSource;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.IsNull.nullValue;

public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item();
        item.setName("test1");
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    @Test
    public void whenReplace() {
        Tracker tracker = new Tracker();
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
        Tracker tracker = new Tracker();
        Item bug = new Item();
        bug.setName("Bug");
        tracker.add(bug);
        int id = bug.getId();
        assertThat(tracker.delete(id), is(true));
    }

    @Test
    public void whenFindByName() {
        Tracker tracker = new Tracker();
        Item item = new Item();
        item.setName("Igor");
        tracker.add(item);
        List<Item> name = tracker.findByName("Igor");
        for (int i = 0; i < name.size(); i++) {
            Item value = name.get(i);
            assertThat(value.getName(), is(item.getName()));
        }
    }

    @Test
    public void whenNotFindByName() {
        Tracker tracker = new Tracker();
        Item item = new Item();
        item.setName("Boris");
        tracker.add(item);
        List<Item> name = tracker.findByName("Igor");
        for (int i = 0; i < name.size(); i++) {
            Item value = name.get(i);
            assertThat(item.getName().equals(value), is(false));
        }
    }
}
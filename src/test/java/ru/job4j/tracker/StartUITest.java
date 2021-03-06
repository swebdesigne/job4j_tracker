package ru.job4j.tracker;

import junit.framework.TestCase;
import org.junit.Test;
import ru.job4j.collection.User;

import java.time.LocalDateTime;
import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.*;

public class StartUITest {
    @Test
    public void whenCreateItem() {
        Output output = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new CreateAction(output));
        actions.add(new Exit(output));
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findAll().get(0).getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        /* Добавим в tracker новую заявку */
        Item item = tracker.add(new Item("Replaced item"));
        /* Входные данные должны содержать ID добавленной заявки item.getId() */
        String replacedName = "New item name";
        String id = String.valueOf(item.getId());
        Input in = new StubInput(
                new String[] {"0", id, replacedName, "1"}
        );
        List<UserAction> actions = new ArrayList<>();
        actions.add(new ReplaceItem(output));
        actions.add(new Exit(output));
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        /* Добавим в tracker новую заявку */
        Item item = tracker.add(new Item("Deleted item"));
        /* Входные данные должны содержать ID добавленной заявки item.getId() */
        String id = String.valueOf(item.getId());
        Input in = new StubInput(
                new String[] {"0", id, "1"}
        );
        List<UserAction> actions = new ArrayList<>();
        actions.add(new DeleteItem(output));
        actions.add(new Exit(output));
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenExit() {
        Output output = new StubOutput();
        Input in = new StubInput(
                new String[] {"0"}
        );
        Tracker tracker = new Tracker();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new Exit(output));
        new StartUI(output).init(in, tracker, actions);
        assertThat(output.toString(), is(
                "Menu." + System.lineSeparator() + "0. Exit" + System.lineSeparator()
        ));
    }

    @Test
    public void findAllAction() {
        Item[] ids = new Item[2];
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("First element"));
        ids[0] = item;
        String id = String.valueOf(item.getId());
        item = tracker.add(new Item("Second element"));
        ids[1] = item;
        for (int i = 1; i < ids.length - 1; i++) {
            Item value = ids[i];
            Input in = new StubInput(
                    new String[] {"0", String.valueOf(value.getId()), "1"}
            );
            List<UserAction> actions = new ArrayList<>();
            actions.add(new FindAllItem(output));
            actions.add(new Exit(output));
            new StartUI(output).init(in, tracker, actions);
            assertThat(output.toString(), is(
                    "Menu."
                            + System.lineSeparator()
                            + "0. Show all items."
                            + System.lineSeparator()
                            + "1. Exit"
                            + System.lineSeparator()
                            + "=== Find all Item ==="
                            + System.lineSeparator()
                            + "value = " + value.getName()
                            + System.lineSeparator()
                            + "value = " + item.getName() + ""
                            + System.lineSeparator()
                            + "Menu."
                            + System.lineSeparator()
                            + "0. Show all items."
                            + System.lineSeparator()
                            + "1. Exit" + System.lineSeparator()
                    )
            );
        }
    }

    @Test
    public void findByNameAction() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Find items by name."));
        Input in = new StubInput(
                new String[] {"0", String.valueOf(item.getName()), "1"}
        );
        List<UserAction> actions = new ArrayList<>();
        actions.add(new FindItemByName(output));
        actions.add(new Exit(output));
        new StartUI(output).init(in, tracker, actions);
        LocalDateTime created = LocalDateTime.now();
        assertThat(output.toString(), is(
                "Menu."
                        + System.lineSeparator()
                        + "0. " + item.getName()
                        + System.lineSeparator()
                        + "1. Exit"
                        + System.lineSeparator()
                        + "=== Find Item by name ==="
                        + System.lineSeparator()
                        + "Item{"
                        + "id=" + item.getId() + ", "
                        + "name='" + item.getName() + "'"
                        + "}"
                        + System.lineSeparator()
                        + "Menu."
                        + System.lineSeparator()
                        + "0. Find items by name."
                        + System.lineSeparator()
                        + "1. Exit" + System.lineSeparator()
                )
        );
    }

      @Test
    public void findByIdAction() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Find item by Id."));
        String id = String.valueOf(item.getId());
        Input in = new StubInput(
                new String[] {"0", id, "1"}
        );
        List<UserAction> actions = new ArrayList<>();
        actions.add(new FindItemById(output));
        actions.add(new Exit(output));
        new StartUI(output).init(in, tracker, actions);
        assertThat(output.toString(), is(
                "Menu."
                        + System.lineSeparator()
                        + "0. " + item.getName()
                        + System.lineSeparator()
                        + "1. Exit"
                        + System.lineSeparator()
                        + "=== Find Item by id ==="
                        + System.lineSeparator()
                        + "Item{"
                        + "id=" + item.getId() + ", "
                        + "name='" + item.getName() + "'"
                        + "}"
                        + System.lineSeparator()
                        + "Menu."
                        + System.lineSeparator()
                        + "0. Find item by Id."
                        + System.lineSeparator()
                        + "1. Exit" + System.lineSeparator()
                )
        );
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"7", "0", "0"}
        );
        Tracker tracker = new Tracker();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new Exit(out));
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                String.format(
                        "Menu.%n"
                                + "0. Exit%n"
                                + "Wrong input, you can select: 0 .. 0%n"
                                + "Menu.%n"
                                + "0. Exit%n"
                )
        ));
    }

    @Test
    public void whenSortASC() {
            List<Item> items = Arrays.asList(
                    new Item(1, "Petr"),
                    new Item(3, "Petr"),
                    new Item(2, "Igor")
            );
        Iterator<Item> it = items.iterator();
        Collections.sort(items);
        assertThat(it.next(), is(new Item(1, "Petr")));
        assertThat(it.next(), is(new Item(2, "Igor")));
        assertThat(it.next(), is(new Item(3, "Petr")));
    }

    @Test
    public void whenSortDESC() {
        List<Item> items = Arrays.asList(
                new Item(1, "Petr"),
                new Item(3, "Alina"),
                new Item(2, "Igor")
        );
        List<Item> sort =  Arrays.asList(
                new Item(3, "Alina"),
                new Item(2, "Igor"),
                new Item(1, "Petr")
                );
        Collections.sort(items, new SortByName());
        assertThat(items, is(sort));
    }
}
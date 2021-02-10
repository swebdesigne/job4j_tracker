package ru.job4j.tracker;

import junit.framework.TestCase;
import org.junit.Test;

import java.time.LocalDateTime;

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
        Tracker tracker = Tracker.getInstance();
        UserAction[] actions = {
                new CreateAction(output),
                new Exit(output)
        };
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem() {
        Output output = new StubOutput();
        Tracker tracker = Tracker.getInstance();
        /* Добавим в tracker новую заявку */
        Item item = tracker.add(new Item("Replaced item"));
        /* Входные данные должны содержать ID добавленной заявки item.getId() */
        String replacedName = "New item name";
        String id = String.valueOf(item.getId());
        Input in = new StubInput(
                new String[] {"0", id, replacedName, "1"}
        );
        UserAction[] actions = {
                new ReplaceItem(output),
                new Exit(output)
        };
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        Output output = new StubOutput();
        Tracker tracker = Tracker.getInstance();
        /* Добавим в tracker новую заявку */
        Item item = tracker.add(new Item("Deleted item"));
        /* Входные данные должны содержать ID добавленной заявки item.getId() */
        String id = String.valueOf(item.getId());
        Input in = new StubInput(
                new String[] {"0", id, "1"}
        );
        UserAction[] actions = {
                new DeleteItem(output),
                new Exit(output)
        };
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0"}
        );
        Tracker tracker = Tracker.getInstance();
        UserAction[] actions = {
                new Exit(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() + "0. Exit" + System.lineSeparator()
        ));
    }

    @Test
    public void findAllAction() {
        Item[] ids = new Item[2];
        Output output = new StubOutput();
        Tracker tracker = Tracker.getInstance();
        Item item = tracker.add(new Item("First element"));
        ids[0] = item;
        String id = String.valueOf(item.getId());
        item = tracker.add(new Item("Second element"));
        ids[1] = item;
        for (int i = 0; i < ids.length - 1; i++) {
            Item value = ids[i];
            Input in = new StubInput(
                    new String[] {"0", String.valueOf(value.getId()), "1"}
            );
            UserAction[] actions = {
                    new FindAllItem(output),
                    new Exit(output)
            };
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
        Tracker tracker = Tracker.getInstance();
        Item item = tracker.add(new Item("Find items by name."));
        Input in = new StubInput(
                new String[] {"0", String.valueOf(item.getName()), "1"}
        );
        UserAction[] actions = {
                new FindItemByName(output),
                new Exit(output)
        };
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
        Tracker tracker = Tracker.getInstance();
        Item item = tracker.add(new Item("Find item by Id."));
        String id = String.valueOf(item.getId());
        Input in = new StubInput(
                new String[] {"0", id, "1"}
        );
        UserAction[] actions = {
                new FindItemById(output),
                new Exit(output)
        };
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
        Tracker tracker = Tracker.getInstance();
        UserAction[] actions = {
                new Exit(out)
        };
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
}
package ru.job4j.tracker;

import junit.framework.TestCase;
import org.junit.Test;

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
        UserAction[] actions = {
                new CreateAction(output),
                new Exit()
        };
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("Item name"));
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
        UserAction[] actions = {
                new ReplaceItem(output),
                new Exit()
        };
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
        UserAction[] actions = {
                new DeleteItem(output),
                new Exit()
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
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new Exit()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() + "0. Exit" + System.lineSeparator()
        ));
    }

    @Test
    public void findAllAction() {
        Item[] ids;
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("First element"));
        String id = String.valueOf(item.getId());
        item = tracker.add(new Item("Second element"));
        id = String.valueOf(item.getId());
        ids = new Item[] {item};
        for (int i = 0; i < ids.length - 1; i++) {
            Item value = ids[i];
            System.out.println(value.getId());
            Input in = new StubInput(
                    new String[] {"0", String.valueOf(value.getId()), "1"}
            );
            UserAction[] actions = {
                    new FindAllItem(output),
                    new Exit()
            };
            new StartUI(output).init(in, tracker, actions);
            assertThat(tracker.findAll()[i].getName(), is(value.getName()));
        }
    }

    @Test
    public void findByNameAction() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Find item by Name"));
        Input in = new StubInput(
                new String[] {"0", String.valueOf(item.getName()), "1"}
        );
        UserAction[] actions = {
                new FindItemByName(output),
                new Exit()
        };
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findByName(item.getName())[0].getName(), is(item.getName()));
    }

    @Test
    public void findByIdAction() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Find item by id"));
        String id = String.valueOf(item.getId());
        Input in = new StubInput(
                new String[] {"0", id, "1"}
        );
        UserAction[] actions = {
                new FindItemById(output),
                new Exit()
        };
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getId(), is(Integer.parseInt(id)));
    }


}
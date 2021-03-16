package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StartUI implements ShowMenu {
    private final Output out;

    public StartUI(Output out) {
        this.out = out;
    }

    public void init(Input input, Tracker tracker, List<UserAction> actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ");
            if (select < 0 || select >= actions.size()) {
                out.println("Wrong input, you can select: 0 .. " + (actions.size() - 1));
                continue;
            }
            UserAction action = actions.get(select);
            run = action.execute(input, tracker);
        }
    }

    public void showMenu(List<UserAction> actions) {
        out.println("Menu.");
        for (int i = 0; i < actions.size(); i++) {
            out.println(i + ". " + actions.get(i).name());
        }
    }

    public static void main(String[] args) {
        Output output = new ConsoleOutput();
        Input input = new ValidateInput(output, new ConsoleInput(output));
        Tracker tracker = Tracker.getInstance();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new CreateAction(output));
        actions.add(new FindAllItem(output));
        actions.add(new ReplaceItem(output));
        actions.add(new DeleteItem(output));
        actions.add(new FindItemById(output));
        actions.add(new FindItemByName(output));
        actions.add(new Exit(output));
        new StartUI(output).init(input, tracker, actions);
    }
}

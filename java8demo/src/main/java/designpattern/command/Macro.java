package designpattern.command;

import java.util.ArrayList;
import java.util.List;

public class Macro {

    private final List<Action> actions;

    public Macro() {
        this.actions = new ArrayList<>(16);
    }

    public void record(Action action){
        actions.add(action);
    }

    public void run(){
        actions.forEach(Action::perform);
    }
}

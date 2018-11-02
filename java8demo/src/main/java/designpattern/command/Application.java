package designpattern.command;

public class Application {

    public static void main(String[] args) {
        Macro macro = new Macro();
        Editor editor = new EditorImpl();
        macro.record(editor::open);
        macro.record(editor::save);
        macro.record(editor::close);
        macro.run();
    }
}

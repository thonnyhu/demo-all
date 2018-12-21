package command.televition;

public class Client {

    public static void main(String[] args) {
        Television television = new Television();
        OpenCommand openCommand = new OpenCommand(television);
        CloseCommand closeCommand = new CloseCommand(television);
        Controller controller = new Controller();
        controller.open(openCommand);
        controller.close(closeCommand);
    }
}

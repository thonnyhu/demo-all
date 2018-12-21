package command;

public class ConcreteCommand implements Command{

    private Receiver receiver;


    public ConcreteCommand(Receiver receiver){
        this.receiver = receiver;
    }

    @Override
    public void command() {
        System.out.println("command begin");
        System.out.println(receiver.action());
    }
}

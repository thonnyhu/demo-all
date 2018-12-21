package command.televition;

public class OpenCommand extends BaseCommand{


    public OpenCommand(Television television) {
        super(television);
    }

    @Override
    public void command() {
        System.out.println("I am OpenCommand");
        television.open();
    }
}

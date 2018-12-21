package command.televition;

public class CloseCommand extends BaseCommand{


    public CloseCommand(Television television) {
        super(television);
    }

    @Override
    public void command() {
        System.out.println("I am CloseCommand");
        television.close();
    }
}

package command.televition;

public abstract class BaseCommand implements Command{

    protected Television television;

    public BaseCommand(Television television){
        this.television = television;
    }
}

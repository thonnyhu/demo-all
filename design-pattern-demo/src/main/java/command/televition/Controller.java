package command.televition;

public class Controller {

    public void open(OpenCommand openCommand){
        System.out.println("I am Controller");
        openCommand.command();
    }


    public void close(CloseCommand closeCommand){
        System.out.println("I am Controller");
        closeCommand.command();
    }
}

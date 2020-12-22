package AlgoUeb2.commands;

public interface ICommand {
    String execute() throws Exception;
    String description();
}

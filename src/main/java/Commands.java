import java.awt.desktop.AppForegroundListener;
import java.util.Arrays;
import java.util.Scanner;

public class Commands {
    private String[] fullCommand;
    static Scanner scanner;

    Commands() {
        scanner = new Scanner(System.in);
    }

    private void next() {
        this.fullCommand = scanner.nextLine().split(" ", 2);
    }

    public void response() throws ApolloException {
        next();
        String instruction = this.fullCommand[0];
        Task newTask;
        switch (instruction.toLowerCase()) {
            case "":
                response();
                break;
            case "bye":
                Apollo.stop();
                break;
            case "list":
                Apollo.printList();
                response();
                break;
            case "mark":
                if (this.fullCommand.length == 1) {
                    throw new ApolloException("Please specify which task to mark as done. \n" +
                            "  mark <task number>");
                }
                Apollo.mark(Integer.parseInt(this.fullCommand[1]), true);
                response();
                break;
            case "unmark":
                if (this.fullCommand.length == 1) {
                    throw new ApolloException("Please specify which task to mark as not done yet. \n" +
                            "  unmark <task number>");
                }
                Apollo.mark(Integer.parseInt(this.fullCommand[1]), false);
                response();
                break;
            case "todo":
                if (this.fullCommand.length == 1) {
                    throw new ApolloException("Please specify the description of the task. \n" +
                            "  todo <description>");
                }
                newTask = new Todo(this.fullCommand[1]);
                Apollo.addTask(newTask);
                response();
                break;
            case "deadline":
                if (this.fullCommand.length == 1) {
                    throw new ApolloException("Please specify the description and deadline of the task. \n" +
                            "  deadline <description> /by <time>");
                }
                String[] descTime = this.fullCommand[1].split(" */[Bb][Yy] *", 2);
                if (descTime.length == 1) {
                    throw new ApolloException("Please add the time this task is due with:\n  /by <time>");
                }
                newTask = new Deadline(descTime[0], descTime[1]);
                Apollo.addTask(newTask);
                response();
                break;
            case "event":
                if (this.fullCommand.length == 1) {
                    throw new ApolloException("Please specify the description and period of the task. \n" +
                            "  event <description> /at <period>");
                }
                String[] descPeriod = this.fullCommand[1].split(" */[Aa][Tt] *", 2);
                if (descPeriod.length == 1) {
                    throw new ApolloException("Please add the period this task happens with:\n  /at <period>");
                }
                newTask = new Event(descPeriod[0], descPeriod[1]);
                Apollo.addTask(newTask);
                response();
                break;
            default:
                throw new ApolloException("Apologies, I do not understand that. ");
        }
    }
}

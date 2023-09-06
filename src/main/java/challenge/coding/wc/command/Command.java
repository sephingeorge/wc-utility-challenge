package challenge.coding.wc.command;

public abstract class Command {

    Command next;

    public abstract void execute() throws Exception;

    public Command next() {
        return this.next;
    }

    public void setNext(Command next) {
        this.next = next;
    }
}

package challenge.coding.wc.command;

import challenge.coding.wc.display.DisplayMessage;

public class FileNamePrintCommand extends Command{
    private final String inputPath;

    public FileNamePrintCommand(String inputPath) {
        super();
        this.next = null;
        this.inputPath = inputPath;
    }

    @Override
    public void execute() throws Exception {
        DisplayMessage.displayName(inputPath);
    }

    
}

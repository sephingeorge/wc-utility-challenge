package challenge.coding.wc.command;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import challenge.coding.wc.display.DisplayMessage;

public class BytesLengthCommand extends Command {

    private final String inputPath;

    public BytesLengthCommand(String inputPath, Command nextCommand) {
        super();
        this.next = nextCommand;
        this.inputPath = inputPath;
    }

    public BytesLengthCommand(String inputPath) {
        super();
        this.inputPath = inputPath;
    }

    @Override
    public void execute() throws Exception {
        Path path = Paths.get(inputPath);
        byte[] file = Files.readAllBytes(path);
        DisplayMessage.displayResult(file.length);
    }

}

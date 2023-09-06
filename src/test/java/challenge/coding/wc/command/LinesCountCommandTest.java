package challenge.coding.wc.command;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import challenge.coding.wc.display.DisplayMessage;

class LinesCountCommandTest {

    private LinesCountCommand linesCountCommand;

    @BeforeEach
    public void setUp() {
        linesCountCommand = new LinesCountCommand("test.txt", null);
    }

    @Test
    void testExecute() throws Exception {
        Path testFilePath = Paths.get("test.txt");
        byte[] testData = "Hello, world!\nThis is a test.".getBytes();
        Files.write(testFilePath, testData);
        // Execute the command
        assertDoesNotThrow(() -> linesCountCommand.execute());
        // Clean up the test file
        Files.delete(testFilePath);
    }
}

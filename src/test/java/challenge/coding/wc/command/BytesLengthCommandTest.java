package challenge.coding.wc.command;

import org.junit.jupiter.api.Test;

import challenge.coding.wc.display.DisplayMessage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BytesLengthCommandTest {

    private BytesLengthCommand bytesLengthCommand;

    @BeforeEach
    void setUp() {
        bytesLengthCommand = new BytesLengthCommand("test.txt", null);
    }

    @AfterEach
    void tearDown() {
        bytesLengthCommand = null;
    }

    @Test
    void testExecute() throws Exception {
        // Create a temporary test file with known content
        Path testFilePath = Paths.get("test.txt");
        byte[] testData = "Hello, World!".getBytes();
        Files.write(testFilePath, testData);

        // DisplayMessage.setInstance(displayMessage);

        // Execute the command
        assertDoesNotThrow(()->bytesLengthCommand.execute());

        // Clean up the test file
        Files.delete(testFilePath);
    }

    @Test
    void testExecuteWithNonExistentFile() {
        // Test with a non-existent file
        bytesLengthCommand = new BytesLengthCommand("nonexistent.txt", null);

        // Execute the command and expect an exception
        assertThrows(IOException.class, () -> bytesLengthCommand.execute());
    }
}

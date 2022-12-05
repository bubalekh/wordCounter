package handlers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class InputFileTest {

    InputFile inputFile;
    @Test
    void check_no_file() {
        new File("31313jk1k3jl1k3j.txt").delete();
        assertThrows(FileNotFoundException.class, () -> inputFile = new InputFileImpl("31313jk1k3jl1k3j.txt"));
    }

    @Test
    void check_file_exist() {
        try (FileWriter fileWriter = new FileWriter("test.txt")) {
            inputFile = new InputFileImpl("test.txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        finally {
            new File("test.txt").delete();
        }
    }

    @ParameterizedTest
    @NullSource
    void check_null_path(String source) {
        assertThrows(NullPointerException.class, () -> inputFile = new InputFileImpl(source));
    }

    @ParameterizedTest
    @EmptySource
    void check_empty_path(String source) {
        assertThrows(FileNotFoundException.class, () -> inputFile = new InputFileImpl(source));
    }

    @Test
    void check_valid_payload() {
        try (FileWriter fileWriter = new FileWriter("test.txt")) {
            String testString = "Возле стола стоял стул. Стул стоял возле стола";
            fileWriter.append(testString);
            fileWriter.close();
            String testData = new InputFileImpl("test.txt")
                    .getInputFileLinesAsStream()
                    .reduce(Objects::toString)
                    .get();
            assertEquals(testString, testData);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        finally {
            new File("test.txt").delete();
        }
    }
}
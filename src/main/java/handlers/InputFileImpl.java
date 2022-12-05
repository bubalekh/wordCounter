package handlers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import java.util.stream.Stream;

public class InputFileImpl implements InputFile {
    private final BufferedReader bufferedReader;

    public InputFileImpl(String filename) throws FileNotFoundException {
        this.bufferedReader = new BufferedReader(new FileReader(filename));
    }

    @Override
    public Stream<String> getInputFileLinesAsStream() {
        return this.bufferedReader.lines();
    }
}

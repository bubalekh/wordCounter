package handlers;

import java.util.stream.Stream;

public interface InputFile {
    Stream<String> getInputFileLinesAsStream();
}

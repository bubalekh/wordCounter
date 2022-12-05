import handlers.InputFile;
import handlers.InputFileImpl;
import handlers.WordCounter;
import handlers.WordCounterImpl;

import java.io.FileNotFoundException;

public class Application {
    public static void main(String[] args) throws FileNotFoundException {
        if (args.length == 0) {
            System.out.println("Пример использования: java -jar target/wordCounter-jar-with-dependencies.jar [PATH] options");
            throw new FileNotFoundException("Не указан путь к файлу!");
        }
        InputFile fileWrapper = new InputFileImpl(args[0]);
        WordCounter wordCounter;
        if (args.length == 1) {
            System.out.println("Не указан тип сортировки. По умолчанию сортировка не применяется.\nВозможные варианты сорировки:\na - лексикографическая,\nc - хронологическая");
            System.out.println("Пример вызова с лексикографической сортировкой: java -jar target/wordCounter-jar-with-dependencies.jar input.txt a\n");
            wordCounter = new WordCounterImpl('d', fileWrapper.getInputFileLinesAsStream());
        }
        else {
            wordCounter = new WordCounterImpl(args[1].charAt(0), fileWrapper.getInputFileLinesAsStream());
        }
        System.out.println(wordCounter.getWords());
    }
}

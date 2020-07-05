package pro.sisit.javacourse.unit7.shell;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import pro.sisit.javacourse.unit7.data.JokeDataService;
import pro.sisit.javacourse.unit7.web.JokeService;

import java.util.stream.Collectors;

@ShellComponent
public class JokeShellCommands {
    private final JokeService jokeService;
    private final JokeDataService jokeDataService;

    public JokeShellCommands(JokeService jokeService, JokeDataService jokeDataService) {
        this.jokeService = jokeService;
        this.jokeDataService = jokeDataService;
    }

    private String lastJoke;

    @ShellMethod("Get joke!")
    public String joke() {
        lastJoke = jokeService.getJoke();
        return lastJoke;

    }

    @ShellMethod("Save jokes in database!")
    public String save() {
        if (lastJoke == null) {
            return "Сначала загрузите шутку";
        } else {
            jokeDataService.save(lastJoke);
            return "Шутка сохранена";
        }
    }

    @ShellMethod("Show all jokes!")
    public String show() {
        return jokeDataService.findAll().stream().collect(Collectors.joining(System.lineSeparator()));
    }
}

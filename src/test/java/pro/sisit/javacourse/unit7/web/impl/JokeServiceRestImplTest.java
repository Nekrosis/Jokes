package pro.sisit.javacourse.unit7.web.impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.shell.jline.InteractiveShellApplicationRunner;
import org.springframework.shell.jline.ScriptShellApplicationRunner;
import pro.sisit.javacourse.unit7.web.JokeService;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(properties = {
        InteractiveShellApplicationRunner
        .SPRING_SHELL_INTERACTIVE_ENABLED + "false",
        ScriptShellApplicationRunner
                .SPRING_SHELL_SCRIPT_ENABLED + "false"})
class JokeServiceRestImplTest {
    @Autowired
    private JokeService jokeService;

    @Test
    void getJoke() {
        String joke = jokeService.getJoke();
        assertNotNull(joke);
        assertTrue(joke.contains("Chuck Norris"));
        System.out.println(joke);

    }
}
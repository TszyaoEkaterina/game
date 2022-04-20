import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class GameTest {
    Game game = new Game();
    Player first = new Player(1, "Tom", 100);
    Player second = new Player(2, "Smith", 50);
    Player third = new Player(3, "Mike", 100);
    Player forth = new Player(4, "Chris", 150);
    
    @BeforeEach
    void addPlayers() {
        game.register(first);
        game.register(second);
        game.register(third);
    }
    
    @Test
    void shouldThrowExceptionIfRoundNotRegisteredPlayer1() {
        assertThrows(NotRegisteredException.class, () -> {game.round("John", "Mike");});
    }
    @Test
    void shouldThrowExceptionIfRoundNotRegisteredPlayer2() {
        assertThrows(NotRegisteredException.class, () -> {game.round("Tom", "John");});
    }
    @Test
    void shouldReturn1WhenPlayer1Stronger(){
        game.register(forth);
        int actual= game.round("Chris","Mike");
        int expected = 1;
        assertEquals(expected,actual);
    }
    @Test
    void shouldReturn2WhenPlayer2Stronger(){
        int actual= game.round("Smith","Tom");
        int expected = 2;
        assertEquals(expected,actual);
    }
    @Test
    void shouldReturn0WhenPlayersEquallyStrong(){
        int actual= game.round("Tom","Mike");
        int expected = 0;
        assertEquals(expected,actual);
    }
    @Test
    void shouldThrowExceptionIfRoundWithYourself() {
        assertThrows(RuntimeException.class, () -> {game.round("Tom", "Tom");});
    }
}
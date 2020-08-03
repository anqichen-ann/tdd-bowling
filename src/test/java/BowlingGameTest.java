import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class BowlingGameTest {
    BowlingGame bowlinggame = new BowlingGame();
    @Test
    void should_calculate_count(){
        Integer score[] = {1,4,4,5,6,4,5,5,10,0,1,7,3,6,4,10,2,8,6};
        int result = bowlinggame.count(score);
        assertEquals(133,result);
    }

    @Test
    void should_throw_exception_when_input_not_regular() {
        Integer score[] = {1,11,4,5,6,4,5,5,10,0,1,7};
        assertThrows(RuntimeException.class, () -> {
            bowlinggame.count(score);
        });
    }
}

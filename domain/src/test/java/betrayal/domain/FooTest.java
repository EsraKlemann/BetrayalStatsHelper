package betrayal.domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import betrayal.domain.Foo;


public class FooTest {
   
    @Test 
    public void aNormalBorlStartsWith4Stones() {
        Foo foo = new Foo();
        assertEquals(41, foo.theAnswerToLifeTheUniverseAndEverything());
    }
}

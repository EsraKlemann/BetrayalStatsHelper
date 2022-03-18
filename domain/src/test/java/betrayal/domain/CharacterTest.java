package betrayal.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CharacterTest {

    @Test
    public void aCharacterHasAName() {
        Character one = new Character("esra", 12);
        assertEquals("esra", one.getName());
    }

    @Test
    public void aCharacterHasAnAge() {
        Character one = new Character("esra", 29);
        assertEquals(29, one.getAge());
    }

    @Test
    public void aCharacterHasASpeedTrait() {
        Character one = new Character("esra", 12);
        assertEquals(4, one.getSpeed());
    }

    @Test
    public void aCharacterHasAMightTrait() {
        Character one = new Character("esra", 12);
        assertEquals(4, one.getMight());
    }

    @Test
    public void aCharacterHasASanityTrait() {
        Character one = new Character("esra", 12);
        assertEquals(4, one.getSanity());
    }

    @Test
    public void aCharacterHasAKnowledgeTrait() {
        Character one = new Character("esra", 12);
        assertEquals(4, one.getKnowledge());
    }

}

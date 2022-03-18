package betrayal.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CharacterTest {

    @Test
    public void aCharacterHasAName() {
        Character one = new Character("esra", 12, null, 0);
        assertEquals("esra", one.getName());
    }

    @Test
    public void aCharacterHasAnAge() {
        Character one = new Character("esra", 29, null, 0);
        assertEquals(29, one.getAge());
    }

    @Test
    public void aCharacterHasASpeedTrait() {
        int[] speedStats = { 4 };
        Character one = new Character("esra", 12, speedStats, 0);
        assertEquals(4, one.getSpeed(0));
    }

    @Test
    public void aCharacterHasAMightTrait() {
        Character one = new Character("esra", 12, null, 0);
        assertEquals(4, one.getMight());
    }

    @Test
    public void aCharacterHasASanityTrait() {
        Character one = new Character("esra", 12, null, 0);
        assertEquals(4, one.getSanity());
    }

    @Test
    public void aCharacterHasAKnowledgeTrait() {
        Character one = new Character("esra", 12, null, 0);
        assertEquals(4, one.getKnowledge());
    }

    @Test
    public void aCharacterCanHaveDifferentSpeeds() {
        int[] speedStats = { 1, 2, 4 };
        Character one = new Character("esra", 12, speedStats, 0);
        assertEquals(2, one.getSpeed(1));
    }

    @Test
    public void aCharacterHasASetStarterSpeed() {
        int[] speedStats = { 1, 2, 4 };
        int defaultSpIndex = 2;
        Character one = new Character("esra", 12, speedStats, defaultSpIndex);
        assertEquals(4, one.getDefaultSpeed(defaultSpIndex));
    }

}

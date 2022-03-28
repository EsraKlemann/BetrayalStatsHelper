package betrayal.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CharacterTest {

    // Character cat = new Character("Ivy", age, speedStats, defaultSpIndex,
    // mightStats, defaultMiIndex, sanityStats, defaultSaIndex, knowledgeStats,
    // defaultKnIndex)

    @Test
    public void aCharacterHasAName() {
        Character cat = new Character("Ivy", 6, null, 0, null, 0, null, 0, null, 0);
        assertEquals("Ivy", cat.getName());
    }

    @Test
    public void aCharacterHasAnAge() {
        Character cat = new Character("Ivy", 6, null, 0, null, 0, null, 0, null, 0);
        assertEquals(6, cat.getAge());
    }

    @Test
    public void aCharacterCanGiveItsSpeedTrait() {
        int[] speedStats = { 4, 5 };
        Character cat = new Character("Ivy", 6, speedStats, 0, null, 0, null, 0, null, 0);
        assertEquals(4, cat.getSpeed(0));
        assertEquals(5, cat.getSpeed(1));
        assertArrayEquals(speedStats, cat.getSpeedStats());
    }

    @Test
    public void aCharacterCanGiveItsMightTrait() {
        int[] mightStats = { 9, 10 };
        Character cat = new Character("Ivy", 6, null, 0, mightStats, 0, null, 0, null, 0);
        assertEquals(9, cat.getMight(0));
        assertEquals(10, cat.getMight(1));
        assertArrayEquals(mightStats, cat.getMightStats());
    }

    @Test
    public void aCharacterCanGiveItsSanityTrait() {
        int[] sanityStats = { 1, 3 };
        Character cat = new Character("Ivy", 6, null, 0, null, 0, sanityStats, 0, null, 0);
        assertEquals(1, cat.getSanity(0));
        assertEquals(3, cat.getSanity(1));
        assertArrayEquals(sanityStats, cat.getSanityStats());
    }

    @Test
    public void aCharacterCanGiveItsKnowledgeTrait() {
        int[] knowledgeStats = { 7, 6 };
        Character cat = new Character("Ivy", 6, null, 0, null, 0, null, 0, knowledgeStats, 0);
        assertEquals(7, cat.getKnowledge(0));
        assertEquals(6, cat.getKnowledge(1));
        assertArrayEquals(knowledgeStats, cat.getKnowledgeStats());
    }

    @Test
    public void aCharacterHasASetStarterSpeed() {
        int[] speedStats = { 1, 2, 4 };
        int defaultSpIndex = 2;
        Character cat = new Character("Ivy", 6, speedStats, defaultSpIndex, null, 0, null, 0, null, 0);
        assertEquals(2, cat.getDefaultSpIndex());
    }

    @Test
    public void aCharacterHasASetStarterMight() {
        int[] speedStats = { 1, 2, 4 };
        int defaultSpIndex = 2;
        int[] mightStats = { 8, 9, 10 };
        int defaultMiIndex = 1;
        Character cat = new Character("Ivy", 6, speedStats, defaultSpIndex, mightStats, defaultMiIndex, null, 0, null,
                0);
        assertEquals(1, cat.getDefaultMiIndex());
    }

    @Test
    public void aCharacterHasASetStarterSanity() {
        int[] speedStats = { 1, 2, 4 };
        int defaultSpIndex = 2;
        int[] mightStats = { 8, 9, 10 };
        int defaultMiIndex = 1;
        int[] sanityStats = { 5, 4, 7 };
        int defaultSaIndex = 2;
        Character cat = new Character("Ivy", 6, speedStats, defaultSpIndex, mightStats, defaultMiIndex, sanityStats,
                defaultSaIndex, null, 0);
        assertEquals(2, cat.getDefaultSaIndex());
    }

    @Test
    public void aCharacterHasASetStarterKnowledge() {
        int[] speedStats = { 1, 2, 4 };
        int defaultSpIndex = 2;
        int[] mightStats = { 8, 9, 10 };
        int defaultMiIndex = 1;
        int[] sanityStats = { 5, 4, 7 };
        int defaultSaIndex = 2;
        int[] knowledgeStats = { 3, 4, 6 };
        int defaultKnIndex = 0;
        Character cat = new Character("Ivy", 6, speedStats, defaultSpIndex, mightStats, defaultMiIndex, sanityStats,
                defaultSaIndex, knowledgeStats, defaultKnIndex);
        assertEquals(0, cat.getDefaultKnIndex());
    }

}

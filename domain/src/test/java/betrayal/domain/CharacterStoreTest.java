package betrayal.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CharacterStoreTest {
    @Test
    public void aCharacterHasAName() {
        CharacterStore cs = new CharacterStore(new Character[] {
                new Character("Ivy", 6, new int[] { 2, 3, 4, 5}, 1, new int[] { 3, 3, 4, 5}, 0, new int[] { 6, 4, 4, 5}, 1, new int[] { 2, 5, 6, 2}, 3)
        });

        assertEquals("Ivy", cs.getCharacterById(1).getName());
    }

    @Test
    public void aCharacterHasAnAge() {
        CharacterStore cs = new CharacterStore(new Character[] {
                new Character("Ivy", 6, new int[] { 2, 3, 4, 5}, 1, new int[] { 3, 3, 4, 5}, 0, new int[] { 6, 4, 4, 5}, 1, new int[] { 2, 5, 6, 2}, 3)
        });

        assertEquals(6, cs.getCharacterById(1).getAge());
    }

    @Test
    public void aCharacterHas8OfAllStats() {

    }

}

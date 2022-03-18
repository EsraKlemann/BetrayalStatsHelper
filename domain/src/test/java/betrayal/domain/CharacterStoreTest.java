package betrayal.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CharacterStoreTest {
    @Test
    public void tests() {
        CharacterStore cs = new CharacterStore(new Character[] {
                new Character("Emmy", 29, null, 0)
        });

        assertEquals("Emmy", cs.getCharacterById(1).getName());
    }

}

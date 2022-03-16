package betrayal.domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CharacterTest {
    
    @Test 
    public void aCharacterHasAName() {
        Character one = new Character();
        one.setName("esra");
        assertEquals("esra", one.getName());
    }

    @Test 
    public void aCharacterHasASpeedTrait() {
        Character one = new Character();
        
        assertEquals(4, one.getSpeed());
    }

    @Test 
    public void aCharacterHasAMightTrait() {
        Character one = new Character();
        
        assertEquals(4, one.getMight());
    }

    @Test 
    public void aCharacterHasASanityTrait() {
        Character one = new Character();
        
        assertEquals(4, one.getSanity());
    }

    @Test 
    public void aCharacterHasAKnowledgeTrait() {
        Character one = new Character();
        
        assertEquals(4, one.getKnowledge());
    }


}

package betrayal.api.models;

import betrayal.domain.Character;

public class CharacterStatusDTO {

    private final String name;
    private final int age;

    public CharacterStatusDTO(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public static CharacterStatusDTO fromCharacter(Character c) {
        return new CharacterStatusDTO(c.getName(), c.getAge());
    }
}

package betrayal.domain;

public class Character {

    private static Character[] characters = new Character[] {
            new Character("Father Rhinehardt", 66),
            new Character("Professor Longfellow", 80)
    };

    private final String name;
    private final int age;

    public Character(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public static Character getCharacterById(int id) {
        return characters[id - 1];
    }
}

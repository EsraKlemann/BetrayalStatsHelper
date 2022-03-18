package betrayal.domain;

public class CharacterStore {

    private final Character[] characters;

    public CharacterStore(Character[] characters) {
        this.characters = characters;
    }

    public Character getCharacterById(int id) {
        return characters[id - 1];
    }

    public static final CharacterStore characterStore = new CharacterStore(new Character[] {
            new Character("Father Rhinehardt", 66),
            new Character("Professor Longfellow", 80),
            new Character("Peter Akimoto", 13),
            new Character("Brandon Jaspers", 12),
            new Character("Jenny LeClerc", 21),
            new Character("Heather Granville", 18),
            new Character("Vivian Lopez", 42),
            new Character("Madame Zostra", 37),
            new Character("Darrin 'Flash' Williams", 20),
            new Character("Ox Bellows", 20),
            new Character("Zoe Ingstrom", 8),
            new Character("Missy Dubourde", 9)
    });

    // CharacterStore.characterStore.getCharacterById()
}

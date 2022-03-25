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
            new Character("Father Rhinehardt", 66, new int[] { 2, 3, 3, 4, 5, 6, 7, 7 }, 2,
                    new int[] { 1, 2, 2, 4, 4, 5, 5, 7 }, 2, new int[] { 3, 4, 5, 5, 6, 7, 7, 8 }, 4,
                    new int[] { 1, 3, 3, 4, 5, 6, 6, 8 }, 3),
            new Character("Professor Longfellow", 80, new int[] { 2, 2, 4, 4, 5, 5, 6, 6 }, 2,
                    new int[] { 1, 2, 3, 4, 5, 5, 6, 6 }, 3, new int[] { 1, 3, 3, 4, 5, 5, 6, 7 }, 2,
                    new int[] { 4, 5, 5, 5, 5, 6, 7, 8 }, 4),
            new Character("Peter Akimoto", 13, new int[] { 3, 3, 3, 4, 6, 6, 7, 7 }, 3,
                    new int[] { 2, 3, 3, 4, 5, 5, 6, 8 }, 2, new int[] { 3, 4, 4, 4, 5, 6, 6, 7 }, 3,
                    new int[] { 3, 4, 4, 5, 6, 7, 7, 8 }, 2),
            new Character("Brandon Jaspers", 12, new int[] { 3, 4, 4, 4, 5, 6, 7, 8 }, 2,
                    new int[] { 2, 3, 3, 4, 5, 6, 6, 7 }, 3, new int[] { 3, 3, 3, 4, 5, 6, 7, 8 }, 3,
                    new int[] { 1, 3, 3, 5, 5, 6, 6, 7 }, 2),
            new Character("Jenny LeClerc", 21, new int[] { 2, 3, 4, 4, 4, 5, 6, 8 }, 3,
                    new int[] { 3, 4, 4, 4, 4, 5, 6, 8 }, 2, new int[] { 1, 1, 2, 4, 4, 4, 5, 6 }, 3,
                    new int[] { 2, 3, 3, 4, 4, 5, 6, 8 }, 2),
            new Character("Heather Granville", 18, new int[] { 3, 3, 4, 5, 6, 6, 7, 8 }, 2,
                    new int[] { 3, 3, 3, 4, 5, 6, 7, 8 }, 2, new int[] { 3, 3, 3, 4, 5, 6, 6, 6 }, 2,
                    new int[] { 2, 3, 3, 4, 5, 6, 7, 8 }, 4),
            new Character("Vivian Lopez", 42, new int[] { 3, 4, 4, 4, 4, 6, 7, 8 }, 3,
                    new int[] { 2, 2, 2, 4, 4, 5, 6, 6 }, 2, new int[] { 4, 4, 4, 5, 6, 7, 8, 8 }, 2,
                    new int[] { 4, 5, 5, 5, 5, 6, 6, 7 }, 3),
            new Character("Madame Zostra", 37, new int[] { 2, 3, 3, 5, 5, 6, 6, 7 }, 2,
                    new int[] { 2, 3, 3, 4, 5, 5, 5, 6 }, 3, new int[] { 4, 4, 4, 5, 6, 7, 8, 8 }, 2,
                    new int[] { 1, 3, 4, 4, 4, 5, 6, 6 }, 3),
            new Character("Darrin 'Flash' Williams", 20, new int[] { 4, 4, 4, 5, 6, 7, 7, 8 }, 4,
                    new int[] { 2, 3, 3, 4, 5, 6, 6, 7 }, 2, new int[] { 1, 2, 3, 4, 5, 5, 5, 7 }, 2,
                    new int[] { 2, 3, 3, 4, 5, 5, 5, 7 }, 2),
            new Character("Ox Bellows", 20, new int[] { 2, 2, 2, 3, 4, 5, 5, 6 }, 4,
                    new int[] { 4, 5, 5, 6, 6, 7, 8, 8 }, 2, new int[] { 2, 2, 3, 4, 5, 5, 6, 7 }, 2,
                    new int[] { 2, 2, 3, 3, 5, 5, 6, 6 }, 2),
            new Character("Zoe Ingstrom", 8, new int[] { 4, 4, 4, 4, 5, 6, 8, 8 }, 3,
                    new int[] { 2, 2, 3, 3, 4, 4, 6, 7 }, 3, new int[] { 3, 4, 5, 5, 6, 6, 7, 8 }, 2,
                    new int[] { 1, 2, 3, 4, 4, 5, 5, 5 }, 2),
            new Character("Missy Dubourde", 9, new int[] { 3, 4, 5, 6, 6, 6, 7, 7, }, 2,
                    new int[] { 2, 3, 3, 3, 4, 5, 6, 7 }, 3, new int[] { 1, 2, 3, 4, 5, 5, 6, 7 }, 2,
                    new int[] { 2, 3, 4, 4, 5, 6, 6, 6 }, 2)
    });

    // CharacterStore.characterStore.getCharacterById()
}

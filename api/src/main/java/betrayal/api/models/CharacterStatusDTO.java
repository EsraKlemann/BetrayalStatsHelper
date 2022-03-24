package betrayal.api.models;

import betrayal.domain.Character;
import betrayal.domain.CharacterStore;

public class CharacterStatusDTO {

    private final String name;
    private final int age;
    private final int[] defaultSpIndex;
    private final int[] defaultMiIndex;
    private final int[] defaultSaIndex;
    private final int[] defaultKnIndex;

    private final int[] speedStats;
    private final int[] mightStats;
    private final int[] sanityStats;
    private final int[] knowledgeStats;

    public CharacterStatusDTO(String name, int age, int[] speedStats, int defaultSpIndex, int[] mightStats,
            int defaultMiIndex, int[] sanityStats, int defaultSaIndex, int[] knowledgeStats, int defaultKnIndex) {
        this.name = name;
        this.age = age;
        this.speedStats = speedStats;
        this.defaultSpIndex = new int[] { defaultSpIndex };
        this.mightStats = mightStats;
        this.defaultMiIndex = new int[] { defaultMiIndex };
        this.sanityStats = sanityStats;
        this.defaultSaIndex = new int[] { defaultSaIndex };
        this.knowledgeStats = knowledgeStats;
        this.defaultKnIndex = new int[] { defaultKnIndex };
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int[] getSpeedStats() {
        return speedStats;
    }

    public int[] getDefaultSpIndex() {
        return defaultSpIndex;
    }

    public int[] getMightStats() {
        return mightStats;
    }

    public int[] getDefaultMiIndex() {
        return defaultMiIndex;
    }

    public int[] getSanityStats() {
        return sanityStats;
    }

    public int[] getDefaultSaIndex() {
        return defaultSaIndex;
    }

    public int[] getKnowledgeStats() {
        return knowledgeStats;
    }

    public int[] getDefaultKnIndex() {
        return defaultKnIndex;
    }

    public static CharacterStatusDTO fromCharacter(Character c) {
        return new CharacterStatusDTO(c.getName(), c.getAge(), c.getSpeedStats(), c.getDefaultSpIndex(),
                c.getMightStats(), c.getDefaultMiIndex(), c.getSanityStats(), c.getDefaultSaIndex(),
                c.getKnowledgeStats(), c.getDefaultKnIndex());
    }
}

package betrayal.domain;

public class Character {

    private final String name;
    private final int age;
    private final int defaultSpIndex;
    private final int defaultMiIndex;
    private final int defaultSaIndex;
    private final int defaultKnIndex;

    private final int[] speedStats;
    private final int[] mightStats;
    private final int[] sanityStats;
    private final int[] knowledgeStats;

    public Character(String name, int age, int[] speedStats, int defaultSpIndex, int[] mightStats, int defaultMiIndex,
            int[] sanityStats, int defaultSaIndex, int[] knowledgeStats, int defaultKnIndex) {
        this.name = name;
        this.age = age;
        this.speedStats = speedStats;
        this.defaultSpIndex = defaultSpIndex;
        this.mightStats = mightStats;
        this.defaultMiIndex = defaultMiIndex;
        this.sanityStats = sanityStats;
        this.defaultSaIndex = defaultSaIndex;
        this.knowledgeStats = knowledgeStats;
        this.defaultKnIndex = defaultKnIndex;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getSpeed(int index) {
        return speedStats[index];
    }

    public int getDefaultSpIndex() {
        return defaultSpIndex;
    }

    public int[] getSpeedStats() {
        return speedStats;
    }

    public int getMight(int index) {
        return mightStats[index];
    }

    public int getDefaultMiIndex() {
        return defaultMiIndex;
    }

    public int[] getMightStats() {
        return mightStats;
    }

    public int getSanity(int index) {
        return sanityStats[index];
    }

    public int getDefaultSaIndex() {
        return defaultSaIndex;
    }

    public int[] getSanityStats() {
        return sanityStats;
    }

    public int getKnowledge(int index) {
        return knowledgeStats[index];
    }

    public int getDefaultKnIndex() {
        return defaultKnIndex;
    }

    public int[] getKnowledgeStats() {
        return knowledgeStats;
    }

}

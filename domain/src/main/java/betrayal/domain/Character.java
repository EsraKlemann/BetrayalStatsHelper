package betrayal.domain;

public class Character {

    private final String name;
    private final int age;
    private final int defaultSpIndex;

    private final int[] speedStats;

    public Character(String name, int age, int[] speedStats, int defaultSpIndex) {
        this.name = name;
        this.age = age;
        this.speedStats = speedStats;
        this.defaultSpIndex = defaultSpIndex;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Integer getSpeed(int index) {
        return speedStats[index];
    }

    public int getDefaultSpIndex() {
        return defaultSpIndex;
    }

    public Integer getDefaultSpeed(int defaultSpIndex) {
        return speedStats[defaultSpIndex];
    }

    public Integer getMight() {
        return 4;
    }

    public Integer getSanity() {
        return 4;
    }

    public Integer getKnowledge() {
        return 4;
    }

}

package betrayal.api.models;

public class CharacterSaveDTO {

    private String name;
    private int age;
    private int[] speedIndex;
    private int[] mightIndex;
    private int[] sanityIndex;
    private int[] knowledgeIndex;

    private int[] speedStats;
    private int[] mightStats;
    private int[] sanityStats;
    private int[] knowledgeStats;

    private int originalID;
    private String userName;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getOriginalID() {
        return originalID;
    }

    public void setOriginalID(int originalID) {
        this.originalID = originalID;
    }

    public int[] getKnowledgeStats() {
        return knowledgeStats;
    }

    public void setKnowledgeStats(int[] knowledgeStats) {
        this.knowledgeStats = knowledgeStats;
    }

    public int[] getSanityStats() {
        return sanityStats;
    }

    public void setSanityStats(int[] sanityStats) {
        this.sanityStats = sanityStats;
    }

    public int[] getMightStats() {
        return mightStats;
    }

    public void setMightStats(int[] mightStats) {
        this.mightStats = mightStats;
    }

    public int[] getSpeedStats() {
        return speedStats;
    }

    public void setSpeedStats(int[] speedStats) {
        this.speedStats = speedStats;
    }

    public int[] getKnowledgeIndex() {
        return knowledgeIndex;
    }

    public void setKnowledgeIndex(int[] knowledgeIndex) {
        this.knowledgeIndex = knowledgeIndex;
    }

    public int[] getSanityIndex() {
        return sanityIndex;
    }

    public void setSanityIndex(int[] sanityIndex) {
        this.sanityIndex = sanityIndex;
    }

    public int[] getMightIndex() {
        return mightIndex;
    }

    public void setMightIndex(int[] mightIndex) {
        this.mightIndex = mightIndex;
    }

    public int[] getSpeedIndex() {
        return speedIndex;
    }

    public void setSpeedIndex(int[] speedIndex) {
        this.speedIndex = speedIndex;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }
}

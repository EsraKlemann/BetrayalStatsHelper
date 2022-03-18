package betrayal.domain;

public class Character {

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

    public Integer getSpeed() {
        return 4;
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

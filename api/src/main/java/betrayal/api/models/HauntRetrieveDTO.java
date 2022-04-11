package betrayal.api.models;

public class HauntRetrieveDTO {

    // private value key
    private String haunt;
    private String survivalStory;
    private String traitorStory;

    public HauntRetrieveDTO() {
    };

    public HauntRetrieveDTO(String haunt, String survivalStory, String traitorStory) {
        this.setHaunt(haunt);
        this.setSurvivalStory(survivalStory);
        this.setTraitorStory(traitorStory);
    }

    public String getTraitorStory() {
        return traitorStory;
    }

    public void setTraitorStory(String traitorStory) {
        this.traitorStory = traitorStory;
    }

    public String getSurvivalStory() {
        return survivalStory;
    }

    public void setSurvivalStory(String survivalStory) {
        this.survivalStory = survivalStory;
    }

    public String getHaunt() {
        return haunt;
    }

    public void setHaunt(String haunt) {
        this.haunt = haunt;
    }
}

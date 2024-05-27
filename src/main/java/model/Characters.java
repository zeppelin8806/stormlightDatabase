package model;

public class Characters {

    private int characterId;
    private String name;
    private String gender;
    private String nationality;
    private int locationId;

    public Characters(){

    }

    public Characters(int characterId, String name, String gender, String nationality, int locationId) {
        this.characterId = characterId;
        this.name = name;
        this.gender = gender;
        this.nationality = nationality;
        this.locationId = locationId;
    }

    public int getCharacterId() {
        return characterId;
    }

    public void setCharacterId(int characterId) {
        this.characterId = characterId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    @Override
    public String toString(){
        return "characters{" +
                "character_id = " + characterId +
                ", name = '" + name + '\'' +
                ", gender = '" + gender + '\'' +
                ", nationality = '" + gender +'\'' +
                ", location_id = '" + locationId + '\'' +
                '}';
    }
}

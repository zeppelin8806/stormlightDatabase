package model;

public class Shards {
    private int shardbladeId;
    private String shardbladeName;
    private String shardbladeType;
    private int characterId;

    public Shards(){

    }

    public Shards(int shardbladeId, String shardbladeName, String shardbladeType, int characterId) {
        this.shardbladeId = shardbladeId;
        this.shardbladeName = shardbladeName;
        this.shardbladeType = shardbladeType;
        this.characterId = characterId;
    }

    public int getShardbladeId() {
        return shardbladeId;
    }

    public void setShardbladeId(int shardbladeId) {
        this.shardbladeId = shardbladeId;
    }

    public String getShardbladeName() {
        return shardbladeName;
    }

    public void setShardbladeName(String shardbladeName) {
        this.shardbladeName = shardbladeName;
    }

    public String getShardbladeType() {
        return shardbladeType;
    }

    public void setShardbladeType(String shardbladeType) {
        this.shardbladeType = shardbladeType;
    }

    public int getCharacterId() {
        return characterId;
    }

    public void setCharacterId(int characterId) {
        this.characterId = characterId;
    }

    @Override
    public String toString(){
        return "shards{" +
                "shardblade_id = " + shardbladeId +
                ", shardblade_name = '" + shardbladeName + '\'' +
                ", shardblade_Type = '" + shardbladeType + '\'' +
                ", character_id = '" + characterId +'\'' +
                '}';
    }
}

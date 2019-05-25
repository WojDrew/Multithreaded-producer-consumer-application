package game.settlers;

public enum Settlers {
    MINER,
    LUMBERMAN,
    FARMER,
    SMITH,
    BAKER,
    CARPENTER;

    public String getTypeOfGood(){
        switch (this){
            case MINER:
            case SMITH:
                return "Iron";
            case LUMBERMAN:
            case CARPENTER:
                return "Wood";
            case FARMER:
            case BAKER:
                return "Grain";
            default:
                return null;
        }
    }
}

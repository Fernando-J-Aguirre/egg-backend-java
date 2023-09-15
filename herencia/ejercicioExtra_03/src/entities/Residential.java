package entities;

public class Residential extends AlternativeAcc{
    private int roomsAmount;
    private boolean unionDiscount;
    private boolean sportsField;

    public Residential(String name, String address, String city, String manager,
                       boolean privateAcc, double squareMts, int roomsAmount, boolean unionDiscount, boolean sportsField) {
        super(name, address, city, manager, privateAcc, squareMts);
        this.roomsAmount = roomsAmount;
        this.unionDiscount = unionDiscount;
        this.sportsField = sportsField;
    }

    public int getRoomsAmount() {
        return roomsAmount;
    }

    public void setRoomsAmount(int roomsAmount) {
        this.roomsAmount = roomsAmount;
    }

    public boolean isUnionDiscount() {
        return unionDiscount;
    }

    public void setUnionDiscount(boolean unionDiscount) {
        this.unionDiscount = unionDiscount;
    }

    public boolean isSportsField() {
        return sportsField;
    }

    public void setSportsField(boolean sportsField) {
        this.sportsField = sportsField;
    }

    @Override
    public String toString() {
        return super.toString() +
                "roomsAmount=" + roomsAmount +
                ", unionDiscount=" + unionDiscount +
                ", sportsField=" + sportsField +
                '}';
    }
}

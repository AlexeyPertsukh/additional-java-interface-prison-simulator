package prog;

//охранник
public class Security extends Human implements Shootable {

    private String rank;

    public Security(String name, String lastName, String nation, String rang) {
        super(name, lastName, nation);
        this.rank = rang;

    }

    public String getRank() {
        return rank;
    }

    @Override
    public void info() {
        String strLive = (getIsAlive()) ? "жив" : "УМЕР";
        System.out.println("Охранник " + getName() + " " + getLastName() + ", " + getNation() + ", " + rank + ", " + strLive);
    }

}

package prog;

public class Prisoner extends Human {

    int prisonPeriod;   //срока заключения

    //заключенный
    public Prisoner(String name, String lastName, String nation, int prisonPeriod){
        super(name,lastName,nation);
        this.prisonPeriod = prisonPeriod;
    }

    @Override
    public void info() {
        String strLive = (getIsAlive()) ? "жив" : "УМЕР";
        System.out.println("Заключенный "+getName() + " " + getLastName() + ", " + getNation()+ ", срок "+ prisonPeriod +
                " лет, " + strLive);
    }


}

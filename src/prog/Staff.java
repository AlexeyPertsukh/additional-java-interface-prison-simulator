package prog;

//гражданский сотрудник
public class Staff extends Human{
    String work;

    public Staff(String name, String lastName, String nation, String work){
        super(name,lastName,nation);
        this.work = work;
    }


    @Override
    public void info() {
        String strLive = (getIsAlive()) ? "жив" : "УМЕР";
        System.out.println("Работник " + getName() + " " + getLastName() + ", " + getNation()+", " +
                work +  ", " + strLive);
    }
}

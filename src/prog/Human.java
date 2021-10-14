package prog;

public abstract class Human {
    private String name;
    private String lastName;
    private String nation;
    private boolean alive;


    public Human(){
        this("noname", "noname", "Ukraine");

    }

    public Human(String name, String lastName, String nation){
       this.name=name;
       this.lastName = lastName;
       this.nation = nation;
       this.alive = true;
    }

    public abstract void info();


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public boolean getIsAlive() {
        return alive;
    }

    public String getNation() {
        return nation;
    }


    public void death(){
        if(alive) {
            alive = false;
            System.out.println(name + " " + lastName + " убит");
        }
    }

}

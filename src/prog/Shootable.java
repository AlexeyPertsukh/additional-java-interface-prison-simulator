package prog;

//интерфейс стрельбы
public interface Shootable {

    default void  shoot(Human enemy){
        Human shooter = (Human)this;

        if(!enemy.getIsAlive()) {
            System.out.println("Стрельба по этому человеку не имеет смысла- он уже мертв");
            return;
        }

        if (shooter.getIsAlive()){
            System.out.println(shooter.getName() + " " + shooter.getLastName() + " cтреляет!");
            enemy.death();
        }else{
            System.out.println("Мертвые не могут стрелять ");
        }
    }
}

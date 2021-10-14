package prog;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Prison {
    Human[] humans  = new Human[7];  // массив. куда заносим всех обитателей тюрьмы: охранников, зеков и вольнонаемных - все они потомки класса Human
    Scanner sc;

    public void start()
    {
        sc =  new Scanner(System.in);
        int choiceCommand;

        humans[0] = new Prisoner("Иван","Иванов","США",15);
        humans[1] = new Prisoner("Стив","Джобс","Палестина", 30);
        humans[2] = new Prisoner("Марк","Цукерберг","Ирландия",20);
        humans[3] = new Security("Света","Деканат","Украина","майор");
        humans[4] = new Security("Дима","Полиновский","Украина","лейтенант");
        humans[5] = new Staff("Руслан","Петров","Мексика","уборщик");
        humans[6] = new Staff("Максим","Сидоров","Аргентина","водитель");

        prisonList();

        do {

            System.out.println();

            System.out.println("Команды: ");
            System.out.println("--------");
            System.out.println("100 - выход");
            System.out.println("101 - распечатать список людей в тюрьме");
            System.out.println("102 - подсчитать количество охранников, заключенных и гражданских сотрудников в тюрьме");
            System.out.println("103 - выстрелить (стрелять могут только люди с интерфейсом Shootable)");
            System.out.println();
            System.out.print("Введите команду: ");

            //если вместо числа вводится что-то другое, происходит исключение InputMismatchException
            try {
                choiceCommand = sc.nextInt();
            } catch (InputMismatchException e)
            {
                sc.nextLine();      //очищаем буфер Scanner
                choiceCommand = 0;
            }

            switch (choiceCommand){
                case 100:
                    System.out.println("Вы покидаете тюрьму. До скорых встреч!");
                    break;
                case 101:
                    prisonList();
                    break;
                case 102:
                    count();
                    break;
                case 103:
                    shoot();
                    break;
                default:
                    System.out.println("Неизвестная команда");
                    break;
            }

        }while (choiceCommand != 100);

    }

    //список тюрьмы
    public void prisonList(){
        System.out.println();
        System.out.println("Список людей в тюрьме");
        for (int i = 0; i < humans.length; i++) {
            System.out.print((i+1) + ". ");
            humans[i].info();
        }
    }

    //стрельба
    public void shoot() {

        int numShooter;
        int numKill;

        //если введут не цифры- отлавливаем исключение
        try {
            System.out.print("Введите номер стрелка: ");
            numShooter = sc.nextInt();
            numShooter--;

            System.out.print("Введите номер цели: ");
            numKill = sc.nextInt();
            numKill--;
        } catch (InputMismatchException e)
        {
            sc.nextLine();      //очищаем буфер Scanner
            System.out.println("Неправильный ввод данных");
            return;
        }

        if (numShooter >= humans.length || numKill >= humans.length ||
                numShooter < 0 || numKill < 0){
            System.out.println("Нет такого стрелка или нет такого заключенного ");
            return;
        }

        if (humans[numShooter] instanceof Shootable)
        {
            System.out.println();
            ((Shootable)humans[numShooter]).shoot(humans[numKill]);
            prisonList();
        } else
        {
            System.out.println("Этот человек не может стрелять");
        }
    }


    //подсчет
    public void count() {
        int cntPrisoner = 0;
        int cntPersonal = 0;
        int cntSecurity = 0;

        System.out.println();
        System.out.println("Подсчет людей в тюрьме по категориям. Считаем всех, живых и умерших");
        for (Human human : humans) {
            if (human instanceof Prisoner) {
                cntPrisoner++;
            } else if (human instanceof Security) {
                cntSecurity++;
            } else if (human instanceof Staff) {
                cntPersonal++;
            }
        }

        int total = cntSecurity + cntPrisoner + cntPersonal;

        System.out.println("Охранники: " + cntSecurity);
        System.out.println("Заключенные: " + cntPrisoner);
        System.out.println("Гражданские сотрудники: " + cntPersonal);
        System.out.println("Всего: " + total);
    }

}

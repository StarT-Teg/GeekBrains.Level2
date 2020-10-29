package lesson_1;

import lesson_1.obstacles.*;
import lesson_1.participants.*;
import java.util.ArrayList;

/* 3. Создайте два массива: с участниками и препятствиями, и заставьте всех участников пройти этот набор препятствий.
Если участник не смог пройти одно из препятствий, то дальше по списку он препятствий не идет.*/


public class Main {
    public static void main(String[] args) {

        ArrayList<Object> participants = new ArrayList<>();
        ArrayList<Object> obstacles = new ArrayList<>();

        // Создаём участников
        randomParticipantsCreator(participants);
        // Создаём препятсвия
        randomObstaclesCreator(obstacles);

            // Перебор участников
            for (Object participant : participants) {

                int winCounter = 0;

                System.out.println();
                System.out.println("Новый участник!");
                getInfo(participant);

                // Перебор препятсвий
                for (Object obstacle : obstacles) {

                    obstacleInfo(obstacle);

                    if (obstacle.getClass() == Wall.class) {

                        if (((Jump) participant).jump(((Wall) obstacle).getHeight())) {
                            winCounter++;
                            System.out.println("Участник преодолел препятсвие!");
                        } else {
                            break;
                        }

                    } else if (obstacle.getClass() == Treadmill.class) {
                        if (((Run) participant).run(((Treadmill) obstacle).getDistance())) {

                            winCounter++;
                            System.out.println("Участник преодолел препятсвие!");
                        } else {
                            break;
                        }

                    }
                }

                System.out.println(winCounter == obstacles.size() ?
                        "Участник преодолел все препятсвия!" :
                        "Участник не смог пройти препятсвие и будет снят с соревнований!");

            }
        }


    public static void randomObstaclesCreator (ArrayList <Object> obstacles){

        // create walls
        for (int i = 0; i < (int) (Math.random() * (5 - 1) + 1); i++) {
            obstacles.add(new Wall(Math.ceil(Math.random() * (10) * (Math.pow(10, 1))) / (Math.pow(10, 1))));
        }

        //create treadmills
        for (int i = 0; i < (int) (Math.random() * (5 - 1) + 1); i++) {
            obstacles.add(new Treadmill((int) (Math.random() * (700))));
        }
    }

    public static void randomParticipantsCreator (ArrayList <Object> participants){

        // create cats
                for (int i = 0; i < (int) (Math.random() * (10)); i++) {
                    participants.add(new Cat("Cat"+i,
                            (int) (Math.random() * (700)),
                            //Формулы для округления числа до 1 знака после запятой))
                            Math.ceil(Math.random() * (10) * (Math.pow(10, 1))) / (Math.pow(10, 1))));
                }

        // create robots
            for (int i = 0; i < (int) (Math.random() * (10)); i++) {
                participants.add(new Robot("Robot"+i,
                    (int) (Math.random() * (1000)),
                    //Формулы для округления числа до 1 знака после запятой))
                    Math.ceil(Math.random() * (15) * (Math.pow(15, 1))) / (Math.pow(15, 1))));
        }

        // create humans
        for (int i = 0; i < (int) (Math.random() * (10)); i++) {
            participants.add(new Human("Human"+i,
                    (int) (Math.random() * (500)),
                    //Формулы для округления числа до 1 знака после запятой))
                    Math.ceil(Math.random() * (5) * (Math.pow(5, 1))) / (Math.pow(5, 1))));
        }

    }

    public static void getInfo (Object participant) {

        if (participant.getClass().equals(Human.class)){
            ((Human) participant).getInfo();
        }
        else if (participant.getClass().equals(Cat.class)){
            ((Cat) participant).getInfo();
        }
        else if (participant.getClass().equals(Robot.class)){
            ((Robot) participant).getInfo();
        }
    }

    public static void obstacleInfo (Object obstacle){

        if (obstacle.getClass().equals(Wall.class)){
            System.out.println("Препятсвие СТЕНА, высотой " + ((Wall) obstacle).getHeight() + " метров.");
        }

        if (obstacle.getClass().equals(Treadmill.class)){
            System.out.println("Препятсвие БЕГОВАЯ ДОРОЖКА, с дистанцией в " + ((Treadmill) obstacle).getDistance() + " метров.");
        }

    }

}

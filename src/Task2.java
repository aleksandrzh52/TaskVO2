import java.util.InputMismatchException;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
//        Кол-во игроков
        int N = 2;
//        Колличество игральных костей
        int K = 1;
        //          создать массив из N обьектов
        Task2Game[] task2games = new Task2Game[N + 1];

        Task2Game taskGame = new Task2Game();

        taskGame.game(task2games, N, K);

    }


}

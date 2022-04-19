import java.util.InputMismatchException;
import java.util.Scanner;

public class Task2Game {
// Все поля приватные, для доступа гетеры и сетеры
    private int koll = 0;
    private String end;
    private int rand = 0;
    private int rand2 = 0;
    private int endChet = 0;
    private int endNumUser = 0;

    private int schet = 0;
    private int user = 0;

    public int getSchet() {
        return schet;
    }

    public void setSchet(int schet) {
        this.schet = schet;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

      void game(Task2Game[] task2games, int N, int K) {

//        Выделяем память под каждый обьект
        for (int i = 0; i < task2games.length; i++) {
            task2games[i] = new Task2Game();
        }

        Scanner sc = new Scanner(System.in);

        do {
            if (koll <= 7) {
                try {
                    for (int i = 0; i < N; i++) {
//                Компьютер последний
                        if (i == N - 1) {
                            for (int j = 0; j < K; j++) {
                                rand = ((int) (Math.random() * 10));

                                System.out.println("КОМПЬЮТЕР: кубик № " + j + 1 + " = " + rand);
                                task2games[i].setSchet(task2games[i].getSchet() + rand);
                                task2games[i].setUser(i);
                            }
                            System.out.println("Компьютер текущий счет: " + task2games[i].getSchet() + "\n");
                        }
//                    Иначе игра
                        else {
                            System.out.println("Нажмите цифру 1 на клавиатуре чтобы подкинуть кости");
                            if (sc.nextInt() == 1) {
                                for (int j = 0; j < K; j++) {
                                    rand2 = ((int) (Math.random() * 10));
                                    System.out.println("Пользователь №" + (task2games[i].getUser() + 1) + ": кубик № " + j + 1 + " = " + rand2);
                                    task2games[i].setSchet(task2games[i].getSchet() + rand2);
                                    task2games[i].setUser(i);
                                }
                                System.out.println("Пользователь " + (task2games[i].getUser() + 1) + " текущий счет: " + task2games[i].getSchet() + "\n");
                            }

                        }
                        if (task2games[i].getSchet() > endChet) {
                            endChet = task2games[i].getSchet();
                            endNumUser = task2games[i].getUser();
                        }


                    }


                } catch (InputMismatchException exp) {
//                играть пока не будет введено end
                    end = sc.nextLine();
                    if (end.equals("end")) break;
                }
            } else {
                System.out.print("Победил пользователь №");
                if (endNumUser == (N - 1)) System.out.println(" Компьютер со счетом " + endChet);
                else System.out.println((endNumUser + 1) + " со счетом " + endChet);
                System.out.println("\nНОВАЯ ИГРА!\n");
                        endChet = 0;
                        endNumUser = 0;
                        koll = 0;
                        continue;
            }
            koll++;
        } while (true);
    }

}

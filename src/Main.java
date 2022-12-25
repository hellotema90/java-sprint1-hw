import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker();
        printMenu();// печатаем меню ещё раз перед завершением предыдущего действия
        int userInput = scanner.nextInt();// повторное считывание данных от пользователя

        while (userInput !=0) {
            if (userInput == 1) {   // обработка разных случаев
                stepTracker.amountStep();
                printMenu();
                userInput = scanner.nextInt();
            } else if (userInput == 2) {
                stepTracker.staticsPrint();
                stepTracker.printFullStat();
                printMenu();
                userInput = scanner.nextInt();
            } else if (userInput == 3) {
                stepTracker.newGoalStep();
                printMenu();
                userInput = scanner.nextInt();
            } else if (userInput == 0){
                System.out.println("Программа завершена");
                break;
            } else {
                System.out.println("Такой команды нет");
                printMenu();
                userInput = scanner.nextInt();
            }



        }
    }

    private static void printMenu() {
        System.out.println("Что вы хотите сделать?");
        System.out.println("1 - Ввести количество шагов за определённый день");
        System.out.println("2 - Напечатать статистику за определённый месяц");
        System.out.println("3 - Изменить цель по количеству шагов в день");
        System.out.println("0 - Выход");

    }
}
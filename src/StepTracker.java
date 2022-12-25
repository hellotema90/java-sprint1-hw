import java.util.Scanner;
public class StepTracker {
    Scanner scanner = new Scanner(System.in);
    Converter converter = new Converter();
    int goalStep = 10000;
    int numberMonth;

    MonthData[] monthToData;

    public StepTracker() {
        monthToData = new MonthData[12];
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    void amountStep() {

        int numberDay;
        int numberStep;
        while (true) {
            staticsPrint();
            System.out.println("Введите номер дня от 1 до 30:");
            numberDay = scanner.nextInt();
            if (numberDay < 1 || numberDay > 30) {
                System.out.println("Такого номера дня нет");
            } else {
                break;
            }
        }
        while (true) {
            System.out.println("Введите пройденое число шагов:");
            numberStep = scanner.nextInt();
            if (numberStep < 0) {
                System.out.println("Отрицательного значения быть не может");
            } else {
                break;
            }
        }
        monthToData[numberMonth].inputDayData(numberDay, numberStep);
        System.out.println("Сохранили количество шагов в нужный день");

    }

    void staticsPrint() {
        System.out.println("Введите номер месяца от 0 до 11:");
        System.out.println("0 - Январь");
        System.out.println("1 - Февраль");
        System.out.println("2 - Март");
        System.out.println("3 - Апрель");
        System.out.println("4 - Май");
        System.out.println("5 - Июнь");
        System.out.println("6 - Июль");
        System.out.println("7 - Август");
        System.out.println("8 - Сентябрь");
        System.out.println("9 - Октябрь");
        System.out.println("10 - Ноябрь");
        System.out.println("11 - Декабрь");
        int numberMonth = scanner.nextInt();
        if (numberMonth < 0 || numberMonth > 11) {
            System.out.println("Такого номера месяца нет!");
        }

    }


    void printFullStat() {
        for (int j = 1; j < monthToData[numberMonth].dayData.length; j++) {
            System.out.println(" " + j + " день: " + monthToData[numberMonth].dayData[j]);

        }
        System.out.println("1. Общее количество шагов за месяц: " + calculateStep(numberMonth));
        System.out.println("2. Максимальное пройденное количество шагов в месяце: " + maxStepPerDay(numberMonth));
        System.out.println("3. Среднее количество шагов: " + calculateStep(numberMonth) / monthToData[numberMonth].dayData.length);
        System.out.println("4. Пройденная дистанция (в км): " + converter.convertDistance(calculateStep(numberMonth)));
        System.out.println("5. Количество сожжённых килокалорий: " + converter.convertCalories(calculateStep(numberMonth)));
        System.out.println("6. Лучшая серия шагов: " + bestSeries(numberMonth));
    }


    int calculateStep(int numberMonth) {
        int calculateStep = 0;
        for (int j = 1; j < monthToData[numberMonth].dayData.length; j++) {
            calculateStep += monthToData[numberMonth].dayData[j];
        }
        System.out.println();

        return calculateStep;
    }

    int maxStepPerDay(int numberMonth) {
        int stepsPerDay = 0;
        for (int j = 0; j < monthToData[numberMonth].dayData.length; j++) {
            if (stepsPerDay < monthToData[numberMonth].dayData[j])
                stepsPerDay = monthToData[numberMonth].dayData[j];
        }
        return stepsPerDay;
    }
    void newGoalStep() {
        System.out.println("Введите новую цель по количеству шагов:");
        int newGoalStep = scanner.nextInt();
        if (newGoalStep > 0) {
            goalStep = newGoalStep;
            System.out.println("Цель по количеству шагов обнавлена " + goalStep);
        } else if (newGoalStep < 0) {
            System.out.println("Указано отрицательное значение.");
        }
    }
    int bestSeries(int numberMonth) {
        int series = 0;
        int bestSeries = 0;
        for (int j = 1; j <monthToData[numberMonth].dayData.length; j++) {
            if (monthToData[numberMonth].dayData[j] >= goalStep) {
                series = series + 1;
                if (bestSeries < series) {
                    bestSeries = series;
                }
            } else {
                if (bestSeries <series) {
                    bestSeries = series;
                }
                series = 0;
            }
        }
        return bestSeries;
    }


    static class MonthData {
        int[] dayData;
        MonthData() {
            dayData = new int[30];
        }
        void inputDayData(int dayNumber, int numSteps) {
            dayData[dayNumber] = numSteps;
        }
    }
}

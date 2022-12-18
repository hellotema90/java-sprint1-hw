public class Converter {

    double oneStepDistance = 0.75;
    double oneStepCalories = 50;

    double convertDistance(int numberStep) {
        double distance = numberStep * oneStepDistance / 1000;
        return distance;

    }
    double convertCalories(int numberStep) {
        double calories = numberStep * oneStepCalories / 1000;
        return calories;
    }
}

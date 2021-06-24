package algo.expert.solutions.medium;

public class ValidStartingCity {
    public int validStartingCity(int[] distances, int[] fuel, int mpg) {

        // Attempt to use each city as the starting city
        for (int startingIdx = 0; startingIdx < distances.length; startingIdx++) {

            boolean stranded = false;
            int totalFuel = 0;
            for (int i = 0; i < distances.length; i++) {
                int cityIdx = (i + startingIdx) % distances.length;
                totalFuel += fuel[cityIdx] * mpg;
                totalFuel -= distances[cityIdx];
                if (totalFuel < 0) {
                    stranded = true;
                    break;
                }
            }

            if (!stranded) {
                return startingIdx;
            }
        }
        return -1;
    }
}

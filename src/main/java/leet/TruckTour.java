package leet;

import java.util.List;

public class TruckTour {

    public static int truckTour(List<List<Integer>> petrolpumps) {
        int tank = 0;
        int deficit = 0;
        int startingPosition = 0;

        int numberOfStations = petrolpumps.get(0).get(0);
        for (int i = 0; i < numberOfStations; i++) {
            List<Integer> stationDetails = petrolpumps.get(i + 1);
            int fuel = stationDetails.get(0);
            int distance = stationDetails.get(1);

            tank += fuel - distance;
            if (tank < 0) {
                deficit += tank;
                tank = 0;
                startingPosition = i + 1;
            }
        }

        return tank + deficit >= 0 ? startingPosition : -1;
    }

    public static void main(String[] args) {
        System.out.println(truckTour(List.of(List.of(3), List.of(1, 5), List.of(10, 3), List.of(3, 4)))); //1
    }
}

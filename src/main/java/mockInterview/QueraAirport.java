package mockInterview;

import java.util.*;

public class QueraAirport {

    // PARAMETERS
    // `k` runways tagged from 1 to k
    // each airplane has `10` character unique ID
    // at first there are `n` airplane in airport at state No `1`

    //STATE
    // 1. in the airport but no runway is taken by it.
    // 2. in the airport and using one runway to takeoff
    // 3. in the airport and using one runway to land
    // 4. not in the airport (unknown or have taken off already -> out of the airport)

    // COMMANDS (how to respond to each command)
    //// TAKE_OFF COMMAND (TAKE-OFF <ID>)
    //// - if airplane is in state `4` print 'YOU ARE NOT HERE'
    //// - if airplane is in state `3` print 'YOU ARE LANDING NOW'
    //// - if airplane is in state `2` print 'YOU ARE TAKING OFF'
    //// - if airplane is in state `1` and there were no free runways print 'NO FREE BOUND'
    //// - else change state of airplane to `2` and set lowest runway No. to the airplane to takeoff

    //// LADING COMMAND (LANDING <ID>)
    //// - if airplane is in state `1` print 'YOU ARE HERE'
    //// - if airplane is in state `2` print 'YOU ARE TAKING OFF'
    //// - if airplane is in state `3` print 'YOU ARE LANDING NOW'
    //// - if airplane is in state `4` and there were no free runways print 'NO FREE BOUND'
    //// - else change state of airplane to `3` and set largest runway No. to the airplane to land

    //// PLANE_STATUS (PLANE-STATUS <ID>)
    //// print the state No.

    //// BAND-STATUS (BAND-STATUS <LINE>)
    //// print airplane ID in case there are non print 'FREE'

    // INPUTS
    // first line with space separated represent No airplanes (n) and No runways (k)
    // in the next (n) lines there are IDs of of airplanes
    // in the next line there is an integer represents No of commands
    // there are COMMANDS from next line to the end

    static Map<String, Integer> airplaneMap = new HashMap<>();
    static List<String> runways = new ArrayList<>();
    static List<String> commands = new ArrayList<>();

    public static void main(String[] args) {
        int airplaneNo;
        int runwayNo;
        int noCommands;


        Scanner sc = new Scanner(System.in);
        airplaneNo = Integer.parseInt(sc.next());
        runwayNo = Integer.parseInt(sc.next());

        for (int i = 0; i < runwayNo; i++)
            runways.add("FREE");

        for (int i = 0; i < airplaneNo; i++)
            airplaneMap.put(sc.next(), 1);

        noCommands = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < noCommands; i++)
            commands.add(sc.nextLine());
        sc.close();

        for (String command : commands) {
            String action = command.split(" ")[0];
            String id = command.split(" ")[1];
            switch (action) {
                case "TAKE-OFF":
                    takeOff(airplaneMap, runways, id);
                    break;
                case "LANDING":
                    landing(airplaneMap, runways, id);
                    break;
                case "PLANE-STATUS":
                    planeStatus(airplaneMap, id);
                    break;
                case "BAND-STATUS":
                    bandStatus(runways, Integer.parseInt(id));
                    break;
                default:
                    System.out.println("UNKNOWN_COMMAND");
                    break;
            }
        }

    }

    //assign 0 state to unknown
    private static void takeOff(Map<String, Integer> airplaneMap, List<String> runways, String planeId) {
        int planeState = airplaneMap.getOrDefault(planeId, 0);
        if (planeState == 4) {
            System.out.println("YOU ARE NOT HERE");
        } else if (planeState == 3) {
            System.out.println("YOU ARE LANDING NOW");
        } else if (planeState == 2) {
            System.out.println("YOU ARE TAKING OFF");
        } else if (planeState == 1 && freeRunwayFromStart(runways) == -1) {
            System.out.println("NO FREE BOUND'");
        } else {
            airplaneMap.put(planeId, 2);
            int i = freeRunwayFromStart(runways);
            runways.set(i, planeId);
        }

    }


    //assign 0 state to unknown
    private static void landing(Map<String, Integer> airplaneMap, List<String> runways, String planeId) {
        int planeState = airplaneMap.getOrDefault(planeId, 0);
        if (planeState == 1) {
            System.out.println("YOU ARE HERE");
        } else if (planeState == 2) {
            System.out.println("YOU ARE TAKING OFF");
        } else if (planeState == 3) {
            System.out.println("YOU ARE LANDING NOW");
        } else if (planeState == 4 && freeRunwayFromStart(runways) == -1) {
            System.out.println("NO FREE BOUND'");
        } else {
            airplaneMap.put(planeId, 3);
            int i = freeRunwayFromEnd(runways);
            runways.set(i, planeId);
        }
    }

    private static void planeStatus(Map<String, Integer> airplaneMap, String planeId) {
        System.out.println(airplaneMap.get(planeId));
    }

    private static void bandStatus(List<String> runways, int runwayId) {
        System.out.println(runways.get(runwayId - 1));
    }

    private static int freeRunwayFromStart(List<String> runways) {
        for (int i = 0; i < runways.size(); i++) {
            if (runways.get(i).equals("FREE"))
                return i;
        }
        return -1;
    }

    private static int freeRunwayFromEnd(List<String> runways) {
        for (int i = runways.size() - 1; i >= 0; i--) {
            if (runways.get(i).equals("FREE"))
                return i;
        }
        return -1;
    }
}

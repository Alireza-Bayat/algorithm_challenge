package mockInterview;

import java.time.LocalTime;
import java.util.List;

/**
 * to set of time as  `[['9:00','10:30'],['12:00','13:00'],['16:00','18:00']]` for 2 different people and start,end
 * of working time would be the starting variables
 * <p>
 * need to extract the free times of that both employee is free to set the meeting
 *
 * <pre>
 * sample input
 * first one: [['9:00','10:30'],['12:00','13:00'],['16:00','18:00']];
 * ['9:00','20:00']
 * second one: [['10:00','11:30'],['12:30','14:30'],['14:30','15:00'],['16:00','17:00']];
 * ['10:00','18:30']
 *
 * sample output
 *
 * 	[['11:30','12:00'],['15:00','16:00'],['18:00','18:30']]
 *
 * </pre>
 *
 * @author alireza_bayat
 * created on 1/26/22
 */


public class MatchSessionTime {

    public List<List<String>> getSessionTimes(List<List<String>> firstPersonTimes, List<List<String>> secondPersonTimes,
                                              List<String> firstPersonWorkingDayTime, List<String> secondPersonWorkingDayTime) {


        return null;
    }

    private void getFreeTime(List<List<String>> personTimes, List<String> personWorkingDayTime) {
        LocalTime startDateTime = convertToLocalTime(personWorkingDayTime.get(0));
        LocalTime endDateTime = convertToLocalTime(personWorkingDayTime.get(1));

        for (List<String> personTime : personTimes) {//each personTime got 2 indexes
//            if (personTime)

        }
    }

    private LocalTime convertToLocalTime(String time) {
        String[] timeSplit = time.split(":");
        return LocalTime.of(Integer.parseInt(timeSplit[0]), Integer.parseInt(timeSplit[1]));
    }
}

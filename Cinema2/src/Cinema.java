import java.util.Map;
import java.util.TreeMap;

public class Cinema {
	 final Map<Days, Schedule> daysScheduleMap;
	    Time open;
	    Time close;

	    public Cinema() {
	        daysScheduleMap = new TreeMap<>();
	        open = new Time();
	        close = new Time();
	    }

	    public boolean checkCinema(Seance seance) {
	        return seance.getStartTime().compareTo(close) < 0 &&
	                seance.getEndTime().compareTo(close) < 0 &&
	                seance.getStartTime().compareTo(open) >= 0 &&
	                seance.getEndTime().compareTo(open) >= 0;


	    }
}

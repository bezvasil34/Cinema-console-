import java.util.HashSet;
import java.util.Set;

public class Schedule {
	 final Set<Seance> seances;

	    public Schedule() {
	        seances = new HashSet<>();

	    }
	    

	    public boolean checkSeanseSchedule(Seance seance) {
	        for (Seance s : seances)
	            if (seance.getStartTime().compareTo(s.getStartTime())>=0&&seance.getStartTime().compareTo(s.getEndTime())<0||
	                    seance.getEndTime().compareTo(s.getStartTime())>=0&&seance.getEndTime().compareTo(s.getEndTime())<0)
	                return false;
	        return true;
	    } 

	   
}

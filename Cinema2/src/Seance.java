
public class Seance {
	 private final Movie movie;
	    private final Time startTime;
	    private final Time endTime;

	    public Seance(Movie movie, Time startTime) {
	        this.movie = movie;
	        this.startTime = startTime;
	        endTime = new Time(
	                startTime.getHour() + movie.getDuration().getHour() + (startTime.getMin() + movie.getDuration().getMin()) / 60
	                ,
	                (startTime.getMin() + movie.getDuration().getMin()) % 60
	        );
	    }

	    public Movie getMovie() {
	        return movie;
	    }

	    public Time getStartTime() {
	        return startTime;
	    }

	    public Time getEndTime() {
	        return endTime;
	    }

	    @Override
	    public String toString() {
	        return movie +
	                ", Початок=" + startTime +
	                ", Закінчення=" + endTime;
	    }
}

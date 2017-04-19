import java.util.Scanner;

public class Movie {
	 private final String title;
	    private final Time duration;

	    @Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (o == null || getClass() != o.getClass()) return false;

	        Movie movie = (Movie) o;

	        return !(title != null ? !title.equals(movie.title) : movie.title != null) && !(duration != null ? !duration.equals(movie.duration) : movie.duration != null);

	    }

	    @Override
	    public int hashCode() {
	        int result = title != null ? title.hashCode() : 0;
	        result = 31 * result + (duration != null ? duration.hashCode() : 0);
	        return result;
	    }

	    @Override
	    public String toString() {
	        return title +
	                " - " + duration;
	    }

	    public Movie(String title, Time duration) {
	        this.title = title;
	        this.duration = duration;
	    }

	    public String getTitle() {
	        return title;
	    }

	    public Time getDuration() {
	        return duration;
	    }

	    static Movie inputMovie() {
	        String title = null;
	        int duration = 0;
	        Scanner scanner = new Scanner(System.in);
	        System.out.println("¬вед≥ть назву ф≥льму:");
	        if (scanner.hasNext()) title = scanner.next();
	        System.out.println("¬вед≥ть тривал≥сть у хвилинах:");
	        if (scanner.hasNextInt()) duration = scanner.nextInt();
	        return new Movie(title, new Time(duration / 60, duration % 60));
	    }
}

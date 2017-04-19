import java.util.Scanner;

public class Time implements Comparable<Time> {
	private int min, hour;

	public int getMin() {
		return min;
	}

	private void setMin(int min) {
		if (min >= 0 && min < 60)
			this.min = min;
	}

	public int getHour() {
		return hour;
	}

	
	private void setHour(int hour) {
		if (hour >= 0 && hour < 24)
			this.hour = hour;
	}

	public Time() {
	}

	public Time(int hour, int min) {
		setMin(min);
		setHour(hour);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Time time = (Time) o;

		return min == time.min && hour == time.hour;

	}

	@Override
	public int hashCode() {
		int result = min;
		result = 31 * result + hour;
		return result;
	}

	@Override
	public int compareTo(Time o) {
		return (getHour() < o.getHour()) ? -1
				: (getHour() > o.getHour()) ? 1 : (getMin() < o.getMin()) ? -1 : (getMin() == o.getMin()) ? 0 : 1;
	}

	@Override
	public String toString() {
		return "" + "" + hour + ":" + min + "";
	}

	static Time inputTime() {
		int hour;
		int min;
		Scanner scanner = new Scanner(System.in);
		if (scanner.hasNext()) {
			hour = scanner.nextInt();
			min = scanner.nextInt();
			return new Time(hour, min);
		}
		return null;
	}
}

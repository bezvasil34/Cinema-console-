import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Core {
	 private static final Cinema cinema = new Cinema();

	    public static void main(String[] args) {
//	        System.out.println(inputTime());
//	        System.out.println(inputMovie());
	        cinema.open = new Time(8, 0);
	        cinema.close = new Time(23, 50);
	        for (Days days : Days.values()) cinema.daysScheduleMap.put(days, new Schedule());
	        testinit();
//	        System.out.println(selectMovie());
	        while (true) {

	        	
	            showMenu();
	            executeCommand(getIntCommand());
	        }
	    }

	    private static void showMenu() {
	        System.out.println("����:\n" +
	                "1. �������� ������� �� �������\n" +
	                "2. �������� ������� �� ����\n" +
	                "3. �������� ������ ������, �� � ������\n" +
	                "4. ��������\\��������  �����\\�����\n" +
	                "0. �����");

	    }

	    private static int getIntCommand() {
	        Scanner scanner = new Scanner(System.in);
	        if (scanner.hasNextInt()) return scanner.nextInt();

	        scanner.close();
	        return 0;
	    }

	    private static void executeCommand(int i) {
	        switch (i) {
	            case 1:
	                cinema.daysScheduleMap.forEach((days, schedule) ->
	                {
	                    System.out.println(days);
	                    schedule.seances.forEach(System.out::println);
	                });
	                break;
	            case 2:
	                Days day = selectDay();
	                cinema.daysScheduleMap.get(day).seances.forEach(System.out::println);
	                break;

	            case 3:
	                HashSet<String> movies = new HashSet<>();
	                cinema.daysScheduleMap.forEach((days, schedule) -> schedule.seances.forEach(seance -> movies.add(seance.getMovie().getTitle())));
	                System.out.println(movies);
	                break;
	            case 4:
	                executeAddMovie();
	                break;
	            case 0:
	                System.exit(0);
	        }
	    }

	    private static Days selectDay() {
	        System.out.println("������� ���� �����");
	        for (Days days : Days.values()) System.out.println(days + "\t ������ " + days.ordinal());
	        int daymumber = getIntCommand();
	        return Days.values()[daymumber];
	    }

	    private static void addMovieMenu() {
	        System.out.println("���� ��������� ������:\n" +
	                "1. ������� ������� ������\n" +
	                "2. �������  ����\n" +
	                "3. ������� �����\n" +
	                "4. ������ ����� �����\n" +
	                "5. �������� ������ ������\n" +
	                "6. �������� �����\n" +
	                "7. �������� �����\n" +
	                "0. �������� ��������� ������");

	    }

	    private static void executeAddMovie() {

	        Scanner scanner = new Scanner(System.in);
	        int command;
	        Movie movie = null;
	        Days day = null;
	        boolean menuIndicator = true;
	        while (menuIndicator) {
	            System.out.println("�������� ����� : " + movie + "\n" +
	                    "���� : " + day);
	            addMovieMenu();
	            command = scanner.nextInt();
	            switch (command) {
	                case 1:
	                    if (day == null) day = selectDay();
	                    cinema.daysScheduleMap.get(day).seances.forEach(System.out::println);
	                    break;
	                case 2:
	                    day = selectDay();
	                    break;
	                case 3:
	                    movie = selectMovie();
	                    break;
	                case 4:
	                    movie = Movie.inputMovie();

	                    break;
	                case 5:
	                    System.out.println("������ ��� ������� ������ � ������ 00 00");

	                    Time time = Time.inputTime();
	                    Seance seance = new Seance(movie, time);
	                    if (cinema.checkCinema(seance) && cinema.daysScheduleMap.get(day).checkSeanseSchedule(seance)) {
	                        cinema.daysScheduleMap.get(day).seances.add(seance);
	                    }
	                    break;
	                case 6:
	                    if (day == null) day = selectDay();
	                    int i = 0;
	                    System.out.println("������� ����� ��� ���������");
	                    Map<Integer,Seance> seanceMap = new TreeMap<>();
	                    for (Seance seance1 : cinema.daysScheduleMap.get(day).seances) {
	                        System.out.println(++i + " :" + seance1);
	                        seanceMap.put(i, seance1);
	                    }
	                    command = getIntCommand();
	                    cinema.daysScheduleMap.get(day).seances.remove(seanceMap.get(command));
	                    break;

	                case 7:
	                    movie = selectMovie();

	                    final Movie finalMovie1 = movie;
	                    cinema.daysScheduleMap.forEach((days, schedule) ->
	                        schedule.seances.removeIf(seance1 -> seance1.getMovie().equals(finalMovie1))
	                    );
	                    break;

	                case 0:
	                    menuIndicator = false;
	                    break;
	            }


	        }
	    }

	    private static Movie selectMovie() {
	        Map<String, Movie> map = new HashMap<>();
	        cinema.daysScheduleMap.forEach((days, schedule) -> schedule.seances.forEach(seance -> map.put(seance.getMovie().getTitle(), seance.getMovie())));
	        int i = 1;
	        for (String s : map.keySet()) {
	            System.out.println("������ " + i++ + " :  " + s);
	        }
	        int command = getIntCommand();
	        i = 1;
	        for (String s : map.keySet()) if (command == i++) return map.get(s);
	        return null;
	    }

	    private static void testinit() {

	        cinema.daysScheduleMap.get(Days.����Ĳ���).seances.add(new Seance(new Movie("Terminator", new Time(1, 30)), new Time(10, 0)));
	        cinema.daysScheduleMap.get(Days.����Ĳ���).seances.add(new Seance(new Movie("Robocop", new Time(1, 20)), new Time(12, 0)));
	        cinema.daysScheduleMap.get(Days.�������).seances.add(new Seance(new Movie("Robocop", new Time(1, 20)), new Time(12, 0)));
	        cinema.daysScheduleMap.get(Days.��Ĳ��).seances.add(new Seance(new Movie("Terminator", new Time(1, 30)), new Time(12, 0)));

	    }
}

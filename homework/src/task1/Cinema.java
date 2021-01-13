package task1;

import java.io.Serializable;
import java.util.Optional;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.Map.Entry;

public class Cinema implements Serializable {

	private static final long serialVersionUID = -2991843421434092287L;
	private String name;
	private TimeTable cinemaTimeTable;
	private TreeSet<Hall> cinemaHalls;

	public Cinema(String name) {
		this.name = name;
		this.cinemaTimeTable = new TimeTable();
		this.cinemaHalls = new TreeSet<Hall>();
	}

	public String getName() {
		return name;
	}

	public static Cinema inputCinema() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);

		System.out.print("������� �������� ����������: ");
		String name = scanner.nextLine();
		if (name.equals("")) {
			System.err.println("�������� ���������� ������� �����������!");
			name = "-= �����-�� ���������� ��������� =-";
		}
		System.out.println("��������� \"" + name.toString() + "\" ������� ������!\n");
		return new Cinema(name);
	}

	public void addHallToCinema() {
		Hall cinemaHall = Hall.inputHall();
		cinemaHalls.add(cinemaHall);
		System.out.println("������� \"" + cinemaHall.getName() + "\" ������� �������� � ��������� \"" + name + "\"!\n");
	}

	public Optional<Hall> getHallFromSet(Hall cinemaHall) {
		Optional<Hall> hallFound = cinemaHalls.stream().filter(entry -> entry.getName().equals(cinemaHall.getName()))
				.findFirst();

		return hallFound;
	}

	public boolean removeHallFromCinema() {
		Hall cinemaHall = Hall.inputHall();

		Optional<Hall> hallFound = getHallFromSet(cinemaHall);

		if (hallFound.isPresent()) {
			cinemaHalls.remove(hallFound.get());
			System.out.println(
					"������� \"" + hallFound.get().getName() + "\" ������� ����� �� ���������� \"" + name + "\"!\n");
			return true;
		} else {
			System.err.println("������� \"" + cinemaHall.getName() + "\" ����������� ���������� \"" + name + "\"!\n");
			return false;
		}
	}

	public boolean addTimeTableToCinema() throws IllegalTimeFormatException {
		boolean isDone = cinemaTimeTable.addTimeTableEntry();
		if (isDone) {
			System.out.println("������ ������ ���������� \"" + name + "\" ������� ������!\n");
			return true;
		} else {
			System.err.println("������ ��������� � ������ ������ ���������� \"" + name + "\" �� �������!\n");
			return false;
		}
	}

	public boolean removeTimeTableFromCinema() {
		boolean isDone = cinemaTimeTable.removeTimeTableEntry();
		if (isDone) {
			System.out.println("������ ������ ���������� \"" + name + "\" ������� ������!\n");
			return true;
		} else {
			System.err.println("������ ��������� � ������ ������ ���������� \"" + name + "\" �� �������!\n");
			return false;
		}
	}

	public boolean addTimeTableToHallInCinema() throws IllegalTimeFormatException {
		Hall cinemaHall = Hall.inputHall();

		Optional<Hall> hallFound = getHallFromSet(cinemaHall);

		if (hallFound.isPresent()) {
			boolean isDone = hallFound.get().addTimeTableToHall();

			if (isDone) {
				System.out.println("������ ������ ��� \"" + hallFound.get() + "\" ������� �������� � ��������� \""
						+ name + "\"!\n");
				return true;
			} else {
				System.err.println("������ ��������� � ������ ������ ���������� \"" + name + "\" �� �������!\n");
				return false;
			}
		} else {
			System.err.println("������� \"" + cinemaHall.getName() + "\" ����������� ���������� \"" + name + "\"!\n");
			return false;
		}
	}

	public boolean removeTimeTableFromHallInCinema() {
		Hall cinemaHall = Hall.inputHall();

		Optional<Hall> hallFound = getHallFromSet(cinemaHall);

		if (hallFound.isPresent()) {
			boolean isDone = hallFound.get().removeTimeTableFromHall();

			if (isDone) {
				System.out.println("������ ������ ��� \"" + hallFound.get() + "\" ������� ����� �� ���������� \""
						+ name + "\"!\n");
				return true;
			} else {
				System.err.println("������ ��������� � ������ ������ ���������� \"" + name + "\" �� �������!\n");
				return false;
			}
		} else {
			System.err.println("������� \"" + cinemaHall.getName() + "\" ����������� ���������� \"" + name + "\"!\n");
			return false;
		}
	}

	public boolean addScheduleToHallInCinema() throws IllegalTimeFormatException {
		Hall cinemaHall = Hall.inputHall();

		Optional<Hall> hallFound = getHallFromSet(cinemaHall);

		if (hallFound.isPresent()) {
			boolean isDone = hallFound.get().addScheduleToHall();

			if (isDone) {
				System.out.println("���������� ������� ��� \"" + hallFound.get() + "\" ������� �������� � ��������� \""
						+ name + "\"!\n");
				return true;
			} else {
				System.err.println("������ ��������� � ���������� ������� ��� \"" + hallFound.get() + "\" ���������� \""
						+ name + "\" �� �������!\n");
				return false;
			}
		} else {
			System.err.println("������� \"" + cinemaHall.getName() + "\" ����������� ���������� \"" + name + "\"!\n");
			return false;
		}
	}

	public boolean removeScheduleFromHallInCinema() {
		Hall cinemaHall = Hall.inputHall();

		Optional<Hall> hallFound = getHallFromSet(cinemaHall);

		if (hallFound.isPresent()) {
			boolean isDone = hallFound.get().removeScheduleFromHall();

			if (isDone) {
				System.out.println("���������� ������� ��� \"" + hallFound.get() + "\" ������� ����� �� ���������� \""
						+ name + "\"!\n");
				return true;
			} else {
				System.err.println("������ ��������� � ���������� ������� ��� \"" + hallFound.get() + "\" ���������� \""
						+ name + "\" �� �������!\n");
				return false;
			}
		} else {
			System.err.println("������� \"" + cinemaHall.getName() + "\" ����������� ���������� \"" + name + "\"!\n");
			return false;
		}
	}

	public boolean addSeanceToScheduleInHallInCinema() throws IllegalTimeFormatException {
		Hall cinemaHall = Hall.inputHall();

		Optional<Hall> hallFound = getHallFromSet(cinemaHall);

		if (hallFound.isPresent()) {
			Days day = Days.inputDay();
			if (day == null)
				return false;

			Optional<Entry<Days, Schedule>> hallScheduleEntryFound = hallFound.get().getHallSchedule().entrySet()
					.stream().filter(entry -> entry.getKey().equals(day)).findFirst();

			if (hallScheduleEntryFound.isPresent()) {
				Movie movie = Movie.inputMovie();
				boolean isDone = hallScheduleEntryFound.get().getValue().addSeance(movie);

				if (isDone)
					return true;
				else
					return false;
			} else {
				System.err.println(day.toLiteral(true) + " ����������� � ���������� ������� ��� \"" + hallFound.get()
						+ "\" ���������� \"" + name + "\"!\n");
				return false;
			}
		} else {
			System.err.println("������� \"" + cinemaHall.getName() + "\" ����������� ���������� \"" + name + "\"!\n");
			return false;
		}
	}

	public boolean removeSeanceFromScheduleInHallInCinema() throws IllegalTimeFormatException {
		Hall cinemaHall = Hall.inputHall();

		Optional<Hall> hallFound = getHallFromSet(cinemaHall);

		if (hallFound.isPresent()) {
			Days day = Days.inputDay();
			if (day == null)
				return false;

			Optional<Entry<Days, Schedule>> hallScheduleEntryFound = hallFound.get().getHallSchedule().entrySet()
					.stream().filter(entry -> entry.getKey().equals(day)).findFirst();

			if (hallScheduleEntryFound.isPresent()) {
				Movie movie = Movie.inputMovie();
				Seance removingSeance = Seance.inputSeance(movie);
				boolean isDone = hallScheduleEntryFound.get().getValue().removeSeance(removingSeance);

				if (isDone)
					return true;
				else
					return false;
			} else {
				System.err.println(day.toLiteral(true) + " ����������� � ���������� ������� ��� \"" + hallFound.get()
						+ "\" ���������� \"" + name + "\"!\n");
				return false;
			}
		} else {
			System.err.println("������� \"" + cinemaHall.getName() + "\" ����������� ���������� \"" + name + "\"!\n");
			return false;
		}
	}

	public void addMovieToSeanceInScheduleInHallInCinema() throws IllegalTimeFormatException {
		Movie movie = Movie.inputMovie();

		boolean addOneMoreSeance;

		do {
			Hall cinemaHall = Hall.inputHall();

			Optional<Hall> hallFound = getHallFromSet(cinemaHall);

			if (hallFound.isPresent()) {
				Days day = Days.inputDay();
				if (day == null)
					return;

				Optional<Entry<Days, Schedule>> hallScheduleEntryFound = hallFound.get().getHallSchedule().entrySet()
						.stream().filter(entry -> entry.getKey().equals(day)).findFirst();

				if (hallScheduleEntryFound.isPresent()) {
					hallScheduleEntryFound.get().getValue().addSeance(movie);
				} else {
					System.err.println(day.toLiteral(true) + " ����������� � ���������� ������� ��� \""
							+ hallFound.get() + "\" ���������� \"" + name + "\"!\n");
				}
			} else {
				System.err
						.println("������� \"" + cinemaHall.getName() + "\" ����������� ���������� \"" + name + "\"!\n");
			}

			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(System.in);

			System.out.print("�������� ��� ���� �����? (true/false) ");
			addOneMoreSeance = scanner.nextBoolean();

			if (!addOneMoreSeance) {
				System.out.println("�� ���������� �� ����������� ���������� ������� ��� ������� ������!\n");
			}

		} while (addOneMoreSeance);
	}

	public void removeMovieFromSeanceInScheduleInAllHallsInCinema() throws IllegalTimeFormatException {
		Movie movie = Movie.inputMovie();
		boolean isDone = false;

		for (Hall hall : cinemaHalls) {
			for (Days day : Days.values()) {
				Optional<Seance> seance = hall.getHallSchedule().entrySet().stream()
						.filter(entry -> entry.getKey().equals(day)).findFirst().get().getValue()
						.getMovieSeanceFromSet(movie);

				if (seance.isPresent()) {
					hall.getHallSchedule().entrySet().stream().filter(entry -> entry.getKey().equals(day)).findFirst()
							.get().getValue().removeSeance(seance.get());
					isDone = true;
				} else
					break;
			}
		}

		if (isDone) {
			System.out.println(movie.toString() + " ������� ����� �� ���������� ������� ���� ����� ����������!\n");
		} else {
			System.err.println("������� " + movie.toString()
					+ " �� ���������� ������� ���� ����� ���������� �� �������, �.�. ������ ������ ��� � ���������� ����������!\n");
		}
	}

	public void viewCinemaTimeTable() {
		System.out.print("��������� \"" + name + "\"\n");
		cinemaTimeTable.viewTimeTable();
		System.out.println();
	}

	public void viewCinemaHalls() {
		System.out.println("�������� ��������� ���������� \"" + name + "\":");
		cinemaHalls.forEach(System.out::println);
		System.out.println();
	}

	public boolean viewHallTimeTableInCinema() {
		Hall cinemaHall = Hall.inputHall();

		Optional<Hall> hallFound = getHallFromSet(cinemaHall);

		if (hallFound.isPresent()) {
			hallFound.get().viewHallTimeTable();
			return true;
		} else {
			System.err.println("������� \"" + cinemaHall.getName() + "\" ����������� ���������� \"" + name + "\"!\n");
			return false;
		}
	}

	public boolean viewHallScheduleInCinema() {
		Hall cinemaHall = Hall.inputHall();

		Optional<Hall> hallFound = getHallFromSet(cinemaHall);

		if (hallFound.isPresent()) {
			hallFound.get().viewHallSchedule();
			return true;
		} else {
			System.err.println("������� \"" + cinemaHall.getName() + "\" ����������� ���������� \"" + name + "\"!\n");
			return false;
		}
	}

	@Override
	public String toString() {
		if (name == "-= �����-�� ���������� ��������� =-") {
			return (String) name;
		} else
			return "��������� \"" + name + "\"";
	}
}

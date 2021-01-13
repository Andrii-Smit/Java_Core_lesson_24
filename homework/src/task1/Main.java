package task1;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static int menu() {
		System.out.println("-= ��������� =-");
		System.out.println("11 - ������� ����� ���������");
		System.out.println("12 - ��������� ��������� � ����");
		System.out.println("13 - ��������� ��������� �� �����");
		System.out.println("-= ������ ������ ���������� =-");
		System.out.println("21 - �������/�������� ������ ������ ���������� �� ����");
		System.out.println("22 - ������� ������ ������ ���������� �� ����");
		System.out.println("23 - ������� ������ ������ ���������� �� ������");
		System.out.println("-= ���� ���������� =-");
		System.out.println("31 - ������� ��� � ����������");
		System.out.println("32 - ������� ��� �� ����������");
		System.out.println("33 - ������� �������� ����� ����������");
		System.out.println("-= ������ ������ ���� ���������� =-");
		System.out.println("41 - �������/�������� ������ ������ ���� ���������� �� ����");
		System.out.println("42 - ������� ������ ������ ���� ���������� �� ����");
		System.out.println("43 - ������� ������ ������ ���� ���������� �� ������");
		System.out.println("-= ���������� ������� ���� ���������� =-");
		System.out.println("51 - �������/�������� ���������� ������� ���� ���������� �� ����");
		System.out.println("52 - ������� ���������� ������� ���� ���������� �� ����");
		System.out.println("53 - ������� ���������� ������� ���� ���������� �� ������");
		System.out.println("-= ������ ���� ���������� �� ���� =-");
		System.out.println("61 - �������� ����� � ���������� ������� ���� ���������� �� ����");
		System.out.println("62 - ������� ����� �� ���������� ������� ���� ���������� �� ����");
		System.out.println("-= ������ =-");
		System.out.println("71 - �������� ����� � ����� ������� � ���������� ���� ����������");
		System.out.println("72 - ������� ����� �� ���������� ������� ���� ����� ����������");
		System.out.println("-= ����� =-");
		System.out.println("0 - ����� �� ���������");
		System.out.println();

		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.print("�������� ��� �����: ");
		int menuChoise = scanner.nextInt();

		return menuChoise;
	}

	public static void main(String[] args)
			throws NumberFormatException, IllegalTimeFormatException, IOException, ClassNotFoundException {
		Cinema cinema = null;

		while (true) {
			switch (menu()) {

			case 11: {
				cinema = Cinema.inputCinema();
				break;
			}

			case 12: {
				SerializeMethods.serialize(cinema, new File("Cinema.obj"));
				System.out.println("��������� \"" + cinema.getName() + "\" ������� ������� � ����!\n");
				break;
			}

			case 13: {
				cinema = (Cinema) SerializeMethods.deserialize(new File("Cinema.obj"));
				System.out.println("��������� \"" + cinema.getName() + "\" ������� �������� �� �����!\n");
				break;
			}

			case 21: {
				cinema.addTimeTableToCinema();
				break;
			}

			case 22: {
				cinema.removeTimeTableFromCinema();
				break;
			}

			case 23: {
				cinema.viewCinemaTimeTable();
				break;
			}

			case 31: {
				cinema.addHallToCinema();
				break;
			}

			case 32: {
				cinema.removeHallFromCinema();
				break;
			}

			case 33: {
				cinema.viewCinemaHalls();
				break;
			}

			case 41: {
				cinema.addTimeTableToHallInCinema();
				break;
			}

			case 42: {
				cinema.removeTimeTableFromHallInCinema();
				break;
			}

			case 43: {
				cinema.viewHallTimeTableInCinema();
				break;
			}

			case 51: {
				cinema.addScheduleToHallInCinema();
				break;
			}

			case 52: {
				cinema.removeScheduleFromHallInCinema();
				break;
			}

			case 53: {
				cinema.viewHallScheduleInCinema();
				break;
			}

			case 61: {
				cinema.addSeanceToScheduleInHallInCinema();
				break;
			}

			case 62: {
				cinema.removeSeanceFromScheduleInHallInCinema();
				break;
			}
			
			case 71: {
				cinema.addMovieToSeanceInScheduleInHallInCinema();
				break;
			}

			case 72: {
				cinema.removeMovieFromSeanceInScheduleInAllHallsInCinema();
				break;
			}
			
			case 0: {
				System.out.println("�������, ��� ������� �� ����������� ������� ���� ���������� ������ ����������! ����� ����������!\n");
				System.exit(0);
				break;
			}

			default: {
				System.err.println("������ ������ ���� �� ����������!\n");
				break;
			}
			}
		}
	}
}

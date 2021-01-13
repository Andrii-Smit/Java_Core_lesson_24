package task1;

import java.io.Serializable;
import java.util.Scanner;

public enum Days implements Serializable {
	MONDAY(1), TUESDAY(2), WEDNESDAY(3), THURSDAY(4), FRIDAY(5), SATURDAY(6), SUNDAY(7);

	int serialNumber;

	Days(int serialNumber) {
		this.serialNumber = serialNumber;
	}

	public int getSerialNumber() {
		return serialNumber;
	}

	public String toLiteral(boolean fullType) {
		String dayToLiteralFull;
		String dayToLiteralShort;

		switch (Days.this) {
		case MONDAY:
			dayToLiteralFull = "�����������";
			dayToLiteralShort = "��.";
			break;
		case TUESDAY:
			dayToLiteralFull = "�������";
			dayToLiteralShort = "��.";
			break;
		case WEDNESDAY:
			dayToLiteralFull = "�����";
			dayToLiteralShort = "��.";
			break;
		case THURSDAY:
			dayToLiteralFull = "�������";
			dayToLiteralShort = "��.";
			break;
		case FRIDAY:
			dayToLiteralFull = "�������";
			dayToLiteralShort = "��.";
			break;
		case SATURDAY:
			dayToLiteralFull = "�������";
			dayToLiteralShort = "��.";
			break;
		case SUNDAY:
			dayToLiteralFull = "�����������";
			dayToLiteralShort = "��.";
			break;
		default:
			dayToLiteralFull = dayToLiteralShort = "";
			break;
		}
		
		if (fullType)
			return dayToLiteralFull;
		else
			return dayToLiteralShort;
	}

	public static Days inputDay() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		Integer returnedNumber = 0;
		Days foundDay = null;

		System.out.print("������� ����� ��� ������: ");
		if (scanner.hasNextInt()) {
			int nextInt = scanner.nextInt();

			if (nextInt > 0 && nextInt <= Days.values().length) {
				returnedNumber = nextInt;
			} else
				System.err.println("����� ��� ������ ������ ���� � ��������� �� 1 �� 7!\n");
		} else
			System.err.println("����� ��� ������ ����� �����������!\n");

		for (Days day : Days.values()) {
			if (day.getSerialNumber() == returnedNumber) {
				foundDay = day;
			}
		}

		return foundDay;
	}
}

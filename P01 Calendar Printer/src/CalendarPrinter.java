
//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           P01 Calendar Printer
// Files:           CalendarTest.java
//                  CalendarPrinter.java
// Course:          CS 300, fall 2019
//
// Author:          Malcolm Balles
// Email:           mballes@wisc.edu
// Lecturer's Name: Mouna
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:    Ishaan Backliwal
// Partner Email:   backliwal@wisc.edu
// Partner Lecturer's Name: Gary
// 
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   _x_ Write-up states that pair programming is allowed for this assignment.
//   _x_ We have both read and understand the course Pair Programming Policy.
//   _x_ We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully 
// acknowledge and credit those sources of help here.  Instructors and TAs do 
// not need to be credited here, but tutors, friends, relatives, room mates, 
// strangers, and others do.  If you received no outside help from either type
//  of source, then please explicitly indicate NONE.
//
// Persons:         none
// Online Sources:  https://apstudents.collegeboard.org/sites/default/files/
//                  2019-05/ap-computer-science-a-2014-java-quick-reference.pdf
//                  helped recall certain methods I forgot
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////
import java.util.Scanner;

public class CalendarPrinter {
	private final static String[] DAYS_OF_WEEK = { "MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN" };
	private final static String[] MONTHS_OF_YEAR = { "JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP",
			"OCT", "NOV", "DEC" };

	/**
	 * runs the driver
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		driver();
	}

	/**
	 * Calculates the number of centuries (rounded down) that is represented by the
	 * specified year (ie. the integer part of year/100).
	 * 
	 * @param year to compute the century of (based on the Gregorian Calendar AD)
	 *             String must contain the digits of a single non-negative int for
	 *             year.
	 * @return number of centuries in the specified year
	 */
	public static int getCentury(String year) {
		if (Integer.parseInt(year) < 0) {
			return 0;
		}
		int cent = Integer.parseInt(year);
		cent = cent / 100;
		return cent;
	}

	/**
	 * Calculates the number of years between the specified year, and the first year
	 * in the specified year's century. This number is always between 0 - 99.
	 * 
	 * @param year to compute the year within century of (Gregorian Calendar AD)
	 *             String must contain the digits of a single non-negative int for
	 *             year.
	 * @return number of years since first year in the current century
	 */
	public static int getYearWithinCentury(String year) {
		int yearInCent = Integer.parseInt(year);// if negative #, return -1 to say so
		if (Integer.parseInt(year) < 0) {
			return -1;
		}
		while (yearInCent >= 100) {
			yearInCent = yearInCent - 100;
		}
		return yearInCent;
	}

	/**
	 * This method computes whether the specified year is a leap year or not.
	 * 
	 * @param yearString is the year that is being checked for leap-year-ness String
	 *                   must contain the digits of a single non-negative int for
	 *                   year.
	 * @return true when the specified year is a leap year, and false otherwise
	 */
	public static boolean getIsLeapYear(String yearString) {
		boolean leapYear = false;
		if (Integer.parseInt(yearString) % 4 != 0) {
			leapYear = false;
		} else {
			if (Integer.parseInt(yearString) % 100 != 0) {
				leapYear = true;
			} else {
				if (Integer.parseInt(yearString) % 400 != 0) {
					leapYear = false;
				} else {
					leapYear = true;
				}
			}
		}
		return leapYear;
	}

	// Note implementation tips in Appendix I below.
	/**
	 * Converts the name or abbreviation for any month into the index of that
	 * month's abbreviation within MONTHS_OF_YEAR. Matches the specified month based
	 * only on the first three characters, and is case in-sensitive.
	 * 
	 * @param month which may or may not be abbreviated to 3 or more characters
	 * @return the index within MONTHS_OF_YEAR that a match is found at and returns
	 *         -1, when no match is found
	 */
	public static int getMonthIndex(String month) {
		String mon = month.toUpperCase();
		for (int c = 0; c < MONTHS_OF_YEAR.length; c++) {
			if (MONTHS_OF_YEAR[c].compareTo(mon.substring(0, 3)) == 0) {
				return c;
			}
		}
		return -1;// if not correctly inputted, return -1 to show so
	}

	/**
	 * Calculates the number of days in the specified month, while taking into
	 * consideration whether or not the specified year is a leap year.
	 * 
	 * @param month which may or may not be abbreviated to 3 or more characters
	 * @param year  of month that days are being counted for (Gregorian Calendar AD)
	 *              String must contain the digits of a single non-negative int for
	 *              year.
	 * @return the number of days in the specified month (between 28-31)
	 */
	public static int getNumberOfDaysInMonth(String month, String year) {
		if (Integer.parseInt(year) > 0) {
			if (getMonthIndex(month) == 1) {
				if (getIsLeapYear(year) == true) {
					return 29;
				} else {
					return 28;
				}
			}
			if (getMonthIndex(month) == 3 || getMonthIndex(month) == 5 || getMonthIndex(month) == 8
					|| getMonthIndex(month) == 10) {
				return 30;
			} else {
				return 31;
			}

		}
		return -1;// if a negative year, returns -1 to show faulty input
	}

	/**
	 * Calculates the index of the first day of the week in a specified month. The
	 * index returned corresponds to position of this first day of the week within
	 * the DAYS_OF_WEEK class field.
	 * 
	 * @param month which may or may not be abbreviated to 3 or more characters
	 * @param year  of month to determine the first day from (Gregorian Calendar AD)
	 *              String must contain the digits of a single non-negative int for
	 *              year.
	 * @return index within DAYS_OF_WEEK of specified month's first day
	 */
	public static int getFirstDayOfWeekInMonth(String month, String year) {
		int m = getMonthIndex(month) + 1;
		int k = getYearWithinCentury(year);
		if (m == 1) {
			m = 13;
			k--;
		}
		if (m == 2) {
			m = 14;
			k--;
		}
		int j = getCentury(year);
		int h = ((1 + (((13 * (m + 1))) / 5) + k + (k / 4) + (j / 4) + (5 * j)) % 7) - 2;
		if (h < 0) {
			if (h == -2) {
				h = 5;
			}
			if (h == -1) {
				h = 6;
			}
		}
		return h;
	}

	// Note implementation tips in Appendix I below.
	/**
	 * Creates and initializes a 2D String array to reflect the specified month. The
	 * first row of this array [0] should contain labels representing the days of
	 * the week, starting with Monday, as abbreviated in DAYS_OF_WEEK. Every later
	 * row should contain dates under the corresponding days of week. Entries with
	 * no corresponding date in the current month should be filled with a single
	 * period. There should not be any extra rows that are either blank, unused, or
	 * completely filled with periods. For example, the contents for September of
	 * 2019 should look as follows, where each horizontal row is stored in different
	 * array within the 2d result:
	 *
	 * MON TUE WED THU FRI SAT SUN . . . . . . 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15
	 * 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 . . . . . .
	 *
	 * @param month which may or may not be abbreviated to 3 or more characters
	 * @param year  of month generate calendar for (Gregorian Calendar AD) String
	 *              must contain the digits of a single non-negative int for year.
	 * @return 2d array of strings depicting the contents of a calendar
	 */
	public static String[][] generateCalendar(String month, String year) {
		String[][] print = new String[7][7];
		Integer dayCount = 0;
		for (int c = 0; c < 7; c++) {
			print[0][c] = DAYS_OF_WEEK[c] + " ";
		}
		for (int c = 0; c < 7; c++) {
			if (c >= getFirstDayOfWeekInMonth(month, year)) {
				dayCount++;
				print[1][c] = " " + dayCount.toString() + "  ";
			} else {
				print[1][c] = " .  ";
			}
		}
		for (int c = 2; c < 7; c++) {
			for (int cc = 0; cc < 7; cc++) {
				dayCount++;
				if (dayCount <= getNumberOfDaysInMonth(month, year)) {
					if (dayCount < 10) {
						print[c][cc] = " " + dayCount.toString() + "  ";
					} else {
						print[c][cc] = " " + dayCount.toString() + " ";
					}
				} else {
					print[c][cc] = " .  ";
				}
			}
		}
		if (print[6][0] == " .  ") {
			if (print[5][0] == " .  ") {
				String[][] edit1 = new String[5][7];
				for (int c = 0; c < 5; c++) {
					for (int cc = 0; cc < 7; cc++) {
						edit1[c][cc] = print[c][cc];
					}
				}
				return edit1;
			}
			String[][] edit2 = new String[6][7];
			for (int c = 0; c < 6; c++) {
				for (int cc = 0; cc < 7; cc++) {
					edit2[c][cc] = print[c][cc];
				}
			}
			return edit2;
		}
		return print;
	}

	/**
	 * displays calendar printer by asking for month and year and then using helper
	 * methods to create and then display the calendar
	 */
	public static void driver() {
		CalendarPrinter printer = new CalendarPrinter();
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to the Calender Printer.");
		System.out.println("================================");
		System.out.println("Enter the month to print: ");
		String month = input.nextLine();
		System.out.println("Enter the year to print: ");
		String year = input.nextLine();
		String[][] calender = generateCalendar(month, year);
		for (int c = 0; c < calender.length; c++) {
			for (int cc = 0; cc < 7; cc++) {
				System.out.print(calender[c][cc]);
			}
			System.out.println();
		}
		System.out.println("================================");
		System.out.println("Thanks, and have a nice day.");
	}

}

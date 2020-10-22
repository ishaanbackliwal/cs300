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
public class CalendarTester {
	/**
	 * runs through all the test and then runs the driver
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(testGetCentury());
		System.out.println(testGetYearWithinCentury());
		System.out.println(testGetIsLeapYear());
		System.out.println(testGetMonthIndex());
		System.out.println(testGetNumberOfDaysInMonth());
		System.out.println(testGetFirstDayOfWeekInMonth());
		System.out.println(testGenerateCalendar());
		CalendarPrinter.driver();
	}

	/**
	 * test to see if getCentury works
	 *
	 * @return true if code is working properly, false if code isn't
	 */
	public static boolean testGetCentury() {
		if (CalendarPrinter.getCentury("2019") != 20)
			return false;
		if (CalendarPrinter.getCentury("1998") != 19)
			return false;
		if (CalendarPrinter.getCentury("200") != 2)
			return false;
		return true;
	}

	/**
	 * test to see if getYearWithinCentury works
	 *
	 * @return true if code is working properly, false if code isn't
	 */
	public static boolean testGetYearWithinCentury() {
		if (CalendarPrinter.getYearWithinCentury("2019") != 19)
			return false;
		if (CalendarPrinter.getYearWithinCentury("1845") != 45)
			return false;
		if (CalendarPrinter.getYearWithinCentury("400") != 0)
			return false;
		return true;
	}

	/**
	 * test to see if getIsLeapYear works
	 *
	 * @return true if code is working properly, false if code isn't
	 */
	public static boolean testGetIsLeapYear() {
		if (CalendarPrinter.getIsLeapYear("2019") != false)
			return false;
		if (CalendarPrinter.getIsLeapYear("2020") != true)
			return false;
		if (CalendarPrinter.getIsLeapYear("200") != false)
			return false;
		return true;
	}

	/**
	 * test to see if getMonthIndex works
	 *
	 * @return true if code is working properly, false if code isn't
	 */
	public static boolean testGetMonthIndex() {
		if (CalendarPrinter.getMonthIndex("january") != 0)
			return false;
		if (CalendarPrinter.getMonthIndex("septemmmmber") != 8)
			return false;
		if (CalendarPrinter.getMonthIndex("mAr") != 2)
			return false;
		return true;
	}

	/**
	 * test to see if getNumberOfDaysInMonth works
	 *
	 * @return true if code is working properly, false if code isn't
	 */
	public static boolean testGetNumberOfDaysInMonth() {
		if (CalendarPrinter.getNumberOfDaysInMonth("feb", "2019") != 28)
			return false;
		if (CalendarPrinter.getNumberOfDaysInMonth("febuaryafdo", "2016") != 29)
			return false;
		if (CalendarPrinter.getNumberOfDaysInMonth("septemr", "2019") != 30)
			return false;
		if (CalendarPrinter.getNumberOfDaysInMonth("jan", "425") != 31)
			return false;
		return true;
	}

	/**
	 * test to see if getFirstDayOfWeekInMonth works
	 *
	 * @return true if code is working properly, false if code isn't
	 */
	public static boolean testGetFirstDayOfWeekInMonth() {
		if (CalendarPrinter.getFirstDayOfWeekInMonth("sep", "2019") != 6)
			return false;
		if (CalendarPrinter.getFirstDayOfWeekInMonth("jan", "2020") != 2)
			return false;
		if (CalendarPrinter.getFirstDayOfWeekInMonth("feb", "2018") != 3)
			return false;
		return true;
	}

	/**
	 * test to see if generateCalendar works
	 *
	 * @return true if code is working properly, false if code isn't
	 */
	public static boolean testGenerateCalendar() {
		if (CalendarPrinter.generateCalendar("sep", "2019")[3][5].compareTo(" 14 ") != 0)
			return false;
		if (CalendarPrinter.generateCalendar("jan", "2020")[4][3].compareTo(" 23 ") != 0)
			return false;
		if (CalendarPrinter.generateCalendar("jun", "2018")[2][2].compareTo(" 6  ") != 0)
			return false;
		return true;
	}

}

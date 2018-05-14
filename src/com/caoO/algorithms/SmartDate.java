package com.caoO.algorithms;

import com.caoO.exception.IllegalDateException;

import java.util.Objects;

public class SmartDate {
    /// the number of days in big month
    private static final int DAYS_OF_BIG_MONTH = 31;
    /// the number of days in small month
    private static final int DAYS_OF_SMALL_MONTH = 30;
    /// the number of days of February in leap year
    private static final int DAYS_OF_FEB_IN_LEAP = 29;
    /// the number of days of February in common year
    private static final int DAYS_OF_FEB_IN_COMM = 28;
    /// the order number of December
    private static final int Dec = 12;
    /// the number of days before February mod 7
    private static final int DAYS_MOD_7_BEFORE_FEB = DAYS_OF_BIG_MONTH % 7;
    /// the number of days before March in common year mod 7
    private static final int DAYS_MOD_7_BEFORE_MAR_COMM = (DAYS_MOD_7_BEFORE_FEB + DAYS_OF_FEB_IN_COMM) % 7;
    /// the number of days before April in common year mod 7
    private static final int DAYS_MOD_7_BEFORE_APR = (DAYS_MOD_7_BEFORE_MAR_COMM + DAYS_OF_BIG_MONTH) % 7;
    /// the number of days before May in common year mod 7
    private static final int DAYS_MOD_7_BEFORE_MAY = (DAYS_MOD_7_BEFORE_APR + DAYS_OF_SMALL_MONTH) % 7;
    /// the number of days before June in common year mod 7
    private static final int DAYS_MOD_7_BEFORE_JUNE = (DAYS_MOD_7_BEFORE_MAY + DAYS_OF_BIG_MONTH) % 7;
    /// the number of days before July in common year mod 7
    private static final int DAYS_MOD_7_BEFORE_JULY = (DAYS_MOD_7_BEFORE_JUNE + DAYS_OF_SMALL_MONTH) % 7;
    /// the number of days before August in common year mod 7
    private static final int DAYS_MOD_7_BEFORE_AUG = (DAYS_MOD_7_BEFORE_JULY + DAYS_OF_BIG_MONTH) % 7;
    /// the number of days before September in common year mod 7
    private static final int DAYS_MOD_7_BEFORE_SEP = (DAYS_MOD_7_BEFORE_AUG + DAYS_OF_BIG_MONTH) % 7;
    /// the number of days before October in common year mod 7
    private static final int DAYS_MOD_7_BEFORE_OCT = (DAYS_MOD_7_BEFORE_SEP + DAYS_OF_SMALL_MONTH) % 7;
    /// the number of days before November in common year mod 7
    private static final int DAYS_MOD_7_BEFORE_NOV = (DAYS_MOD_7_BEFORE_OCT + DAYS_OF_BIG_MONTH) % 7;
    /// the number of days before December in common year mod 7
    private static final int DAYS_MOD_7_BEFORE_DEC = (DAYS_MOD_7_BEFORE_NOV + DAYS_OF_SMALL_MONTH) % 7;
    /// the number of days in leap year
    private static final int DAYS_OF_LEAP = 366;
    /// the number of days in common year
    private static final int DAYS_OF_COMM = 365;
    /// the number of days per 4 years
    private static final int DAYS_MOD_7_PER_4YEARS = (DAYS_OF_COMM * 3 + DAYS_OF_LEAP) % 7;
    /// reference year
    private static final int YEAR_OF_CONTROL = 2000;

    /// year of this SmartDate object
    private int year;
    /// month of this SmartDate object
    private int month;
    /// day of this SmartDate object
    private int day;

    public SmartDate() {}

    public SmartDate(int year, int month, int day) {
        /// check if this date is legal
        checkDateLegal(year, month, day);
        this.year = year;
        this.month = month;
        this.day = day;
    }

    private SmartDate(String smartDate) {
        String[] dates = smartDate.split("/");
        if (dates.length == 3) {
            try {
                int y = Integer.parseInt(dates[0]);
                int m = Integer.parseInt(dates[1]);
                int d = Integer.parseInt(dates[2]);
                checkDateLegal(y, m, d);
                this.year = y;
                this.month = m;
                this.day = d;
            } catch (NumberFormatException e) {
                throw new IllegalDateException();
            }
        } else {
            throw new IllegalDateException();
        }
    }

    /**
     * Get the day of the week
     *
     * @return the day of the week
     */
    public String dayOfTheWeek() {
        int yearsFromYear = (year - YEAR_OF_CONTROL);
        int pos = 1;
        if (year < YEAR_OF_CONTROL)
            pos = -1;
        int days = yearsFromYear / 4 * DAYS_MOD_7_PER_4YEARS;
        int dayForLeap = 1;
        if (yearsFromYear % 4 > 0) {
            days += DAYS_OF_LEAP + DAYS_OF_COMM * (yearsFromYear % 4 - 1);
            dayForLeap = 0;
        }
        if (yearsFromYear % 4 < 0) {
            days += DAYS_OF_COMM * (yearsFromYear % 4);
            dayForLeap = 0;
        }
        days *= pos;
        switch (month) {
            case 1 :
                break;
            case 2 :
                days += DAYS_MOD_7_BEFORE_FEB * pos;
                break;
            case 3 :
                days += (DAYS_MOD_7_BEFORE_MAR_COMM + dayForLeap) * pos;
                break;
            case 4 :
                days += DAYS_MOD_7_BEFORE_APR * pos;
                break;
            case 5 :
                days += DAYS_MOD_7_BEFORE_MAY * pos;
                break;
            case 6 :
                days += DAYS_MOD_7_BEFORE_JUNE * pos;
                break;
            case 7 :
                days += DAYS_MOD_7_BEFORE_JULY * pos;
                break;
            case 8 :
                days += DAYS_MOD_7_BEFORE_AUG * pos;
                break;
            case 9 :
                days += DAYS_MOD_7_BEFORE_SEP * pos;
                break;
            case 10 :
                days += DAYS_MOD_7_BEFORE_OCT * pos;
                break;
            case 11 :
                days += DAYS_MOD_7_BEFORE_NOV * pos;
                break;
            case 12 :
                days += DAYS_MOD_7_BEFORE_DEC * pos;
                break;
        }
        if (year < YEAR_OF_CONTROL)
            days += 1;
        days += day;
        switch (days % 7) {
            case 0 :
                return "Friday";
            case 1 :
                return "Saturday";
            case 2 :
                return "Sunday";
            case 3 :
                return "Monday";
            case 4 :
                return "Tuesday";
            case 5 :
                return "Wednesday";
            case 6 :
                return "Thursday";
        }
        return "NULL";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SmartDate smartDate = (SmartDate) o;
        return year == smartDate.year &&
                month == smartDate.month &&
                day == smartDate.day;
    }

    @Override
    public int hashCode() {

        return Objects.hash(year, month, day);
    }

    /**
     * Check if this date is legal
     *
     * @param year the year of this date
     * @param month the month of this date
     * @param day the day of this date
     */
    private static void checkDateLegal(int year, int month, int day) {
        if (month < 1 || month > Dec || day < 1)
            throw new IllegalDateException();
        switch (month) {
            case 1 : case 3 : case 5 : case 7 : case 8 : case 10 : case 12 :
                if (day > DAYS_OF_BIG_MONTH)
                    throw new IllegalDateException();
                break;
            case 4 : case 6 : case 9 : case 11 :
                if (day > DAYS_OF_SMALL_MONTH)
                    throw new IllegalDateException();
                break;
            case 2 :
                if (year % 100 == 0) {
                    if (year % 400 == 0 && day > DAYS_OF_FEB_IN_LEAP)
                        throw new IllegalDateException();
                }
                else {
                    if (year % 4 == 0 && day > DAYS_OF_FEB_IN_COMM)
                        throw new IllegalDateException();
                }
                break;
        }
    }
}

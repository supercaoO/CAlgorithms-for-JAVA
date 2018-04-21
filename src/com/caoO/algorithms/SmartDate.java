package com.caoO.algorithms;

import com.caoO.exception.IllegalDateException;

public class SmartDate {
    private static final int DAYS_OF_BIG_MONTH = 31;
    private static final int DAYS_OF_SMALL_MONTH = 30;
    private static final int DAYS_OF_FEB_IN_LEAP = 28;
    private static final int DAYS_OF_FEB_IN_COMM = 29;
    private static final int Dec = 12;

    private int year;
    private int month;
    private int day;

    public SmartDate() {}

    public SmartDate(int year, int month, int day) {
        checkDateLegal(year, month, day);
        this.year = year;
        this.month = month;
        this.day = day;
    }

    private static void checkDateLegal(int year, int month, int day) {
        if (month < 1 || month > Dec || day < 1)
            throw new IllegalDateException();
        switch (month) {
            case 1 :
                if (day > DAYS_OF_BIG_MONTH)
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
            case 3 :
                if (day > DAYS_OF_BIG_MONTH)
                    throw new IllegalDateException();
                break;
            case 4 :
                if (day > DAYS_OF_SMALL_MONTH)
                    throw new IllegalDateException();
                break;
            case 5 :
                if (day > DAYS_OF_BIG_MONTH)
                    throw new IllegalDateException();
                break;
            case 6 :
                if (day > DAYS_OF_SMALL_MONTH)
                    throw new IllegalDateException();
                break;
            case 7 :
                if (day > DAYS_OF_BIG_MONTH)
                    throw new IllegalDateException();
                break;
            case 8 :
                if (day > DAYS_OF_BIG_MONTH)
                    throw new IllegalDateException();
                break;
            case 9 :
                if (day > DAYS_OF_SMALL_MONTH)
                    throw new IllegalDateException();
                break;
            case 10 :
                if (day > DAYS_OF_BIG_MONTH)
                    throw new IllegalDateException();
                break;
            case 11 :
                if (day > DAYS_OF_SMALL_MONTH)
                    throw new IllegalDateException();
                break;
            case 12 :
                if (day > DAYS_OF_BIG_MONTH)
                    throw new IllegalDateException();
                break;
        }
    }
}

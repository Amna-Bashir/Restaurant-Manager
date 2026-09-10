public class Date {

    int day;
    int month;
    int year;

    public Date(int day, int month, int year) {

        this.day = day;
        this.month = month;
        this.year = year;
    }

    public boolean compareDay(Date date) {

        return this.day == date.day
                && this.month == date.month
                && this.year == date.year;
    }

    public boolean compareMonth(Date date) {

        return this.month == date.month
                && this.year == date.year;
    }

    public boolean compareYear(Date date) {

        return this.year == date.year;
    }

    public void changeDate(Date date) {

        this.day = date.day;
        this.month = date.month;
        this.year = date.year;
    }

    public boolean isAfter(Date date) {

        if (this.year > date.year) {
            return true;
        }

        if (this.year == date.year
                && this.month > date.month) {

            return true;
        }

        return this.year == date.year
                && this.month == date.month
                && this.day > date.day;
    }

    public int dayofWeek() {

        int m = month;
        int y = year;

        if (m < 3) {
            m += 12;
            y--;
        }

        int k = y % 100;
        int j = y / 100;

        return (
                day
                        + (13 * (m + 1)) / 5
                        + k
                        + k / 4
                        + j / 4
                        + 5 * j
        ) % 7;
    }

    public int julianDayNumber() {

        int m = month;
        int y = year;

        if (m < 3) {
            m += 12;
            y--;
        }

        int a = y / 100;
        int b = 2 - a + a / 4;

        return (int) (365.25 * (y + 4716))
                + (int) (30.6001 * (m + 1))
                + day
                + b
                - 1524;
    }

    public int daysDifference(Date date) {

        return this.julianDayNumber()
                - date.julianDayNumber();
    }

    public Date addDays(int days) {

        Date temp =
                new Date(day, month, year);

        temp.day += days;

        while (temp.day > temp.lastDayofMonth()) {

            temp.day -= temp.lastDayofMonth();
            temp.month++;

            if (temp.month > 12) {
                temp.month = 1;
                temp.year++;
            }
        }

        return temp;
    }

    public int lastDayofMonth() {

        if (month == 2) {

            if (year % 4 == 0
                    && (year % 100 != 0
                    || year % 400 == 0)) {

                return 29;
            }

            return 28;
        }

        if (month == 4
                || month == 6
                || month == 9
                || month == 11) {

            return 30;
        }

        return 31;
    }

    @Override
    public String toString() {

        return day + "/" + month + "/" + year;
    }

    public void reservation(
            Date date,
            boolean[] space1,
            boolean[] space2,
            boolean[] space3) {

        char[][] arr =
                new char[37][127];

        int d = 1;
        boolean first = true;

        Date temp =
                new Date(1, date.month, date.year);

        int w = temp.dayofWeek();
        int lastDay = temp.lastDayofMonth();

        for (int row = 0; row < arr.length; row++) {

            for (int col = 0; col < arr[0].length; col++) {

                arr[row][col] = ' ';
            }
        }

        for (int i = 0; i < arr.length; i++) {

            for (int k = 0; k < arr[0].length; k++) {

                if (k % 18 == 0) {
                    arr[i][k] = '|';
                }

                if (i % 6 == 0) {
                    arr[i][k] = '-';
                }
            }
        }

        for (int i = 0;
             i < arr.length && d <= lastDay;
             i++) {

            for (int k = 0;
                 k < arr[0].length && d <= lastDay;
                 k++) {

                if (i > 6) {

                    if (d < 10) {

                        if (i % 6 == 1
                                && k % 18 == 9
                                && (!first
                                || (k - 9) / 18 == w)) {

                            first = false;

                            arr[i][k] =
                                    (char) (d + '0');

                            arr[i + 2][k - 1] =
                                    space1[d - 1] ? 'X' : 'O';

                            arr[i + 2][k] =
                                    space2[d - 1] ? 'X' : 'O';

                            arr[i + 2][k + 1] =
                                    space3[d - 1] ? 'X' : 'O';

                            d++;
                        }

                    } else {

                        if (i % 6 == 1
                                && k % 18 == 9) {

                            arr[i][k] =
                                    (char) ((d % 10) + '0');

                            arr[i][k - 1] =
                                    (char) (((d - (d % 10))
                                            / 10) + '0');

                            arr[i + 2][k - 1] =
                                    space1[d - 1] ? 'X' : 'O';

                            arr[i + 2][k] =
                                    space2[d - 1] ? 'X' : 'O';

                            arr[i + 2][k + 1] =
                                    space3[d - 1] ? 'X' : 'O';

                            d++;
                        }
                    }
                }
            }
        }

        String[] headers = {
                "SAT",
                "SUN",
                "MON",
                "TUE",
                "WED",
                "THU",
                "FRI"
        };

        for (int i = 0; i < 7; i++) {

            int col = 8 + i * 18;

            arr[3][col] =
                    headers[i].charAt(0);

            arr[3][col + 1] =
                    headers[i].charAt(1);

            arr[3][col + 2] =
                    headers[i].charAt(2);
        }

        if (lastDay == 28 && w == 0) {

            for (int i = arr.length - 6;
                 i < arr.length;
                 i++) {

                for (int m = 0;
                     m < arr[0].length;
                     m++) {

                    arr[i][m] = ' ';
                }
            }
        }

        Order.printer2D(arr);
    }
}
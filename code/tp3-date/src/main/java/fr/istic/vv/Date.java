package fr.istic.vv;

class Date implements Comparable<Date> {
    private static final int[] nbJours={31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private int day, month, year;

    public Date(int day, int month, int year) throws Exception{
        if (!isValidDate(day, month, year)) throw new Exception("mois illégal");
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public static boolean isValidDate(int day, int month, int year) {
        if( month<0 || month>12) return false;
        if( (month == 2 && isLeapYear(year) && day>0 && day<=29) || ( day>0 && day<=nbJours[month-1])) return true;;
        return false;
    }

    public static boolean isLeapYear(int year) {
        return (year%4==0 && year%100!=0) || year%400==0;
    }

    public Date nextDate() throws Exception {
        int day = this.day, month = this.month, year = this.year;
        try{
            ++day;
            isValidDate(day,month,year);
        }catch(Exception ex){
            try{
                ++month;
                day = 1;
                isValidDate(day,month,year);
            }catch(Exception ex1){
                try{
                    ++year;
                    month = 1;
                    day = 1;
                    isValidDate(day,month,year);
                }catch(Exception ex2){
                    System.out.println("Something went wrong.");
                }
            }
        }
        return new Date(day, month, year);
    }

    public Date previousDate() throws Exception {
        int day = this.day, month = this.month, year = this.year;
        try{
            --day;
            isValidDate(day,month,year);
        }catch(Exception ex){
            try{
                --month;
                day = nbJours[month - 1];
                if(isLeapYear(year) &&  month == 2) ++day;
                isValidDate(day,month,year);
            }catch(Exception ex1){
                try{
                    --year;
                    month = 12;
                    day = 31;
                    isValidDate(day,month,year);
                }catch(Exception ex2){
                    System.out.println("Something went wrong.");
                }
            }
        }
        return new Date(day, month, year);
    }

    public int compareTo(Date other) {
        if (this.day < other.getDay() || this.month < other.getMonth() || this.year < other.getYear()) return -1;
        else if (this.day > other.getDay() || this.month > other.getMonth() || this.year > other.getYear()) return 1;
        return 0;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public int getYear() {
        return year;
    }
}
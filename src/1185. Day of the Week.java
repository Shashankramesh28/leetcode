class Solution {
    public String dayOfTheWeek(int day, int month, int year) {
        String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        int[] months = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int no_days = day;
        for(int i =1; i< month; i++){
            no_days+=months[i];
        }

        if( month > 2 && ((year % 400 == 0) || ((year % 100 != 0) && (year % 4 == 0)))){
            no_days++;
        }
        
        year--;

        no_days+=(year + (year/4) - (year/100) + (year/400));

        return days[no_days % 7];
    }
}
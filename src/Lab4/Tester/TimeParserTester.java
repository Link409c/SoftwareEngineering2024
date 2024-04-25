package Lab4.Tester;

import Lab4.Program.TimeParser;

public class TimeParserTester {
    public static void main(String[] args) {
        //test case for correct data type
        //test case for length of entry
        //test case for colon placement
        //check that colon index -1 returns -1
        //test case for hours value
        //correct output
        //bad output
        //max_hours branch
        //test case for minutes value
        //correct output
        //bad output
        //max_mins branch
        //test case for seconds value
        //test case for AM / PM
        //test case for syntax
        TimeParser tp = new TimeParser();
        String[] entries = {"not a time", "500:30 PM", ":530 PM", "530 PM",
                "5:30 PM", "14:30 PM", "25:30 PM", "5:30 PM", "5:651 PM", "5:61 PM",
                "5:30:00 PM", "5:30:99 PM", "5:30 AM", "5:30 ZM", "530PM"};
        for(int i = 0; i < entries.length; i++) {
            try {
                System.out.printf("Entry: %-10s | Output: %-6s\n", entries[i],
                        tp.parseTimeToMinutes(entries[i]));
            }catch(Exception e){
                System.out.printf("Entry: %-10s | %s Thrown.\n",
                        entries[i], e.getClass());
            }
        }
    }
}
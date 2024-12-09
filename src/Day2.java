import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Day2 {
    public static void main(String[] args) {
        ArrayList<String> list = getFileData("inputs/day2");
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            ArrayList<Integer> report = new ArrayList<>();
            String repString = list.get(i);
            System.out.println(repString);
            while (repString.indexOf(" ") > 0) {
                report.add(Integer.parseInt(repString.substring(0,repString.indexOf(" "))));
                repString = repString.substring(repString.indexOf(" ")+1);
            }
            report.add(Integer.parseInt(repString));
            System.out.println(report);
            boolean safe = true;
            boolean increasing = report.get(0) - report.get(1) <= 0;
            for (int n = 0; n < report.size() - 1; n++) {
                if(increasing && report.get(n) - report.get(n+1) > 0) {
                    System.out.println(report.get(n));
                    System.out.println(report.get(n+1));
                    safe = false;
                    System.out.println("increasing error");
                    break;
                }
                if(report.get(n) - report.get(n+1) > 3) {
                    System.out.println(report.get(n));
                    System.out.println(report.get(n+1));
                    safe = false;
                    System.out.println("greater than 3");
                    break;
                }
                if(report.get(n) - report.get(n+1) < -3) {
                    System.out.println(report.get(n));
                    System.out.println(report.get(n+1));
                    safe = false;
                    System.out.println("less than -3");
                    break;
                }
                if (report.get(n) - report.get(n+1) == 0) {
                    System.out.println(report.get(n));
                    System.out.println(report.get(n+1));
                    safe = false;
                    System.out.println("zero error");
                    break;
                }
            }
            if (safe) {
                count++;
            }
            System.out.println("increasing: " + increasing +"\nSafe: " + safe);
        }
        System.out.println("2024 Advent Day 2 Part 1 -\nTotal safe reports: " + count);
    }
    public static ArrayList<String> getFileData(String fileName) {
        ArrayList<String> fileData = new ArrayList<String>();
        try {
            File f = new File(fileName);
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                if (!line.equals(""))
                    fileData.add(line);
            }
            return fileData;
        }
        catch (FileNotFoundException e) {
            return fileData;
        }
    }
}

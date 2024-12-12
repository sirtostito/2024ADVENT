import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Day2 {
    public static void main(String[] args) {
        ArrayList<String> list = getFileData("inputs/day2");
        int count = 0;
        int count2 = 0;
        for (int i = 0; i < list.size(); i++) {
            ArrayList<Integer> report = new ArrayList<>();
            String repString = list.get(i);
            while (repString.indexOf(" ") > 0) {
                report.add(Integer.parseInt(repString.substring(0,repString.indexOf(" "))));
                repString = repString.substring(repString.indexOf(" ")+1);
            }
            report.add(Integer.parseInt(repString));
            boolean safe = numDiff(report,increasing(report));
            if (safe) {
                count++;
            }
            safe = numDiff2(report,increasing(report));
            if (safe) {
                count2++;
            }
        }
        System.out.println("2024 Advent Day 2 Part 1 -\nTotal safe reports: " + count);
        System.out.println("2024 Advent Day 2 Part 2 -\nTotal safe reports: " + count2);
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

    public static boolean increasing(ArrayList<Integer> report) {
        if (report.get(0) < report.get(1)) {
            return true;
        } else if (report.get(0) > report.get(1)) {
            return false;
        } else {
            return false;
        }
    }

    public static boolean numDiff(ArrayList<Integer> report, boolean isIncreasing) {
        if (isIncreasing) {
            for (int i = 0; i < report.size() - 1; i++) {
                if (report.get(i) - report.get(i + 1) < -3
                || report.get(i) - report.get(i + 1) > -1) {
                    return false;
                }
            }
        } else {
            for (int i = 0; i < report.size() - 1; i++) {
                if (report.get(i) - report.get(i + 1) > 3
                || report.get(i) - report.get(i + 1) < 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean numDiff2(ArrayList<Integer> report, boolean isIncreasing) {
        boolean fault = false;
        if (isIncreasing) {
            for (int i = 0; i < report.size() - 1; i++) {
                if (report.get(i) - report.get(i + 1) < -3 || report.get(i) - report.get(i + 1) > -1) {
                    if (fault == false) {
                        System.out.println(report);
                        int num = report.remove(i);
                        boolean saved = numDiff(report,isIncreasing);
                        report.add(i,num);
                        report.remove(i+1);
                        boolean saved2 = numDiff(report,isIncreasing);
                        System.out.println(saved || saved2);
                        return saved || saved2;
                    } else {
                        return false;
                    }
                }
            }
        } else {
            for (int i = 0; i < report.size() - 1; i++) {
                if (report.get(i) - report.get(i + 1) > 3 || report.get(i) - report.get(i + 1) < 1) {
                    if (fault == false) {
                        System.out.println(report);
                        int num = report.remove(i);
                        boolean saved = numDiff(report,isIncreasing);
                        report.add(i,num);
                        report.remove(i+1);
                        boolean saved2 = numDiff(report,isIncreasing);
                        System.out.println(saved || saved2);
                        return saved || saved2;
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}

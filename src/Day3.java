import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day3 {
    public static void main(String[] args) {
        ArrayList<String> instructions = getFileData("inputs/day3");
        int total = 0;
        for (int lines = 0; lines < instructions.size(); lines++) {
            String instruction = instructions.get(lines);
            while (instruction.contains("mul(")) {
                int mul = instruction.indexOf("mul("); // first index of mul
                String mulString;
                if (instruction.length() - 1 < mul+11) {
                    mulString = instruction.substring(mul, mul + 11); // highest possible index for a valid mulString
                } else {
                    mulString = instruction.substring(mul);
                }
                if (mulString.contains(")")) {
                    mulString = mulString.substring(0,mulString.indexOf(")") + 1);
                    if (mulString.contains(",")) {
                        String[] nums = mulString.substring(4,mulString.length()-1).split(",");
                        if (nums.length == 2 && nums[0].chars().allMatch( Character::isDigit ) && nums[1].chars().allMatch( Character::isDigit )) {
                            /*
                            Checks if there is only one comma
                            Checks if the first field delimited by comma is numerical
                            Checks if the second field delimited by comma is numerical
                             */
                            System.out.println(mulString);
                            System.out.println(Integer.parseInt(nums[0]) + " " + Integer.parseInt(nums[1]));
                            System.out.println(Integer.parseInt(nums[0]) * Integer.parseInt(nums[1]));
                            System.out.println("Total: " + total);
                            total += Integer.parseInt(nums[0]) * Integer.parseInt(nums[1]);
                            System.out.println("New total: " + total);
                        }
                    }
                }
                instruction = instruction.substring(mul+1);
            }
        }
        System.out.println(total);
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

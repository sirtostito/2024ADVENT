import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day3 {
    public static void main(String[] args) {
        ArrayList<String> instructions = getFileData("inputs/day3");
        int total = 0;
        int total2 = 0;
        boolean enabled = true;
        for (int lines = 0; lines < instructions.size(); lines++) {
            String instruction = instructions.get(lines);
            while (instruction.contains("mul(")) {
                if (instruction.indexOf("do()") < instruction.indexOf("mul(")) {
                    enabled = true;
                }
                if (instruction.indexOf("don't()") < instruction.indexOf("mul(")) {
                    enabled = false;
                }
                total2 += multiply(instruction,enabled);
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
                            total += Integer.parseInt(nums[0]) * Integer.parseInt(nums[1]);
                        }
                    }
                }
                instruction = instruction.substring(mul+1);
            }
        }
        System.out.println("Day 3 Pt 1 - " + total
        + "\nDay 3 Pt 2 - " + total2);
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

    public static int multiply(String string, boolean enabled) {
        if (enabled) {
            if (string.indexOf("mul(") < string.indexOf("don't()")) {
                int mul = string.indexOf("mul("); // first index of mul
                String mulString;
                if (string.length() - 1 < mul + 11) {
                    mulString = string.substring(mul, mul + 11); // highest possible index for a valid mulString
                } else {
                    mulString = string.substring(mul);
                }
                if (mulString.contains(")")) {
                    mulString = mulString.substring(0, mulString.indexOf(")") + 1);
                    if (mulString.contains(",")) {
                        String[] nums = mulString.substring(4, mulString.length() - 1).split(",");
                        if (nums.length == 2 && nums[0].chars().allMatch(Character::isDigit) && nums[1].chars().allMatch(Character::isDigit)) {
                            /*
                            Checks if there is only one comma
                            Checks if the first field delimited by comma is numerical
                            Checks if the second field delimited by comma is numerical
                             */
                            return Integer.parseInt(nums[0]) * Integer.parseInt(nums[1]);
                        }
                    }
                }
            }
        }
        return 0;
    }
    public static int multiply(String string) {
        if (string.indexOf("mul(") < string.indexOf("don't()")) {
            int mul = string.indexOf("mul("); // first index of mul
            String mulString;
            if (string.length() - 1 < mul + 11) {
                mulString = string.substring(mul, mul + 11); // highest possible index for a valid mulString
            } else {
                mulString = string.substring(mul);
            }
            if (mulString.contains(")")) {
                mulString = mulString.substring(0, mulString.indexOf(")") + 1);
                if (mulString.contains(",")) {
                    String[] nums = mulString.substring(4, mulString.length() - 1).split(",");
                    if (nums.length == 2 && nums[0].chars().allMatch(Character::isDigit) && nums[1].chars().allMatch(Character::isDigit)) {
                            /*
                            Checks if there is only one comma
                            Checks if the first field delimited by comma is numerical
                            Checks if the second field delimited by comma is numerical
                             */
                        return Integer.parseInt(nums[0]) * Integer.parseInt(nums[1]);
                    }
                }
            }
        }
        return 0;
    }
}

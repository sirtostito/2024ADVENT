import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Day4 {
    public static void main(String[] args) {
        ArrayList<String> wordSearch = getFileData("inputs/day4");
        String[][] grid = new String[wordSearch.getFirst().length()][wordSearch.size()];
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[0].length; y++) {
                grid[x][y] = String.valueOf(wordSearch.get(y).charAt(x));
            }
        }
//        String[][] test = new String[3][10];
//        System.out.println(test[0].length + " " + test.length);
        int count = 0;
        for (int y = 0; y < grid[0].length; y++) {
            for (int x = 0; x < grid.length; x++) {
                if (grid[x][y].equals("X")) {
                    count += checkAll(grid,x,y);
                }
                System.out.print(grid[x][y]);
            }
            System.out.println();
        }
        System.out.println("Day 4 Part 1 -\nTotal XMAS: " + count); //not 1950 or 2557
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

    public static int checkVertical(String[][] grid, int x, int y) {
        int count = 0;
        if (y < grid[0].length - 3) {
            if (grid[x][y+1].equals("M") && grid[x][y+2].equals("A") && grid[x][y+3].equals("S")) {
                count++;
            }
        }
        if (y > 2) {
            if (grid[x][y - 1].equals("M") && grid[x][y - 2].equals("A") && grid[x][y - 3].equals("S")) {
                count++;
            }
        }
        return count;
    }

    public static int checkHorizontal(String[][] grid, int x, int y) {
        int count = 0;
        if (x < grid.length - 3) {
            if (grid[x+1][y].equals("M") && grid[x+2][y].equals("A") && grid[x+3][y].equals("S")) {
                count++;
            }
        }
        if (x > 2) {
            if (grid[x - 1][y].equals("M") && grid[x - 2][y].equals("A") && grid[x - 3][y].equals("S")) {
                count++;
            }
        }
        return count;
    }

    public static int checkDiagonal(String[][] grid, int x, int y) {
        int count = 0;
        if (x < grid.length - 3 && y < grid[0].length - 3) { // south-east
            if (grid[x+1][y+1].equals("M") && grid[x+2][y+2].equals("A") && grid[x+3][y+3].equals("S")) {
                count++;
            }
        }
        if (x < grid.length - 3  && y > 2) { // north-east
            if (grid[x+1][y-1].equals("M") && grid[x+2][y-2].equals("A") && grid[x+3][y-3].equals("S")) {
                count++;
            }
        }
        if (x > 2 && y < grid[0].length - 3) { // south-west
            if (grid[x-1][y+1].equals("M") && grid[x-2][y+2].equals("A") && grid[x-3][y+3].equals("S")) {
                count++;
            }
        }
        if (x > 2 && y > 2) { // north-west
            if (grid[x - 1][y - 1].equals("M") && grid[x - 2][y - 2].equals("A") && grid[x - 3][y - 3].equals("S")) {
                count++;
            }
        }
        return count;
    }

    public static int checkAll(String[][] grid, int x, int y) {
        return checkDiagonal(grid,x,y) + checkVertical(grid,x,y) + checkHorizontal(grid,x,y);
    }

}

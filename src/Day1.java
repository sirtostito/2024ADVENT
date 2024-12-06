import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class Day1 {
    public static void main(String[] args) {
        ArrayList<String> list = getFileData("inputs/lists");
        ArrayList<Integer> leftList = new ArrayList<>();
        ArrayList<Integer> rightList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            leftList.add(Integer.parseInt(list.get(i).substring(0,list.get(i).indexOf(" "))));
            rightList.add(Integer.parseInt(list.get(i).substring(list.get(i).lastIndexOf(" ")+1)));
        }


        for (int i = 0; i < leftList.size(); i++) {
            int num = leftList.get(i);
            for (int n = i + 1; n < leftList.size(); n++) {
                if (leftList.get(n) < num) {
                    num = leftList.get(n);
                    leftList.add(i,num);
                    leftList.remove(n+1);
                }
            }
            num = rightList.get(i);
            for (int n = i + 1; n < rightList.size(); n++) {
                if (rightList.get(n) < num) {
                    num = rightList.get(n);
                    rightList.add(i,num);
                    rightList.remove(n+1);
                }
            }
        }


        int total = 0;
        for (int i = 0; i < leftList.size(); i++) {
            total += Math.abs(leftList.get(i) - rightList.get(i));
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


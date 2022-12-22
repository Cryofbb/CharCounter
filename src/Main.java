import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter file path");
        String filePath = sc.nextLine();
        HashMap<Integer, Integer> hash = new HashMap<>();
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        int l = 0;
        while (true) {
            String line = reader.readLine();
            l++;
            if (line == null) {break;}
            for (int i = 0; i < line.length(); i++) {
                char c = line.charAt(i);
                //English
                if (c == 'a') {
                    int value = hash.getOrDefault((int) c, 0);
                    hash.put((int) c, value + 1);
                }
                //Russian
                if (c == 'а') {
                    int value = hash.getOrDefault((int) c, 0);
                    hash.put((int) c, value + 1);
                }
            }
        }
        reader.close();
        for (int key : hash.keySet()) {
            System.out.println((char) key + ": " + hash.get(key));
        }
        System.out.println("Lines " + l);
    }
}
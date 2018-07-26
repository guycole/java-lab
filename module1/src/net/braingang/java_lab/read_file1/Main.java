package net.braingang.java_lab.read_file1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public void execute(String fileName) throws FileNotFoundException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));

        try {
            StringBuilder stringBuilder = new StringBuilder();
            String line = bufferedReader.readLine();

            while (line != null) {
                stringBuilder.append(line);
                //stringBuilder.append(System.lineSeparator());
                line = bufferedReader.readLine();
            }

            System.out.println(stringBuilder.toString());
        } catch(IOException exception) {
            exception.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch(IOException exception) {
                    exception.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println("begin");

        Main main = new Main();
        main.execute("/Users/gsc/IdeaProjects/java-lab/module1/src/net/braingang/java_lab/read_file1/Main.java");
        System.out.println("end");
    }
}

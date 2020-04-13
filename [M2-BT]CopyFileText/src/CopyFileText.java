import java.io.*;
import java.util.Scanner;

public class CopyFileText {

    public static String copyFile(String path){
        String content = "";
        File file = new File(path);
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;

        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e){
                e.printStackTrace();
            }
        } else {
            try {
                fileReader = new FileReader(file);
                bufferedReader = new BufferedReader(fileReader);

                String line;
                while ((line = bufferedReader.readLine()) != null){
                    content += line + "\n";
                }
            } catch (IOException e){
                e.printStackTrace();
            } finally {
                try {
                    fileReader.close();
                } catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
        return content;
    }

    public static void createNewFile(String path, String content){
        File file = new File(path);
        FileWriter fileWriter = null;
        if (!file.exists()){
            try {
                file.createNewFile();
                fileWriter = new FileWriter(file);
                fileWriter.write(content);
            } catch (IOException e){
                e.printStackTrace();
            }
        } else {
            try {
                fileWriter = new FileWriter(file);
                fileWriter.write(content);
            } catch (IOException e){
                e.printStackTrace();
            } finally {
                try {
                    fileWriter.close();
                } catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter file path to copy content: ");
        String originalFilePath = scanner.nextLine();
        System.out.println("Enter new file path: ");
        String newFilePath = scanner.nextLine();
        createNewFile(newFilePath, copyFile(originalFilePath));
    }
}

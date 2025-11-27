import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
public class CopyFile {
    public static void main(String[] args) {
        String sourceFile = "v1.txt";
        String targetFile = "f2.txt";
        try (FileInputStream in = new FileInputStream(sourceFile); 
            FileOutputStream out = new FileOutputStream(targetFile, true)) {
            out.write(in.readAllBytes());
            System.out.println("Данные добавлены в " + targetFile);
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Ошибка при работе с файлом:" + e.getMessage());
        }
    }
}




































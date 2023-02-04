import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class project{
    static Scanner sc = new Scanner(System.in);
    private static void Encryption(){
        System.out.println("Enter Key : ");
        int key = sc.nextInt();
        FileOutputStream Image_output;
        try (FileInputStream Image_input = new FileInputStream("../assets/image.png")) {
            byte data[] = new byte[Image_input.available()];
            Image_input.read(data);
            int i = 0;

            for (byte b : data) {
                data[i] = (byte)(b^key);
                i++;
            }

            Image_output = new FileOutputStream("../assets/image.png");
            Image_output.write(data);

            Image_input.close();
            Image_output.close();

            System.out.println("Encryption Done");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        Encryption();
    }
}
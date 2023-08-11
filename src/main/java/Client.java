import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try (
                Socket socket = new Socket("localHost", 8989);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream());
        ) {
            String word = "бизнес"; // слово, которое нужно найти
            out.println(word);
            out.flush();

            String response = in.readLine(); // ответ от сервера
            System.out.println(response);
        } catch (IOException e) {
            System.out.println("Ошибка при работе с сервером");
            e.printStackTrace();
        }
    }
}
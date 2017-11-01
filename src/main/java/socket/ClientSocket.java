import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientSocket {


    public ClientSocket() {
    }

    public void start() {
        System.out.println("客户端启动...");
        System.out.println("试试输入help获取帮助吧！（输入bye可以结束会话）");

        try (
                Socket socket = new Socket("127.0.0.1", 10010);
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))
        ) {
            Scanner scanner = new Scanner(System.in);
            String input;
            String serverMsg;
            while (true) {
                input = scanner.nextLine();
                if("bye".equals(input)) {
                    break;
                }

                writer.write(input);
                writer.newLine();
                writer.flush();

                if ((serverMsg = reader.readLine()) != null) {
                    System.out.println("服务器说:" + serverMsg);
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new ClientSocket().start();
    }
}

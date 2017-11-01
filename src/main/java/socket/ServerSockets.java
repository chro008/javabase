import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSockets {

    public void service() throws IOException {
        ServerSocket serverSocket = new ServerSocket(10010);
        System.out.println("服务器启动成功，正在监听...");
        int index = 0;
        while (true) {
            /*建立链接*/
            Socket client = serverSocket.accept();
            System.out.println("connect:" + (index++) + ",address is:" + client.getInetAddress().getHostAddress());

            new Thread(new SeverSocketThread(client)).start();

        }
    }

    public static void main(String[] args) {
        ServerSockets serverSockets = new ServerSockets();
        try {
            serverSockets.service();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    class SeverSocketThread implements Runnable {
        private volatile Socket socket;

        public SeverSocketThread(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                String temp;
                String returnMsg;
                while ((temp = reader.readLine()) != null) {
                    System.out.print("Server:accept msg:" + temp + "\n");
                    switch (temp) {
                        case "help":
                            returnMsg = "可输入项为:sing、eat、drink、play";
                            break;
                        case "sing":
                            returnMsg = "你想听什么?";
                            break;
                        case "eat":
                            returnMsg = "你饿了吗?";
                            break;
                        case "drink":
                            returnMsg = "我这有瓶可乐，你要吗？";
                            break;
                        case "play":
                            returnMsg = "一起来绝地求生吧？";
                            break;
                        default:
                            returnMsg = "你在说什么？我没有收到！";
                    }

                    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

                    writer.write(returnMsg);
                    writer.newLine();
                    writer.flush();

                }



            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

}

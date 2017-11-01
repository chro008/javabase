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
/*
D:\NewProject\java_8_131\bin\java "-javaagent:D:\Program Files\JetBrains\IntelliJ IDEA 2017.1.2\lib\idea_rt.jar=57193:D:\Program Files\JetBrains\IntelliJ IDEA 2017.1.2\bin" -Dfile.encoding=UTF-8 -classpath D:\NewProject\java_8_131\jre\lib\charsets.jar;D:\NewProject\java_8_131\jre\lib\deploy.jar;D:\NewProject\java_8_131\jre\lib\ext\access-bridge-64.jar;D:\NewProject\java_8_131\jre\lib\ext\cldrdata.jar;D:\NewProject\java_8_131\jre\lib\ext\dnsns.jar;D:\NewProject\java_8_131\jre\lib\ext\jaccess.jar;D:\NewProject\java_8_131\jre\lib\ext\jfxrt.jar;D:\NewProject\java_8_131\jre\lib\ext\localedata.jar;D:\NewProject\java_8_131\jre\lib\ext\nashorn.jar;D:\NewProject\java_8_131\jre\lib\ext\sunec.jar;D:\NewProject\java_8_131\jre\lib\ext\sunjce_provider.jar;D:\NewProject\java_8_131\jre\lib\ext\sunmscapi.jar;D:\NewProject\java_8_131\jre\lib\ext\sunpkcs11.jar;D:\NewProject\java_8_131\jre\lib\ext\zipfs.jar;D:\NewProject\java_8_131\jre\lib\javaws.jar;D:\NewProject\java_8_131\jre\lib\jce.jar;D:\NewProject\java_8_131\jre\lib\jfr.jar;D:\NewProject\java_8_131\jre\lib\jfxswt.jar;D:\NewProject\java_8_131\jre\lib\jsse.jar;D:\NewProject\java_8_131\jre\lib\management-agent.jar;D:\NewProject\java_8_131\jre\lib\plugin.jar;D:\NewProject\java_8_131\jre\lib\resources.jar;D:\NewProject\java_8_131\jre\lib\rt.jar;D:\Workspaces\IntelliJ\99click-sf\sz-rtana-client\target\test-classes;D:\Workspaces\IntelliJ\99click-sf\sz-rtana-client\target\classes;D:\Workspaces\IntelliJ\99click-sf\sz-sysenv\target\classes;D:\NewProject\apache-maven-3.5.0\repo\com\alibaba\druid\1.0.31\druid-1.0.31.jar;D:\NewProject\apache-maven-3.5.0\repo\com\mysql\mysql-jdbc\5.1.42\mysql-jdbc-5.1.42.jar;D:\NewProject\apache-maven-3.5.0\repo\com\shangzhu\sz-commons\0.0.9-20170906\sz-commons-0.0.9-20170906.jar;D:\NewProject\apache-maven-3.5.0\repo\joda-time\joda-time\2.6\joda-time-2.6.jar;D:\NewProject\apache-maven-3.5.0\repo\commons-codec\commons-codec\1.9\commons-codec-1.9.jar;D:\NewProject\apache-maven-3.5.0\repo\javax\mail\mail\1.4.7\mail-1.4.7.jar;D:\NewProject\apache-maven-3.5.0\repo\javax\activation\activation\1.1\activation-1.1.jar;D:\NewProject\apache-maven-3.5.0\repo\ch\qos\logback\logback-core\1.1.2\logback-core-1.1.2.jar;D:\NewProject\apache-maven-3.5.0\repo\ch\qos\logback\logback-classic\1.1.2\logback-classic-1.1.2.jar;D:\NewProject\apache-maven-3.5.0\repo\org\slf4j\slf4j-api\1.7.6\slf4j-api-1.7.6.jar;D:\NewProject\apache-maven-3.5.0\repo\com\alibaba\fastjson\1.2.3\fastjson-1.2.3.jar;D:\NewProject\apache-maven-3.5.0\repo\junit\junit\3.8.1\junit-3.8.1.jar ClientSocket
客户端启动...
试试输入help获取帮助吧！（输入bye可以结束会话）
hel
服务器说:你在说什么？我没有收到！
help
服务器说:可输入项为:sing、eat、drink、play
sing
服务器说:你想听什么?
eat
服务器说:你饿了吗?
drink
服务器说:我这有瓶可乐，你要吗？
play
服务器说:一起来绝地求生吧？
bye

Process finished with exit code 0
*/



import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
//import java.util.Scanner;

public class TaskServerWhile {
    public static void main(String[] args) {

        try {

            ServerSocket server = new ServerSocket(5000); // ポート番号を指定し、クライアントとの接続の準備を行う

            // Scanner s = new Scanner(System.in);
            Socket socket = server.accept(); // クライアントからの接続要求を待ち、
            // 要求があればソケットを取得し接続を行う
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            TaskObject task = (TaskObject) ois.readObject();

            // String a = "quit";

            task.exec();
            System.out.println("nyan");

            task.getResult();
            // int b = response.getResult();
            // System.out.println("yukari cat" + a);
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

            oos.writeObject(task);
            oos.flush();

            // System.out.println("通ってる?");

            oos.close();
        } catch (

        BindException e) {
            // System.out.println("殺しますよ");
        } catch (Exception e) {

        }

    }
}
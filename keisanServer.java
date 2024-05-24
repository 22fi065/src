
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;

public class keisanServer {
    public static void main(String[] args) {
        try {

            ServerSocket server = new ServerSocket(5000); // ポート番号を指定し、クライアントとの接続の準備を行う

            Socket socket = server.accept(); // クライアントからの接続要求を待ち、
            // 要求があればソケットを取得し接続を行う
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            TaskObject task = (TaskObject) ois.readObject();
            task.setExecNumber(100);
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

            TaskObject response = new TaskObject();
            response.exec();
            response.getResult();
            int a = response.getResult();
            System.out.println("yukari cat" + a);
            // System.out.println("通ってる?");
            oos.writeObject(response);
            oos.flush();

            oos.close();
        } catch (BindException e) {
            // System.out.println("殺しますよ");
        } catch (Exception e) {

        }
    }
}
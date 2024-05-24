import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.BindException;
import java.net.Socket;
import java.util.Scanner;

public class TaskClientWhile {
    public static void main(String[] args) {

        try {
            Socket socket = new Socket("localhost", 5000);

            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            Scanner s = new Scanner(System.in);
            String owari = "quit";
            TaskObject task = new TaskObject();

            while (owari != s.next()) {
                System.out.println("数字を入力して");

                task.setExecNumber(s.nextInt());
                task.exec();

                System.out.println(task.getResult());
                oos.writeObject(task);
                oos.flush();
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                TaskObject okaeshiPresent = (TaskObject) ois.readObject();

                int replayContent = okaeshiPresent.getResult();

                System.out.println(replayContent + "をもらいました！");
            }

            oos.close();
            socket.close();
        } catch (BindException e) {
            System.out.println("殺しますよ");
        } catch (Exception e) {

        }

    }
}

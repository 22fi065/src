
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.BindException;
import java.net.Socket;

public class keisanClient {
        public static void main(String[] args) {

                try {
                        Socket socket = new Socket("localhost", 5000);

                        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

                        TaskObject task = new TaskObject();
                        task.setExecNumber(100);
                        task.exec();
                        System.out.println(task.getResult());
                        oos.writeObject(task);
                        oos.flush();

                        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                        TaskObject okaeshiPresent = (TaskObject) ois.readObject();

                        int replayContent = okaeshiPresent.getResult();

                        System.out.println(replayContent + "をもらいました！");
                        oos.close();
                        socket.close();
                } catch (BindException e) {
                } catch (Exception e) {

                }

        }
}
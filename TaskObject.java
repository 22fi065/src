import java.io.Serializable;

public class TaskObject implements ITask, Serializable {
    private static int n;
    private static int sosuu;

    public void setExecNumber(int x) {
        n = x;
    } // クライアントで最初に計算させる数字を入力しておく関数

    public void exec() {
        int target = n;
        int preserve = 0;

        // サーバでの計算は入力x以下の最大素数を求めるものとする。
        for (int a = 1; a < target; a += 2) {
            // System.out.println("a:" + a + "だよ～");
            for (int i = 2; i < a; i++) {
                if (a % i != 0) {
                    System.out.println("i:" + i + ",a:" + a + "は素数。");
                    sosuu = i;

                } else {
                    // System.out.println("i:" + i + ",a:" + a + "殺しますよ");
                    break;
                }

            }
            if (sosuu + 1 == a) {
                if (sosuu + 1 > preserve) {
                    preserve = sosuu + 1;
                }
            }
        }
        sosuu = preserve;
        // System.out.println( preserve + "ﾆｰﾊｵﾆｬﾝ" + sosuu);
    }

    // サーバで計算を実行をさせる関数...計算アルゴリズムが記載される。

    public int getResult() {

        return sosuu;
    }// クライアントで結果を取り出す関数

}
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.IOException;
import java.util.Scanner;
public class TestLog{
    private static final Scanner sc= new Scanner(System.in);
    private static final Logger log = LogManager.getLogger(TestLog.class);
    public static void main(String[] args) throws IOException {
        int i = sc.nextInt();
        log.info("Entered first num " + i);
        int j = sc.nextInt();
        log.info("Entered second num " + j);
        System.out.print("Enter a char: ");
        String k = sc.next();
        log.info("Entered char " + k);
        switch (k){
            case "+":
                i = i + j;
                break;
            case "-":
                i = i - j;
                break;
            case "*":
                i = i * j;
                break;
            case "/":
                if (j==0){
                    log.fatal("can't divide by zero");
                    i = 0;
                }else {
                    i = i / j;
                }
                break;
        }
        log.info("result  " + i);
        System.out.println(i);
    }
}

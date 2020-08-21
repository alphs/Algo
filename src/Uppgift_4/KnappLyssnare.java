package Uppgift_4;
import java.util.*;

// En tråd som lysnar på input från tangentbordet
// Om stop mattas in avbryts tråden
public class KnappLyssnare extends Thread {

    public KnappLyssnare() {}

    public void run() {
        Scanner scan = new Scanner(System.in);

        while(!scan.next().equals("stop")) {
            try {
                Thread.sleep(100);
            } catch( Exception e){
                e.printStackTrace();
            }
        }

        System.out.println("hej då");
    }


}
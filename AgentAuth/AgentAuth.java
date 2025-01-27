import java.util.Scanner;


import com.me.db.PgConnector;
import com.me.generator.AgentTokenGenerator;

public class AgentAuth {

    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        boolean x = true;
        while (x) {
            System.out.println("zChoose: \n1.create  \n4.exit");
            String choise = sc.nextLine();
        switch (choise) {
            case "1":
                System.out.println("create ");
                PgConnector.insert(new AgentTokenGenerator());
                break;
        
            default:
                break;
        }
    }
        sc.close();

    }
}
import java.util.Scanner;

public class AgentAuth {

    
    public static void main(String args[]) {
        System.out.println("zChoose: \n1.create customer \n2.create group \n3.create user \n4.exit");
        Scanner sc = new Scanner(System.in);
        String choise = sc.nextLine();

        switch (choise) {
            case "1":
                System.out.println("");
                break;
        
            default:
                break;
        }
        sc.close();

    }
}
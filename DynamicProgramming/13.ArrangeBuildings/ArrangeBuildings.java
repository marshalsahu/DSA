import java.util.*;

public class ArrangeBuildings {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        long n = sc.nextInt();

        long oldSpace = 1;
        long oldBuilding = 1;

        for(int i=2; i<=n; i++){
            long newSpace = oldBuilding + oldSpace;
            long newBuilding = oldSpace;

            oldSpace = newSpace;
            oldBuilding = newBuilding;
        }

        long total = oldSpace + oldBuilding;
        total = total + total;
        System.out.println(total);
    }
}

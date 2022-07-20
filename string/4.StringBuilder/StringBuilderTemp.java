import java.lang.*;
public class StringBuilderTemp {
    
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("hello");
        System.out.println(sb);
        char  ch = sb.charAt(0); //get
        System.out.println(ch);

        sb.setCharAt(0,'d'); //update
        sb.insert(2,'y'); //insert 
        System.out.println(sb);
        sb.deleteCharAt(2); //delete
        System.out.println(sb);
        sb.append("!");//add
        System.out.println(sb);
        System.out.println(sb.length());
    }
}

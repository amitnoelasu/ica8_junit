import java.io.File;
import java.util.Scanner;

/*
    AUTHOR: Amit Noel Thokala
 */
public class Urinals {

    public static int RULE_NO = 0;
    boolean goodString(String str) {
        System.out.println("Not yet Implemented");
        return true;
    }

    String getStringFromKeyboard() {
        Scanner s = new Scanner(System.in);
        String input = s.nextLine().trim();
        return input;
    }

    File createFile() {

        String filePath = "rule"+RULE_NO+".txt";
        if(RULE_NO == 0) {
            filePath = "rule.txt";
        }
        File f = new File(filePath);
        while(f.exists()) {
            RULE_NO++;
            return createFile();
        }
        return f;
    }

    int countUrinals(String str) {
        boolean isInputValid = goodString(str);
        if(!isInputValid)
            return -1;
        int count = 0;
        char[] s = str.toCharArray();
        int lastOne = -1;
        for(int i = 0; i<s.length; i++) {
            if(s[i] == '0') {
                boolean isLeftZero = (i==0) || (s[i-1] == '0');
                boolean isRightZero = (i == s.length-1) || (s[i + 1] == '0');

                if(isLeftZero && isRightZero) {
                    count++;
                    s[i] = '1';
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {

    }
}

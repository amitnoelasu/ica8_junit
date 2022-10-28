import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

/*
    AUTHOR: Amit Noel Thokala
 */
public class Urinals {

    public static int RULE_NO = 0;
    static boolean goodString(String str) {
        char[] s = str.toCharArray();

        int lastOne = -1;
        for(int i = 0; i<s.length; i++) {
            if(s[i] == '1') {
                if(lastOne != -1 && lastOne == i-1) {
                    return false;
                } else {
                    lastOne = i;
                }
            }
        }

        return true;
    }

    FileReader openFile() {
        try {
            File datFile = new File("urinal.dat");
            FileReader fr = new FileReader(datFile);
            return fr;
        } catch (Exception e) {
            return null;
        }
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

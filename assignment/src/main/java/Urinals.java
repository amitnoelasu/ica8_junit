import java.io.*;
import java.util.Scanner;

/*
AUTHOR: Amit Noel Thokala

 */
public class Urinals {
    public static int RULE_NO = 0;

    String getStringFromKeyboard() {
        Scanner s = new Scanner(System.in);
        String input = s.nextLine().trim();
        return input;
    }

    String getStringFromFile() {
        return null;
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

    boolean writeToFile(String output, File f) {
        try {
            FileWriter myWriter = new FileWriter(f);
            BufferedWriter buffer = new BufferedWriter(myWriter);
            buffer.write(output);
            buffer.close();
            RULE_NO++;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }



    FileReader openFile() {
        try {
            String currentDirectory = System.getProperty("user.dir");
            System.out.println("The current working directory is " + currentDirectory);
            File datFile = new File("urinal.dat");
            System.out.println(datFile + "datfile");
            FileReader fr = new FileReader(datFile);
            return fr;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    static void processConsoleInput(Urinals urinal, StringBuilder output) {
        while (true) {
            String input = urinal.getStringFromKeyboard();
            if(input.equals("-1"))
                break;
            int count = urinal.countUrinals(input);
            output.append(count);
            output.append("\n");
        }
    }

    private static void processTextFile(Urinals urinal, StringBuilder output) throws IOException {
        FileReader datFileReader = urinal.openFile();
        if(datFileReader == null) {
            System.err.println("Error reading dat file");
            System.exit(1);
            datFileReader.close();
        }

        BufferedReader br = new BufferedReader(datFileReader);
        String input;
        while((input = br.readLine()) != null) {
            if (input.equals("-1"))
                break;
            boolean isInputValid = urinal.goodString(input);
            if (isInputValid) {
                int count = urinal.countUrinals(input);
                output.append(count);
                output.append("\n");
            } else {
                output.append("-1");
                output.append("\n");
            }
        }
        datFileReader.close();
    }
    public static void main(String[] args) {
        Urinals urinal = new Urinals();
        System.out.println("Press 1 for file input, Press 0 for keyboard input");
        Scanner s = new Scanner(System.in);
        int choice  = Integer.parseInt(s.nextLine().trim());
        StringBuilder output = new StringBuilder("");
        if(choice == 0) {
            processConsoleInput(urinal, output);
        } else if (choice == 1){
            try {
//                System.out.println("choice 1");
                processTextFile(urinal, output);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(!output.toString().isEmpty()) {
//            System.out.println(urinal.writeToFile(output.toString(), urinal.createFile()));
            urinal.writeToFile(output.toString(), urinal.createFile());
        }
    }
}

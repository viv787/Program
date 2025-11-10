import java.io.*;
import java.util.*;

class Obj {
    String name;
    int addr;

    Obj(String name, int addr) {
        this.name = name;
        this.addr = addr;
    }
}

public class Pass2 {
    static Obj[] symb_table = new Obj[10];
    static Obj[] literal_table = new Obj[10];
    static int symb_found = 0;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter("target_code.txt"); // <-- writer added

        System.out.println("ENTER TOTAL NUMBER OF SYMBOLS : ");
        int total_symb = sc.nextInt();
        int pos, num;

        for (int i = 0; i < total_symb; i++) {
            symb_table[i] = new Obj("", 0);
            System.out.println("ENTER SYMBOL NAME : ");
            symb_table[i].name = sc.next();
            System.out.println("ENTER SYMBOL ADDRESS : ");
            symb_table[i].addr = sc.nextInt();
        }

        System.out.println("ENTER TOTAL NUMBER OF LITERALS : ");
        int total_ltr = sc.nextInt();

        for (int i = 0; i < total_ltr; i++) {
            literal_table[i] = new Obj("", 0);
            System.out.println("ENTER LITERAL NAME : ");
            literal_table[i].name = sc.next();
            System.out.println("ENTER LITERAL ADDRESS : ");
            literal_table[i].addr = sc.nextInt();
        }

        System.out.println("\n***************SYMBOL TABLE*****************");
        System.out.println("SYMBOL\tADDRESS");
        for (int i = 0; i < total_symb; i++)
            System.out.println(symb_table[i].name + "\t" + symb_table[i].addr);

        System.out.println("\n***************LITERAL TABLE*****************");
        System.out.println("Index\tLITERAL\tADDRESS");
        for (int i = 0; i < total_ltr; i++)
            System.out.println((i + 1) + "\t" + literal_table[i].name + "\t" + literal_table[i].addr);

        BufferedReader br2 = new BufferedReader(
                new FileReader("Intermediate.txt"));
        String line;
        boolean symbol_error = false, undef_mnemonic = false;

        // Remove the header - we only want machine code in the output file

        lab: while ((line = br2.readLine()) != null) {
            // Stop processing when we hit the symbol table section
            if (line.contains("*****SYMBOL TABLE***")) {
                break;
            }

            String[] token_list = line.split("\\s+", 5);
            symbol_error = false;
            undef_mnemonic = false;

            // Check if first token is a location counter
            boolean hasLocationCounter = false;
            if (token_list.length > 0 && token_list[0].matches("[0-9]+")) {
                hasLocationCounter = true;
            }

            lab1: for (int i = 0; i < token_list.length; i++) {
                String token = token_list[i];
                if (token.length() > 0) {
                    pos = -1;

                    if (token.matches("---")) {
                        pw.print("\t---");
                        undef_mnemonic = true;
                    } else if (token.matches("[0-9]+")) {
                        // Check if this is a location counter (first token in line)
                        if (i == 0 && hasLocationCounter) {
                            pw.print(token);
                        } else {
                            pw.print(" " + token);
                        }
                    } else {
                        String letters = token.replaceAll("[^A-Za-z]", "");
                        String numberStr = token.replaceAll("[^0-9]", "");

                        // Check if numberStr is not empty before parsing
                        if (numberStr.isEmpty()) {
                            continue; // Skip this token if no number found
                        }

                        num = Integer.parseInt(numberStr);

                        if (token.matches("\\([0-9]+\\)"))
                            pw.print(" " + num);
                        else {
                            switch (letters.toUpperCase()) {
                                case "S":
                                    if (num > 0 && num <= total_symb && symb_table[num - 1].addr == 0) {
                                        pw.print(" ---");
                                        symbol_error = true;
                                    } else if (num > 0 && num <= total_symb) {
                                        pw.print(" " + symb_table[num - 1].addr);
                                    } else {
                                        pw.print(" ---");
                                        symbol_error = true;
                                    }
                                    break;
                                case "L":
                                    if (num > 0 && num <= total_ltr) {
                                        pw.print(" " + literal_table[num - 1].addr);
                                    } else {
                                        pw.print(" ---");
                                        symbol_error = true;
                                    }
                                    break;
                                case "AD":
                                    pw.println();
                                    continue lab;
                                case "DL":
                                    switch (num) {
                                        case 1:
                                            pw.println();
                                            continue lab;
                                        case 2:
                                            pw.print(" 00 00");
                                            continue lab1;
                                    }
                                    break;
                                case "C":
                                    pw.print(" " + num);
                                    break;
                                default:
                                    pw.print(" 00" + num);
                            }
                        }
                    }
                }
            }

            if (symbol_error)
                System.out.println("\n*************************SYMBOL IS NOT DEFINED***************************");

            if (undef_mnemonic)
                System.out.println("\n*************************INVALID MNEMONIC *******************************");

            // Add newline at the end of each line
            pw.println();
        }

        int[] flag = new int[total_symb];
        for (int i = 0; i < total_symb; i++) {
            symb_found = 0;
            for (int j = 0; j < total_symb; j++) {
                if (symb_table[i].name.equalsIgnoreCase(symb_table[j].name) && flag[j] == 0) {
                    symb_found++;
                    flag[i] = flag[j] = 1;
                }
            }

            if (symb_found > 1)
                System.out.print("\n************************ '" + symb_table[i].name
                        + "' IS DUPLICATE SYMBOL**************************");
        }

        br2.close();
        sc.close();
        pw.close(); // <-- close writer at end
    }
}

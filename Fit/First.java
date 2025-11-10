import java.util.Scanner;

public class First {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter total no. of processes: ");
        int p = sc.nextInt();

        System.out.print("Enter total no. of blocks: ");
        int b = sc.nextInt();

        int[] process = new int[p];
        int[] block = new int[b];
        boolean[] isalloc = new boolean[b];
        boolean[] isProcessAlloc = new boolean[p];

        int blockSize = 0, allocatedMemory = 0;

        System.out.println("Enter the size of blocks: ");
        for (int i = 0; i < b; i++) {
            block[i] = sc.nextInt();
            blockSize += block[i];
            isalloc[i] = false;
        }

        System.out.println("Enter the size of processes: ");
        for (int i = 0; i < p; i++) {
            process[i] = sc.nextInt();
        }

        for (int i = 0; i < p; i++) {
            for (int j = 0; j < b; j++) {
                if (isalloc[j] == false && process[i] <= block[j]) {
                    isalloc[j] = true;
                    isProcessAlloc[i] = true;
                    System.out.println("Process " + (i + 1) + " of size " + process[i] + " is allocated to block "
                            + (j + 1) + " of size " + block[j]);
                    allocatedMemory += process[i];
                    break;
                }
            }
        }

        System.out.println("Unallocated Processes are: ");
        for (int i = 0; i < p; i++) {
            if (isProcessAlloc[i] == false) {
                System.out.println("Process " + (i + 1) + " of size " + process[i]);
            }
        }

        System.out.println("Memory Utilization : " + (allocatedMemory * 100) / blockSize + "%");

    }
}
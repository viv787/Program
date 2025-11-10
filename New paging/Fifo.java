import java.util.Scanner;

class Fifo {
    public static void main(String[] args) {
        int n, m;
        int pageFaults = 0, pageHits = 0;
        int pointer = 0;

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of frames:");
        m = sc.nextInt();
        System.out.println("Enter the number of pages:");
        n = sc.nextInt();

        int pages[] = new int[n];
        int frames[] = new int[m];
        int memory_layout[][] = new int[n][m];

         
        for (int i = 0; i < m; i++) {
            frames[i] = -1;
        }

        // accept pages
        System.out.println("Enter the pages:");
        for (int i = 0; i < n; i++) {
            pages[i] = sc.nextInt();
        }

         
        for (int i = 0; i < n; i++) {
            int currentPage = pages[i];
            boolean hit = false;

             
            for (int j = 0; j < m; j++) {
                if (frames[j] == currentPage) {
                    hit = true;
                    pageHits++;
                    break;
                }
            }

             
            if (!hit) {
                frames[pointer] = currentPage;
                pointer = (pointer + 1) % m;
                pageFaults++;
            }

             
            for (int j = 0; j < m; j++) {
                memory_layout[i][j] = frames[j];
            }
        }

         
        System.out.println("\nMemory Layout:");
        for (int i = 0; i < n; i++) {
            System.out.print("After page " + pages[i] + ": ");
            for (int j = 0; j < m; j++) {
                if (memory_layout[i][j] == -1) {
                    System.out.print(" - ");
                } else {
                    System.out.print(" " + memory_layout[i][j] + " ");
                }
            }
            System.out.println();
        }

        System.out.println("\nTotal Page Faults: " + pageFaults);
        System.out.println("Total Page Hits: " + pageHits);

        sc.close();
    }
}

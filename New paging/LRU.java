import java.io.*;

class LRU {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int frames[], referenceString[], memory[][];
        int frameCount, refLength;
        int pointer = 0, faults = 0, hits = 0, searchIndex;
        boolean isFull = false;

         
        System.out.print("Enter number of frames: ");
        frameCount = Integer.parseInt(br.readLine());

        
        System.out.print("Enter length of reference string: ");
        refLength = Integer.parseInt(br.readLine());

        frames = new int[frameCount];
        referenceString = new int[refLength];
        memory = new int[refLength][frameCount];

         
        for (int i = 0; i < frameCount; i++) {
            frames[i] = -1;
        }

         
        System.out.println("Enter reference string: ");
        for (int i = 0; i < refLength; i++) {
            referenceString[i] = Integer.parseInt(br.readLine());
        }

         
        for (int i = 0; i < refLength; i++) {
            searchIndex = -1;

             
            for (int j = 0; j < frameCount; j++) {
                if (frames[j] == referenceString[i]) {
                    hits++;
                    searchIndex = j;
                    break;
                }
            }

             
            if (searchIndex == -1) {
                if (isFull) {
                    int leastRecentIndex = i;
                    int replacePos = 0;

                     
                    for (int j = 0; j < frameCount; j++) {
                        int lastUsed = -1;
                        for (int k = i - 1; k >= 0; k--) {
                            if (frames[j] == referenceString[k]) {
                                lastUsed = k;
                                break;
                            }
                        }
                        if (lastUsed < leastRecentIndex) {
                            leastRecentIndex = lastUsed;
                            replacePos = j;
                        }
                    }
                    pointer = replacePos;
                }

                 
                frames[pointer] = referenceString[i];
                faults++;
                pointer++;

                if (pointer == frameCount) {
                    pointer = 0;
                    isFull = true;
                }
            }

             
            for (int j = 0; j < frameCount; j++) {
                memory[i][j] = frames[j];
            }
        }

         
        System.out.println("\nMemory Layout:");
        for (int j = 0; j < frameCount; j++) {
            for (int i = 0; i < refLength; i++) {
                System.out.print(memory[i][j] + "\t");
            }
            System.out.println();
        }

         
        System.out.println("\nHits = " + hits);
        System.out.println("Faults = " + faults);
    }
}

import java.io.*;

class Optimal {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int frameCount, refLength;
        int pointer = 0, hits = 0, faults = 0, searchIndex;
        boolean isFull = false;
        System.out.print("Enter number of frames: ");
        frameCount = Integer.parseInt(br.readLine());
        System.out.print("Enter length of reference string: ");
        refLength = Integer.parseInt(br.readLine());
        int[] frames = new int[frameCount];
        int[] referenceString = new int[refLength];
        int[][] memoryLayout = new int[refLength][frameCount];
        for (int i = 0; i < frameCount; i++) {
            frames[i] = -1;
        }
        System.out.println("Enter reference string:");
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
                    int[] nextUseIndex = new int[frameCount];
                    boolean[] found = new boolean[frameCount];
                    for (int j = i + 1; j < refLength; j++) {
                        for (int k = 0; k < frameCount; k++) {
                            if (referenceString[j] == frames[k] && !found[k]) {
                                nextUseIndex[k] = j;
                                found[k] = true;
                                break;
                            }
                        }
                    }
                    int maxIndex = (nextUseIndex[0] == 0) ? 200 : nextUseIndex[0];
                    pointer = 0;
                    for (int j = 0; j < frameCount; j++) {
                        if (nextUseIndex[j] == 0)
                            nextUseIndex[j] = 200; // Not used again
                        if (nextUseIndex[j] > maxIndex) {
                            maxIndex = nextUseIndex[j];
                            pointer = j;
                        }
                    }
                }
                frames[pointer] = referenceString[i];
                faults++;
                if (!isFull) {
                    pointer++;
                    if (pointer == frameCount) {
                        pointer = 0;
                        isFull = true;
                    }
                }
            }
            for (int j = 0; j < frameCount; j++) {
                memoryLayout[i][j] = frames[j];
            }
        }
        System.out.println("\nMemory Layout:");
        for (int j = 0; j < frameCount; j++) {
            for (int i = 0; i < refLength; i++) {
                System.out.print(memoryLayout[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println("\nHits = " + hits);
        System.out.println("Faults = " + faults);
    }
}
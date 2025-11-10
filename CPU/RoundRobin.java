import java.util.*;

class RoundRobin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();
        int pid[] = new int[n];
        int at[] = new int[n];
        int bt[] = new int[n];
        int rt[] = new int[n];
        int ct[] = new int[n];
        int tat[] = new int[n];
        int wt[] = new int[n];
        for (int i = 0; i < n; i++) {
            pid[i] = i + 1;
            System.out.print("Enter AT and BT for P" + pid[i] + ": ");
            at[i] = sc.nextInt();
            bt[i] = sc.nextInt();
            rt[i] = bt[i];
        }
        System.out.print("Enter Time Quantum: ");
        int q = sc.nextInt();
        int time = 0, completed = 0;
        boolean inQueue[] = new boolean[n];
        int queue[] = new int[1000];
        int front = 0, rear = 0;
        while (true) {
            int minAT = Integer.MAX_VALUE, idx = -1;
            for (int i = 0; i < n; i++)
                if (at[i] < minAT) {
                    minAT = at[i];
                    idx = i;
                }
            if (idx != -1) {
                queue[rear++] = idx;
                inQueue[idx] = true;
                break;
            }
        }
        while (completed < n) {
            if (front == rear) {
                time++;
                continue;
            }
            int idx = queue[front++];
            int exec = Math.min(rt[idx], q);
            rt[idx] -= exec;
            time += exec;
            for (int i = 0; i < n; i++) {
                if (at[i] <= time && rt[i] > 0 && !inQueue[i]) {
                    queue[rear++] = i;
                    inQueue[i] = true;
                }
            }
            if (rt[idx] > 0) {
                queue[rear++] = idx;
            } else {
                ct[idx] = time;
                tat[idx] = ct[idx] - at[idx];
                wt[idx] = tat[idx] - bt[idx];
                completed++;
            }
        }
        System.out.println("PID\tAT\tBT\tCT\tTAT\tWT");
        double avgTAT = 0, avgWT = 0;
        for (int i = 0; i < n; i++) {
            System.out.printf("%d\t%d\t%d\t%d\t%d\t%d\n", pid[i], at[i], bt[i], ct[i], tat[i], wt[i]);
            avgTAT += tat[i];
            avgWT += wt[i];
        }
        System.out.printf("Avg TAT=%.2f Avg WT=%.2f\n", avgTAT / n, avgWT / n);
        sc.close();
    }
}

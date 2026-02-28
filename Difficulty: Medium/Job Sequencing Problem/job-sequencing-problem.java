import java.util.*;

class Solution {

    static int find(int[] parent, int s) {
        if (parent[s] == s)
            return s;
        return parent[s] = find(parent, parent[s]); // path compression
    }

    static void union(int[] parent, int u, int v) {
        parent[v] = u;
    }

    public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {

        int n = profit.length;
        ArrayList<Integer> result = new ArrayList<>();

        int[][] jobs = new int[n][2];

        for (int i = 0; i < n; i++) {
            jobs[i][0] = profit[i];
            jobs[i][1] = deadline[i];
        }

        Arrays.sort(jobs, (a, b) -> Integer.compare(b[0], a[0]));

        int maxDeadline = 0;
        for (int d : deadline)
            maxDeadline = Math.max(maxDeadline, d);

        int[] parent = new int[maxDeadline + 1];

        // Initially each slot is its own parent
        for (int i = 0; i <= maxDeadline; i++)
            parent[i] = i;

        int count = 0;
        int maxProfit = 0;

        for (int i = 0; i < n; i++) {

            int availableSlot = find(parent, jobs[i][1]);

            if (availableSlot > 0) {
                count++;
                maxProfit += jobs[i][0];

                // Mark this slot as filled
                union(parent, find(parent, availableSlot - 1), availableSlot);
            }
        }

        result.add(count);
        result.add(maxProfit);

        return result;
    }
}
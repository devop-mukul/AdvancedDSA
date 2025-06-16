import java.util.Arrays;

class segment_tree {
    static int[] arr;
    static int[] segMin;  
    static int[] segMax;  

    public static void main(String[] args) {
        arr = new int[]{10, 20, 30, 40, 50};
        int n = arr.length;

        segMin = new int[4 * n];
        segMax = new int[4 * n];
        Arrays.fill(segMin, Integer.MAX_VALUE);
        Arrays.fill(segMax, Integer.MIN_VALUE);

        segment_tree tree = new segment_tree();
        tree.buildMinTree(0, n - 1, 0);
        tree.buildMaxTree(0, n - 1, 0);

        System.out.println("Min Segment Tree: " + Arrays.toString(segMin));
        System.out.println("Max Segment Tree: " + Arrays.toString(segMax));
        System.out.println("Minimum in range [1, 3]: " + getMin(0, n - 1, 0, 0, 2));
        System.out.println("Maximum in range [2, 4]: " + getMax(0, n - 1, 0, 1, 3));
    }
    
    void buildMinTree(int s, int e, int idx) {
        if (s == e) {
            segMin[idx] = arr[s];
            return;
        }

        int m = s + (e - s) / 2;
        buildMinTree(s, m, 2 * idx + 1);
        buildMinTree(m + 1, e, 2 * idx + 2);
        segMin[idx] = Math.min(segMin[2 * idx + 1], segMin[2 * idx + 2]);
    }

    void buildMaxTree(int s, int e, int idx) {
        if (s == e) {
            segMax[idx] = arr[s];
            return;
        }

        int m = s + (e - s) / 2;
        buildMaxTree(s, m, 2 * idx + 1);
        buildMaxTree(m + 1, e, 2 * idx + 2);
        segMax[idx] = Math.max(segMax[2 * idx + 1], segMax[2 * idx + 2]);
    }


    static int getMin(int s, int e, int idx, int l, int r) {
        if (s > r || e < l) return Integer.MAX_VALUE;
        if (s >= l && e <= r) return segMin[idx];

        int m = s + (e - s) / 2;
        int left = getMin(s, m, 2 * idx + 1, l, r);
        int right = getMin(m + 1, e, 2 * idx + 2, l, r);
        return Math.min(left, right);
    }

    
    static int getMax(int s, int e, int idx, int l, int r) {
        if (s > r || e < l) return Integer.MIN_VALUE;
        if (s >= l && e <= r) return segMax[idx];

        int m = s + (e - s) / 2;
        int left = getMax(s, m, 2 * idx + 1, l, r);
        int right = getMax(m + 1, e, 2 * idx + 2, l, r);
        return Math.max(left, right);
    }

    public static int update(int idx, int start, int end, int pos, int value) {
        if(start == end) {
            arr[pos] = value;
            return arr[idx] = value; // segment tree node yaha update hota hai
        }

        int mid = start + (end - start) / 2;
        if(pos >= start && pos <= end) 
            update(2 * idx + 1, start, mid, pos, value);
        else 
            update(2 * idx + 2, mid + 1, end, pos, value);

        return arr[idx] = Math.min(arr[2 * idx + 1], arr[2 * idx + 2]);
    }
}
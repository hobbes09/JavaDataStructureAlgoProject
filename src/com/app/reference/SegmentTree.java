package com.app.reference;

public class SegmentTree {

    /**
     * Given N is the number of elements in input array
     * If N is power of 2, the number of elements in segment tree is (N*2-1)
     * If N is not a power of 2, the number of elements in segment tree is (K*2-1),
     * where K is the next greater power of 2, greater than N. Eg : N=5, K=8.
     *
     * Segment tree is also represented in an Array like Heap.
     * Starting from index 0,
     * left_child_index = 2*i+1
     * right_child_index = 2*i+2
     * Parent = (i-1)/2
     *
     * Segment Tree creation time complexity = O(n)
     * Segment Tree creation space complexity = O(n)
     * Segment Tree search time complexity = O(log(n))
     */

    int[] arr;
    int[] segTree;

    // =================== CONSTRUCT ======================

    private void constructSegmentTree(int[] arr) {
        this.arr = arr;
        int heightSegmentTree = (int) (Math.ceil(Math.log(arr.length) / Math.log(2)));
        int sizeSegTree = 2 * (int) Math.pow(2, heightSegmentTree) - 1;
        this.segTree = new int[sizeSegTree];

        this.constructSegmentTreeUtil(arr, segTree, 0, arr.length - 1, 0);
    }

    private void constructSegmentTreeUtil(int[] arr, int[] segTree, int low, int high, int pos) {

        if (low == high) {
            segTree[pos] = arr[low];
            return;
        }
        int mid = (low+high)/2;
        int leftChildIndex = 2*pos+1;
        int rightChildIndex = 2*pos+2;
        constructSegmentTreeUtil(arr, segTree, low, mid, leftChildIndex);
        constructSegmentTreeUtil(arr, segTree, mid+1, high, rightChildIndex);
        segTree[pos] = segTree[leftChildIndex] + segTree[rightChildIndex];
    }

    // ================== RANGE BASED PROBLEM ======================

    // Return sum of elements in range from index qs (quey start) to
    // qe (query end).  It mainly uses getSumUtil()
    int getSum(int n, int qs, int qe)
    {
        // Check for erroneous input values
        if (qs < 0 || qe > n - 1 || qs > qe) {
            System.out.println("Invalid Input");
            return -1;
        }
        return getSumUtil(0, n - 1, qs, qe, 0);
    }

    /*  A recursive function to get the sum of values in given range
    of the array.  The following are parameters for this function.

    si    --> Index of current node in the segment tree. Initially
            0 is passed as root is always at index 0
    ss & se  --> Starting and ending indexes of the segment represented
                by current node, i.e., st[si]
    qs & qe  --> Starting and ending indexes of query range */
    int getSumUtil(int ss, int se, int qs, int qe, int si)
    {
        // If segment of this node is a part of given range, then return
        // the sum of the segment
        if (qs <= ss && qe >= se)
            return this.segTree[si];

        // If segment of this node is outside the given range
        if (se < qs || ss > qe)
            return 0;

        // If a part of this segment overlaps with the given range
        int mid = getMid(ss, se);
        return getSumUtil(ss, mid, qs, qe, 2 * si + 1) +
                getSumUtil(mid + 1, se, qs, qe, 2 * si + 2);
    }

    int getMid(int s, int e) {
        return s + (e - s) / 2;
    }

    // ================ UPDATE ARRAY NODE ====================

    // The function to update a value in input array and segment tree.
    // It uses updateValueUtil() to update the value in segment tree
    void updateValue(int arr[], int n, int i, int new_val)
    {
        // Check for erroneous input index
        if (i < 0 || i > n - 1) {
            System.out.println("Invalid Input");
            return;
        }

        // Get the difference between new value and old value
        int diff = new_val - arr[i];

        // Update the value in array
        arr[i] = new_val;

        // Update the values of nodes in segment tree
        updateValueUtil(0, n - 1, i, diff, 0);
    }

    /* A recursive function to update the nodes which have the given
   index in their range. The following are parameters
    st, si, ss and se are same as getSumUtil()
    i    --> index of the element to be updated. This index is in
             input array.
   diff --> Value to be added to all nodes which have i in range */
    void updateValueUtil(int ss, int se, int i, int diff, int si)
    {
        // Base Case: If the input index lies outside the range of
        // this segment
        if (i < ss || i > se)
            return;

        // If the input index is in range of this node, then update the
        // value of the node and its children
        this.segTree[si] = this.segTree[si] + diff;
        if (se != ss) {
            int mid = getMid(ss, se);
            updateValueUtil(ss, mid, i, diff, 2 * si + 1);
            updateValueUtil(mid + 1, se, i, diff, 2 * si + 2);
        }
    }

}

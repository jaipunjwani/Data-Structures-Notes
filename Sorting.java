
/**
 * Write a description of class mergeSort here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Sorting
{
    public static void main(String[] args) {
        int[] arr = {6, 5, 3, 1, 9, 8, 7, 2, 4};
        int[] arr1 = {1, 2, 3, 0, 5, 6};
        int[] arr3 = {7, 4, 1, 3, 5};

        mergeSort(arr);
        for(int a: arr) {
            System.out.print(a + ", ");
        }

    }

    static void mergeSort(int[] x) {
        int n = x.length;
        int[] aux = new int[n];
        int i, j, k, l1, l2, u1, u2, size;
        size = 1;

        while (size < n) {
            l1 = 0;
            k = 0; 

            // merge arrays of length SIZE (or less) while we can
            while (l1 + size < n) {
                u1 = l1 + size - 1;
                l2 = u1 + 1;
                // check that second upper bound does not exceed array bounds
                if (l2 + size - 1 >=n) {
                    u2 = n - 1;
                } else {
                    u2 = l2 + size - 1;
                }

                for (i = l1, j = l2; i<= u1 && j <= u2; k++) {
                    if (x[i] < x[j]) {
                        aux[k] = x[i++];
                    } else {
                        aux[k] = x[j++];
                    }

                }

                // add remaining elements from array that finished loop
                for ( ; i<=u1; i++) {
                    aux[k++] = x[i];
                }

                for ( ; j<=u2; j++) {
                    aux[k++] = x[j];
                }

                // move to the next array
                l1 = u2 + 1;
            }

            // l1 + size was too big, so we go from l1 till the end of the array 
            for (i = l1; i<n; i++) {
                aux[k++] = x[i]; 
            }
            
            // copy entire aux into array x
            for (i = 0; i<n; i++) {
                x[i] = aux[i];
            }
            size *= 2;
        }


    }

    static void bubbleSort(int[] x) {
        // outer loop controls how many items we check up to
        int n = x.length;
        boolean swapped = false;
        for (int itemsSorted = 0; itemsSorted < n-1; itemsSorted++) {

            // actual loop of items
            for (int i = 0; i< n - itemsSorted - 1; i++) {
                int current = x[i];
                if (current > x[i+1]) {
                    x[i] = x[i+1];
                    x[i+1] = current;
                    swapped = true;
                } 

            }

            if (!swapped) {
                System.out.println("Loop breaking after " + itemsSorted + " have been sorted.");
                break; //list is all sorted!

            }

        }
    }

    static void selectionSort(int[] x) {
        int n = x.length;
        int max = x[0];
        //we compare each element to the last element and switch if necessary
        for(int i = n-1; i>=0; i--) {

            for(int j = 0; j<i; j++) {
                if (x[j] > x[i]) {
                    int temp = x[j];
                    x[j] = x[i];
                    x[i] = temp;
                }
            }

        }

    }

    /**
     * Dr. Robert Siegfried's implementation
     * 
     */
    static void insertionSort(int[] x) {
        int i, k, y;
        int n = x.length;
        for (k = 1; k < n; k++) {
            y = x[k];
            for (i = k-1; i >= 0 && y < x[i]; --i)
                x[i+1] = x[i];

            /* Insert y into its proper
            position */
            x[i+1] = y;
        }
    }

    static void heapSort(int[] x) {
        int n = x.length;
        // step 1 - create the heap
        for (int i = 1; i<n; i++) { // O(n)
            int root = i;
            while (root!=0) {
                root = (root-1)/2; // because we repeatedly divide by 2, O(log n) [base 2] 
                if (x[i] > x[root]) {
                    int temp = x[i];
                    x[i] = x[root]; 
                    x[root] = temp;
                    i = root; // new parent
                } else {
                    break; // element i is in the right place
                }
            }

        }

        // step 2 - sort the heap
        for (int lastIndex = n-1; lastIndex>=0; lastIndex--) {
            int temp = x[lastIndex];
            x[lastIndex] = x[0]; //move first element to end of unsorted heap

            // fill in the remaining nodes w/ larger of two children. finally, insert temp element in last remaining spot
            int root = 0;
            int right = (root+1)*2;
            int left = root*2 + 1;

            while( right < lastIndex) {
                // higher of two children should fill empty node
                if (x[right] < x[left]) {
                    x[root] = x[left]; 
                    root = left;
                } else {
                    x[root] = x[right];
                    root = right;
                }

                right = (root+1)*2;
                left = root*2 + 1;

            }
            // check whether left is in range
            if (left < lastIndex) {
                // check for greater element, that should go on top
                if ( x[left] > temp ) {
                    x[root] = x[left];
                    x[left] = temp;
                } else {
                    x[root] = temp;
                }
            } else {
                x[root] = temp;
            }

        }

    }
}

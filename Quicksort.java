
public class Quicksort {

    public static void main(String[] args) {
        int[] arr = { 10, 7, 8, 9, 1, 5 };
        int N = arr.length;

        System.out.println("Starting Array:");
        printArr(arr);
        System.out.println("");
        // Call Quick Sort
        quickSort(arr, 0, N - 1);
        System.out.println("Sorted Array:");
        printArr(arr);
    }

    // Start with the last element as the pivot,
    // place all smaller element to the left and larger to the right of the pivot
    public static int partition(int[] arr, int start, int end)
    {
        // Pivot starting at the end
        int pivot = arr[end];
        // Keep the place where the pivot ends
        int i = (start - 1);

        for (int j = start; j <= end - 1; j++) {
            // If current element is smaller than the pivot
            if (arr[j] < pivot) {
                // Increment index of the left index
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, end);
        return (i + 1);
    }

    // arr[] --> Array to be sorted,
    // left --> Starting index,
    // right --> Ending index
    public static void quickSort(int[] arr, int left, int right)
    {
        // Do the index are equal
        if (left < right) {
            // partitioning index, arr[p] is now at right place
            int pivotFinalIndex = partition(arr, left, right);
            // Left to right sort (swap i with j)
            quickSort(arr, left, pivotFinalIndex - 1);
            // Right to left sort (swap pivot)
            quickSort(arr, pivotFinalIndex + 1, right);
        }
    }
    // To print sorted array
    public static void printArr(int[] arr)
    {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
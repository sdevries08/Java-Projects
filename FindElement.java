public class FindElement {

    public static void main(String[] args) {
// Create a new array with a capacity of 7.
        int[] intArray = { 20, 35, -15, 7, 55, 1, -22 };

// index pf the element in the array
        int index = -1;

// Add 3 items into it.
        for (int i = 0; i < intArray.length; i++) {
            if (intArray[i] == 55) {
                index = i;
                break;
            }
        }

        System.out.println("Index = " + index);
    }
}

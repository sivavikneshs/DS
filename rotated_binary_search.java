
public class Search {

    private static int search(int arr[], int key, int start, int end) {

        if (start > end)
            return -1;

        int mid = (start + end) / 2;

        if (arr[mid] == key)
            return mid;

        if (arr[mid] > key)
            return search(arr, key, start, mid - 1);

        return search(arr, key, mid + 1, end);
    }

    private static int pointOfRotation(int[] arr, int start, int end) {

        if (start > end)
            return -1;

        int mid = (start + end) / 2;

        if (mid - 1 >= 0 && arr[mid - 1] > arr[mid])
            return mid;

        if (arr[mid] > arr[end])
            return pointOfRotation(arr, mid + 1, end);

        return pointOfRotation(arr, start, mid - 1);
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 4, 6, 9};
        int index = search(arr, 6, 0, arr.length - 1);
        System.out.println(index);

        int rotatedArr[] = {6, 9, 1, 2, 4};
        int pointOfRotation = pointOfRotation(rotatedArr, 0, rotatedArr.length - 1);
        System.out.println(pointOfRotation);
    }


}

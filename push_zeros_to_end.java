package sample;

public class MS1 {

	static void pushZeros(int arr[]) {
		int i = 0, j = 1;

		// i points to '0'
		// j points to Non-Zero Element, such that j > i

		if (arr.length == 1)
			return;

		while (i < arr.length && j < arr.length) {

			if (arr[j] == 0 || i >= j)
				j++;

			else if (arr[i] != 0)
				i++;

			// valid case
			// i < j && arr[i] == 0 && arr[j] != 0

			else {
				// swap
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}

		for (int k = 0; k < arr.length; k++) {
			System.out.print(arr[k] + " ");
		}
	}

	public static void main(String[] args) {
  
		int arr[] = new int[] { 1, 2, 0, 4, 3, 0, 5, 8, 0, 11 };
		pushZeros(arr);
	}

}

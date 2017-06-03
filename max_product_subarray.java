

public class MS1 {

	static void maxProduct(int arr[]) {
		int result = Integer.MIN_VALUE;
		int maxProduct = 1, minProduct = 1, start = 0, end = 0, maxStart = start;

		for (int i = 0; i < arr.length; i++) {

			if (arr[i] > 0) {
				maxProduct *= arr[i];
				minProduct = Math.min(minProduct * arr[i], 1);
			}

			else if (arr[i] == 0) {
				start = i + 1;
				maxProduct = 1;
				minProduct = 1;
			}

			else {
				int prevMaxProduct = maxProduct;
				maxProduct = Math.max(minProduct * arr[i], 1);
				minProduct = prevMaxProduct * arr[i];
			}

			if (maxProduct > result) {
				result = maxProduct;
				maxStart = start;
				end = i;
			}

		}
		System.out.println(result);
		for (int i = maxStart; i <= end; i++)
			System.out.print(arr[i] + " ");
	}

	public static void main(String[] args) {
		// {-1 , -2, -3, -4, -5}
		// { -1, -2, -3, 8, -4, -5 }
		int arr[] = new int[] {8 , -1, -2, -3, -4, -5};
		maxProduct(arr);
	}

}


public class GS2 {

	static int recurse(String input, int i, int length, int count, int arr[]) {

		if (i > length) {
			return count + 1;
		}
		
		if(arr[i] != -1)
			return arr[i];

		int single = input.charAt(i) - 48;
		
		// ignore cases like 1001 - 10,0,1 --> Invalid
		if (single == 0)
			return 0;

		 int first = recurse(input, i + 1, length, count, arr);
/*
		if (arr[i + 1] == -1)
			arr[i + 1] = recurse(input, i + 1, length, count, arr);*/

		int twoDigit, second = 0;

		if (i + 1 <= length) {
			int secondDigit = input.charAt(i + 1) - 48;
			twoDigit = single * 10 + secondDigit;

			if (twoDigit >= 10 && twoDigit <= 26) {
				 second = recurse(input, i + 2, length, count, arr);
				/*if (arr[i + 2] == -1)
					arr[i + 2] = recurse(input, i + 2, length, count, arr);*/
			}
		}
		
		 arr[i] = first + second;
		 return  arr[i];
		/*if (arr[i + 2] != -1)
			return arr[i + 1] + arr[i + 2];
		return arr[i + 1];*/
	}

	static long calculatePossibleCombination(String input) {
		int arr[] = new int[input.length() + 2];
		for (int i = 0; i < arr.length; i++)
			arr[i] = -1;
		return recurse(input, 0, input.length() - 1, 0, arr);
	}

	public static void main(String[] args) {
		System.out.println(calculatePossibleCombination("1234"));
	}
}

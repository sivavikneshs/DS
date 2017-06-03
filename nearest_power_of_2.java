package sample;

public class MS1 {

	static int NearestPowerOf2(int n) {

		// n itself is a power of 2
		if (n == 0 || (n & n - 1) == 0)
			return n;

		// say, n = 5 --> 101
		// Convert 101 to 111 --> m
		// return m + 1
		int count = 0, temp = n;

		// count number of bits
		while (temp > 0) {
			temp = temp >> 1;
			count++;
		}

		// another solution 1 << count --> m
		// return m+1

		int p = 1;

		// set all bits of n to 1
		for (int i = 0; i < count; i++) {
			n = n | p;
			p = p << 1;
		}

		return n + 1;

	}

	public static void main(String[] args) {

		System.out.println(NearestPowerOf2(156));
	}

}

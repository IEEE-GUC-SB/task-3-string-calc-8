import java.util.StringTokenizer;

public class Kata {
	public  int Add(String numbers) {
		int sum =0;
		StringTokenizer stringTokenizer = new StringTokenizer(numbers,",");
		while(!isEmpty(stringTokenizer)) {
			if(isOneDigit(stringTokenizer)) {
				int digit = convertStringToNumber(stringTokenizer);
				sum += digit;
			}
			else {
				int digitOne = convertStringToNumber(stringTokenizer);
				int digitTwo = convertStringToNumber(stringTokenizer);
				sum += digitOne+digitTwo;
			}
		}
		return sum;
	}

	private int convertStringToNumber(StringTokenizer stringTokenizer) {
		return Integer.parseInt(stringTokenizer.nextToken());
	}

	private boolean isOneDigit(StringTokenizer stringTokenizer) {
		return stringTokenizer.countTokens() == 1;
	}

	private boolean isEmpty(StringTokenizer stringTokenizer) {
		return stringTokenizer.countTokens() == 0;
	}

}

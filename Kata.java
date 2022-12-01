import java.util.StringTokenizer;

public class Kata {
	public  int Add(String numbers) {
		StringTokenizer stringTokenizer = new StringTokenizer(numbers,",");
		if(isEmpty(stringTokenizer)) {
			return 0;
		}
		else {
			if(isOneDigit(stringTokenizer)) {
				int digit = convertStringToNumber(stringTokenizer);
				return digit;
			}
		}
		return -1;
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

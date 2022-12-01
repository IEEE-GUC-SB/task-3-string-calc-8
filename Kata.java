import java.util.StringTokenizer;

public class Kata {
	public  int Add(String numbers) {
		StringTokenizer stringTokenizer = new StringTokenizer(numbers,",");
		if(isEmpty(stringTokenizer)) {
			return 0;
		}
		else {
			if(stringTokenizer.countTokens() == 1) {
				int digit = Integer.parseInt(stringTokenizer.nextToken());
				return digit;
			}
		}
		return -1;
	}

	private boolean isEmpty(StringTokenizer stringTokenizer) {
		return stringTokenizer.countTokens() == 0;
	}

}

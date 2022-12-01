import java.util.StringTokenizer;

public class Kata {
	public  int Add(String numbers) {
		StringTokenizer stringTokenizer = new StringTokenizer(numbers,",");
		if(isEmpty(stringTokenizer)) {
			return 0;
		}
		return -1;
	}

	private boolean isEmpty(StringTokenizer stringTokenizer) {
		return stringTokenizer.countTokens() == 0;
	}

}

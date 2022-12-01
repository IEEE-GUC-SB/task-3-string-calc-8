import java.util.StringTokenizer;

public class Kata {
	public  int Add(String numbers) {
		StringTokenizer stringTokenizer = new StringTokenizer(numbers,",");
		if(stringTokenizer.countTokens() == 0) {
			return 0;
		}
		return -1;
	}

}

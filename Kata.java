import java.util.StringTokenizer;

public class Kata {
	
	public  int Add(String numbers) {
		int sum =0;
		if(isDifferentDelimiter(numbers)){
			return this.AddHelper(numbers.substring(5),numbers.substring(2,3));
		}
		else{
		StringTokenizer stringTokenizer = new StringTokenizer(numbers,",");
		while(!isEmpty(stringTokenizer)) {
		sum += this.AddHelper(stringTokenizer.nextToken(),"\n");
		}
		}
		return sum;
	}

	public  int AddHelper(String numbers , String delimeter) {
		int sum =0;
		StringTokenizer stringTokenizer = new StringTokenizer(numbers,delimeter);
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
	
	private boolean isDifferentDelimiter(String numbers) {
		return numbers.length()>0&&numbers.charAt(0) == '/';
	}
	
	


}

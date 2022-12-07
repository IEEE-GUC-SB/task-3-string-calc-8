import java.util.ArrayList;
import java.util.StringTokenizer;

public class Kata {
	private ArrayList negatives = new ArrayList();
	public  int Add(String numbers) throws Exception   {
		int sum =0;
		if(isDifferentDelimiter(numbers)){
			sum = this.AddHelper(numbers.substring(5),numbers.substring(2,3));
		}
		else{
		StringTokenizer stringTokenizer = new StringTokenizer(numbers,",");
		while(!isEmpty(stringTokenizer)) {
		sum += this.AddHelper(stringTokenizer.nextToken(),"\n");
		}
		}
		if(!negatives.isEmpty()) {
			String message = negatives.toString();
			negatives = new ArrayList();
			throw new Exception("negatives not allowed "+message);
		}
		
		return sum;
	}

	public  int AddHelper(String numbers , String delimeter) {
		int sum =0;
		StringTokenizer stringTokenizer = new StringTokenizer(numbers,delimeter);
		while(!isEmpty(stringTokenizer)) {
			if(isOneDigit(stringTokenizer)) {
				int digit = convertStringToNumber(stringTokenizer);
				if(digit<0)
					negatives.add(digit);
				sum += digit;
			}
			else {
				int digitOne = convertStringToNumber(stringTokenizer);
				int digitTwo = convertStringToNumber(stringTokenizer);
				if(digitOne<0)
					negatives.add(digitOne);
				if(digitTwo<0)
					negatives.add(digitTwo);
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

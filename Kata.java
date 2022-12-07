import java.util.ArrayList;
import java.util.StringTokenizer;

public class Kata {
	private ArrayList negatives = new ArrayList();
	public  int Add(String numbers) throws Exception   {
		int sum =0;
		if(isDifferentDelimiter(numbers)){
			if(numbers.charAt(2) == '[') {
				String delimiters = getDelimiters(numbers.substring(2));
				sum = this.AddHelper(numbers.substring(numbers.indexOf("\n")+1),delimiters);
			}
			else
			   sum = this.AddHelper(numbers.substring(4),numbers.substring(2,3));
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
				if(!(digit>1000))
					sum += digit;
			}
			else {
				int digitOne = convertStringToNumber(stringTokenizer);
				int digitTwo = convertStringToNumber(stringTokenizer);
				if(digitOne<0)
					negatives.add(digitOne);
				if(digitTwo<0)
					negatives.add(digitTwo);
				if(!(digitOne>1000))
				     sum += digitOne;
				if(!(digitTwo>1000))
				     sum += digitTwo;
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
	private String getDelimiters (String numbers) {
		String delimiters = "";
		while(numbers.indexOf("]") != -1) {
			int start = numbers.indexOf("[");
			int end = numbers.indexOf("]");
			delimiters += numbers.substring(start+1, end);
			numbers = numbers.substring(end+1);
			}
		return delimiters;
		
	}
	

}

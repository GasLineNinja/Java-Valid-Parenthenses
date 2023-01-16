
public class ValidParentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "[[[]";
		String st = "()[]{}";
		String str = "(]";
		String strs = "(){]";

		isValid(s);
		isValid(st);
		isValid(str);
		isValid(strs);

	}

	public static boolean isValid(String s) {

		int strlen = s.length();
		char[] ch = s.toCharArray();
		int openPar = 0;
		int closedPar = 0;
		int openBrkt = 0;
		int closedBrkt = 0;
		int openCurl = 0;
		int closedCurl = 0;


		//If string is odd it has to be false
		if(strlen % 2 != 0) {
			return false;
		}

		//If the length is 2 it has to be a pair 
		if(strlen == 2) {
			if((s.charAt(0) == '(' && s.charAt(1) == ')') || (s.charAt(0) == '[' && s.charAt(1) == ']') || (s.charAt(0) == '{' && s.charAt(1) == '}')) {
				return true;
			}
			else {
				return false;
			}
		}

		// If the string ends in an open bracket is is false
		if(s.charAt(strlen-1) == '(' || s.charAt(strlen-1) == '['  || s.charAt(strlen-1) == '{') {
			return false;
		}
		else if(s.charAt(0) == ')' || s.charAt(0) == ']'  || s.charAt(0) == '}') {
			return false;
		}
		
		//Checking for number of each type of bracket
		//Checking for closing character and then for corresponding open character
		for(int i=0; i<ch.length; i++) {
			switch(ch[i]) {
			case '(':
				openPar += 1;
				break;
			case ')':
				closedPar += 1;
				for(int j=i-1; j>=0; j--) {
					if(ch[j] == '(') {
						ch[j] = '-';
						break;
					}
					else if(ch[j] == '[' || ch[j] == '{') {
						return false;
					}
				}
				break;
			case '[':
				openBrkt += 1;
				break;
			case ']':
				closedBrkt += 1;
				for(int j=i-1; j>=0; j--) {
					if(ch[j] == '[') {
						ch[j] = '-';
						break;
					}
					else if(ch[j] == '(' || ch[j] == '{') {
						return false;
					}
				}
				break;
			case '{':
				openCurl += 1;
				break;
			case '}':
				closedCurl += 1;
				for(int j=i-1; j>=0; j--) {
					if(ch[j] == '{') {
						ch[j] = '-';
						break;
					}
					else if(ch[j] == '[' || ch[j] == '(') {
						return false;
					}
				}
				break;
			}
		}
		
		if(openPar == closedPar && openBrkt == closedBrkt && openCurl == closedCurl) {
			return true;
		}
		return false;
	}

}

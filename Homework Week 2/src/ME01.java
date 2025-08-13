
public class ME01 {

	public static void main(String[] args) {
		int a = 52,  b = 3, c = 1, Smallest=0, Medium=0 , Largest=0;
		if ((a>b)&&(a>c)) {
			Largest=a;
			if (b>c){
				Smallest=c;
				Medium=b;
			}
			else if(c>b) {
				Smallest=b;
				Medium=c;
			}
		}
		else if ((b>a)&&(b>c)) {
			Largest=b;
			if (a>c){
				Smallest=c;
				Medium=a;
			}
			else if(c>a) {
				Smallest=a;
				Medium=c;
			}
		}
		else if ((c>a)&&(c>b)) {
			Largest=c;
			if (a>b){
				Smallest=b;
				Medium=a;
			}
			else if(c>a) {
				Smallest=a;
				Medium=b;
			}
		}
	    else {
	    }
	    System.out.println(Smallest+" "+Medium+" "+Largest);
	  }
	}
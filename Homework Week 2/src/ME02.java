

public class ME02 {
	public static void main(String[] args) {
		int percentGrade = 60;
        double UPgrade=0;

        if (percentGrade >= 96) {
        	if(100<percentGrade) {
				System.out.print("percentGrade is out of range");
        	}
			else {
				UPgrade = 1;
				System.out.println("UP Grade = " + UPgrade);
			}
        }
		else if (percentGrade >= 92) {
			UPgrade = 1.25;
			System.out.println("UP Grade = " + UPgrade);
        }
		else if (percentGrade >= 88) {
			UPgrade = 1.5;
			System.out.println("UP Grade = " + UPgrade);
        }
		else if (percentGrade >= 84) {
			UPgrade = 1.75;
			System.out.println("UP Grade = " + UPgrade);
        }
		else if (percentGrade >= 80) {
			UPgrade = 2;
			System.out.println("UP Grade = " + UPgrade);
        }
		else if (percentGrade >= 75) {
			UPgrade = 2.25;
			System.out.println("UP Grade = " + UPgrade);
        }
		else if (percentGrade >= 70) {
			UPgrade = 2.5;
			System.out.println("UP Grade = " + UPgrade);
		}
		else if (percentGrade >=65) {
			UPgrade = 2.75;
			System.out.println("UP Grade = " + UPgrade);
		}
		else if (percentGrade >= 60) {
			UPgrade = 3;
			System.out.println("UP Grade = " + UPgrade);
		}
		else if (percentGrade >= 55) {
			UPgrade = 4;
			System.out.println("UP Grade = " + UPgrade);
		}
		else if (percentGrade >= 0){
			UPgrade = 5;
			System.out.println("UP Grade = " + UPgrade);
		}
		else{
			System.out.print("Not a grade. Please check your input.");
        }
	}
}

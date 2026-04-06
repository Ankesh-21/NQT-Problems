import java.util.*;

public class ArmstrongNum{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		sc.nextLine();
		List<Integer> digits = new ArrayList<>();
		int ind = 0;
		int n = num;
		while (n > 0){
			digits.add(n % 10);
			n = (int)(n / 10);
		}
		// System.out.println(digits);
		int sum = 0;
		for(int i = 0;i < digits.size();i++){
			sum += Math.pow(digits.get(i),3);
		}
		if (sum == num) System.out.println("Yes");
		else System.out.println("No");
	}
}
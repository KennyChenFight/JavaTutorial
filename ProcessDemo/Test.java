import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		boolean isCorrect = true;

		System.out.println("Enter list1:");
		int a = input.nextInt();
		int[] list1 = new int[a];
		for(int i = 0; i < a; i++) {
			list1[i] = input.nextInt();
		}

		System.out.println("Enter list2:");
		int b = input.nextInt();
		int[] list2 = new int[b];
		for(int i = 0; i < b; i++) {
			list2[i] = input.nextInt();
		}

		for(int i = 0; i < a; i++) {
			if(list1[i] != list2[i]) {
				isCorrect = false;
				break;
			}
		}
		if(isCorrect){
 			System.out.println("two lists are strictly identical");
		}
		else {
			System.out.println("two lists are not strictly identical");
		}
			
    }
}
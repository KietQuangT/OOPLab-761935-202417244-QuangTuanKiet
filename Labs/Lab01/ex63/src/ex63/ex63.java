package ex63;
import java.util.Scanner;
public class ex63 {
		public static void main(String[] args) {
			Scanner meomaybe=new Scanner(System.in);
			System.out.println("Nhập số nguyên n: ");
			int n=meomaybe.nextInt();
			for (int i=0;i<n;i++) {
				for (int j=0;j<n+i;j++)
					if (j<n-i-1)
						System.out.print(" ");
					else
						System.out.print("*");
			System.out.println();
			}
			System.exit(0);
		}

}

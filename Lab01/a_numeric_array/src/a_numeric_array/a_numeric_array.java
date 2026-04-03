package a_numeric_array;
import java.util.Scanner;
public class a_numeric_array {
	public static void main(String[] args) {
		double[] a=new double[100];
		Scanner meomaybe=new Scanner(System.in);
		System.out.println("Nhập số nguyên n: ");
		int n=meomaybe.nextInt();
		System.out.println("Nhập các giá trị của mảng a: ");
		double s=0;
		for (int i=0;i<n;i++) {
			a[i]=meomaybe.nextDouble();
			s+=a[i];
		}
		System.out.println("Sum của mảng a là: "+s+"\nAverage của mảng a là: "+s/n);
		System.exit(0);
	}
}

package add_2_matrices;
import java.util.Scanner;
public class add_2_matrices {
	public static void main(String[] args) {
		Scanner meomaybe=new Scanner(System.in);
		int[][] a=new int[100][100];
		int[][] b=new int[100][100];
		System.out.println("Nhập chiều dài của ma trận: ");
		int n=meomaybe.nextInt();
		System.out.println("Nhập chiều rộng của ma trận: ");
		int m=meomaybe.nextInt();
		System.out.println("Nhập ma trận a với nhiều dài "+n+" chiều rộng "+m+": ");
		for (int i=0;i<n;i++)
			for (int j=0;j<m;j++)
				a[i][j]=meomaybe.nextInt();
		System.out.println("Nhập ma trận b với nhiều dài "+n+" chiều rộng "+m+": ");
		for (int i=0;i<n;i++)
			for (int j=0;j<m;j++) {
				b[i][j]=meomaybe.nextInt();
				a[i][j]+=b[i][j];
			}
		System.out.println("Tổng 2 ma trận a và b là: ");
		for (int i=0;i<n;i++) {
			for (int j=0;j<m;j++)
				System.out.print(a[i][j]+" ");
			System.out.println();
		}
		System.exit(0);
	}
}

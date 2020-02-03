
import java.util.Arrays;
import java.util.Scanner;

public class acmicpc_17136 {
	static int [][] paper = new int [10][10];
	static int [][] comp_paper = new int [10][10];
	static int [] comp_count = {5,5,5,5,5};
	static int [][] comp;
	static int ans=0;
	public static void main(String[] args) {
		//���� ���簢����� ������ �����
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				paper[i][j] = sc.nextInt();
			}
		}
		
		for (int c = 5; c >=1; c--) {
			comp = new int[c][c];//5x5 ~1x1���� �������
			compare(comp);
		}
		System.out.println(ans);
	}//end main
	
	public static void compare(int [][] comp) {
		int a=0,b=0;
		while(a<=paper.length-comp.length) {
			if (b>paper.length-comp.length) {
				b=0; 	a++;
				continue;
			}
			int sum = 0;
			//System.out.printf("%d %d\n",a,b);
			for (int i = 0; i < comp.length; i++) {
				for (int j = 0; j < comp[i].length; j++) {
					if (comp[i][j]+paper[i+a][j+b] == 0) {//comp�� paper�� �� ���� 0
						continue;
					} else {	//comp�� paper�� ���� ���� 1�϶�
						sum++;
						int len =comp.length*comp.length;
						if (sum == len) {	//�� 1�̸� comp�� ���������� -> comp�� ���� --���ְ� paper�� ���� 0����, ������ ���� ++;
							//System.out.println(len);
							if (comp_count[comp.length-1] == 0) {
								//System.out.println(Arrays.toString(comp_count));
								ans=-1;
								return;
							}
							comp_count[comp.length-1]--;
//							System.out.println(i+a+comp.length-2);  4
//							System.out.println(j+b+comp.length-2);  5
							//i+a,j+b�������� comp��ŭ ����
							for (int k = i+a; k >i+a-comp.length; k--) {
								for (int l = j+b; l > j+b-comp.length; l--) {
									paper[k][l]=0;
								}
							}
							for (int y = 0; y < paper.length; y++) {
								System.out.println(Arrays.toString(paper[y]));
							}
							System.out.println();
							ans++;
						}//end (sum==len)
					}
				}
			}
			b++;
		}//end while
	}//end compare
}//end class

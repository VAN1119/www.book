import java.util.Random;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Random rand = new Random();
		Scanner scanner = new Scanner(System.in);
		
		System.out.println(" ");
		System.out.println("4つの数当てゲーム");
		int first = rand.nextInt(10);
		int second = rand.nextInt(10);
		if (second == first) { second--; } if (second < 0) { second += 2; }
		int third = rand.nextInt(10);
		if (third == first) { third--; } if (third == second) { third --; } if (third < 0) { third += 3; }
		int fourth = rand.nextInt(10);
		if (fourth == first) { fourth--; } if (fourth == second) { fourth--; } if (fourth == third) { fourth--; } if (fourth < 0) { fourth += 4; }
		for (int i = 0; i < 10; i++) {
			System.out.println(" ");
			System.out.println(i + 1 + "回目の挑戦");
			
			System.out.print("一番目の予想数字を入力してください(0～9までの数字):");
			int fAns = scanner.nextInt();
			System.out.print("二番目の予想数字を入力してください(0～9までの数字):");
			int sAns = scanner.nextInt();
			System.out.print("三番目の予想数字を入力してください(0～9までの数字):");
			int tAns = scanner.nextInt();
			System.out.print("四番目の予想数字を入力してください(0～9までの数字):");
			int foAns = scanner.nextInt();
			
			boolean f = first == fAns;
			boolean s = second == sAns;
			boolean t = third == tAns;
			boolean fo = fourth == foAns;
			
			boolean nf = first == sAns || first == tAns || first == foAns;
			boolean ns = second == fAns || second == tAns || second == foAns;
			boolean nt = third == fAns || third == sAns || third == foAns;
			boolean nfo = fourth == fAns || fourth == sAns || fourth == tAns;
			
			if  (f && s && t && fo) {
				System.out.println("ご名答、4桁とも一致しています");
				System.out.println(i + 1 + "回目で正解しました");
				break;
			} else if ((f && s && t) || (s && t && fo) || (f && s && t) || (f && t && fo)) {
				System.out.println("惜しい、3桁一致");
			} else if ((f && s) || (f && t) || (f && fo) || (s && t) || (s && fo) || (t && fo)) {
				System.out.println("2桁一致");
				if ((nf && ns) || (nf && nt) || (nf && nfo) || (ns && nt) || (ns && nfo) || (nt && nfo)) {
					System.out.println("2つの数字が場所違い");
				} else if (nf || ns || nt || nfo) {
					System.out.println("1つの数字が場所違い");	
				}
			} else if (f || s || t || fo) {
				System.out.println("1桁一致");
				if ((nf && ns && nt) || (ns && nt && nfo) || (nf && ns && nt) || (nf && nt && nfo)) {
					System.out.print("3つの数字が場所違い");
				} else if ((nf && ns) || (nf && nt) || (nf && nfo) || (ns && nt) || (ns && nfo) || (nt && nfo)) {
					System.out.println("2つの数字が場所違い");
				} else if (nf || ns || nt || nfo) {
					System.out.println("1つの数字が場所違い");	
				}
			} else {
				System.out.println("残念");
				if (nf && ns && nt && nfo){
					System.out.println("4つの数字が場所違い");
				} else if ((nf && ns && nt) || (ns && nt && nfo) || (nf && ns && nt) || (nf && nt && nfo)) {
					System.out.println("3つの数字が場所違い");
				} else if ((nf && ns) || (nf && nt) || (nf && nfo) || (ns && nt) || (ns && nfo) || (nt && nfo)) {
					System.out.println("2つの数字が場所違い");
				} else if (nf || ns || nt || nfo) {
					System.out.println("1つの数字が場所違い");	
				}
			}
		}
		System.out.print("答えは" + first + second + third + fourth + "でした");
	}
}

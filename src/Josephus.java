/*
 * 				JOSEPHUS PROBLEM
 * 
 * 	A legend says:
 * In a war, there was a group of fighters surrounded by a roman legion.
 * The group didn't want to be captured, so they figured to commit suicide.
 * They stood in a circle and the first began to kill the second. The third killed the fourth, the fifth the sixth and so on.
 * So every one will kill the next living person until the last, who will commit suicide.
 * 
 * Josephus didn't want to commit suicide, so he wanted to know, which will be the last living person in this circle so he can get captured.
 * 
 * if n = 2^a + l
 * then W(n) = 2l + 1
 * 
 * where l < 2a
 * 
 * if 13 = 8 + 5
 * then 11 = 10 + 1
 * 
 */

public class Josephus {
	static boolean PrintAll = true;
	public static void main(String[] args) {
		StartLoop(1300);
	}
	
	
	public static void StartLoop(int Amount) {
		boolean[] People = new boolean[Amount];
		int Current = 0;
		
		fillArray(People);
		
		while(Remaining(People) > 1) {
			Current = Killnext(People, Current);
//			System.out.println(Remaining(People));
		}
		System.out.println("People: " + Amount + " Winner: " + (GetWinner(People) + 1));
	}
	
	
	public static int Remaining(boolean[] People) {
		int Amount = 0;
		for(int i = 0; i < People.length; i++) {
			if(People[i])Amount ++;
		}
		
		return Amount;
	}
	
	public static int Killnext(boolean[] People, int Current) {
		int Starter = Current;
		if(Current >= (People.length - 1)) {
			Current = 0;
		}else {
			Current++;
		}
		
		while(!People[Current]){
			if(Current >= (People.length - 1)) {
				Current = 0;
			}else {
				Current++;
			}
		}
		if(Starter != Current)People[Current] = false;
		
		if(PrintAll)System.out.println((Starter + 1) + " kills " + (Current + 1));
		
//		System.out.println("Before "+Current);
		
		if(Current >= (People.length - 1)) {
			Current = 0;
		}
		
//		System.out.println("After " + Current);
		
		while(!People[Current]){
			if(Current >= (People.length - 1)) {
				Current = 0;
			}else {
				Current++;
			}
		}
		return Current;
	}
	
	public static void fillArray(boolean[] People) {
		for(int i = 0; i < People.length; i++) {
			People[i] = true;
		}
	}
	
	public static int GetWinner(boolean[] People) {
		for(int i = 0; i < People.length; i++) {
			if(People[i])return i;
		}
		return 0;
	}

}

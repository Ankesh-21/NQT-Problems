import java.util.*;
class ElectricBillMeter{
	String uid;
	List<Integer> readings = new ArrayList<>();
	private static HashMap<String,ElectricBillMeter> mp = new HashMap<>();
	public void setReadings(List<Integer>reads){
		this.readings = reads;
	}
	public List<Integer> getReadings(){
		return this.readings;
	}
	public ElectricBillMeter(String board,List<Integer>reads){
		this.uid = board;
		this.readings = reads;
	}
	
	public static void addReading(String board,List<Integer>reads){
		List<Integer> Reads = null;
		if (mp.getOrDefault(board,null) != null){
			Reads = mp.get(board).getReadings();
			for (int i = 0;i < reads.size();i++){
				Reads.add(reads.get(i));
			}
			mp.get(board).setReadings(Reads);
		}else{
			mp.put(board,new ElectricBillMeter(board,reads));
		}
	}
	public static void getAverage(String board,int start,int end){
		int sum = 0;
		int cnt = 0;
		List<Integer> reads = mp.get(board).getReadings();
		for (int i = 0;i < reads.size();i++){
			if (reads.get(i) >= start && reads.get(i) <= end){
				sum += reads.get(i);
				cnt ++;
			}
		}
		double ans = sum / cnt;
		System.out.print("Average power consumption of "+board);
		System.out.print(" "+start+" to " + end + ":");
		System.out.println(ans);
	}
}

class Solution{
	public static void main(String[]args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		for(int i = 0;i < n;i++){
			String board = sc.nextLine();
			int m = sc.nextInt();
			sc.nextLine();
			List<Integer> Reads = new ArrayList<>();
			for(int j = 0;j < m;j++){
				int k = sc.nextInt();
				sc.nextLine();
				Reads.add(k);
			}
			ElectricBillMeter.addReading(board,Reads);
		}
		String board = sc.nextLine();
		int start = sc.nextInt();
		sc.nextLine();
		int end = sc.nextInt();
		sc.nextLine();
		ElectricBillMeter.getAverage(board,start,end);
		sc.close();
	}
}

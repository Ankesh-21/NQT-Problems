import java.util.*;
class Footwear {
	private int footwearId;
	private String footwearName;
	private String footwearType;
	private int price;

	public void setFootwearId(int id) {
		this.footwearId = id;
	}
	public int getFootwearId() {
		return this.footwearId;
	}

	public void setFootwearName(String name) {
		this.footwearName = name;
	}
	public String getFootwearName() {
		return this.footwearName;
	}
	public void setFootwearType(String type) {
		this.footwearType = type;
	}
	public String getFootWearType() {
		return this.footwearType;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	public int getPrice() {
		return this.price;
	}
	public Footwear(int id, String name, String type, int price) {
		this.footwearId = id;
		this.footwearName = name;
		this.footwearType = type;
		this.price = price;
	}


	public static int getCountByType(Footwear[] fws, String type) {
		int cnt = 0;
		for (int i = 0; i < fws.length; i++) {
			if (fws[i].getFootWearType().equals(type)) {
				cnt += 1;
			}
		}
		return cnt;
	}
	public static Footwear getSecondHighestPriceByBrand(Footwear[] fws, String brand) {
		Footwear f = null;
		Footwear s = null;
		for (int i = 0; i < fws.length; i++) {
			if (fws[i].getFootwearName().equalsIgnoreCase(brand)) {
				if (f == null) {
					f = fws[i];
				} else {
					if (fws[i].getPrice() > f.getPrice()) {
						s = f;
						f = fws[i];
					} else if (s == null || s.getPrice() < fws[i].getPrice()) {
						s = fws[i];
					}
				}
			}
		}
		return s;
	}
}
public class footwearProgram {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Footwear[] fws = new Footwear[5];
		int ind = 0;
		for (int i = 0; i < 5; i++) {
			int id = sc.nextInt();
			sc.nextLine();
			String name = sc.nextLine();
			String type = sc.nextLine();
			int price = sc.nextInt();
			sc.nextLine();
			Footwear obj = new Footwear(id, name, type, price);
			/*
			obj.setPrice(price);
			obj.setFootwearId(id);
			obj.setFootwearName(name);
			obj.setFootwearType(type);
			*/
			fws[ind++] = obj;
		}

		String type = sc.nextLine();
		System.out.println(Footwear.getCountByType(fws, type));
		String brand = sc.nextLine();
		Footwear ans = Footwear.getSecondHighestPriceByBrand(fws, brand);
		if (ans == null) {
			System.out.println("No Brand Available");
			return;
		}
		System.out.println(ans.getFootwearId());
		System.out.println(ans.getFootwearName());
		System.out.println(ans.getPrice());
		sc.close();
	}

}
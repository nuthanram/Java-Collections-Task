package datastructure;

public class Test {
	public static void main(String[] args) {
		DynamicArray<String> d = new DynamicArray<>();
		d.add(null);
		d.add("abc");
		d.add("as usual");
		d.add("what else");
		for (int i = 0; i < 10; i++) {
			d.add("" + i);
		}
		System.out.println(d);
		System.out.println(d.size());
		d.add(5, null);
		System.out.println(d);
		System.out.println(d.size());
		System.out.println(d.get(10));
		System.out.println(d.contains(null));
		System.out.println(d.remove(6));
	}
}

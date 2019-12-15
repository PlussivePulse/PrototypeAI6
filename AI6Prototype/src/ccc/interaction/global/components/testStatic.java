package ccc.interaction.global.components;

public class testStatic {
	public static int count = 0;
	
	public static int get() {
		count++;
		return count;
	}
}

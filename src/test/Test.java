package test;

import tree.RBTree;

public class Test {
	public static void main(String[] args) {
		RBTree<String, Integer> tree=new RBTree<>();
		tree.add("zhang",1);
		tree.add("rui",3);
		tree.add("zz",6);
		tree.get("r");
	}
}

package tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

import dylist.LinkedList;
import dylist.LinkedStack;

public class Main {
	public static void main(String[] args) {
		BinaryThreadTree<Integer> tree=new BinaryThreadTree<>();
		tree.add(5);
		tree.add(3);
		tree.add(2);
		tree.add(9);
		tree.add(6);
		tree.add(4);
		tree.add(7);
		tree.test();
		tree.midPrint();
	}
}

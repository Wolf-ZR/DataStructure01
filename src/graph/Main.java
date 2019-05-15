package graph;

public class Main {
	public static void main(String[] args) {
		SparseGraph dg=new SparseGraph(13,true);
		ReadGraph rg=new ReadGraph(dg,"E:/qqfile/testG1.txt");
		System.out.println("testG1:");
		dg.show();
		System.out.println("**********");
		Path path=new Path(dg, 0);
		path.showPath(3);
		System.out.println();
		System.out.println("**********");
		ShortestPath pa=new ShortestPath(dg, 0);
		System.out.println(pa.showPath(3));
		System.out.println("--------------------------");
		Components co=new Components(dg);
		System.out.println(co.getCount());
	}
}

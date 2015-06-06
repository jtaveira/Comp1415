import java.util.ArrayList;

public class MyEdge {

	private MyNode source;
	private MyNode target;
	private int weight;
	
	public MyEdge(MyNode source, MyNode target, int weight){
		this.source = source;
		this.target = target;
		this.weight = weight;
	}
	
	public MyEdge(MyNode source, MyNode target){
		this.source = source;
		this.target = target;
	}
	
	public int getWeight(){
		return this.weight;
	}
	
	public void setWeight(int weight){
		this.weight = weight;
	}
	
	public MyNode getSource(){
		return this.source;
	}
	
	public MyNode getTarget(){
		return this.target;
	}
	
	public ArrayList<MyNode> getNodes(){
		
		ArrayList<MyNode> temp = new ArrayList<MyNode>();
		temp.add(this.source);
		temp.add(this.target);
		
		return temp;
	}
	
	public void printEdge(){
		System.out.print(this.source.getName() + " -- " + this.weight + " --> " + this.target.getName());
	}
	
	public void printOutwardConnection(){
		System.out.print(" -- [" + this.weight + "] --> ");
		this.target.printNode();
	}
	
	public void printInwardConnection(){
		System.out.print(" <-- [" + this.weight + "] -- ");
		this.source.printNode();
	}
}

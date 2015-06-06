import java.util.ArrayList;

public class MyNode {

	private String name;
	private Integer id;
	private Integer group;
	private ArrayList<MyEdge> inEdges;
	private ArrayList<MyEdge> outEdges;
	private boolean star;
	private boolean essential;
	private boolean central;
	
	public MyNode(String name, Integer id, Integer group, ArrayList<MyEdge> inEdges, ArrayList<MyEdge> outEdges){
		this.name = name;
		this.id = id;
		this.group = group;
		this.inEdges = inEdges;
		this.outEdges = outEdges;
		this.star = false;
		this.essential = false;
		this.central = false;
	}
	
	public MyNode(String name, Integer id, Integer group){
		this.name = name;
		this.id = id;
		this.group = group;
		this.inEdges = new ArrayList<MyEdge>();
		this.outEdges = new ArrayList<MyEdge>();
		this.star = false;
		this.essential = false;
		this.central = false;
	}
	
	public String getName(){
		return this.name;
	}
	
	public Integer getId(){
		return this.id;
	}
	
	public Integer getGroup(){
		return this.group;
	}
	
	public ArrayList<MyEdge> getInEdges(){
		return inEdges;
	}
	
	public ArrayList<MyEdge> getOutEdges(){
		return outEdges;
	}
	
	public boolean isStar(){
		return this.star;
	}
	
	public boolean isEssential(){
		return this.essential;
	}
	
	public boolean isCentral(){
		return this.central;
	}
	
	public void setIsStar(boolean bool){
		this.star = bool;
	}
	
	public void setIsEssential(boolean bool){
		this.essential = bool;
	}
	
	public void setIsCentral(boolean bool){
		this.central = bool;
	}
	
	public void clearInEdges(){
		this.inEdges.clear();
	}
	
	public void clearOutEdges(){
		this.outEdges.clear();
	}
	
	public ArrayList<MyNode> getAdjacentNodes(){
		ArrayList<MyNode> temp = new ArrayList<MyNode>();
		
		for(int i = 0; i < inEdges.size(); i++)
			temp. add(inEdges.get(i).getSource());
		
		for(int i = 0; i < outEdges.size(); i++)
			temp. add(outEdges.get(i).getTarget());
		
		return temp;
	}
	
	public int getAdjacentNodesNum(){
		return inEdges.size() + outEdges.size();
	}
	
	public void addEdge(MyNode node){
		MyEdge edge = new MyEdge(this, node);
		this.outEdges.add(edge);
		node.inEdges.add(edge);
	}
	
	public void addEdge(MyNode node, Integer weight){
		MyEdge edge = new MyEdge(this, node, weight);
		this.outEdges.add(edge);
		node.inEdges.add(edge);
	}
	
	public void printNode(){
		System.out.print(this.name + " (" + this.group + ")");
	}
}

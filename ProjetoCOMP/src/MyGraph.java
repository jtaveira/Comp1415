import java.util.ArrayList;

public class MyGraph {

	private ArrayList<MyNode> nodes;
	
	public MyGraph( ArrayList<MyNode> nodes){
		this.nodes = nodes;
	}
	
	public MyGraph(){
		this.nodes = new ArrayList<MyNode>();
	}
	
	public void addNode(MyNode node){
		this.nodes.add(node);
	}
	
	public ArrayList<MyNode> getNodes(){
		return this.nodes;
	}
	
	public void setNodes(ArrayList<MyNode> nodes){
		this.nodes = nodes;
	}
	
	public void removeNode (Integer id){
		
		for(int i = 0; i < this.nodes.size(); i++){
			
			if(this.nodes.get(i).getId() == id){
				
				for(int j = 0; j < this.nodes.get(i).getInEdges().size(); j++){
					
					if(this.nodes.get(i).getInEdges().get(j).getTarget().getId() == id){
						
						for(int z = 0; z < this.nodes.get(i).getInEdges().get(j).getSource().getOutEdges().size(); z++){
							
							if(this.nodes.get(i).getInEdges().get(j).getSource().getOutEdges().get(z).getTarget().getId() == id){
								this.nodes.get(i).getInEdges().get(j).getSource().getOutEdges().remove(z);
							}	
						}
					}
				}
				
				this.nodes.remove(i);
				break;
			}
		}	
	}
	
	public boolean isFullyConnected(ArrayList<MyNode> nodeArray){
		
		MyNode startNode = nodeArray.get(0);
		startNode.setVisited(true);
		/////////////////////////////////////////////////////////////
		
		
		ArrayList<MyNode> subset = new ArrayList<MyNode>();
		
		for(int i = 0; i < startNode.getAdjacentNodes().size(); i++){
			if(startNode.getAdjacentNodes().get(i).getVisited() == false)
				subset.add(startNode.getAdjacentNodes().get(i));
			startNode.getAdjacentNodes().get(i).setVisited(true);	
		}
		
		for(int i = 0; i < subset.size(); i++){
			isFullyConnected(subset.get(i).getAdjacentNodes());	
		}

		/////////////////////////////////////////////////////////////
		//TODO
		
		int count = 0;
		
		for(int i = 0; i < nodeArray.size(); i++){
			if(nodeArray.get(i).getVisited() == true)
				count++;
		}
		
		if(count == nodeArray.size())
			return true;
		
		return false;
	}
	
	public ArrayList<MyNode> getStarNodes(){
		
		ArrayList<MyNode> temp = new ArrayList<MyNode>();
		Integer maxCon = 0;
		
		for(int i = 0; i < this.nodes.size(); i++){//descobrir os nos estrela
			
			if(this.nodes.get(i).getAdjacentNodesNum() > maxCon){
				maxCon = this.nodes.get(i).getAdjacentNodesNum();
				temp.clear();
				temp.add(this.nodes.get(i));
			}
			
			else if(this.nodes.get(i).getAdjacentNodesNum() == maxCon){
				temp.add(this.nodes.get(i));
			}
		}
		
		for(int i = 0; i < this.nodes.size(); i++){//dizer no proprio no que sao estrela
			if(temp.contains(nodes.get(i)))
				nodes.get(i).setIsStar(true);
		}
		
		System.out.println();
		System.out.println(" -- STAR NODES --");
		
		for(int i = 0; i < temp.size(); i++){//imprimir nos estrela
			temp.get(i).printNode();
			System.out.println();
		}
		
		return temp;
	}
	
	public ArrayList<MyNode> getEssentialNodes(){
		
		ArrayList<MyNode> temp = new ArrayList<MyNode>();
		ArrayList<MyNode> essentials = new ArrayList<MyNode>();

		temp = (ArrayList<MyNode>) this.nodes.clone();
		
		for(int i = 0; i < this.nodes.size(); i++){
			
			if(temp.get(i).getInEdges().size() + temp.get(i).getInEdges().size() > 1){//se nao forem folhas dos grafos
				
				temp.remove(i);
				
				if(!isFullyConnected(temp)){
					essentials.add(nodes.get(i));
					nodes.get(i).setIsEssential(true);
				}
			}

			temp = (ArrayList<MyNode>) this.nodes.clone();
		}
		
		System.out.println("Size:" + essentials.size());
		System.out.println(" -- ESSENTIAL NODES --");
		
		for(int i = 0; i < essentials.size(); i++){//imprimir nos essenciais
			essentials.get(i).printNode();
			System.out.println();
		}
		
		return temp;
	}
	
	public ArrayList<MyNode> getCentralNodes(){
		
		ArrayList<MyNode> temp = new ArrayList<MyNode>();
		ArrayList<MyNode> centrals = new ArrayList<MyNode>();

		
		
		
		
		
		//TODO
		
		
		
		
		
		
		System.out.println();
		System.out.println(" -- CENTRAL NODES --");
		
		for(int i = 0; i < centrals.size(); i++){//imprimir nos essenciais
			centrals.get(i).printNode();
			System.out.println();
		}
		
		return temp;
	}
	
	public void printGraph(){
		
		System.out.println();
		System.out.println(" -- GRAPH --");
		
		for(int i = 0; i < nodes.size(); i++){
			
			nodes.get(i).printNode();
			System.out.println();
			
			for(int j = 0; j < nodes.get(i).getOutEdges().size(); j++){
				nodes.get(i).getOutEdges().get(j).printOutwardConnection();
				System.out.println();
			}
		}		
	}
}

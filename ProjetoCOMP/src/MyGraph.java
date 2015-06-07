import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

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

	public void clearNodes(){
		this.nodes.clear();
	}

	public void clearVisitedNodes(){
		for(int i = 0; i < this.nodes.size(); i++){
			this.nodes.get(i).setVisited(false);
		}
	}

	public void clearAppearanceNodes(){
		for(int i = 0; i < this.nodes.size(); i++){
			this.nodes.get(i).setAppearances(0);
		}
	}

	public void resetConnections(){

		for(int i = 0; i < this.nodes.size(); i++){
			this.nodes.get(i).resetConnections();
		}
	}

	public MyNode getNode(int id){

		for(int i = 0; i < this.nodes.size(); i++){
			if(this.nodes.get(i).getId() == id)
				return this.nodes.get(i);
		}

		return null;
	}

	public void removeNode (Integer id){

		for(int i = 0; i < this.nodes.size(); i++){

			if(this.nodes.get(i).getId() == id){

				for(int j = 0; j < this.nodes.get(i).getInEdges().size(); j++){

					if(this.nodes.get(i).getInEdges().get(j).getTarget().getId() == id){

						for(int z = 0; z < this.nodes.get(i).getInEdges().get(j).getSource().getOutEdges().size(); z++){

							if(this.nodes.get(i).getInEdges().get(j).getSource().getOutEdges().get(z).getTarget().getId() == id){
								this.nodes.get(i).getInEdges().get(j).getSource().addRemovedOutEdge(this.nodes.get(i).getInEdges().get(j).getSource().getOutEdges().get(z));
								this.nodes.get(i).getInEdges().get(j).getSource().getOutEdges().remove(z);
							}
						}
					}
				}

				for(int j = 0; j < this.nodes.get(i).getOutEdges().size(); j++){

					if(this.nodes.get(i).getOutEdges().get(j).getSource().getId() == id){

						for(int z = 0; z < this.nodes.get(i).getOutEdges().get(j).getTarget().getInEdges().size(); z++){

							if(this.nodes.get(i).getOutEdges().get(j).getTarget().getInEdges().get(z).getSource().getId() == id){
								this.nodes.get(i).getOutEdges().get(j).getTarget().addRemovedInEdge(this.nodes.get(i).getOutEdges().get(j).getTarget().getInEdges().get(z));
								this.nodes.get(i).getOutEdges().get(j).getTarget().getInEdges().remove(z);
							}
						}
					}
				}

				this.nodes.remove(i);
				break;
			}
		}	
	}

	public boolean isFullyConnected(MyGraph temp, MyNode nodeStart){//verifica se o grafo esta todo ligado

		MyNode startNode = nodeStart;
		startNode.setVisited(true);

		for(int i = 0; i < startNode.getAdjacentNodes().size(); i++){

			if(startNode.getAdjacentNodes().get(i).getVisited() == false){//para cada no vizinho nao visitado
				startNode.getAdjacentNodes().get(i).setVisited(true);//fica automaticamente visitado
				MyGraph tempAux = new MyGraph(startNode.getAdjacentNodes().get(i).getAdjacentNodes());
				isFullyConnected(tempAux, startNode.getAdjacentNodes().get(i));//chama recursivamente com o grafo dos vizinhos deste vizinho
			}
		}

		int count = 0;	

		for(int i = 0; i < temp.getNodes().size(); i++){//conta os nos visitados
			if(temp.getNodes().get(i).getVisited() == true)
				count++;
		}

		if(count == temp.getNodes().size())//se os nos visitados forem iguais aos numero de nos da rede, esta tudo ligado
			return true;

		return false;
	}

	public ArrayList<MyNode> getShortestPath(MyNode startNode, MyNode endNode){

		Map<MyNode, Boolean> vis = new HashMap<MyNode, Boolean>();
		Map<MyNode, MyNode> prev = new HashMap<MyNode, MyNode>();
		ArrayList<MyNode> directions = new  ArrayList<MyNode>();
		Queue q = new LinkedList();

		q.add(startNode);
		vis.put(startNode, true);

		while(!q.isEmpty()){

			startNode = (MyNode) q.remove();

			if (startNode.equals(endNode)){
				break;
			}

			else{
				for(MyNode node : startNode.getAdjacentNodes()){
					if(!vis.containsKey(node)){
						q.add(node);
						vis.put(node, true);
						prev.put(node, startNode);
					}
				}
			}
		}

		if (!startNode.equals(endNode)){
			System.out.println("can't reach destination");
		}

		for(MyNode node = endNode; node != null; node = prev.get(node)) {
			directions.add(node);
		}

		Collections.reverse(directions);
		return directions;
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

		ArrayList<MyNode> tempArr = new ArrayList<MyNode>();
		ArrayList<MyNode> essentials = new ArrayList<MyNode>();

		tempArr =  (ArrayList<MyNode>) this.nodes.clone();
		MyGraph temp = new MyGraph(tempArr);

		for(int i = 0; i < temp.getNodes().size(); i++){

			if(temp.getNodes().get(i).getInEdges().size() + temp.getNodes().get(i).getOutEdges().size() > 1){//se nao forem folhas dos grafos

				temp.removeNode(i);

				if(!isFullyConnected(temp, temp.getNodes().get(0))){
					essentials.add(nodes.get(i));
					nodes.get(i).setIsEssential(true);
				}
			}	

			tempArr =  (ArrayList<MyNode>) this.nodes.clone();
			temp.clearNodes();
			temp = new MyGraph(tempArr);
			temp.resetConnections();
			temp.clearVisitedNodes();
		}

		System.out.println();
		System.out.println(" -- ESSENTIAL NODES --");

		for(int i = 0; i < essentials.size(); i++){//imprimir nos essenciais
			essentials.get(i).printNode();
			System.out.println();
		}

		return essentials;
	}

	public ArrayList<MyNode> getCentralNodes(){

		ArrayList<ArrayList<MyNode>> temp = new ArrayList<ArrayList<MyNode>>();
		ArrayList<MyNode> centrals = new ArrayList<MyNode>();
		Integer maxAppearances = 0;

		//ve todos os caminhos mais curtos existentes
		for(int i = 0; i < this.nodes.size(); i++){
			for(int j = 0; j < this.nodes.size(); j++){

				if(i != j)
					temp.add(getShortestPath(this.nodes.get(i), this.nodes.get(j)));
			}
		}

		/////////// PRINT PATHS ////////////////////////
		/*
		System.out.println();

		for(int j = 0; j < temp.size(); j++){	
			for(int i = 0; i < temp.get(j).size(); i++){	

				System.out.print(temp.get(j).get(i).getId());

				if(i != temp.get(j).size() - 1)
					System.out.print(" -> ");
			}
			System.out.println();
		}
		 */
		////////////////////////////////////////////////

		//contar os nos que aparecem mais vezes
		for(int i = 0; i < this.nodes.size(); i++){
			for(int j = 0; j < temp.size(); j++){	

				if(temp.get(j).contains(this.nodes.get(i))){
					this.nodes.get(i).addAppearances(1);

				}		
			}
		}

		for(int i = 0; i < this.nodes.size(); i++){//descobrir os nos centrais

			if(this.nodes.get(i).getAppearances() > maxAppearances){
				maxAppearances = this.nodes.get(i).getAppearances();
				centrals.clear();
				centrals.add(this.nodes.get(i));
			}

			else if(this.nodes.get(i).getAppearances() == maxAppearances){
				centrals.add(this.nodes.get(i));
			}
		}

		for(int i = 0; i < this.nodes.size(); i++){//dizer no proprio no que sao centrais
			if(centrals.contains(nodes.get(i)))
				nodes.get(i).setIsCentral(true);
		}

		System.out.println();
		System.out.println(" -- CENTRAL NODES --");

		for(int i = 0; i < centrals.size(); i++){//imprimir nos centrais
			centrals.get(i).printNode();
			System.out.println();
		}

		return centrals;
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

			for(int j = 0; j < nodes.get(i).getInEdges().size(); j++){
				nodes.get(i).getInEdges().get(j).printInwardConnection();
				System.out.println();
			}
		}		
	}

	public void printToDot(){

		GraphViz gv = new GraphViz();
		gv.addln(gv.start_graph());
		
		
		//TODO
		//gv.addln("A -> B;");
		//gv.addln("A -> C;");
		
		
		gv.addln(gv.end_graph());
		System.out.println(gv.getDotSource());

		String type = "dot";

		File out = new File("../comp/output/out." + type);
		gv.writeGraphToFile( gv.getGraph( gv.getDotSource(), type ), out );


		System.out.println();
		System.out.println(".DOT file generated successfully");
	}

	public void makeImageFromDot(){

		String input = "../comp/output/out.dot";

		GraphViz gv = new GraphViz();
		gv.readSource(input);

		String type = "gif";

		File out = new File("../comp/graph/out." + type);
		gv.writeGraphToFile( gv.getGraph( gv.getDotSource(), type ), out );

		System.out.println();
		System.out.println(".GIF file generated successfully");
	}
}

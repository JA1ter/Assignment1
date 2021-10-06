package CWc;

public class Graph {
    int vertices;
    int[][] adjacency_matrix;
    Graph(int v){
        vertices = v;
        adjacency_matrix= new int[vertices][vertices];
    }
    public void addEdge(int source, int destination){
        adjacency_matrix[source][destination]=1;
        adjacency_matrix[destination][source]=1;
    }
    public void printMatrix(){               //i=rows j=column
        for (int i=0; i<vertices;i++){
            for (int j=0;j<vertices;j++){
                System.out.print(adjacency_matrix[i][j]+" ");
            }
            System.out.println("");
        }
    }

    public void printEdges(){               //i=rows j=column
        for (int i=0; i<vertices;i++){
            System.out.print(i+" is connected to: ");
            for (int j=0;j<vertices;j++){
                if(adjacency_matrix[i][j]!=0){
                    System.out.print(j+" ");
                }
            }
            System.out.println("");
        }
    }
    public static void main(String [] args){
        Graph g = new Graph(4);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(0,3);
        g.addEdge(2,3);
        g.printMatrix();
        g.printEdges();
    }
}

/*
import java.util.Scanner;

public class floayad {
    static int INF = 999;

    static int[][] inputGraph() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of offices:");
        int numOffices = scanner.nextInt();

        System.out.println("Enter the number of Lines:");
        int numOfLines = scanner.nextInt();

        int[][] graph = new int[numOffices][numOffices];

        for (int i = 0; i < numOffices; i++) {
            for (int j = 0; j < numOffices; j++) {
                graph[i][j] = INF;
                graph[i][i] = 0;
            }
        }

        for (int i = 0; i < numOfLines; i++) {
            int source = 0, destination = 0, cost = 0;
            System.out.println("Enter the source destination cost:");
            source = scanner.nextInt() - 1; // Adjust for 0-based indexing
            destination = scanner.nextInt() - 1; // Adjust for 0-based indexing
            cost = scanner.nextInt();

            graph[source][destination] = cost;
        }
        scanner.close();
        return graph;
    }

    static int[][] floydWarshall(int[][] graph, int numOffices) {
        for (int k = 0; k < numOffices; k++) {
            for (int i = 0; i < numOffices; i++) {
                for (int j = 0; j < numOffices; j++) {
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }
        return graph;
    }

    static void printSolution(int[][] graph, int numOffices) {
        int totalCost = 0;
        System.out.println("Minimum costs between offices:");
        for (int i = 0; i < numOffices; i++) {
            for (int j = 0; j < numOffices; j++) {
                if (graph[i][j] == INF) {
                    System.out.print("INF\t");
                } else {
                    System.out.print(graph[i][j] + "\t");
                    totalCost += graph[i][j];
                }
            }
            System.out.println();
        }
        System.out.println("Total minimum cost to reach all offices: " + totalCost);
    }

    public static void main(String[] args) {
        int[][] g = inputGraph();
        g = floydWarshall(g, g.length);
        printSolution(g, g.length);
    }
}
*/

import java.util.*;

public class floyd {
    static int INF=999;

    static int[][] inputGraph() {

        Scanner scanner= new Scanner(System.in);
        System.out.println("Enter the no of offices?");
        int n=scanner.nextInt();

        int[][] g=new int [n][n];
        
       System.out.println("Enter the no of lines?");
        int l=scanner.nextInt();

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                g[i][j] = INF;
                g[i][i]= 0;
            }
        }
  

        for(int i=0;i<l;i++)
        {
            int source=0,destination=0,cost=0;
            System.out.println("Enter the source vertex");
            source=scanner.nextInt()-1;
            System.out.println("Enter the destianation vertex");
            destination=scanner.nextInt()-1;
            System.out.println("Enter the cost");
            cost=scanner.nextInt();
               

            g[source][destination]=cost;
            


        }



      
            scanner.close();
            return g;

 

    }


    static int[][] floydwarshall(int [][] g,int n)
    {
        for(int k=0;k<n;k++)
        {for(int i=0;i<n;i++)
        {for(int j=0;j<n;j++)
        {
          g[i][j]=Math.min(g[i][k]+g[k][j],g[i][j]);
        }
            
        }

        }
        return g;
    }


    static void printSolution(int[][] g,int n)
    {
        int totalcost=0;
        System.out.println("minimum distances between offices");
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(g[i][j]==INF)
                {
                System.out.print("INF\t");
                }
                else
                {
                    System.out.print(g[i][j]+"\t"); 
                    totalcost=totalcost+g[i][j];
                }


            }
            System.out.println();
        }

        System.out.println("total minmum cost to reach all the offices" + totalcost);

    }



    public static void main(String[] args){
        int [][] g=inputGraph();
        g=floydwarshall(g,g.length);
        printSolution(g,g.length);

    }

    
}

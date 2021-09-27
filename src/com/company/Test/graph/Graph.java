package com.company.Test.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Graph {
    private List<String> vertexList;//存储顶点集合
    private int[][] edges; //存储图对应的邻接矩阵
    private int numOfEdges; //边的条数
    private static boolean[] visit;

    public static void main(String[] args) {
        int n = 5;
        String[] vertexes = {"A", "B", "C", "D", "E"};
        Graph graph = new Graph(n);
        for (String vertex : vertexes) {
            graph.insertVertex(vertex);
        }
        graph.insertEdges(0, 1, 1);
        graph.insertEdges(0, 2, 1);
        graph.insertEdges(1, 2, 1);
        graph.insertEdges(1, 3, 1);
        graph.insertEdges(1, 4, 1);
        graph.show();
        graph.dfs();
    }

    public Graph(int n) {//n代表顶点个数
        vertexList = new ArrayList<>(n);
        edges = new int[n][n];
        visit = new boolean[n];
    }

    //查找第一个邻接节点下标
    private int getFirstNeighbor(int index) {
        for (int j = 0; j < vertexList.size(); j++) {
            if (edges[index][j] > 0) {
                return j;
            }
        }
        return -1;
    }

    //查找前一个邻接节点的下一个邻接节点的后一个下标
    private int getNextNeighbor(int v1, int v2) {
        for (int j = v2 + 1; j < vertexList.size(); j++) {
            if (edges[v1][j] > 0) {
                return j;
            }
        }
        return -1;
    }

    private void dfs(boolean[] visit, int i) {
        System.out.print(vertexList.get(i) + " ->");
        visit[i] = true;
        int w = getFirstNeighbor(i);
        while (w != -1) {
            if (!visit[w]) {//如果没访问过
                dfs(visit, w);
            } else {
                w = getNextNeighbor(i, w);//返回上一个节点的下一个没被访问的邻接节点
            }
        }
    }

    //深度遍历所有节点
    private void dfs() {
        for (int i = 0; i < vertexList.size(); i++) {
            if (!visit[i]) {
                dfs(visit, i);
            }
        }
    }

    private void bfs(boolean[] visit, int i) {
        int u, w;//u 队列的头部节点下标  v 邻接节点
        LinkedList<Integer> queue = new LinkedList<>();
        System.out.print(vertexList.get(i) + " ->");
        visit[i] = true;
        queue.addLast(i);
        while (!queue.isEmpty()) {
            u = (Integer) queue.removeFirst();
            w = getFirstNeighbor(i);
            while (w != -1) {
                if (!visit[w]) {
                    System.out.print(vertexList.get(w) + " ->");
                    visit[w] = true;
                    queue.addLast(w);
                }
                w = getNextNeighbor(i, w);
            }
        }
        visit[i] = true;
    }

    //添加顶点
    private void insertVertex(String vertex) {
        vertexList.add(vertex);
    }

    //给顶点添加边 v1和v2代表顶点下标,weight代表权值
    private void insertEdges(int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;//因为是无向图所以需要加
        numOfEdges++;//没添加一个边,边数+1
    }

    //查看图
    private void show() {
        for (int[] edge : edges) {
            System.err.println(Arrays.toString(edge));
        }
    }


}

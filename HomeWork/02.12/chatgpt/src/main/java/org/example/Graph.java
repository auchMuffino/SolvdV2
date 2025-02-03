package org.example;

import java.util.ArrayList;
import java.util.List;

public class Graph {

    private Integer[][] graph;

    public Graph(Integer[][] graph){
        this.graph = graph;
    }

    public List<Integer> fastestRoute(int startPeek, int finishPeek){

        List<Integer> route = new ArrayList<>();

        int currentPos = startPeek;
        while(currentPos != finishPeek){
            for(int i = 0; i < graph.length; i++){
                if(graph[currentPos][finishPeek] == 1){
                    route.add(i);
                    currentPos = finishPeek;
                    break;
                }
                if(graph[currentPos][i] == 1 && (finishPeek - i < finishPeek - currentPos)){
                    route.add(i);
                    currentPos = i;
                }
            }
        }

       return route;
    }
}

import heapq
from typing import List, Tuple
from collections import defaultdict

class Solution:
    def networkDelayTime(self, times: List[Tuple[int, int, int]], N: int, K: int) -> int:
        adj_list={i:[] for i in range(1,N+1)}
        for u,v,w in times:
            adj_list[u].append((v,w))
            
        distances={node:float('inf') for node in range(1,N+1)}
        distances[K]=0
        heap=[(0,K)]
        
        while heap:
            curr_dist,curr_node=heapq.heappop(heap)
            if curr_dist>distances[curr_node]:
                continue
            
            for neighbor,weight in adj_list[curr_node]:
                new_dist=curr_dist+weight
                if new_dist<distances[neighbor]:
                    distances[neighbor]=new_dist
                    heapq.heappush(heap,(new_dist,neighbor))
        if float('inf') in distances.values():
            return -1
        return max(distances.values())
    
    
num_times=int(input("enter the number of times:"))
times_input=[tuple(map(int,input().split())) for _ in range(num_times)]
N_input=int(input("enter the number of nodes:"))
K_input=int(input("enter the source node:"))

solution=Solution()

result=solution.networkDelayTime(times_input,N_input,K_input)

print("delay time:",result)




import heapq
from typing import Tuple,List
from collections import defaultdict


class Soltion:
    def networkdelay(self,times:List[Tuple[int,int,int]],N:int,K:int)->int:
        adj={i:[] for i in range(N+1)}
        for u,v,w in times:
            adj[u].append(v,w)

        distances={node:float('inf') for node in range(N+1)}
        distances[K]=0
        heap=[(0,K)]


        while heap:
            curr_dist,curr_node = heapq.heappop(heap)
            if curr_dist>distances[curr_node]:
                continue

            for neighbor,weights in adj[curr_node]:
                new_dist=curr_dist+weights
                if new_dist<distances[neighbor]:
                    distances[neighbor]=new_dist
                    heapq.heappush(heap,(new_dist,neighbor))

        if float('inf') in distances.values():
            return -1
        return max(distances.values())











E=int (input("enter the number of edgess"))
times=tuple((map(int,input().split())) for _ in range(E))
N=int (input("enter the number of node"))
K=int (input("enter the number of sioores"))

solution=Solution()

resu=solution.networkdelay(times,N,K)

print("Solution",resu)
# 算法 todo-list
## 二叉搜索树
需要实现的操作
- put
- get
- size
- max
- min
- floor
- ceiling
- delete
- select
- rank
- keys
- keys(lo, hi) 范围查找
## 图
### 无向图
#### 连通分量 CC
- DFS
- Union-Find
#### 无环图的判定
DFS遍历节点，如果重复检测到某个节点，则存在环
#### 二部图的判断
染色法，DFS遍历节点并染色，染色的规则是相邻节点颜色不一样，如果出现已染色且相邻颜色相同，则不是二部图。
### 符号图
### 有向图
#### 基本API
#### 单点可达
#### 多点可达
#### 拓扑排序
##### 定义
将一个有向图的所有节点排序，使得所有有向边的dst节点在src节点之后。
##### 方法
dfs访问顺序的逆后序。
```
...
    dfs(i)
    stack.push(i)
...    
```
逆后序就是这个Stack的出栈顺序。
#### 强连通
##### 定义
s , v 强连通即 v 对 s 可达，同时存在 v 到 s 的路径。
##### 算法 - Kosaraju 算法
对一个图 G ，首先计算它的反图的逆后序。然后按照这个顺序 dfs 图G。
###### 证明
1. 对节点 s ，它的所有强连通点都在调用 `dfs(s)` 时被mark。<br/>
假设存在强连通的一点 v `dfs(s)` 无法mark，则它在之前就被`dfs`标记了，但是由于强连通，则`dfs` mark v时，必定也mark了s，这样 `dfs(s)` 将不会被调用，矛盾。
2. 对于节点 s ，marked的点必定是强连通的。<br/>
称mark的点为 v，则 s 到 v，必定存在路径。接下来我们只需证明 v 到 s 存在路径，即在图的反图 Gr 中，存在 s 到 v 的路径。<br/>
由于按照逆后序访问节点，而 s 被访问时 v 尚未访问，则在图的反图中（由于逆后序的性质），`dfs(v)` 的结束必定早于 `dfs(s)`。<br/>

这时，有两种可能：
1. `dfs(v)` 的开始早于 `dfs(s)` （且结束早于`dfs(s)`）
2. `dfs(v)`开始在`dfs(s)`开始之后。
对于情况 1，即是说`dfs(v)`的过程中，未访问 s ，即无 v 到 s 的路径，这是与[前面](/s-v存在路径/)矛盾的。而情况2即说明 s 到 v 存在路径。
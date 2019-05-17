package graph;

import java.util.LinkedList;

/**
 * 邻接矩阵
 *      v1  v2  v3  v4
 *  v1  0   1   1   1
 *  v2
 *  v3
 *  v4
 *  如果是有向图 行之和表示初度和，列之和表示该顶点的入度和
 *  如果是无向图 1表示与另一个顶点向交---一个对称矩阵
 *
 *
 * 带权图 （0表示顶点自己与自己 ∞表示没有这样关系  直接的数字为权值 ）
 *   *      v1  v2  v3  v4
 *  *  v1  0   ∞   ∞   6
 *  *  v2
 *  *  v3
 *  *  v4
 *
 *
 *  邻接表 既可以表示是无向图 又可以表示有向图
 *  有向邻接表：
 *  v0->3^
 *  v1->0->2^
 *  v2->0->1^
 *  v3
 *  无向邻接表：
 *  v0->1->2-3^
 *  v1->0->2^
 *  v2->0->1->3^
 *  v3->0->2^
 *  逆邻接表
 *
 *  带权邻接表
 *  v0->4 6 ^
 *  v1->0 9 ->2 3 ^
 *  v2->0 2->3 5 ^
 *  v3->4 1 ^
 *
 */
public class Graph {
    private int vertexSize;
    private int[] vertexs;//顶点数组
    private int[][] matrix;//邻接矩阵
    private static final int MAX_WEIGHT=1000;//权值
    private boolean[] isVisited;//是否访问

    public Graph(int vertexSize){
        this.vertexSize= vertexSize;
        matrix=new int[vertexSize][vertexSize];
        vertexs=new int[vertexSize];
        for(int i=0;i<vertexSize;i++){
            vertexs[i]=i;
        }
        isVisited=new boolean[vertexSize];

    }

    public int[] getVertexs(){
        return vertexs;
    }
    public void setVertexs(int[] vertexs){
        this.vertexs=vertexs;
    }

    /**
     * 获取顶点的出度
     * @param index
     * @return 出度
     */
    public int getOutDegree(int index){
        int OutDegree=0;
        for(int j=0;j<matrix[index].length;j++){
           int weight= matrix[index][j];
           if(weight!=0 && weight!=MAX_WEIGHT){
               OutDegree++;
           }
        }
        return OutDegree;
    }

    /**
     * 入度
     * @param index
     * @return
     */
    public int getIntDegree(int index){
        int intDegree=0;
        for(int i=0;i<matrix.length;i++){
                if(matrix[i][index]!=0 & matrix[i][index]!=MAX_WEIGHT){
                    intDegree++;

                }
        }
        return intDegree;
    }

    /**
     * 获取两个顶点之间的权值
     * @param v1
     * @param v2
     * @return
     */
    public  int getWeight(int v1,int v2){
        int weight=matrix[v1][v2];
        return weight==0?0:weight==MAX_WEIGHT?-1:weight;
    }


    //图的遍历

    /**
     * 图的遍历：从图中的某一点出发访遍图中其余顶点，且使每一个顶点被访问一次，图的遍历。
     * @param args
     */

    //图深度优先遍历Depth_First_Search  DFS（迭代 回溯 ）

    /**
     * 获取某个顶点的第一个邻接点
     * @param
     */
    public int getFirstNeighbor(int index){
        for(int j=0;j<vertexSize;j++){
            if(matrix[index][j]>0 && matrix[index][j]<MAX_WEIGHT){
                return j;
            }
        }
        return -1;//如果没有邻接点
    }

    /**
     * 根据前一个邻接点的下标来取得下一个邻接点
     * @param v 表示要找的顶点
     * @param index 表示该顶点相对于哪一个邻接点
     * @return
     */
    public int getNextNeighbor(int v,int index){
        for(int j=index+1;j<vertexSize;j++){
            if(matrix[v][j]>0 && matrix[v][j]<MAX_WEIGHT){
                return j;
            }
        }
        return -1;
    }

    /**
     * 深度优先遍历
     * @param i
     */
    private void   DFS(int i){

        isVisited[i]=true;
        int w=getFirstNeighbor(i);
        while(w!=-1){
            if(!isVisited[w]){
                System.out.println("访问到了"+w+" 结点");
                DFS(w);
            }
            w=getNextNeighbor(i,w);//第一个相对于 w的第一个临界结点
        }

    }

    public void DFS(){//处理 不连通 有向
        isVisited=new boolean[vertexSize];
        for(int i=0;i<vertexSize;i++){
            if(isVisited[i]){
                System.out.println("访问到"+i+" 结点");
                DFS(i);
            }
        }
        isVisited=new boolean[vertexSize];
    }
    //图广度优先遍历

    public void BFS(){
        isVisited=new boolean[vertexSize];
        for(int i=0;i<vertexSize;i++){
            if(!isVisited[i]){
                BFS(i);
            }
        }
    }

    public void BFS(int i){
        int w,u;
        LinkedList<Integer> queue=new LinkedList<>();
        System.out.println("访问到："+i+" 顶点");
        isVisited[i]=true;
        queue.add(i);//v0
        while(!queue.isEmpty()){
            u=(Integer)( queue.removeFirst()).intValue();

            w=getFirstNeighbor(u);
            while(w!=-1){
                if(!isVisited[w]){
                    System.out.println("访问："+w+"  顶点");
                    isVisited[w]=true;
                    queue.add(w);
                }
                w=getNextNeighbor(u,w);
            }
        }
    }

    public static void main(String[] args) {

        Graph graph=new Graph(5);

        int[] a1=new int[]{0        ,MAX_WEIGHT,MAX_WEIGHT,MAX_WEIGHT,      6};
        int[] a2=new int[]{9,       0,              3,      MAX_WEIGHT,MAX_WEIGHT};
        int[] a3=new int[]{2,       MAX_WEIGHT,    0,      5,          MAX_WEIGHT};
        int[] a4=new int[]{MAX_WEIGHT,MAX_WEIGHT, MAX_WEIGHT, 0,        1};
        int[] a5=new int[]{MAX_WEIGHT,MAX_WEIGHT,MAX_WEIGHT,MAX_WEIGHT,0};
        //初始化二维邻接矩阵
        graph.matrix[0]=a1;
        graph.matrix[1]=a2;
        graph.matrix[2]=a3;
        graph.matrix[3]=a4;
        graph.matrix[4]=a5;

        for(int i=0;i<graph.vertexSize;i++){
            System.out.println("顶点"+i+"的出度："+graph.getOutDegree(i));
        }
        for(int i=0;i<graph.vertexSize;i++){
            System.out.println("顶点"+i+"的入度："+graph.getIntDegree(i));
        }

        System.out.println(graph.getWeight(1,0));
        System.out.println();
        System.out.println();
        graph.DFS();
        graph.BFS();
    }


}













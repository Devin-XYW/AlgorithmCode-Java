package JavaInterviewBook.list;

/**
 * 给定一个大小为NXN的迷宫，从左上角到右下角找到迷宫中的路径
 */
public class P168FindMiPath {

    public static final int mSize = 4;//迷宫的深度

    //判断当前路径中的单元值是否为合理的单元:当前结点值是否在范围内，并且值为1
    public static boolean isSafe(int[][] maze,int x,int y){
        return ((x>=0 && x<mSize) && (y >= 0 && y < mSize) && maze[x][y] == 1);
    }

    //使用回溯法的方法找到一条从左上角到右下角的路径
    public static boolean getPath(int[][] maze,int x,int y,int[][] sol){
        //到达目的地
        if(x == mSize-1 && y == mSize-1){
            sol[x][y] = 1;
            return true;
        }

        //判断maze[x][y]是否为一个可走的单元
        if(isSafe(maze,x,y)){
            //标记的当前单元为1
            sol[x][y] = 1;
            //向右走一步
            if(getPath(maze,x+1,y,sol)){
                return true;
            }
            //向下走一步
            if(getPath(maze,x,y+1,sol)){
                return true;
            }
            //标记当前单元为0，用来表示这条路不可行，进行回溯
            sol[x][y] = 0;
            return false;
        }
        return false;
    }

}

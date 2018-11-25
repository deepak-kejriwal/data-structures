package com.coders.array;

/*
 * 
 * The demons had captured the princess (P) and imprisoned her in the bottom-right corner of a dungeon. The dungeon consists of M x N rooms laid out in a 2D grid. Our valiant knight (K) was initially positioned in the top-left room and must fight his way through the dungeon to rescue the princess.

The knight has an initial health point represented by a positive integer. If at any point his health point drops to 0 or below, he dies immediately.

Some of the rooms are guarded by demons, so the knight loses health (negative integers) upon entering these rooms; other rooms are either empty (0's) or contain magic orbs that increase the knight's health (positive integers).

In order to reach the princess as quickly as possible, the knight decides to move only rightward or downward in each step.

 

Write a function to determine the knight's minimum initial health so that he is able to rescue the princess.

For example, given the dungeon below, the initial health of the knight must be at least 7 if he follows the optimal path RIGHT-> RIGHT -> DOWN -> DOWN.

-2 (K)	-3	 3
-5	    -10	 1
10	     30	-5 (P)
 

Note:

The knight's health has no upper bound.
Any room can contain threats or power-ups, even the first room the knight enters and the bottom-right room where the princess is imprisoned.
 * 
 * 
 * 
 * 
 */
public class DungeonGame {

	public static void main(String[] args) {
		int[][] board = { { -2, -3, 3 }, { -5, -10, 1 }, { 10, 30, -5 } };
		System.out.println(7==new DungeonGame().calculateMinimumHP(board));
	}

    public int calculateMinimumHP(int[][] dungeon) {
        int row=dungeon.length;
        int col=dungeon[0].length;
        dungeon[row-1][col-1]=getMinEnergy(dungeon[row-1][col-1],1);
        for(int i=col-2;i>=0;i--){
            dungeon[row-1][i]=getMinEnergy(dungeon[row-1][i],dungeon[row-1][i+1]);
        }
        for(int i=row-2;i>=0;i--){
            dungeon[i][col-1]=getMinEnergy(dungeon[i][col-1],dungeon[i+1][col-1]);
        }
        for(int i=row-2;i>=0;i--){
            for(int j=col-2;j>=0;j--){                
                int minRight=getMinEnergy(dungeon[i][j],dungeon[i][j+1]);
                int minDown=getMinEnergy(dungeon[i][j],dungeon[i+1][j]);
                dungeon[i][j]=Math.min(minRight,minDown);
            }
        }
        //for printing the newly formed array
        for(int i=0;i<dungeon.length;i++){
            for(int j=0;j<dungeon[0].length;j++){
               System.out.print(dungeon[i][j]+" ");
            }
           System.out.println();
        }
        return dungeon[0][0];
    }
    public int getMinEnergy(int x,int y){
        return y-x>0?y-x:1;
    }
}

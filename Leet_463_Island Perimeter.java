package com.lyh;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Test {
	public int islandPerimeter(int[][] grid) {
		int circumference = 0;//周长
		int row = grid.length;//行数，对于grid[i][j]来说，0<=i<=(row-1)
		//遍历每一行
		for(int i = 0; i < row; ++i){
			//先要知道这一行有几列
			int col = grid[i].length;
			//再来遍历每个元素
			for(int j = 0; j < col; ++j){
				//只对类型为陆地（数组元素为1）的块进行计算周长
				if(grid[i][j] == 1){
					//1.判断上下邻近的两个元素是什么
					//(1)先考虑当前块为上边界或者下边界的情况
					if(i == row - 1){//下边界
						circumference++;
					}
					if(i == 0){//上边界
						circumference++;
					}
					//(2)再考虑当前块的上边或下边可能与water邻接
					if((i != 0) && (grid[i - 1][j] == 0)){//看当前块的上方那个块
						//不直接写成grid[i - 1][j] == 0是为了防止数组越界
						circumference++;
					}
					if((i != row - 1) && (grid[i + 1][j] == 0)){//看当前块下方那个块
						circumference++;
					}
					//2.判断左右邻近的两个元素是什么
					//(1)先考虑当前块为左边界或者右边界的情况
					if(j == 0){//左边界
						circumference++;
					}
					if(j == col - 1){//右边界
						circumference++;
					}
					//(2)再考虑当前块的左边或者邮编可能与water邻接
					if((j != 0) && (grid[i][j - 1] == 0)){//看当前块左侧的那个块
						circumference++;
					}
					if((j != col - 1) && (grid[i][j + 1] == 0)){//看当前块右侧的那个块
						circumference++;
					}
				}
			}
		}
        return circumference;
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test testObj = new Test();
		int[][] map = {{0,1,0,0},
		{1,1,1,0},
		{0,1,0,0},
		{1,1,0,0}};
    //注意，map2中各行的列数可能不一样，要考虑这种情况
    int[][] map2 = {{1,1,1,0},
    {1,1,1},
    {0,1},
    {1,1,0}
    }
		//打印数组有几行
		System.out.println("共有：" + map.length + "行。");
		for(int i = 0; i < map.length; ++i){
			System.out.println("正在打印第：" + i + "行。");
			System.out.println("	第" + i + "行有" + map[i].length + "列，它们是：");
			for(int j = 0; j < map[i].length; ++j){
				if(j == 0)
					System.out.printf("		" + map[i][j] + " ");
				else
					System.out.printf(map[i][j] + " ");
			}
			System.out.printf("\n");
		}
		//计算岛的周长
		System.out.println("岛的周长是：" + testObj.islandPerimeter(map));
	}

}

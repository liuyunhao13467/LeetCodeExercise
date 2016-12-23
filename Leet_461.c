/*
 * Leet code 461: Hamming Distance
 * We will find the Hamming Distance between two integers. My solution is doing  bitwise exclusive, and calculate the number of 1.
 * By LiuYunhao 2016/12/23
*/
#include <stdio.h>
#include <stdlib.h>

int hammingDistance(int x, int y);

int main(int argc, char* argv[]){
	int input1 = 0, input2 = 0, result = -1;
	scanf("%d,%d",&input1,&input2);
	result = hammingDistance(input1, input2);
	printf("Result is: %d\n",result);
	system("PAUSE");
}

int hammingDistance(int x, int y){
	int result = x ^ y;
	int distance = 0;
	while (result != 0){
		distance++;
		result &= result - 1;
	}
	return distance;
}

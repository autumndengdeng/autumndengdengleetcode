//545 Top K Integer 2
//实现一个数据结构，提供下面两个接口
//1 add（number) 添加元素
//2 topk() 返回前k大的数

public class Solution {
	int[] A;
	int n = 0;
	int size;

	public Solution (int k) {
		A = new int[k];
		size = k;
	}

	private void add (int num) {
		if (n < size) {
			offer (num);
		} else {
			if (num > A[0]) {
				poll();
				offer(num);
			}
		}
	}
}
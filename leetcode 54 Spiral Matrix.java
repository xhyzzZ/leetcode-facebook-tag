//leetcode 54 Spiral Matrix


/*
time: O(m * n)
space: O(m * n)
*/
public class Solution {
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> res = new ArrayList<Integer>();
		if (matrix.length == 0 || matrix[0].length == 0) return res;

		int top = 0;
		int button = matrix.length - 1;
		int left = 0;
		int right = matrix[0].length - 1;

		while (true) {
			for (int i = left; i <= right; i++) res.add(matrix[top][i]);
			top++;
			if (left > right || top > bottom) break;

			for (int i = top; i <= buttom; i++) res.add(matrix[i][right]);
			right--;
			if (left > right || top > buttom) break;

			for (int i = right; i >= left; i--) res.add(matrix[buttom][i]);
			buttom--;
			if (left > right || top > buttom) break;

			for (int i = buttom; i >= top; i--) res.add(matrix[i][left]);
			left++;
			if (left > right || top > buttom) break;
		}
		return res;
	}
}
package ua.kruart._07_fork_join.fork_join_max;

public class SequentialMaxFind {

	public long sequentialMaxFinding(long[] nums, int highIndex) {

		long max = nums[0];

		for (int i = 0; i < highIndex; ++i)
			if (nums[i] > max)
				max = nums[i];

		return max;
	}
}

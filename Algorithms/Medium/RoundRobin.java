import java.util.*;

public class RoundRobin 
{
	public static class Process
	{
		int requestTime;
		int executionTime;

		public Process(int requestTime, int executionTime)
		{
			this.requestTime = requestTime;
			this.executionTime = executionTime;
		}
	}

	public static void main(String[] args)
	{
		int[] arrival = new int[]{0,1,4};
		int[] run = new int[]{5,2,3};
		int timeQuantum = 3;
	
		float averageWaitTime = roundRobin(arrival, run, timeQuantum);

		System.out.println(averageWaitTime);
	}

	public static float roundRobin(int[] arrival, int[] run, int timeQuantum)
	{
		int waitTime = 0;
		int currTime = 0;
		int i = 0;
		Queue<Process> queue = new LinkedList<>();

		while(i < arrival.length || !queue.isEmpty())
		{
			if(!queue.isEmpty())
			{
				Process p = queue.poll();
				waitTime += currTime - p.requestTime;
				currTime += Math.min(p.executionTime, timeQuantum);
				while(i < arrival.length && arrival[i] <= currTime)
				{
					queue.offer(new Process(arrival[i], run[i]));
					i++;
				}
				if(p.executionTime > timeQuantum)
				{
					queue.offer(new Process(currTime, p.executionTime - timeQuantum));
				}
			}
			else
			{
				queue.offer(new Process(arrival[i], run[i]));
				currTime = arrival[i];
				i++;
			}
		}

		return (float) waitTime / (float) arrival.length;	
	}
}

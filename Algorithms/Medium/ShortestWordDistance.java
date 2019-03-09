public int shortestDistance(String[] words, String w1, String w2)
{
	int w1Index = -1;
	int w2Index = -1;

	int min = Integer.MAX_VALUE;

	for(int i = 0; i < words.length; i++)
	{
		String s = words[i];
		if(s.equals(w1))
		{
			w1Index = i;
			if(w2Index != -1)
			{
				min = Math.min(min, w1Index-w2Index);
			}
		}
		else if(s.equals(w2))
		{
			w2Index = i;
			if(w1Index != -1)
			{
				min = Math.min(min, w2Index - w1Index);
			}
		}
	}
	return min;
}

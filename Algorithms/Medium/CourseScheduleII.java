class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

		// store number of prerequisites for each course
        int[] numPrerequisites = new int[numCourses];

        for(int i = 0; i < prerequisites.length; i++)
        {
            numPrerequisites[prerequisites[i][0]]++;
        }
        
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        Queue<Integer> queue = new LinkedList<>();

		// look for courses without prerequisite        
        for(int i = 0; i < numPrerequisites.length; i++)
        {
            if(numPrerequisites[i] == 0)
            {
				// add course to set as if we have studied the course
                set.add(i);
                queue.add(i);
            }
        }
        
        while(!queue.isEmpty())
        {
            int course = queue.remove();
            for(int i = 0; i < prerequisites.length; i++)
            {
				// if the course has not been studied
                if(!set.contains(prerequisites[i][0]))
                {
					// if the prerequisite for the course is something we have studied
                    if(prerequisites[i][1] == course)
                    {
						// decrement the num of prerequisites for the course
                        numPrerequisites[prerequisites[i][0]]--;

						// when there is no more prerequisite
                        if(numPrerequisites[prerequisites[i][0]] == 0)
                        {
							// add course into set as if we have studied it
                            set.add(prerequisites[i][0]);
                            queue.add(prerequisites[i][0]);
                        }
                    }
                }
            }
        }
        
        int[] result;
        int index = 0;
        
		// if the courses that we have studied match total num of courses
		// then we have managed to studied all the courses
        if(set.size() == numCourses)
        {
            result = new int[numCourses];
            for(int a : set)
            {
                result[index++] = a;
            }
        }

		// otherwise there are some courses that we cant study as we cant
		// fulfill the prerequisites
        else
        {
            result = new int[0];
        }
        
        return result;
        
    }
}

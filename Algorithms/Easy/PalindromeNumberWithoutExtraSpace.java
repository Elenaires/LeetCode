public class PalindromeNumberWithoutExtraSpace  {
	public static void main(String[] args)
	{
		System.out.println(isPalindrome(10101));
	}

    public static boolean isPalindrome(int x) {
   		
		boolean palindrome;

		if(x < 0)
		{
			palindrome = false;
		}
		else
		{
			int original = x;
			int reversed = 0;

			while(x != 0)
			{
				reversed = reversed * 10 + x % 10;
				x = x/10;
			}
  
        	palindrome = (original == reversed) ? true : false;
		}

		return palindrome;
    }
}

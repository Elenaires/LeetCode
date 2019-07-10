import java.util.*;

public class HeaviestPallet
{
	public static void main(String[] args)
	{
		double[] pallets = new double[]{1,1.5,3.5,17.25,19};
		double maxCapacity = 20.8;

		List<Double> list = heaviestPallets(pallets, maxCapacity);

		for(double d : list)
		{
			System.out.println(d);
		}	
	}

	public static List<Double> heaviestPallets(double[] pallets, double maxCapacity)
	{
		Arrays.sort(pallets);
		
		ArrayList<Double> list = new ArrayList<>();
		double maxWeight = 0.0;
		double sum = 0.0;
		for(int i = pallets.length-1; i > 0; i--)
		{
			// optimization
			sum = pallets[i] + pallets[i];
			if(sum <= maxWeight)
			{
				break;
			}

			for(int j = i-1; j >= 0; j--)
			{
				sum = pallets[i] + pallets[j];
				if(sum <= maxCapacity)
				{
					if(sum > maxWeight)
					{
						list.clear();
						list.add(pallets[i]);
						list.add(pallets[j]);
						maxWeight = sum;
					}
		
					// optimization
					break;
				}	
			}
			
		}

		return list;
	}	
}

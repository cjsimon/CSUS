import java.util.HashMap;

class HashMapReplace
{
	public static void main(String[] args)
	{
		String pattern = "Q01 + Q02";
		String result = "";
		
		// Create a HashMap of find and replace values
		HashMap<String, String> vals = new HashMap<>();
		vals.put("Q01", "123");
		vals.put("Q02", "456");
		
		// For each entry
		for(HashMap.Entry<String, String> val : vals.entrySet())
		{
			// Replace each key with it's coresponding value
			result = pattern.replace(val.getKey(), val.getValue());
			pattern = result;
		}
		
		System.out.println(result);
		
	}
}
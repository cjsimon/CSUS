import java.util.*;
public class permute {

    static void permute(int level, String permuted, boolean used[], String original) {
        int length = original.length();
        if (level == length) {
            System.out.println(permuted);
        } else {
            for (int i = 0; i < length; i++) {
                if (!used[i]) {
                    used[i] = true;
                    permute(level + 1, permuted + original.charAt(i),
                       used, original);
                    used[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
		//String s = "ABC";
		//boolean used[] = {false, false, false};
		//permute(0, "", used, s);
		perm8();
    }
	
	public void perm8() {
		final long count = 36L * 36L * 36L * 36L * 36L * 36L * 36L * 36L;
		
		for (long i = 0; i < count; ++i) {
			String name = StringUtils.leftPad(Long.toString(i, 36), 8, '0');
			System.out.println(name);
		}
	}
}
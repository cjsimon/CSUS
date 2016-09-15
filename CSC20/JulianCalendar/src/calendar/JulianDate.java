package calendar;

public class JulianDate {
    public static int JGREG = 588829;

    public JulianDate() {
    }

    public static int toJulian(int var0, int var1, int var2) {
        int var3 = var0;
        if(var0 < 0) {
            var3 = var0 + 1;
        }

        int var4;
        if(var1 > 2) {
            var4 = var1 + 1;
        } else {
            --var3;
            var4 = var1 + 13;
        }

        double var5 = Math.floor(365.25D * (double)var3) + Math.floor(30.6001D * (double)var4) + (double)var2 + 1720995.0D;
        if(var2 + 31 * (var1 + 12 * var0) >= JGREG) {
            int var7 = (int)(0.01D * (double)var3);
            var5 += (double)(2 - var7) + 0.25D * (double)var7;
        }

        return (int)Math.floor(var5);
    }
}
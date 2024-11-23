
public class Timecode {
	public static String fromSeconds(double seconds){
        int hours = (int)seconds/3600;
        int mins = (int)(seconds/60)%60;
        int secs = (int)seconds%60;
        int millisecs = (int)((seconds%1f)*1000f);

		return String.format("%02d:%02d:%02d:%03d",hours,mins,secs,millisecs);
	}
}

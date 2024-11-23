// Rational approximation
class RationalApx {
	int num;	// numerator
	int den;	// denominator
	int prec;	// how many decimal places the approximation is good out to
	
	RationalApx(){ this(0,1, 0); }
	
	RationalApx(int n, int d, int p){
		num = n;
		den = d;
		prec = p;
	}

	boolean equals(int n, int d, int p){
		return num==n && den==d && prec==p;
	}

	boolean equals(RationalApx other){
		return equals(other.num, other.den, other.prec);
	}
}

public class FindingPi {
	public static RationalApx run(int maxInt){
		var result = new RationalApx();
		double approx = 0;
        double minDiff = Double.MAX_VALUE;
        
        for(int den = 1; den<maxInt; den++)
        {
        	int num = (int) Math.round(Math.PI*den);
        	double r = (double) num/den;
        	double diff = Math.abs(Math.PI - r);
        	if(num > maxInt)
        	{
        		break;
        	}
        	if(diff < minDiff) {
        		minDiff = diff;
        		result.num = num<maxInt ? num: result.num;
        		result.den = den;
        		approx = (double) num/den;
        	}
        }
        result.prec = checkPrec(approx);
		return result;
	}
	public static int checkPrec(double approximation)
	{
		int i = 1;
		while(i<100)
        {
            double approxToDp = Math.floor(approximation*Math.pow(10,i));
            double piToDp = Math.floor(Math.PI*Math.pow(10,i));
            if(approxToDp != piToDp)
            {
          	  return i-1;
            }
            i++;
        }
		return -1;
	}
}

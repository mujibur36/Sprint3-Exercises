package labSpock;

public class Belly {
	private int cukes = 0;
	private int hours = 0;
	
    public void eat(int cukes_) {
    	cukes += cukes_;
    }
    public int getCukes() {
    	return cukes;
    }
    public void wait(int hours_) {
    	hours = hours_;
    }
    public boolean growl() {
    	if (cukes>10)
    		if (hours >= 1) return true;
    	return false;
    }
}

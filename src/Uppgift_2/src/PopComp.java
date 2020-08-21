import java.util.Comparator;

public class PopComp implements Comparator<Land>{

	@Override
	public int compare(Land o1, Land o2) {
		if(o1.getPopulation() == o2.getPopulation()) {
			return 0;
		}
		else if(o1.getPopulation() >= o2.getPopulation()) {
			return 1;
		}
		else {
			return -1;
		}
	}
}
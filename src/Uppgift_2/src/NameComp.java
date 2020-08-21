import java.util.Comparator;

public class NameComp implements Comparator<Land>{

	@Override
	public int compare(Land o1, Land o2) {
		return o1.getCountryName().compareTo(o2.getCountryName());
	}
}

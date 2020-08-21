import java.util.Comparator;

public class AreaComp implements Comparator<Land>{ //class with overriding compare method, so we can dictate how the Collections.sort() function sorts.

	@Override
	public int compare(Land o1, Land o2) {
		if(o1.getArea() == o2.getArea()) { 		//equal size 
			return 0;
		}
		else if(o1.getArea() > o2.getArea()) { 	//o1 is smaller than o2
			return 1;
		}
		else {									//o1 is bigger than o2
			return -1;
		}
	}


}
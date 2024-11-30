import java.util.Comparator;

public class VisitorComparator implements Comparator<Visitor> {
    @Override
    public int compare(Visitor v1, Visitor v2) {
        // First, compare by name 
        int nameComparison = v1.getName().compareTo(v2.getName());
        
        // If names are the same, compare by age
        if (nameComparison == 0) {
            return Integer.compare(v1.getAge(), v2.getAge());
        }
        
        return nameComparison;
    }
}

package tcissues;

import java.util.Comparator;

public class BaseIssueComparator implements Comparator<BaseIssue> {
	@Override
	public int compare(BaseIssue o1, BaseIssue o2) {
		return Integer.compare(o1.getIssueNumber(), o2.getIssueNumber());
	}
}

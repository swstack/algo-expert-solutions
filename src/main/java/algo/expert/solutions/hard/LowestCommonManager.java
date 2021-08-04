package algo.expert.solutions.hard;

import java.util.ArrayList;
import java.util.List;

public class LowestCommonManager {
    public static OrgChart getLowestCommonManager(OrgChart topManager, OrgChart reportOne, OrgChart reportTwo) {
        OrgChart manager = getLowestCommonManagerRec(topManager, reportOne, reportTwo);
        if (manager != null) {
            return manager;
        } else {
            return topManager;
        }
    }

    public static OrgChart getLowestCommonManagerRec(OrgChart manager, OrgChart reportOne, OrgChart reportTwo) {

        for (OrgChart node : manager.directReports) {
            OrgChart common = getLowestCommonManagerRec(node, reportOne, reportTwo);
            if (common != null) {
                return common;
            } else {
                if (findReport(node, reportOne) && findReport(node, reportTwo)) {
                    return node;
                }
            }
        }

        return null;
    }

    private static Boolean findReport(OrgChart manager, OrgChart report) {
        if (manager.name == report.name) {
            return true;
        }

        for (OrgChart node : manager.directReports) {
            boolean found = findReport(node, report);
            if (found) {
                return true;
            }
        }

        return false;
    }


    static class OrgChart {
        public char name;
        public List<OrgChart> directReports;

        OrgChart(char name) {
            this.name = name;
            this.directReports = new ArrayList<OrgChart>();
        }

        // This method is for testing only.
        public void addDirectReports(OrgChart[] directReports) {
            for (OrgChart directReport : directReports) {
                this.directReports.add(directReport);
            }
        }
    }
}

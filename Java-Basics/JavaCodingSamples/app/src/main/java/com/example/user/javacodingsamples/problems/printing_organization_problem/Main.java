package com.example.user.javacodingsamples.problems.printing_organization_problem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by singh on 12/7/17.
 */


/**
 * We have an organization and need to print an org chart in the terminal.
 * The input is a list of strings.
 * Each string is a management / direct report relationship Example: "A1,B2,C3,D4"
 * Explanation: A1 is the manager of B2, C3, D4, where A1, B2, C3, D4 are unique employee IDs separated by comma.
 *
 * An org chart is a list of strings like above. Example of an org chart "B2,E5,F6", "A1,B2,C3,D4", "D4,G7,I9", "G7,H8"
 *
 * The output is a terminal representation of the org chart, such as
 *
 * A1
 *      B2
 *            E5
 *            F6
 *      C3
 *      D4
 *            G7
 *                   H8
 *            I9
 *
 * INPUT: an array of strings "B2,E5,F6", "A1,B2,C3,D4", "D4,G7,I9", "G7,H8"
 *
 * OUTPUT: (see above)
 */


public class Main {

    static Map<String,String> result = new HashMap<>();


    public static void main(String[] args) {
        String[] input =  {"B2,E5,F6", "A1,B2,C3,D4", "D4,G7,I9", "G7,H8" };
        Map<String, String> relationMap = processInput(input);
        Map<String, List<String>> organization = populateResult(relationMap);
        System.out.println(relationMap);
        String head = getHead(relationMap);
        printResult(head, organization.get(head), organization,0);
    }

    public static String getHead(Map<String, String> relationMap) {
        for(Map.Entry<String, String> entry: relationMap.entrySet()) {
            if(entry.getValue() == null) {
                return entry.getKey();
            }
        }
        return null;
    }

    private static Map<String, String> processInput(String[] input) {
        Map<String, String> relationMap = new HashMap<>();
        for (int i = 0; i < input.length; i++) {
            String[] employees = input[i].split(",");
            String manager = employees[0];
            if(relationMap.get(manager)== null) {
                relationMap.put(manager, null);
            }
            for (int j = 1; j < employees.length; j++) {
                relationMap.put(employees[j], manager);
            }
        }
        return relationMap;
    }

    private static Map<String, List<String>> populateResult(Map<String, String> dataSet) {
        Map<String, List<String>> mngrMap = new HashMap<>();

        for (Map.Entry<String,String> entry: dataSet.entrySet()) {
            String emp = entry.getKey();
            String mngr = entry.getValue();
            if (!emp.equals(mngr)) {
                List<String> directReportList = mngrMap.get(mngr);

                if (directReportList == null)
                    directReportList = new ArrayList<>();

                directReportList.add(emp);
                mngrMap.put(mngr, directReportList);
            }
        }
        return mngrMap;
    }

    public static void printResult(String manager,
                                   List<String> employees,
                                   Map<String, List<String>> organization,
                                   int count) {
        String formatter = "";
        for(int i = 0; i<count; i++) {
            formatter += "\t\t";
        }
        System.out.println(formatter + manager);
        for (String emp:employees) {
            if(organization.get(emp) != null) {
                printResult(emp, organization.get(emp), organization, count++);
            } else {
                System.out.println(formatter+"\t\t"+emp);
            }
        }
    }


}

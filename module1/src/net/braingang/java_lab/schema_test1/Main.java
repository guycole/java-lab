package net.braingang.java_lab.schema_test1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Main {

    /**
     * Compare array of HashMap, ensure each HashMap value matches data type
     * @param candidates
     * @return
     */

    public boolean testSchema(ArrayList<HashMap<String, Object>> candidates) {
        for (int ii = 0; ii < candidates.size(); ii++) {
            HashMap<String, Object> hm1 = candidates.get(ii);
            Set<String> keySet1 = hm1.keySet();

            for (int jj = ii+1; jj < candidates.size(); jj++) {
                HashMap<String, Object> hm2 = candidates.get(jj);
                Set<String> keySet2 = hm2.keySet();

                if (!keySet1.equals(keySet2)) return false;

                for (String key:keySet1) {
                    Object oo1 = hm1.get(key);
                    Object oo2 = hm2.get(key);

                    if ((oo1 == null) || (oo2 == null)) {
                        // should have asked about this, skip for now
                        continue;
                    }

                    String className1 = oo1.getClass().getCanonicalName();
                    String className2 = oo2.getClass().getCanonicalName();

                    if (!className1.equals(className2)) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    public ArrayList<HashMap<String, Object>> getTestSet1() {
        /**
         * two matching schema
         */

        HashMap<String, Object> hm1 = new HashMap<>();
        hm1.put("key1", "hello");
        hm1.put("key2", 123);

        HashMap<String, Object> hm2 = new HashMap<>();
        hm2.put("key1", "goodbye");
        hm2.put("key2", 456);

        ArrayList<HashMap<String, Object>> result = new ArrayList<>();
        result.add(hm1);
        result.add(hm2);

        return result;
    }

    public ArrayList<HashMap<String, Object>> getTestSet2() {
        /**
         * not matching schema
         */

        HashMap<String, Object> hm1 = new HashMap<>();
        hm1.put("key1", "hello");
        hm1.put("key2", 123);

        HashMap<String, Object> hm2 = new HashMap<>();
        hm2.put("key1", "goodbye");
        hm2.put("key2", "bogus");

        HashMap<String, Object> hm3 = new HashMap<>();
        hm3.put("key1", "goodbye");
        hm3.put("key2", 456);

        ArrayList<HashMap<String, Object>> result = new ArrayList<>();
        result.add(hm1);
        result.add(hm2);
        result.add(hm3);

        return result;
    }

    public static void main(String[] args) {
        System.out.println("begin");

        Main main = new Main();
        System.out.println(main.testSchema(main.getTestSet1()));
        System.out.println(main.testSchema(main.getTestSet2()));

        System.out.println("end");
    }
}

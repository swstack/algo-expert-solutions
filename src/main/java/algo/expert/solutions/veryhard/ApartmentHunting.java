package algo.expert.solutions.veryhard;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ApartmentHunting {
    public static int apartmentHunting(List<Map<String, Boolean>> blocks, String[] reqs) {

        // For every single block as "home", calculate the closest reqs
        int bestIdx = -1;
        int bestDistance = Integer.MAX_VALUE;
        for (int home = 0; home < blocks.size(); home++) {

            Map<String, Integer> bestReqDistances = new HashMap<>();
            for (String req : reqs) {
                for (int i = 0; i < blocks.size(); i++) {
                    Map<String, Boolean> block = blocks.get(i);
                    if (block.get(req)) {
                        int distanceToReq = Math.abs(i - home);
                        if (distanceToReq < bestReqDistances.getOrDefault(req, Integer.MAX_VALUE)) {
                            bestReqDistances.put(req, distanceToReq);
                        }
                    }
                }
            }

            // If we didn't find a closest of a req, don't even consider this block
            if (bestReqDistances.keySet().size() != reqs.length) {
                continue;
            }

            // Minimize walking distance for any single req, not just sum of all distances.
            // Technically sum could be greater, as long as individual walking distance to each req is shorter.

            int maxReqDistance = bestReqDistances.values().stream().mapToInt(Integer::intValue).max().getAsInt();
//            int distanceToAllReqs = bestReqDistances.values().stream().mapToInt(Integer::intValue).sum();
            if (maxReqDistance < bestDistance) {
                bestDistance = maxReqDistance;
                bestIdx = home;
            }

        }
        return bestIdx;
    }
}

package algo.expert.solutions.veryhard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class AirportConnections {
    public static int airportConnections(List<String> airports,
                                         List<List<String>> routes,
                                         String startingAirport) {

        HashMap<String, List<String>> graph = buildGraph(airports, routes);

        // Build adjacency matrix from routes
        List<List<String>> newRoutes = new ArrayList<>();
        List<String> unreachable = unreachableAirports(airports, graph, startingAirport);
        while (unreachable.size() != 0) {
            int mostReachableUnreachable = 0;
            String mostReachableUnreachableAirport = null;
            for (String airport : unreachable) {
                // Of all unreachable airports, find the airport that has the most connections that are also unreachable
                List<String> reachable = visitAllReachable(airport, graph, new ArrayList<>());
                List<String> finalUnreachable = unreachable;  // Temp var for lambda
                List<String> reachableUnreachable = reachable
                        .stream()
                        .filter(a -> finalUnreachable.contains(a) && !a.equals(airport))
                        .collect(Collectors.toList());
                if (reachableUnreachable.size() > mostReachableUnreachable) {
                    mostReachableUnreachable = reachableUnreachable.size();
                    mostReachableUnreachableAirport = airport;
                }
            }

            if (mostReachableUnreachableAirport == null) {
                // Pick one at random that is not the starting airport
                mostReachableUnreachableAirport = unreachable.stream().filter(a -> !a.equals(startingAirport)).findFirst().get();
            }

            newRoutes.add(List.of(startingAirport, mostReachableUnreachableAirport));
            List<String> connections = graph.get(startingAirport);
            connections.add(mostReachableUnreachableAirport);
            graph.put(startingAirport, connections);

            unreachable = unreachableAirports(airports, graph, startingAirport);
        }
        return newRoutes.size();
    }

    static HashMap<String, List<String>> buildGraph(List<String> airports, List<List<String>> routes) {
        HashMap<String, List<String>> graph = new HashMap<>();
        for (String airport : airports) {
            // Always initialize empty list for any airport we find
            graph.put(airport, graph.getOrDefault(airport, new ArrayList<>()));
        }

        for (List<String> route : routes) {
            String src = route.get(0);
            String dst = route.get(1);

            List<String> connections = graph.get(src);
            connections.add(dst);
            graph.put(src, connections);
        }

        return graph;
    }

    static List<String> unreachableAirports(List<String> airports,
                                            HashMap<String, List<String>> graph,
                                            String startingAirport) {
        // A list of unreachable airports given the startingAirport

        List<String> unreachable = new ArrayList<>();
        for (String airport : airports) {
            if (!isReachable(airport, graph, startingAirport, new ArrayList<>())) {
                unreachable.add(airport);
            }
        }
        return unreachable;
    }

    static boolean isReachable(String airport,
                               HashMap<String, List<String>> graph,
                               String startingAirport,
                               List<String> visited) {
        // Given a startingAirport, determine if airport is reachable

        if (startingAirport.equals(airport)) {
            return true;
        }

        if (visited.contains(startingAirport)) {
            return false;
        }

        visited.add(startingAirport);

        for (String connection : graph.getOrDefault(startingAirport, new ArrayList<>())) {
            boolean result = isReachable(airport, graph, connection, visited);
            if (result) {
                return true;
            }
        }

        return false;
    }

    static List<String> visitAllReachable(String startingAirport,
                                          HashMap<String, List<String>> graph,
                                          List<String> visited) {
        // Populate the visited list with every reachable airport

        if (visited.contains(startingAirport)) {
            return visited;
        } else {
            visited.add(startingAirport);
        }

        for (String connection : graph.getOrDefault(startingAirport, new ArrayList<>())) {
            visitAllReachable(connection, graph, visited);
        }

        return visited;
    }
}

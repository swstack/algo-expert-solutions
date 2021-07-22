package algo.expert.solutions

import algo.expert.solutions.veryhard.AirportConnections
import algo.expert.solutions.veryhard.LRUCacheProgram
import org.junit.Test

class TestVeryHardSolutions {
    @Test
    fun testAirportConnections() {
        val airports = listOf(
            "BGI",
            "CDG",
            "DEL",
            "DOH",
            "DSM",
            "EWR",
            "EYW",
            "HND",
            "ICN",
            "JFK",
            "LGA",
            "LHR",
            "ORD",
            "SAN",
            "SFO",
            "SIN",
            "TLV",
            "BUD"
        )
        val routes = listOf<List<String>>()
        AirportConnections.airportConnections(airports, routes, "LGA");
    }

    @Test
    fun testLRUCache() {
        val cache = LRUCacheProgram.LRUCache(4);
        cache.insertKeyValuePair("foo", 1);
        cache.print();

        cache.insertKeyValuePair("bar", 2);
        cache.print();

        cache.insertKeyValuePair("ab", 3);
        cache.print();

        cache.insertKeyValuePair("fg", 4);
        cache.print();

        cache.insertKeyValuePair("z", 5);
        cache.print();

        System.out.println(String.format("most recent: %s", cache.mostRecentKey));
        cache.print();

        System.out.println(String.format("get: %s", cache.getValueFromKey("z")));
        cache.print();

        System.out.println(String.format("get: %s", cache.getValueFromKey("farts")));
        cache.print();

        System.out.println(String.format("get: %s", cache.getValueFromKey("ab")));
        cache.print();

        System.out.println(String.format("get: %s", cache.getValueFromKey("bar")));
        cache.print();
    }
}
package algo.expert.solutions

import algo.expert.solutions.veryhard.AirportConnections
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
}
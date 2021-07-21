package algo.expert.solutions

import algo.expert.solutions.hard.GenerateDivTags
import org.junit.Test

class TestHardSolutions {
    @Test
    fun testGenerateDivTags() {
        val program = GenerateDivTags()
        val tags = program.generateDivTags(2)
        println(tags)
    }
}
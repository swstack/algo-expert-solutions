package algo.expert.solutions.random

fun O_logn(n: Int) {
    // O(log(n)): each iteration, remaining iterations is cut by half
    // Examples:
    //  n = 100, total iterations = 7
    //  n = 200, total iterations = 8
    //  n = 300, total iterations = 9
    //  n = 10000, total iterations = 14

    var count = 0
    var i = n
    while (i > 0) {
        count++
        i /= 2
    }
    println(count)
}

fun O_n(n: Int) {
    // O(n): iterate n times

    var count = 0
    for (d in 0..n) {
        count++
    }
    println(count)
}

fun O_nlogn(n: Int) {
    // O(n log(n)): iterate n times, for each iteration perform log(n) iterations
    // Examples:
    //  n = 100, total iterations = 700
    //  n = 200, (200)*(log(200)=8), total iterations = 1600
    //  n = 300, total iterations = 2700
    //  n = 10000, total iterations = 140,000

    var count = 0
    for (d in 1..n) {
        var i = n
        while (i > 0) {
            count++
            i /= 2
        }
    }
    println(count)
}

fun O_n2(n: Int) {
    // O(n^2): iterate n times, for each iteration iterate n times again
    // Examples:
    //  n = 100, total iterations = 10000
    //  n = 10000, total iterations = 10000000
    var count = 0
    for (d1 in 1..n) {
        for (d2 in 1..n) {
            count++
        }
    }
    println(count)
}

fun O_n3(n: Int) {
    // O(n^3): Triple for loop
    // Examples:
    //  n = 100, total iterations = 1000000
    var count = 0
    for (d1 in 1..n) {
        for (d2 in 1..n) {
            for (d3 in 1..n) {
                count++
            }
        }
    }
    println(count)
}

fun O_2n(n: Int) {
    // O(2^n): each iteration the total number of iterations is doubled
    // Examples:
    //  n = 1, , total iterations = 2
    //  n = 2, total iterations = 4
    //  n = 3, , total iterations = 8
    //  n = 4, total iterations = 16
    //  n = 10, total iterations = 1024

    var count = 1
    for (d1 in 1..n) {

        var subCount = 0
        for (d2 in 1..count) {
            subCount++
        }

        count += subCount
    }
    println(count)
}

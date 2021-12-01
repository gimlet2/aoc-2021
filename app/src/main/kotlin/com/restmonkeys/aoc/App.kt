/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package com.restmonkeys.aoc

import java.io.File

fun main() {
    
    print(`task1 part2`())
}

fun `task1 part1`(): Int {
    val input: List<Int> = File("/workspaces/aoc-2021/1_1.txt").readLines().map { it.toInt()}
    var result = 0
    for(i in 1..(input.size-1)) {
        if(input[i] > input[i-1]) result++
    }
    return result
}

fun `task1 part2`(): Int {
    val input: List<Int> = File("/workspaces/aoc-2021/1_1.txt").readLines().map { it.toInt()}
    var result = 0
    for(i in 3..(input.size-1)) {
        if(input[i] - input[i-3] > 0) result++
    }
    return result
}
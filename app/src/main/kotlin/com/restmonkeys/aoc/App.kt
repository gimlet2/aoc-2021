/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package com.restmonkeys.aoc

import java.io.File
import kotlin.math.pow

fun main() {
    // val input: List<Int> = File("/workspaces/aoc-2021/1_1.txt").readLines().map { it.toInt() }
    // val input: List<Pair<Direction, Int>> =
    //         File("/workspaces/aoc-2021/2_1.txt").readLines().map {
    //             it.split(' ').let { Direction.valueOf(it[0]) to it[1].toInt() }
    //         }
    val input: List<String> = File("/workspaces/aoc-2021/3_1.txt").readLines()
    print(`task3 part1`(input))
}

fun `task1 part1`(input: List<Int>): Int {
    var result = 0
    for (i in 1..(input.size - 1)) {
        if (input[i] > input[i - 1]) result++
    }
    return result
}

fun `task1 part2`(input: List<Int>): Int {
    var result = 0
    for (i in 3..(input.size - 1)) {
        if (input[i] - input[i - 3] > 0) result++
    }
    return result
}

fun `task2 part1`(input: List<Pair<Direction, Int>>): Int {
    var horizontal = 0
    var vertical = 0
    for (i in 0..(input.size - 1)) {
        when (input[i].first) {
            Direction.forward -> horizontal += input[i].second
            Direction.up -> if (vertical >= input[i].second) vertical -= input[i].second
            Direction.down -> vertical += input[i].second
        }
    }
    return horizontal * vertical
}

fun `task2 part2`(input: List<Pair<Direction, Int>>): Int {
    var horizontal = 0
    var aim = 0
    var depth = 0
    for (i in 0..(input.size - 1)) {
        when (input[i].first) {
            Direction.forward -> {
                horizontal += input[i].second
                depth += input[i].second * aim
            }
            Direction.up -> if (aim >= input[i].second) aim -= input[i].second
            Direction.down -> aim += input[i].second
        }
    }
    return horizontal * depth
}

fun `task3 part1`(input: List<String>): Int {
    var gamma = 0
    var epsilon = 0
    var gammaCounts = IntArray(input[0].length)
    for (line in input) {
        line.forEachIndexed { i, s -> if (s == '1') gammaCounts[i]++ }
    }

    for (i in gammaCounts.lastIndex downTo 0) {
        if (gammaCounts[i] > input.size / 2) {
            gamma += 2.0.pow(gammaCounts.size - i - 1).toInt()
        } else {
            epsilon += 2.0.pow(gammaCounts.size - i - 1).toInt()
        }
    }
    return gamma * epsilon
}

enum class Direction {
    forward,
    down,
    up,
}

package org.algorithm.kotlin

import org.algorithm.kotlin.LT_412_FizzBuzz.Companion.fizzBuzz

/**
 * https://leetcode.com/problems/fizz-buzz/submissions/969598047/
 */

class LT_412_FizzBuzz {
    companion object {
        fun fizzBuzz(n: Int): List<String> {
            val answer = List(n + 1) { i ->
                if (i % 15 == 0) "FizzBuzz"
                else if (i % 3 == 0) "Fizz"
                else if (i % 5 == 0) "Buzz"
                else i.toString()
            }
            return answer.subList(1, n + 1)
        }
    }

}

fun main(args: Array<String>) {
    println(fizzBuzz(3))
}

package org.algorithm.kotlin

import org.algorithm.kotlin.LT_49_GroupAnagrams.Companion.groupAnagrams

class LT_49_GroupAnagrams {
    companion object{
        fun groupAnagrams(strs: Array<String>): List<List<String>> {
            val strMap: MutableMap<String, MutableList<String>> = mutableMapOf()
            val result: MutableList<List<String>> = mutableListOf()

            for(str in strs) {
                val sortedStr = str.toCharArray().sorted().joinToString("")
                val strSet = strMap.getOrDefault(sortedStr, mutableListOf())
                strSet.add(str)
                strMap[sortedStr] = strSet
            }

            for(map in strMap){
                result.add(map.value.toList())
            }

            return result
        }
    }

}

fun main(args: Array<String>) {
    println(groupAnagrams(arrayOf("","")))
}

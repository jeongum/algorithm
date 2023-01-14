class `49_GroupAnagrams` {
    companion object{
        private fun groupAnagrams(strs: Array<String>): List<List<String>> {
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
        @JvmStatic
        fun main(args: Array<String>) {
            println(groupAnagrams(arrayOf("","")))
        }
    }
}
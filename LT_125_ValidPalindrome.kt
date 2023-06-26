import LT_125_ValidPalindrome.Companion.isPalindromeTwoPointer

/**
 * https://leetcode.com/problems/valid-palindrome/submissions/980046711/
 */

class LT_125_ValidPalindrome {
    companion object {
        fun isPalindrome(s: String): Boolean = s.lowercase().filter {
           it.isLetterOrDigit()
        }.let {
            it == it.reversed()
        }

        fun isPalindromeTwoPointer(s: String): Boolean {
            var left: Int = 0
            var right: Int = s.length - 1

            while(left < right) {
                while(!s[left].isLetterOrDigit() && left < right) left ++
                while(!s[right].isLetterOrDigit() && right > left) right --

                if(s[left].lowercase() != s[right].lowercase()) return false

                left ++
                right --
            }

            return true
        }

    }
}

fun main(args: Array<String>) {
    println(isPalindromeTwoPointer(".,"))
}

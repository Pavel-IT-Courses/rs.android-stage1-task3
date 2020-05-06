package subtask5

import java.util.ArrayList
import kotlin.reflect.KClass

class TelephoneFinder {


    fun findAllNumbersFromGivenNumber(number: String): Array<String>? {
        val result: MutableList<String> =
            ArrayList()
        for (i in 0 until number.length) {
            val c = number[i]
            val charArray = number.toCharArray()
            val chars = findNeighbours(c) ?: return null
            for (ch in chars) {
                charArray[i] = ch
                result.add(String(charArray))
            }
        }
        return result.toTypedArray()
    }

    fun findNeighbours(digit: Char?): List<Char>? {
        val neighbors: MutableList<Char> =
            ArrayList()
        return when (digit) {
            '1' -> {
                neighbors.add('2')
                neighbors.add('4')
                neighbors
            }
            '2' -> {
                neighbors.add('1')
                neighbors.add('3')
                neighbors.add('5')
                neighbors
            }
            '3' -> {
                neighbors.add('2')
                neighbors.add('6')
                neighbors
            }
            '4' -> {
                neighbors.add('1')
                neighbors.add('5')
                neighbors.add('7')
                neighbors
            }
            '5' -> {
                neighbors.add('2')
                neighbors.add('4')
                neighbors.add('6')
                neighbors.add('8')
                neighbors
            }
            '6' -> {
                neighbors.add('3')
                neighbors.add('5')
                neighbors.add('9')
                neighbors
            }
            '7' -> {
                neighbors.add('4')
                neighbors.add('8')
                neighbors
            }
            '8' -> {
                neighbors.add('7')
                neighbors.add('5')
                neighbors.add('9')
                neighbors.add('0')
                neighbors
            }
            '9' -> {
                neighbors.add('6')
                neighbors.add('8')
                neighbors
            }
            '0' -> {
                neighbors.add('8')
                neighbors
            }
            else -> null
        }
    }
}

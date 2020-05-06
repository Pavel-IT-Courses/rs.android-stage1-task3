package subtask4

import java.util.ArrayList

class SquareDecomposer {

    // TODO: Complete the following function
    fun decomposeNumber(number: Int): Array<Int>? {
        for (i in number - 1 downTo 1) {

            val num = (number.toLong() * number - i.toLong() * i)
            val result = decompose(num, i)
            if (result != null) {
                result.add(i)
                return result.toTypedArray()
            }
        }
        return null
    }

    private fun decompose(num: Long, limit: Int): MutableList<Int>? {
        for (i in limit - 1 downTo 1) {
            //println("Inner num = " + num + " i = " + i)
            if(i.toLong() * i > num) continue
            if ((i.toLong() * i) == num) {
                val result: MutableList<Int> = ArrayList()
                result.add(i)
                return result
            }
            val n = num - i * i
            val r = decompose(n, i)
            if (r != null) {
                r.add(i)
                return r
            }
        }
        return null
    }
}

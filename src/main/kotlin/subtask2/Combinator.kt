package subtask2

class Combinator {

    // TODO: Complete the following function
    fun checkChooseFromArray(array: Array<Int>): Int? {
        val n = array[1]
        for (i in 1..n) {
            if (choose(n, i) == array[0]) return i
        }
        return null
    }

    private fun choose(n: Int, m: Int): Int {
        return (fact(n) / fact(m) / fact(n - m)).toInt()
    }

    private fun fact(a: Int): Long {
        var result = 1L
        for (i in 1..a) {
            result *= i.toLong()
        }
        return result
    }
}

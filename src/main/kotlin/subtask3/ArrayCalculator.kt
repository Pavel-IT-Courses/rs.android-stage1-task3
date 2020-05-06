package subtask3

import java.util.ArrayList

class ArrayCalculator {

    // TODO: Complete the following function
    fun maxProductOf(numberOfItems: Int, itemsFromArray: Array<Any>): Int {
        val integers: MutableList<Int> = ArrayList()
        for (o in itemsFromArray) {
            if (o is Int) {
                integers.add(o)
            }
        }
        if(integers.isEmpty()) return 0
        if (numberOfItems >= integers.size) {
            var result = 1
            for (i in integers) {
                result *= i
            }
            return result
        }
        if (numberOfItems == 0) return 0
        val sortList: MutableList<Int> = ArrayList(integers)
        sortList.sortWith(Comparator { o1, o2 -> o1 - o2 })
        val absSortList: MutableList<Int> = ArrayList(integers)
        absSortList.sortWith(Comparator { o1, o2 -> Math.abs(o1!!) - Math.abs(o2!!) })

        var n = numberOfItems
        var product = 1
        var searchLeast = false
        if (n % 2 == 1) {
            val max = sortList[sortList.size - 1]
            if (max == 0) return 0
            if (max < 0) {
                searchLeast = true
            }
            product = max
            sortList.remove(Integer.valueOf(max))
            absSortList.remove(Integer.valueOf(max))
            n--
        }
        while (n > 1) {

            if (searchLeast) {
                val one = getLeastPair(absSortList)[0]
                val two = getLeastPair(absSortList)[1]
                product = product * one!! * two!!
                absSortList.remove(Integer.valueOf(one))
                absSortList.remove(Integer.valueOf(two))
                n = n - 2
            } else {
                val one = getMostPair(absSortList)[0]
                val two = getMostPair(absSortList)[1]
                product = product * one!! * two!!
                absSortList.remove(Integer.valueOf(one))
                println("remove one" + Integer.valueOf(one))
                absSortList.remove(Integer.valueOf(two))
                println("remove two" + Integer.valueOf(two))
                n = n - 2
            }
        }
        return product
    }

    private fun getMostPair(absSortList: List<Int>): Array<Int?> {

        val one1 = absSortList[absSortList.size - 1]
        var one2: Int? = null
        var two1: Int? = null
        var two2: Int? = null
        for (i in 1 until absSortList.size) {
            if (one1 * absSortList[absSortList.size - 1 - i] > 0) {
                one2 = absSortList[absSortList.size - 1 - i]
                break
            }
        }
        var j: Int = 1
        for (i in 1 until absSortList.size) {
            if (one1 * absSortList[absSortList.size - 1 - i] < 0) {
                two1 = absSortList[absSortList.size - 1 - i]
                j = i + 1
                break
            }
        }
        for (i in j until absSortList.size) {
            if (two1!! * absSortList[absSortList.size - 1 - i] > 0) {
                two2 = absSortList[absSortList.size - 1 - i]
                break
            }
        }
        val result: Array<Int?>
        if(one2 == null) return arrayOf(two1, two2)
        if(two1 == null || two2 == null) return arrayOf(one1, one2)
        result = if (one1 * one2!! > two1!! * two2!!) {
            arrayOf(one1, one2)
        } else arrayOf(two1, two2)
        return result
    }

    private fun getLeastPair(absSortList: List<Int>): Array<Int?> {
        val one1 = absSortList[0]
        var one2: Int? = null
        var two1: Int? = null
        var two2: Int? = null
        for (i in 1 until absSortList.size) {
            if (one1 * absSortList[i] > 0) {
                one2 = absSortList[i]
                break
            }
        }
        var j: Int = 1
        for (i in 1 until absSortList.size) {
            if (one1 * absSortList[i] < 0) {
                two1 = absSortList[i]
                break
            }
        }
        for (i in j until absSortList.size) {
            if (two1!! * absSortList[i] > 0) {
                two2 = absSortList[i]
                break
            }
        }
        val result: Array<Int?>
        if(one2 == null) return arrayOf(two1, two2)
        if(two1 == null || two2 == null) return arrayOf(one1, one2)
        result = if (one1 * one2!! > two1!! * two2!!) {
            arrayOf(two1, two2)
        } else arrayOf(one1, one2)
        return result
    }
}

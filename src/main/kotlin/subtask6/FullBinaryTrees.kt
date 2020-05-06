package subtask6

import java.util.*

class FullBinaryTrees {

    // TODO: Complete the following function
    fun stringForNodeCount(count: Int): String {
        if (count <= 0 || count % 2 == 0) return Arrays.toString(arrayOf<Int>())
        if (count == 1) {
            val res = arrayOf(0)
            val collection =
                arrayOf(Arrays.toString(res))
            return Arrays.toString(collection)
        }


        return Arrays.toString(arrayOf<Int>())
    }
}

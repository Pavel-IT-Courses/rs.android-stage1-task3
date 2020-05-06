package subtask1

class PolynomialConverter {

    // TODO: Complete the following function
    fun convertToStringFrom(numbers: Array<Int>): String? {
        if (numbers.isEmpty()) return null
        var result = ""
        val max = numbers.size - 1
        for (i in 0 until max) {
            if (numbers[max - i] == 0) {
                continue
            }
            if (numbers[max - i] == 1) {
                result = " + " + getPower(i) + result
                continue
            }
            if (numbers[max - i] > 1) {
                result = " + " + numbers[max - i] + getPower(i) + result
                continue
            }
            if (numbers[max - i] == -1) {
                result = " - " + getPower(i) + result
                continue
            }
            result = " - " + Math.abs(numbers[max - i]) + getPower(i) + result
        }
        if (numbers[0] == 0) return result.substring(3)
        if (numbers[0] == 1) return getPower(max) + result
        if (numbers[0] > 1) return numbers[0].toString() + getPower(max) + result
        return if (numbers[0] == -1) "-" + getPower(max) + result else "-" + Math.abs(
            numbers[0]
        ) + getPower(max) + result
    }
    private fun getPower(power: Int): String {
        if (power == 0) return ""
        return if (power == 1) "x" else "x^$power"
    }
}

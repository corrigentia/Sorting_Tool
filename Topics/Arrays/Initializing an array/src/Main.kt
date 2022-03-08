private const val HUNDRED = 100
private const val TEN = 10
private const val NINE = 9
private const val NINETY_NINE = 99

fun main() {
    val numbers = IntArray(HUNDRED)
    numbers[0] = 1
    numbers[NINE] = TEN
    numbers[NINETY_NINE] = HUNDRED

    // do not touch the lines below
    println(numbers.joinToString())
}

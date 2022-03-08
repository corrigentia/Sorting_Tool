import java.util.*

fun main() {
    val studentsMarks = mutableMapOf<String, Int>()

    var odd = true
    var name: String = ""

    val scanner = Scanner(System.`in`)
    var input = scanner.nextLine()

    while (input != "stop" && scanner.hasNextLine()) {
        if (odd) {
            name = input
        } else {
            if (!studentsMarks.containsKey(name)) {
                studentsMarks[name] = input.toInt()
            }
        }
        odd = !odd
        input = scanner.nextLine()
    }
    println(studentsMarks)
}

    private const val THREE = 3

    fun main(args: Array<String>) {
        if (args.size == THREE) {
            for (index in args.indices) {
                println("Argument ${index + 1}: ${args[index]}. It has ${args[index].length} characters")
            }
        } else println("Invalid number of program arguments")
    }

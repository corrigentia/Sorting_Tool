package sorting

import java.io.File
import java.util.*
import kotlin.reflect.KFunction0

private const val REGEX_STRING = "\\s+"
private const val FILE_REGEX_STRING = """\s+.\s+"""
private const val INPUT_FILE_STR = "-inputFile"
private const val OUTPUT_FILE_STR = "-outputFile"
private const val SORT_INTEGERS_STR = "-sortIntegers"
private const val SORTING_TYPE_STR = "-sortingType"
private const val DATA_TYPE_STR = "-dataType"
private const val WORD = "word"
private const val LINE = "line"
private const val LONG = "long"
private const val NUMBER = "number"
private const val HUNDRED = 100


fun writeToFile(filePath: String, message: String = "") {
    val outputFileReference = File(filePath)
    if (outputFileReference.exists()) {
        outputFileReference.appendText(message)
    } else outputFileReference.writeText(message)
}


fun option(switch: String, args: Array<String>): Boolean {
    /*
    for (argument in args) if (argument == switch) return true
    return false
    */
    return switch in args
}

fun main(args: Array<String>) {
    // write your code here
    var numbers = mutableListOf<Int>()
    var strings = mutableListOf<String>()

    var intMap = mutableMapOf<Int, Int>()
    var strMap = mutableMapOf<String, Int>()

    val sortingTypeProvided: Boolean = option(SORTING_TYPE_STR, args)

    val indexOfSortingTypeInArgs: Int = args.indexOf(SORTING_TYPE_STR)
    val indexAfterSortingType: Int = indexOfSortingTypeInArgs + 1


    val sortingType = try {
        if (sortingTypeProvided) args[indexAfterSortingType] else "natural" // "byCount"
    } catch (e: ArrayIndexOutOfBoundsException) {
        println("No sorting type defined!")
    }


    fun mergeTwoSortedArrays(arrayA: Array<Int>, arrayB: Array<Int>): Array<Int> {
        val result = Array(arrayA.size + arrayB.size) { 0 }
        var i = 0
        var j = 0
        var k = 0
        while (k <= result.lastIndex) {
            when {
                i > arrayA.lastIndex -> result[k++] = arrayB[j++]
                j > arrayB.lastIndex -> result[k++] = arrayA[i++]
                arrayA[i] < arrayB[j] -> result[k++] = arrayA[i++]
                else -> result[k++] = arrayB[j++]
            }
        }
        return result
    }

    fun mergeByCount(leftHalf: Array<Int>, rightHalf: Array<Int>): Array<Int> {
        val result = Array<Int>(leftHalf.size + rightHalf.size) { 0 }

        var idxLeft = 0
        var idxRight = 0
        var idxResult = 0

        while (idxResult <= result.lastIndex) {
            when {
                idxLeft > leftHalf.lastIndex -> result[idxResult++] = rightHalf[idxRight++]
                idxRight > rightHalf.lastIndex -> result[idxResult++] = leftHalf[idxLeft++]
                intMap[rightHalf[idxRight]]!! < intMap[leftHalf[idxLeft]]!! -> result[idxResult++] =
                    rightHalf[idxRight++]
                rightHalf[idxRight] < leftHalf[idxLeft] -> result[idxResult++] = rightHalf[idxRight++]
                else -> result[idxResult++] = leftHalf[idxLeft++]
            }
        }

        return result

/*
    if (leftHalf.size == 1 && rightHalf.size == 1) {
        if (rightHalf.first() < leftHalf.first()) {
            return rightHalf.also { it.addAll(leftHalf) }
        } else return leftHalf.also { it.addAll(rightHalf) }
    } else {
        return merge(mergeSort(leftHalf), mergeSort(rightHalf))
    }
*/
    }

    fun merge(leftHalf: Array<Int>, rightHalf: Array<Int>): Array<Int> {
        val result = Array<Int>(leftHalf.size + rightHalf.size) { 0 }

        var idxLeft = 0
        var idxRight = 0
        var idxResult = 0

        while (idxResult <= result.lastIndex) {
            println("rightHalf[idxRight]: ${rightHalf[idxRight]}")
            when {
                idxLeft > leftHalf.lastIndex -> result[idxResult++] = rightHalf[idxRight++]
                idxRight > rightHalf.lastIndex -> result[idxResult++] = leftHalf[idxLeft++]
                rightHalf[idxRight] < leftHalf[idxLeft] -> result[idxResult++] = rightHalf[idxRight++]
                else -> result[idxResult++] = leftHalf[idxLeft++]
            }
        }

        return result

/*
    if (leftHalf.size == 1 && rightHalf.size == 1) {
        if (rightHalf.first() < leftHalf.first()) {
            return rightHalf.also { it.addAll(leftHalf) }
        } else return leftHalf.also { it.addAll(rightHalf) }
    } else {
        return merge(mergeSort(leftHalf), mergeSort(rightHalf))
    }
*/
    }


    fun merge(leftHalf: Array<String>, rightHalf: Array<String>): Array<String> {
        val result = Array<String>(leftHalf.size + rightHalf.size) { "" }

        var idxLeft = 0
        var idxRight = 0
        var idxResult = 0

        while (idxResult <= result.lastIndex) {
            when {
                idxLeft > leftHalf.lastIndex -> result[idxResult++] = rightHalf[idxRight++]
                idxRight > rightHalf.lastIndex -> result[idxResult++] = leftHalf[idxLeft++]
                rightHalf[idxRight] < leftHalf[idxLeft] -> result[idxResult++] = rightHalf[idxRight++]
                else -> result[idxResult++] = leftHalf[idxLeft++]
            }
        }

        return result
    }

    fun mergeByCount(leftHalf: Array<String>, rightHalf: Array<String>): Array<String> {
        val result = Array<String>(leftHalf.size + rightHalf.size) { "" }

        var idxLeft = 0
        var idxRight = 0
        var idxResult = 0

        while (idxResult <= result.lastIndex) {
            when {
                idxLeft > leftHalf.lastIndex -> result[idxResult++] = rightHalf[idxRight++]
                idxRight > rightHalf.lastIndex -> result[idxResult++] = leftHalf[idxLeft++]
                strMap[rightHalf[idxRight]]!! < strMap[leftHalf[idxLeft]]!! -> result[idxResult++] =
                    rightHalf[idxRight++]
                rightHalf[idxRight] < leftHalf[idxLeft] -> result[idxResult++] = rightHalf[idxRight++]
                else -> result[idxResult++] = leftHalf[idxLeft++]
            }
        }

        return result
    }


    fun mergeSort(collection: Array<String>, start: Int = 0, end: Int = collection.lastIndex): Array<String> {
        // return if (collection.size == 1) {
        numbers
        strings
        intMap
        strMap
//        mapCollection
        return if (start == end) {
            collection.sliceArray(start..end)
        } else {
            val middle = (start + end) / 2
            val leftHalf = mergeSort(collection, start, middle) // collection.subList(start, middle)
            val rightHalf = mergeSort(collection, middle + 1, end) // collection.subList(middle, end)
            if (sortingType == "byCount") {
                mergeByCount(leftHalf, rightHalf)
            } else {
                merge(leftHalf, rightHalf)
            }
        }
    }


    fun mergeSort(collection: Array<Int>, start: Int = 0, end: Int = collection.lastIndex): Array<Int> {
        // return if (collection.size == 1) {
//    numbers
//    strings
//    intMap
//    strMap
//    mapCollection
        return if (start == end) {
            collection.sliceArray(start..end)
        } else {
            val middle = (start + end) / 2
            val leftHalf = mergeSort(collection, start, middle) // collection.subList(start, middle)
            val rightHalf = mergeSort(collection, middle + 1, end) // collection.subList(middle, end)
            if (sortingType == "byCount") {
                mergeByCount(leftHalf, rightHalf)
            } else {
                merge(leftHalf, rightHalf)
            }
        }
    }

/*
fun mergeSort(arr: Array<Int>, start: Int = 0, end: Int = arr.lastIndex): Array<Int> {
    if (start == end) return arr.sliceArray(start..end)
    val sliceAt = (start + end) / 2
    val arrayA = mergeSort(arr, start, sliceAt)
    val arrayB = mergeSort(arr, sliceAt + 1, end)
    return mergeTwoSortedArrays(arrayA, arrayB)
}
*/

//    var emptyArray = emptyArray<String>()
//    val stringArray = arrayOf<String>()
    val regex = FILE_REGEX_STRING.toRegex()
    val regexConstructor = Regex(FILE_REGEX_STRING)
//    val str = ""
    // val numbers = str.split(regex).map { it.toInt() }.toTypedArray()
    // println(numbers.joinToString())


    val sortIntegers: Boolean = option(SORT_INTEGERS_STR, args)

    val dataTypeProvided: Boolean = option(DATA_TYPE_STR, args)
    val indexOfDataTypeInArgs: Int = args.indexOf(DATA_TYPE_STR)
    val indexAfterDataType: Int = indexOfDataTypeInArgs + 1

    val dataType = if (sortIntegers) LONG else {
//        if (args.isEmpty()) "word" else dataTypePassed
        try {
            if (dataTypeProvided) args[indexAfterDataType] else WORD
        } catch (e: ArrayIndexOutOfBoundsException) {
            println("No data type defined!")
        }
    }

    val inputType = when (dataType) {
        LONG -> NUMBER
        else -> dataType
    }

    val validParameters =
        arrayOf<String>(DATA_TYPE_STR, SORTING_TYPE_STR, SORT_INTEGERS_STR, INPUT_FILE_STR, OUTPUT_FILE_STR)

    for (arg in args) {
        if (arg.first() == '-' && arg !in validParameters) {
            println("\"${arg}\" is not a valid parameter. It will be skipped.")
        }
    }


    var intCollection = mutableListOf<Int>()
    var strCollection = mutableListOf<String>()

    val lineInput: Boolean = inputType == LINE
    val numberInput: Boolean = inputType == NUMBER

    val outputFileProvided: Boolean = option(OUTPUT_FILE_STR, args)
    val indexOfOutputFileInArgs: Int = args.indexOf(OUTPUT_FILE_STR)
    val indexAfterOutputFile: Int = indexOfOutputFileInArgs + 1


    val outputFilePassed =
        if (outputFileProvided && args.size > indexAfterOutputFile && args[indexAfterOutputFile].first() != '-') {
            args[indexAfterOutputFile]
        } else ""


    val inputFileProvided: Boolean = option(INPUT_FILE_STR, args)
    val indexOfInputFileInArgs: Int = args.indexOf(INPUT_FILE_STR)
    val indexAfterInputFile: Int = indexOfInputFileInArgs + 1

    val inputFilePassed =
        if (inputFileProvided && args.size > indexAfterInputFile && args[indexAfterInputFile].first() != '-') {
            args[indexAfterInputFile]
        } else ""

    if (inputFilePassed.isNotEmpty()) {
        val inputFileReference = File(inputFilePassed)
        if (inputFileReference.exists()) {
            if (lineInput) {
                strCollection = inputFileReference.readLines().toMutableList() // as MutableList<String>
            } else {
                inputFileReference.forEachLine { strCollection.addAll(it.split(" ")) }
                if (numberInput) {
                    intCollection = strCollection.map { it.toInt() }.toMutableList() // as MutableList<Int>
                }
            }
        }
    } else {
        val scanner = Scanner(System.`in`)


        val hasNext: KFunction0<Boolean> = scanner::hasNext
        val hasNextInt: KFunction0<Boolean> = scanner::hasNextInt

        val nextElementPresent = if (sortIntegers) hasNextInt else when (inputType) {
            NUMBER -> hasNextInt
            LINE -> scanner::hasNextLine
            else -> {
                hasNext
            }
        }

        val nextInt: KFunction0<Int> = scanner::nextInt
        val next: KFunction0<String> = scanner::next

        val getNextElement = if (sortIntegers) nextInt else when (inputType) {
            NUMBER -> nextInt
            LINE -> scanner::nextLine
            else -> {
                next
            }
        }

        if (numberInput) {
            while (hasNext()) {
                val nextElement = next()
                val element = try {
                    nextElement.toInt()
                } catch (e: NumberFormatException) {
                    println("\"${readLine()!!}\" is not a long. It will be skipped.")
                }
                if (element is Int) {
                    intCollection.add(element as Int)
                }
            }
        } else {
            while (nextElementPresent()) {
                val element = try {
                    getNextElement()
                } catch (e: NumberFormatException) {
                    println("\"${readLine()!!}\" is not a long. It will be skipped.")
                }
                /*
                if (numberInput) {
                    intCollection.add(element as Int)
                } else {
                */
                strCollection.add(element as String)
//            }
            }
        }
    }


/*
    val testing = mutableListOf(1, -2, 333, 33, 4, 42).map { it.toString() }
    val sortedTest = mergeSort(testing.toTypedArray())
    println("sortedTest: ${sortedTest.joinToString()}")
*/


//    val collection = if (inputType == NUMBER) mutableListOf<Int>() else mutableListOf<String>()
    val collection = if (numberInput) intCollection else strCollection


    val elementsTotalMessage: String = "Total ${inputType}s: ${collection.size}"

    if (outputFilePassed.isNotEmpty()) {
        writeToFile(outputFilePassed, elementsTotalMessage)
    } else println(elementsTotalMessage)

/*
    println(
        """
sortIntegers: $sortIntegers, 
indexOfDataTypeInArgs: $indexOfDataTypeInArgs,
indexAfterDataType: $indexAfterDataType,
dataTypePassed: $dataTypePassed, 
intCollection: ${intCollection.joinToString()}, 
intCollection.toSortedSet(): ${intCollection.sorted().joinToString()}
        """.trimIndent()
    )
*/

    if (sortIntegers) {
        val sortedData = mergeSort(intCollection.toTypedArray())
//        val sortedData = intCollection.sorted()
//        println("Sorted data: ${intCollection.sorted().joinToString(" ")}")
        val sortedDataMessage: String = "Sorted data: ${sortedData.joinToString(" ")}"

        if (outputFilePassed.isNotEmpty()) {
            writeToFile(outputFilePassed, sortedDataMessage)
        } else println(sortedDataMessage)
    } else if (sortingType == "byCount") {

//        for (element in intCollection.toSet()) {
        for (element in collection/*.toSet()*/) {
            if (numberInput) {
                intMap[element as Int] = 0
            } else strMap[element as String] = 0
        }

//            for (element in intCollection) {
        for (element in collection) {
            if (numberInput) {
                intMap[element as Int] = intMap[element]!! + 1
            } else strMap[element as String] = strMap[element]!! + 1
        }

        intMap = intMap.toList().sortedBy { (_, value) -> value }.toMap().toMutableMap()
        strMap = strMap.toList().sortedBy { (_, value) -> value }.toMap().toMutableMap()
//        println("intMap: $intMap")
//        println("strMap: $strMap")

        var mapCollection = if (numberInput) intMap else strMap

//        var numbers = mutableListOf<Int>()
//        var strings = mutableListOf<String>()

        for ((number, count) in intMap) numbers += number
        for ((text, count) in strMap) strings += text

//        println("inputType == NUMBER: ${inputType == NUMBER}")

//        if (inputType == NUMBER) {
        if (numberInput) {
//            println("sortingType: $sortingType")
/*
            for (left in 0 until numbers.lastIndex) {
//            for (right in 1..numbers.lastIndex) {
                val right = left + 1
                println("numbers[left]: ${numbers[left]}, numbers[right]: ${numbers[right]}")
                if (intMap[numbers[right]]!! < intMap[numbers[left]]!!) {
                    val temp = numbers[left]
                    numbers[left] = numbers[right]
                    numbers[right] = temp
                } else if (numbers[right]!! < numbers[left]!!) {
                    val temp = numbers[left]!!
                    numbers[left] = numbers[right]!!
                    numbers[right] = temp
                }
                println("numbers: $numbers")
            }
*/




            numbers = mergeSort(numbers.sorted().toTypedArray()).toMutableList()
//            println("numbers: $numbers")


        } else {
/*
            for (left in 0 until strings.lastIndex) {
                for (right in 1..strings.lastIndex) {
                    if (strMap[strings[right]]!! < strMap[strings[left]]!!) {
                        val temp = strings[left]
                        strings[left] = strings[right]
                        strings[right] = temp
                    } else if (strings[right] < strings[left]) {
                        val temp = strings[left]
                        strings[left] = strings[right]
                        strings[right] = temp
                    }
                }
            }
*/

            strings = mergeSort(strings.sorted().toTypedArray()).toMutableList()
//            println("strings: $strings")


        }


//        println(mergeSort(numbers.toTypedArray()).joinToString())
//        val elements = if (inputType == NUMBER) numbers else strings
        val elements = if (numberInput) numbers else strings

//        println("elements: $elements")


        for (element in elements) {
            val count = mapCollection[element]!!
            val elementCountPercentageMessage: String =
                "$element: $count time(s), ${count!! * HUNDRED / collection.size}%"


            if (outputFilePassed.isNotEmpty()) {
                writeToFile(outputFilePassed, elementCountPercentageMessage)
            } else println(elementCountPercentageMessage)

        }
    } else {
        var greatestNumber = 0
        var longestString = ""

        if (numberInput) {
            for (number in intCollection) if (number > greatestNumber) greatestNumber = number
        } else for (element in strCollection) if (element.length > longestString.length) longestString = element

        val dominantElement = if (numberInput) greatestNumber else longestString
        var dominantOccurrences = 0

        for (element in collection) if (element == dominantElement) ++dominantOccurrences

        val sortedData = if (numberInput) intCollection.sorted() else strCollection.sorted()
        val sortedDataMessage: String = "Sorted data: ${sortedData.joinToString(" ")}"

        if (outputFilePassed.isNotEmpty()) {
            writeToFile(outputFilePassed, sortedDataMessage)
        } else println(sortedDataMessage)

        val dominantPercentage = dominantOccurrences * HUNDRED / collection.size
//        val dominant = if (inputType == NUMBER) "greatest" else "longest"
        val newLineOrSpace = if (lineInput) "\n" else " "

//        print("The $dominant $inputType:$newLineOrSpace")
//        print("$dominantElement$newLineOrSpace")
//        println("($dominantOccurrences time(s), $dominantPercentage%).")
    }
}

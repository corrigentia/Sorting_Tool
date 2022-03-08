fun helpingTheRobot(purchases: Map<String, Int>, addition: Map<String, Int>): MutableMap<String, Int> {
    // write your code here
    val result = purchases.toMutableMap()

    for ((addedKey, addedValue) in addition) {
        if (result.containsKey(addedKey)) {
            result[addedKey] = result[addedKey]!! + addition[addedKey]!!
        } else result[addedKey] = addedValue
    }

    return result
}

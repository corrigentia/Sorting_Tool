fun removing(currentMap: MutableMap<Int, String>, value: String): MutableMap<Int, String> {
    // write your code here
    val result = currentMap.toMutableMap()

    for ((key, ignoredValue) in currentMap) {
        if (result[key] == value) result.remove(key)
    }

    return result
}

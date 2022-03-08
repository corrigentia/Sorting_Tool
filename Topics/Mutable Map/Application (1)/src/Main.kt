fun addUser(userMap: Map<String, String>, login: String, password: String): MutableMap<String, String> {
    // write your code here
    val updatedMap = userMap.toMutableMap()

    if (userMap.containsKey(login)) {
        println("User with this login is already registered!")
    } else updatedMap[login] = password

    return updatedMap
}

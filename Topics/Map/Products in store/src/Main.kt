fun bill(priceList: Map<String, Int>, shoppingList: MutableList<String>): Int {
    // put your code here
    var totalPrice = 0

    for (wanted in shoppingList) {
        totalPrice += if (priceList.containsKey(wanted)) priceList[wanted]!! else 0
    }

    return totalPrice
}

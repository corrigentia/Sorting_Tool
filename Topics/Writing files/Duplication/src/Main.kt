// Write your code here. Do not import any libraries
val text = readLine()!!
val pathName = "MyFile.txt"
val myFile = File(pathName)

myFile.writeText(text.repeat(2))

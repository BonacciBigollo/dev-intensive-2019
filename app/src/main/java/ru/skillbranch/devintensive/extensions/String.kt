package ru.skillbranch.devintensive.extensions

import androidx.core.text.htmlEncode
import androidx.core.text.parseAsHtml
import kotlin.reflect.typeOf

fun String.truncate(cutValue: Int = 16):String?{
    var str = this
    if(cutValue > 0) {
        str = str.substring(range = 0..lastIndex-cutValue)
        val lastChar = str[str.lastIndex]
        if(lastChar.compareTo(' ')==0) {
            str = str.substring(range = 0 until str.lastIndex) + "..."
            return str
        }else{
            return "$str..."
        }
    } else {
        return str
    }
}
fun String.stripHtml(): String? {
    val parts = this
    var string = ""
    //string += parts.replace(Regex("""[&<>"'/@]"""),"")
    val lastIndex = parts.indexOf(">", 0)
    val firstIndex = parts.indexOf("<",1)
    val subStr = parts.substring(lastIndex+1,firstIndex-1)
    string += subStr
    string = string.replace("  ", " ").trim()
    string = string.replace(Regex("""[&<>"'/@]"""),"")
    return string
}
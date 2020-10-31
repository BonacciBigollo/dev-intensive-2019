package ru.skillbranch.devintensive.utils

import ru.skillbranch.devintensive.extensions.TimeUnits

object Utils {
    private var lastId: Int = -1
    fun parseFullName(fullName: String?): Pair<String?, String?> {
        lastId++
        val parts: List<String>? = fullName?.split(" ")
        return if (!parts.isNullOrEmpty() && parts.count() == 2 && !parts.contains("")) {
            val firstName = parts.getOrNull(0)
            val lastName = parts.getOrNull(1)
            Pair(firstName, lastName)
        } else {
            Pair(null, null)
        }
    }

    fun toInitials(fullName: String?): String? {
        val firstLetter: Char?
        val secondLetter: Char?
        val parts: List<String>? = fullName?.split(" ")

        val firstName = parts?.getOrNull(0)?.trim()
        val lastName = parts?.getOrNull(1)?.trim()

        firstLetter = firstName?.getOrNull(0)?.toUpperCase()
        secondLetter = lastName?.getOrNull(0)?.toUpperCase()

        return if(firstLetter != null && secondLetter != null) {
            ("$firstLetter$secondLetter")
        } else if (firstLetter != null && secondLetter == null){
            ("$firstLetter")
        } else if (firstLetter == null && secondLetter != null) {
            ("$secondLetter")
        } else {
            null
        }

    }
    fun transliteration(payload: String, divider: String = " "): String? {
        val divide = payload.split(" ")
        val formatString = "${divide.getOrNull(0)}"+ divider +"${divide.getOrNull(1)}"
        var latin = formatString.replace("а", "a", true)
        latin = latin.replace("б", "b", true)
        latin = latin.replace("в", "v", true)
        latin = latin.replace("г", "g", true)
        latin = latin.replace("д", "d", true)
        latin = latin.replace("е", "e", true)
        latin = latin.replace("ё", "e", true)
        latin = latin.replace("ж", "zh", true)
        latin = latin.replace("з", "z", true)
        latin = latin.replace("и", "i", true)
        latin = latin.replace("й", "i", true)
        latin = latin.replace("к", "k", true)
        latin = latin.replace("л", "l", true)
        latin = latin.replace("м", "m", true)
        latin = latin.replace("н", "n", true)
        latin = latin.replace("о", "o", true)
        latin = latin.replace("п", "p", true)
        latin = latin.replace("р", "r", true)
        latin = latin.replace("с", "s", true )
        latin = latin.replace("т", "t", true)
        latin = latin.replace("у", "u", true)
        latin = latin.replace("ф", "f", true)
        latin = latin.replace("х", "h", true)
        latin = latin.replace("ц", "c", true)
        latin = latin.replace("ч", "ch", true)
        latin = latin.replace("ш", "sh", true)
        latin = latin.replace("щ", "sh'", true)
        latin = latin.replace("ъ", "", true)
        latin = latin.replace("ы", "i", true)
        latin = latin.replace("ь", "", true)
        latin = latin.replace("э", "e", true)
        latin = latin.replace("ю", "yu", true)
        latin = latin.replace("я", "ya", true)

        val split = latin.split(divider)
        val firstLetter = split.getOrNull(0)?.get(0)?.toUpperCase()
        val lastLetter = split.getOrNull(1)?.get(0)?.toUpperCase()
        val oldFirstLetter = split.getOrNull(0)?.get(0)
        val oldLastLetter = split.getOrNull(1)?.get(0)
        val replaceName = split.getOrNull(0)?.replaceFirst("$oldFirstLetter","$firstLetter")
        val replaceLast = split.getOrNull(1)?.replaceFirst("$oldLastLetter","$lastLetter")
        latin = "$replaceName"+ divider +"$replaceLast"
        return latin
    }
}

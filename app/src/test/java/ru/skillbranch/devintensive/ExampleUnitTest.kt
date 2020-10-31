package ru.skillbranch.devintensive

import org.junit.Test

import org.junit.Assert.*
import ru.skillbranch.devintensive.extensions.*
import ru.skillbranch.devintensive.models.User
import java.util.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }
    @Test
    fun test_instance(){
        val user = User("1", "John", "Travolta")
    }
    @Test
    fun test_factory(){
        val user = User.makeUser("John Wick")
    }
    @Test
    fun test_plural(){
        val day = TimeUnits.DAYS.plural(-1)
        val hour = TimeUnits.HOURS.plural(4)
        val minute = TimeUnits.MINUTES.plural(-10)
        val second = TimeUnits.SECONDS.plural(1)
        println("Was: $day, $hour, $minute, $second ago")
    }
    @Test
    fun test_string_truncate(){
        val name = "Strew Barrow was a great man from North of America"
        val string = name.truncate(7)
        println(string)
    }
    @Test
    fun test_string_stripHtml(){
        val str = "<p class='  title'> Hello@  &World  </p>"

        println(str.stripHtml())

    }
}
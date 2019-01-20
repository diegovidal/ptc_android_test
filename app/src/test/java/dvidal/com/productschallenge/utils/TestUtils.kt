package dvidal.com.productschallenge.utils

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.lang.reflect.Type

/**
 * @author diegovidal on 30/04/2018.
 */

object TestUtils {

    private val TEST_MOSHI = initializeMoshi()

    fun <T> loadJson(path: String, type: Type): T? {
        try {
            val json = getFileString(path)

            @Suppress("UNCHECKED_CAST")
            return TEST_MOSHI.adapter<Any>(type).fromJson(json) as T?
        } catch (e: IOException) {
            throw IllegalArgumentException("Could not deserialize: $path into type: $type")
        }

    }

    fun <T> loadJson(path: String, clazz: Class<T>): T? {
        try {
            val json = getFileString(path)

            return TEST_MOSHI.adapter(clazz).fromJson(json)
        } catch (e: IOException) {
            throw IllegalArgumentException("Could not deserialize: $path into class: $clazz")
        }

    }

    private fun getFileString(path: String): String {
        try {
            val reader = BufferedReader(InputStreamReader(
                    javaClass.classLoader.getResourceAsStream(path)))
            return reader.buffered().use(BufferedReader::readText)
        } catch (e: IOException) {
            throw IllegalArgumentException("Could not read from resource at: $path")
        }

    }

    private fun initializeMoshi(): Moshi {

        val builder = Moshi.Builder()
        builder.add(KotlinJsonAdapterFactory())
        return builder.build()
    }
}

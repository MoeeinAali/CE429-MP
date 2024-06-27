package com.moeein.calculatordb

import android.content.Context
import java.io.BufferedReader
import java.io.FileOutputStream
import java.io.InputStreamReader
import java.lang.Exception

object FileUtils {
    fun writeToFile(fileName: String, data: String, context: Context) {
        try {
            val fileOutputStream: FileOutputStream =
                context.openFileOutput(fileName, Context.MODE_PRIVATE)
            fileOutputStream.write(data.toByteArray())
            fileOutputStream.close()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun readFromFile(fileName: String, context: Context): String? {
        return try {
            val fileInputStream = context.openFileInput(fileName)
            val inputStreamReader = InputStreamReader(fileInputStream)
            val bufferedReader = BufferedReader(inputStreamReader)
            val stringBuilder = StringBuilder()

            var line: String?
            while (bufferedReader.readLine().also { line = it } != null) {
                stringBuilder.append(line).append("\n")
            }

            bufferedReader.close()
            stringBuilder.toString()
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

}
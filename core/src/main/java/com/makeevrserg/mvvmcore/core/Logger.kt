package com.makeevrserg.mvvmcore.core

import android.os.Environment
import android.util.Log
import java.io.BufferedWriter
import java.io.File
import java.io.FileWriter
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale
// TODO
object Logger {

    var MAIN_PATH: String? = null

    var TAG = MAIN_PATH

    private val PATH: String
        get() = Environment.getExternalStorageDirectory().absolutePath + "/$MAIN_PATH/"

    init {
        Log.w(TAG, "Log Folder: $PATH")
    }

    fun log(tag: String, message: String) {
        val s = TAG + "_" + tag
        Log.d(s, message)
        logInFile(Log.DEBUG, "$TAG", message)
    }

    fun warn(tag: String, msg: String) {
        Log.w(TAG + "_" + tag, msg)
        logInFile(Log.WARN, TAG + "_" + tag, msg)
    }

    fun exn(tag: String, e: Throwable) {
        e.printStackTrace()
        Log.w(TAG + "_" + tag, e)
        logInFile(Log.ERROR, tag, e.toString())
    }

    private fun logInFile(priority: Int, tag: String, msg: String): Int {
        var result = 0
        val path = File(PATH)
        if (!path.exists()) path.mkdirs()
        val dateLog = SimpleDateFormat("dd.MM.yy", Locale.getDefault())
        val file = File(PATH + dateLog.format(Date()) + ".rw.txt")

        kotlin.runCatching {
            BufferedWriter(FileWriter(file, true)).use { bw ->
                if (!path.exists()) path.mkdirs()
                val timeLog =
                    SimpleDateFormat("dd.MM.yy HH:mm:ss", Locale.getDefault()).format(Date())
                bw.append(priority.toString()).append("\t").append(timeLog).append(" [")
                    .append(tag).append("]\t").append(msg).append("\n")
                result = 1
                bw.flush()
            }
        }

        return result
    }

}
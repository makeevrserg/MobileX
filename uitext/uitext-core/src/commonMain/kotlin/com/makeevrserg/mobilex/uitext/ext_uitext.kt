package com.makeevrserg.mobilex.uitext

fun UiText.withArgs(line: String, vararg args: Pair<String, String>): String {
    var line = line
    args.forEach {
        line = line.replace(it.first, it.second)
    }
    return line
}

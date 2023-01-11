package com.makeevrserg.mobilex.ktx_core.action.components

expect sealed interface UiText

/**
 * Если у текста есть аргументы вроде %name% - в [args] можно передать например %name% to user.name
 */
fun UiText.withArgs(line: String, vararg args: Pair<String, String>): String {
    var line = line
    args.forEach {
        line = line.replace(it.first, it.second)
    }
    return line
}

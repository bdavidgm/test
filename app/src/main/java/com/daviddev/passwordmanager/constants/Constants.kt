package com.daviddev.passwordmanager.constants

class Constants {
    companion object {
        const val TYPE_TEXT_FIELD = "TEXT"
        const val TYPE_PARAGRAPH_TEXT = "PARAGRAPH"
        const val TYPE_DATE_PICKER = "DATE"
        const val TYPE_TIME_PICKER = "TIME"
        const val TYPE_SWITCH   = "SWITCH"
        const val TYPE_PASSWORD   = "PASSWORD"
        const val TYPE_NUMBER   = "NUMBER"
        const val TYPE_URL   = "URL"
        const val TYPE_CHECKBOX   = "CHECKBOX"
    }
}

enum class DataType(val type:String ){
    TEXT(Constants.TYPE_TEXT_FIELD),
    PARAGRAPH(Constants.TYPE_PARAGRAPH_TEXT),
    DATE (Constants.TYPE_DATE_PICKER),
    TIME ( Constants.TYPE_TIME_PICKER),
    SWITCH(Constants.TYPE_SWITCH),
    PASSWORD(Constants.TYPE_PASSWORD),
    NUMBER(Constants.TYPE_NUMBER),
    URL(Constants.TYPE_URL)
}
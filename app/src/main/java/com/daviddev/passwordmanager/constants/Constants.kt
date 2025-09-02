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
        const val TYPE_UNDEFINED   = "UNDEFINED"
        const val KEY_ACCOUNT_NAME = "Nombre de cuenta"
        const val STATUS_TEMPLATE = "Template"
        const val STATUS_ACCOUNT = "Account"
        const val STATUS_DELETED = "Deleted"
        const val STATUS_REPLACED = "Replaced"
        const val ROUTE_ADD_ACCOUNT = "AddDataView"
        const val ROUTE_SELECT_TEMPLATE = "SelectTemplate"
        const val ROUTE_EDIT_ACCOUNT = "editAccount"
        const val ROUTE_EDIT_TEMPLATE = "editTemplate"
        const val ROUTE_SHOW_ACCOUNTS = "showAccountsView"
        const val ROUTE_VIEW_TEMPLATE = "viewTemplate"
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
    URL(Constants.TYPE_URL),
    UNDEFINED(Constants.TYPE_UNDEFINED),
    CHECKBOX(Constants.TYPE_CHECKBOX);
    companion object {
        /**
         * Crea una instancia de DataType a partir de un valor de cadena.
         *
         * @param typeString La cadena que representa el tipo de dato.
         * @return La instancia de DataType correspondiente, o DataType.UNDEFINED si no se encuentra ninguna coincidencia.
         */
        fun fromString(typeString: String): DataType {
            // values() devuelve un array con todas las constantes del enum
            return values().find { it.type.equals(typeString, ignoreCase = true) } ?: UNDEFINED
        }
    }
}

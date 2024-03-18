package com.training.base.data.objects

class CommonEntity() {
    private var icon: Int = 0
    private var title: String? = null
    private var descript: String? = null
    private var typeLayout: Int = 0
    private var function: Any?=null

    fun getFunction(): Any? {
        return function
    }

    fun setFunction(function: Any): CommonEntity {
        this.function = function
        return this
    }
    fun getTypeLayout(): Int {
        return typeLayout
    }

    fun setTypeLayout(typeLayout: Int): CommonEntity {
        this.typeLayout = typeLayout
        return this
    }


    fun getTitle(): String? {
        return title
    }

    fun setTitle(title: String?): CommonEntity {
        this.title = title
        return this
    }

    fun getIcon(): Int {
        return icon
    }

    fun setIcon(icon: Int): CommonEntity {
        this.icon = icon
        return this
    }

    fun getDescript(): String? {
        return descript
    }

    fun setDescript(descript: String?): CommonEntity {
        this.descript = descript
        return this
    }

}
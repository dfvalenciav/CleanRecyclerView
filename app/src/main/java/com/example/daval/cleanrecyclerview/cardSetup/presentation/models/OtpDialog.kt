package com.example.daval.cleanrecyclerview.cardSetup.presentation.models

class OtpDialog(
    val title: String?,
    val message: String?,
    val editText: String?,
    val btnConfirm: String?,
    val btnCancel: String?
) {

    private constructor(builder: Builder) : this(
        builder.title,
        builder.message,
        builder.editText,
        builder.btnConfirm,
        builder.btnCancel
    )

    class Builder {
        var title: String? = null
            private set

        var message: String? = null
            private set

        var editText: String? = null
            private set

        var btnConfirm: String? = null
            private set

        var btnCancel: String? = null
            private set

        fun title(title: String) = apply { this.title = title }
        fun message(message: String) = apply { this.message = message }
        fun editText(editText: String) = apply { this.editText = editText }
        fun btnConfirm(btnConfirm: String) = apply { this.btnConfirm = btnConfirm }
        fun btnCancel(btnCancel: String)= apply { this.btnCancel = btnCancel }
        fun build() = OtpDialog(this)
    }
}
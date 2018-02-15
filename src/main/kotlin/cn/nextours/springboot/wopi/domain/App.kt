package cn.nextours.springboot.wopi.domain

import java.util.*

abstract class App(protected val editable: Boolean = false) {

    abstract fun resolveURL(owaUrl: String?, checkFileInfoUrl: String?, accessToken: String?): String

    override fun toString(): String {
        return "${this.javaClass.name}[editable=$editable]"
    }

    class Word(editable: Boolean) : App(editable) {
        override fun resolveURL(owaUrl: String?, checkFileInfoUrl: String?, accessToken: String?): String {
            return if (editable) {
                "$owaUrl/we/wordeditorframe.aspx?WOPISrc=$checkFileInfoUrl&access_token=$accessToken"
            } else {
                "$owaUrl/wv/wordviewerframe.aspx?WOPISrc=$checkFileInfoUrl&access_token=$accessToken"
            }
        }
    }

    class Excel(editable: Boolean) : App(editable) {
        override fun resolveURL(owaUrl: String?, checkFileInfoUrl: String?, accessToken: String?): String {
            val url = "$owaUrl/x/_layouts/xlviewerinternal.aspx?WOPISrc=$checkFileInfoUrl&access_token=$accessToken"
            return if (editable) {
                url.plus("&edit=1")
            } else {
                url
            }
        }
    }

    class PowerPoint(editable: Boolean) : App(editable) {
        override fun resolveURL(owaUrl: String?, checkFileInfoUrl: String?, accessToken: String?): String {
            val url = "$owaUrl/p/PowerPointFrame.aspx?&WOPISrc=$checkFileInfoUrl&access_token=$accessToken"
            return if (editable) {
                url.plus("&PowerPointView=EditView")
            } else {
                url.plus("&PowerPointView=ReadingView")
            }
        }
    }

    class Pdf : App(false) {
        override fun resolveURL(owaUrl: String?, checkFileInfoUrl: String?, accessToken: String?): String {
            return "$owaUrl/wv/wordviewerframe.aspx?PdfMode=1&WOPISrc=$checkFileInfoUrl&access_token=$accessToken"
        }
    }

    companion object {
        private val WORD_PREVIEW_EXTENSIONS = arrayOf("doc", "dot", "dotm", "dotx", "rtf")
        private val WORD_PREVIEW_AND_EDIT_EXTENSIONS = arrayOf("docx", "docm", "odt")

        private val EXCEL_PREVIEW_EXTENSIONS = arrayOf("xls", "csv")
        private val EXCEL_PREVIEW_AND_EDIT_EXTENSIONS = arrayOf("xlsx", "xlsb", "xlsm", "ods")

        private val PPT_PREVIEW_EXTENSIONS = arrayOf("ppt", "pot", "potm", "potx", "pps", "ppsm", "pptm")
        private val PPT_PREVIEW_AND_EDIT_EXTENSIONS = arrayOf("pptx", "ppsx", "odp")

        private const val PORTABLE_DOCUMENT_FORMAT = "pdf"

        fun match(extension: String, editable: Boolean): App =
                when (extension.toLowerCase(Locale.getDefault())) {
                    in WORD_PREVIEW_EXTENSIONS -> Word(false)
                    in WORD_PREVIEW_AND_EDIT_EXTENSIONS -> Word(editable)

                    in EXCEL_PREVIEW_EXTENSIONS -> Excel(false)
                    in EXCEL_PREVIEW_AND_EDIT_EXTENSIONS -> Excel(editable)

                    in PPT_PREVIEW_EXTENSIONS -> PowerPoint(false)
                    in PPT_PREVIEW_AND_EDIT_EXTENSIONS -> PowerPoint(editable)

                    PORTABLE_DOCUMENT_FORMAT -> Pdf()

                    else -> Word(false)
                }
    }
}
package com.example.customlayout

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class ConfirmationDialogFragment : DialogFragment() {
    companion object {
        private const val ARG_TITLE = "arg_title"
        private const val ARG_MESSAGE = "arg_message"

        fun newInstance(title: String, message: String): ConfirmationDialogFragment {
            val fragment = ConfirmationDialogFragment()
            val args = Bundle()

            args.putString(ARG_TITLE, title)
            args.putString(ARG_MESSAGE, message)

            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val title = arguments?.getString(ARG_TITLE) ?: "Výchozí titulek"
        val message = arguments?.getString(ARG_MESSAGE) ?: "Výchozí zpráva"

        return AlertDialog.Builder(requireActivity())
            .setTitle(title)
            .setMessage(message)
            .setNegativeButton("Zavěsit") { _, _ ->
                dismiss()
            }
            .create()
    }
}
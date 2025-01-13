package com.example.checkboxsnackbar

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar


class MainActivity : AppCompatActivity() {

    private lateinit var inputField: EditText
    private lateinit var outputField: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        inputField = findViewById(R.id.inputField)
        outputField = findViewById(R.id.outputField)
        val saveButton: Button = findViewById(R.id.saveButton)
        val deleteButton: Button = findViewById(R.id.deleteButton)

        saveButton.setOnClickListener {
            val inputText = inputField.text.toString()
            outputField.text = inputText
        }

        deleteButton.setOnClickListener {
            //showDeleteConfirmationDialog()
            onClick(it)
        }
    }

    private fun showDeleteConfirmationDialog() {
        AlertDialog.Builder(this)
            .setTitle("Подтвердите удаление")
            .setMessage("Вы уверены, что хотите удалить данные?")
            .setPositiveButton("Удалить") { _, _ ->
                outputField.text = ""
                Snackbar.make(
                    findViewById(android.R.id.content),
                    "Данные удалены",
                    Snackbar.LENGTH_SHORT
                ).show()
            }
            .setNegativeButton("Отмена", null)
            .show()
    }

    private fun onClick(view: View) {
        Snackbar
            .make(
                view,
                "Подтвердите удаление",
                Snackbar.LENGTH_SHORT
            ).setAction("Удалить?") {
                outputField.text = ""
                Snackbar.make(
                    view,
                    "Данные удалены",
                    Snackbar.LENGTH_SHORT
                ).show()
            }.show()
    }
}


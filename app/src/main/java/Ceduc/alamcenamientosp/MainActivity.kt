package Ceduc.alamcenamientosp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private val sharedP = ""//Variable para guardar las preferencias
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Recuperar los valores del formulario
        val name = findViewById<TextView>(R.id.txtName)
        val email = findViewById<TextView>(R.id.txtMail)
        //Recupero el control de los botones
        val save = findViewById<Button>(R.id.btnSave)
        val search = findViewById<Button>(R.id.btnSearch)

        //Aqui recupero las preferencias del sistema
        val sp = getSharedPreferences(sharedP, Context.MODE_PRIVATE)

        //Escuchadores
        save.setOnClickListener {
            val editor = sp.edit()//Modo Edicion de SP
            editor.putString(name.text.toString(), email.text.toString())//Guardando datos
            editor.apply()//Guardando cambios
            Toast.makeText(this, "Datos guardados", Toast.LENGTH_LONG).show()
            name.setText("")//Limpiando campos del formulario
            email.setText("")
        }

        search.setOnClickListener {
            //Recuperando el correo con la clave nombre
            val correo = sp.getString(name.text.toString(), "")

            if(correo!!.isNotEmpty())
            {
              email.setText(correo)//escribiendo el correo en el campo del formulario
            }
            else
            {
                Toast.makeText(this,"Usuario no Encontrado", Toast.LENGTH_LONG)
            }


        }

    }
}
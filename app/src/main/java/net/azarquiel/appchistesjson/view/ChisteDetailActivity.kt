package net.azarquiel.appchistesjson.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import net.azarquiel.appchistesjson.R
import net.azarquiel.appchistesjson.model.Chiste

class ChisteDetailActivity : AppCompatActivity() {
    private lateinit var chiste: Chiste

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chiste_detail)

        chiste = intent.getSerializableExtra("chiste") as Chiste
        showChiste()


    }

    private fun showChiste() {
        val ivdetail =findViewById<ImageView>(R.id.ivdetail)
        val tvcontenidodetail = findViewById<TextView>(R.id.tvcontenidodetail)
        val contenido = Html.fromHtml(chiste.contenido)
        tvcontenidodetail.text = contenido

        val foto = "http://www.ies-azarquiel.es/paco/apichistes/img/${chiste.idcategoria}.png"
        Picasso.get().load(foto).into(ivdetail)


    }
}
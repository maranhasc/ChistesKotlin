package net.azarquiel.appchistesjson.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import net.azarquiel.appchistesjson.R
import net.azarquiel.appchistesjson.model.Categoria
import net.azarquiel.recyclerviewCategorias.adapter.AdapterCat
import net.azarquiel.appchistesjson.model.Result
import java.net.URL

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: AdapterCat

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRV()
        getDatos()
    }

    private fun getDatos() {
        GlobalScope.launch() {
            val jsontxt = URL("http://www.ies-azarquiel.es/paco/apichistes/categorias").readText(Charsets.UTF_8)
            launch(Main) {
                val result = Gson().fromJson(jsontxt, Result::class.java)
                adapter.setCategorias(result.categorias)
            }
        }
    }

    private fun initRV() {
        val rvcat = findViewById<RecyclerView>(R.id.rvcat)
        adapter = AdapterCat(this, R.layout.rowcat)
        rvcat.adapter = adapter
        rvcat.layoutManager = LinearLayoutManager(this)
    }
    fun onclickCat(v: View) {
        val categoria = v.tag as Categoria

        val intent = Intent(this, ChistesActivity::class.java)
        intent.putExtra("categoria", categoria)
        startActivity(intent)
    }
}
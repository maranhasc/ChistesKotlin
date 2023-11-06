package net.azarquiel.appchistesjson.model

import java.io.Serializable
data class Result(var categorias:List<Categoria>, var chistes:List<Chiste>)
data class Categoria(var id:String, var nombre:String):Serializable
data class Chiste(var id:String, var idcategoria:String, var contenido:String):Serializable
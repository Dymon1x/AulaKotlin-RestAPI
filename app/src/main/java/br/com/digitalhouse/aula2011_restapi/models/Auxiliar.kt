package br.com.digitalhouse.aula2011_restapi.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

//Classe Auxiliar
class Auxiliar(@SerializedName("produtos") @Expose var listProdutos: ArrayList<Produtos>){
}
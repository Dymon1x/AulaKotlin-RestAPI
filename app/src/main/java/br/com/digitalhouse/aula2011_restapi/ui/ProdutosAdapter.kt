package br.com.digitalhouse.aula2011_restapi.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.digitalhouse.aula2011_restapi.R
import br.com.digitalhouse.aula2011_restapi.models.Produtos

class ProdutosAdapter (): RecyclerView.Adapter<ProdutosAdapter.ProdutoViewHolder>() {
    val listProd = ArrayList<Produtos>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProdutoViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_produtos, parent, false)
        return ProdutoViewHolder(itemView)
    }

    override fun getItemCount() = listProd.size

    override fun onBindViewHolder(holder: ProdutoViewHolder, position: Int) {
        val produto = listProd.get(position)
        holder.idProd.text = produto.id_prod.toString()
        holder.nomeProd.text = produto.nome_prod
        holder.urlProd.text = produto.url
        holder.idEmp.text = produto.id_emp.toString()
        holder.nomeEmp.text = produto.nome_emp
        holder.valor.text = produto.valor
        holder.logoEmp.text = produto.logo_emp
        holder.volProd.text = produto.vol_prod
    }
    class ProdutoViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val idProd: TextView = itemView.findViewById(R.id.id_prod)
        val nomeProd: TextView = itemView.findViewById(R.id.nome_item)
        val urlProd: TextView = itemView.findViewById(R.id.url_prod)
        val idEmp: TextView = itemView.findViewById(R.id.id_emp)
        val nomeEmp: TextView = itemView.findViewById(R.id.nome_emp)
        val valor: TextView = itemView.findViewById(R.id.valor)
        val logoEmp: TextView = itemView.findViewById(R.id.logo_emp)
        val volProd: TextView = itemView.findViewById(R.id.vol_prod)
    }

    fun addProd(items: ArrayList<Produtos>){
        listProd.addAll(items)
        notifyDataSetChanged()
    }

    fun clear(){
        listProd.clear()
        notifyDataSetChanged() //notifica a mudança da lista
    }
}


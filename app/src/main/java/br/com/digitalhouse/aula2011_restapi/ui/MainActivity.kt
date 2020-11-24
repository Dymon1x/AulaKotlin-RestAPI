package br.com.digitalhouse.aula2011_restapi.ui

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.digitalhouse.aula2011_restapi.R
import br.com.digitalhouse.aula2011_restapi.services.service
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var prodAdapter: ProdutosAdapter
    private lateinit var lManager: LinearLayoutManager

    private val viewModel by viewModels<MainViewModel> {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return MainViewModel(service) as T
            }
        }
    }

    @SuppressLint("ServiceCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



//        viewModel.aluno.observe(this, Observer {
//            Log.i("MainActivity", it.toString())
//       })
//// por padrao o android studio vem desligado da INTERNET
//
//        viewModel.listAlunos.observe(this, Observer {
//            it.forEach{
//                Log.i("MainActivity", it.toString())
//            }
//        })
//        viewModel.getAlunoSort()
//        viewModel.getAllAlunos()

//
//        viewModel.listProdutos.observe(this, Observer {
//            Log.i("MainActivity", it.toString())
//        })
//
//        viewModel.listProdutos.observe(this, {
//            it.forEach{
//                Log.i("MainActivity", it.toString())
//            }
//        })

        lManager = LinearLayoutManager(this)
        rvProdutos.layoutManager = lManager

        prodAdapter = ProdutosAdapter()
        rvProdutos.adapter = prodAdapter
        rvProdutos.setHasFixedSize(true)

        viewModel.listProdutos.observe(this) {
            prodAdapter.addProd(it) // add um novo produto
        }

        viewModel.getAllProdutos()
        setScrollView()
    }

    // Paginação
    private fun setScrollView() {
        rvProdutos.run {
            addOnScrollListener(object : RecyclerView.OnScrollListener(){
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)

                    val itensVisible = lManager?.childCount
                    val pastItens = lManager.findFirstVisibleItemPosition()
                    val total = prodAdapter?.itemCount

//                    Log.i("Itens visiveis", itensVisible.toString())
//                    Log.i("pastItens", pastItens.toString())
//                    Log.i("total", total.toString())

                    var page = 0

                    if((itensVisible + pastItens) == total){
                        page++
                        Log.i("Nova Página", page.toString())
                        viewModel.getAllProdutos()
                    }
                }
            })
        }
    }
}

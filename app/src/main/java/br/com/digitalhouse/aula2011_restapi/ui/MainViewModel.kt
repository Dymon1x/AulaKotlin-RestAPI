package br.com.digitalhouse.aula2011_restapi.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.digitalhouse.aula2011_restapi.models.Aluno
import br.com.digitalhouse.aula2011_restapi.models.Produtos
import br.com.digitalhouse.aula2011_restapi.services.Service
import br.com.digitalhouse.aula2011_restapi.services.service
import kotlinx.coroutines.launch

class MainViewModel(service: Service): ViewModel() {

    val aluno = MutableLiveData<Aluno>()
    val listAlunos = MutableLiveData<List<Aluno>>()

    val produtos = MutableLiveData<Produtos>()
    val listProdutos = MutableLiveData<ArrayList<Produtos>>()

    fun getAlunoSort(){
        viewModelScope.launch {
            aluno.value = service.getAlunoSortRepo()
        }
    }

    fun getAllAlunos(){
        viewModelScope.launch {
            listAlunos.value = service.getAllAlunosRepo()
        }
    }

    fun getProdutoSort(){
        viewModelScope.launch {
            produtos.value = service.getProdutos()
        }
    }


    fun getAllProdutos(){
        viewModelScope.launch {
            listProdutos.value = service.getAllProdutos().listProdutos
        }
    }
}
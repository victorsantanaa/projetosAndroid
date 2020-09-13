package modelo

import kotlin.random.Random

enum class TabuleiroEvento{ VITORIA, DERROTA}

class Tabuleiro (val qtDeLinhas: Int, val qtDeColunas: Int, private val qtDeMinas: Int) {

    private val campos = ArrayList<ArrayList<Campo>>()
    private val callbacks = ArrayList<(TabuleiroEvento)->Unit>()

    init {
        gerarCampos()
        associarVizinhos()
        sortearMinas()
    }

    private fun gerarCampos(){
        for(linha in 0 until qtDeLinhas) {
            campos.add(ArrayList())
            for (coluna in 0 until qtDeColunas) {
                val novoCampo = Campo(linha, coluna)
                novoCampo.onEvento(this::verificarDerrotaOuVitoria)
                campos[linha].add(novoCampo)
            }
        }
    }

    private fun associarVizinhos() {
        forEachCampo { associarVizinhos(it) }
    }

    private fun associarVizinhos(campo: Campo) {
        val (linha, coluna) = campo
        val linhas = arrayOf(linha - 1, linha, linha + 1)
        val colunas = arrayOf(coluna - 1, coluna, coluna + 1)

        linhas.forEach { l->
            colunas.forEach { c->
                val atual = campos.getOrNull(l)?.getOrNull(c)
                atual?.takeIf { campo != it }?.let {campo.addVizinho(it)}
            }
        }
    }

    private fun sortearMinas() {
        val gerador = java.util.Random()

        var linhaSorteada = -1
        var colunaSorteada = -1
        var qtDeMinasAtual = 0
         while (qtDeMinasAtual < this.qtDeMinas) {
             linhaSorteada = gerador.nextInt(qtDeLinhas)
             colunaSorteada = gerador.nextInt(qtDeColunas)
             val campoSorteado = campos[linhaSorteada][colunaSorteada]
             if (campoSorteado.seguro){
                 campoSorteado.minar()
                 qtDeMinasAtual++
             }
         }
    }

    private fun objetivoAlcancado(): Boolean {
        var jogadorGanhou = true
        forEachCampo { if (!it.objetivoAlcancado) jogadorGanhou = false }
        return jogadorGanhou
    }

    private fun verificarDerrotaOuVitoria(campo: Campo, evento: CampoEvento){
        if (evento == CampoEvento.EXPLOSAO) {
            callbacks.forEach { it(TabuleiroEvento.DERROTA) }
        } else if (objetivoAlcancado()) {
            callbacks.forEach { it(TabuleiroEvento.VITORIA) }
        }
    }

    fun forEachCampo(callback: (Campo) -> Unit) {
        campos.forEach { linha -> linha.forEach(callback) }
    }

    fun onEvento(callback: (TabuleiroEvento) -> Unit) {
        callbacks.add(callback)
    }

    fun reiniciar() {
        forEachCampo { it.reiniciar()}
        sortearMinas()
    }
}
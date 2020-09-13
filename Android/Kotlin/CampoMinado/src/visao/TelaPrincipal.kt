package visao

import modelo.Tabuleiro
import modelo.TabuleiroEvento
import javax.swing.JFrame
import javax.swing.JOptionPane
import javax.swing.SwingUtilities

fun main() {
    TelaPrincipal()
}

class TelaPrincipal : JFrame() {
    private val tabuleiro = Tabuleiro(qtDeLinhas = 16, qtDeColunas = 30, qtDeMinas = 25)
    private val painelTabuleiro = PainelTabuleiro(tabuleiro)

    init {
        tabuleiro.onEvento (this::mostrarResultado)
        add(painelTabuleiro)

        setSize(690, 438)
        setLocationRelativeTo(null)
        defaultCloseOperation = EXIT_ON_CLOSE
        title = "Campo Minado do Victor Santana"
        isVisible = true
    }

    private fun mostrarResultado(evento: TabuleiroEvento) {
        SwingUtilities.invokeLater {
            val msg = when(evento) {
                TabuleiroEvento.VITORIA -> "Você ganhou meu parça, você é TOP!"
                TabuleiroEvento.DERROTA -> "Você infelizmente perdeu, tente novamente :'("
            }

            JOptionPane.showMessageDialog(this, msg)
            tabuleiro.reiniciar()

            painelTabuleiro.repaint()
            painelTabuleiro.validate()
        }
    }
}
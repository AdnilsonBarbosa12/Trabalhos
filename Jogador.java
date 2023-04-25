public class Jogador {
    private String nome;
    private char simbolo;
    private int jogadas;

    public Jogador(String nome, char simbolo) {
        this.nome = nome;
        this.simbolo = simbolo;
        this.jogadas = 0;
    }

    public String getNome() {
        return nome;
    }

    public char getSimbolo() {
        return simbolo;
    }

    public boolean jogar(Tabuleiro tabuleiro, int linha, int coluna) {
        if (jogadas <= 6) {
            boolean jogadaValida = tabuleiro.jogar(linha, coluna, simbolo);
            if (jogadaValida) {
                jogadas++;
                return true;
            }
        }
        return false;
    }

    public void moverPedras(Tabuleiro tabuleiro, int linha1, int coluna1, int linha2, int coluna2) {
        tabuleiro.moverPedras(linha1, coluna1, linha2, coluna2);
    }

    public boolean verificarVitoria(Tabuleiro tabuleiro) {
        return tabuleiro.verificarVitoria(simbolo);
    }
}

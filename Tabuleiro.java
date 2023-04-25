public class Tabuleiro {
    private char[][] casas;

    public Tabuleiro() {
        this.casas = new char[3][3];
        for (int i = 0; i < casas.length; i++) {
            for (int j = 0; j < casas[i].length; j++) {
                casas[i][j] = ' ';
            }
        }
    }

    public void exibir() {
        System.out.println("-------------");
        for (int i = 0; i < casas.length; i++) {
            System.out.print("| ");
            for (int j = 0; j < casas[i].length; j++) {
                System.out.print(casas[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }


    public boolean jogar(int linha, int coluna, char jogador) {
        if (casas[linha][coluna] == ' ') {
            casas[linha][coluna] = jogador;
            return true;
        } else {
            return false;
        }
    }

    public char getCasa(int linha, int coluna) {
        return casas[linha][coluna];
    }

    public void moverPedras(int linha1, int coluna1, int linha2, int coluna2) {
        char aux = casas[linha1][coluna1];
        casas[linha1][coluna1] = casas[linha2][coluna2];
        casas[linha2][coluna2] = aux;
    }

    public boolean verificarVitoria(char jogador) {
        // Verificar linhas
        for (int i = 0; i < casas.length; i++) {
            if (casas[i][0] == jogador && casas[i][1] == jogador && casas[i][2] == jogador) {
                return true;
            }
        }
        // Verificar colunas
        for (int j = 0; j < casas[0].length; j++) {
            if (casas[0][j] == jogador && casas[1][j] == jogador && casas[2][j] == jogador) {
                return true;
            }
        }
        // Verificar diagonal principal
        if (casas[0][0] == jogador && casas[1][1] == jogador && casas[2][2] == jogador) {
            return true;
        }
        // Verificar diagonal secundária
        if (casas[0][2] == jogador && casas[1][1] == jogador && casas[2][0] == jogador) {
            return true;
        }
        return false;
    }

    public boolean tabuleiroCheio() {
        for (int i = 0; i < casas.length; i++) {
            for (int j = 0; j < casas[i].length; j++) {
                if (casas[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}

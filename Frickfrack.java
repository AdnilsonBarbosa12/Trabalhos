import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Frickfrack extends JFrame implements ActionListener {
    private static final int LINHAS = 3;
    private static final int COLUNAS = 3;
    private static final int MAX_JOGADAS = 6;

    private JButton[][] tabuleiro;
    private JButton btnNovoJogo;
    private JLabel lblInfo;
    private int jogada;
    private int vencedor;

    public Frickfrack() {
        setTitle("Frickfrack");
        setSize(300, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        JPanel pnlTabuleiro = new JPanel(new GridLayout(LINHAS, COLUNAS));
        tabuleiro = new JButton[LINHAS][COLUNAS];
        for (int i = 0; i < LINHAS; i++) {
            for (int j = 0; j < COLUNAS; j++) {
                tabuleiro[i][j] = new JButton();
                tabuleiro[i][j].setFont(new Font("Arial", Font.BOLD, 40));
                tabuleiro[i][j].addActionListener(this);
                pnlTabuleiro.add(tabuleiro[i][j]);
            }
        }

        btnNovoJogo = new JButton("Novo Jogo");
        btnNovoJogo.addActionListener(this);

        lblInfo = new JLabel("Jogador 1 - Sua vez!");
        lblInfo.setHorizontalAlignment(JLabel.CENTER);

        JPanel pnlBotoes = new JPanel(new GridLayout(1, 2));
        pnlBotoes.add(btnNovoJogo);
        pnlBotoes.add(lblInfo);

        add(pnlTabuleiro, BorderLayout.CENTER);
        add(pnlBotoes, BorderLayout.SOUTH);

        setVisible(true);

        iniciarJogo();
    }

    private void iniciarJogo() {
        jogada = 0;
        vencedor = 0;
        for (int i = 0; i < LINHAS; i++) {
            for (int j = 0; j < COLUNAS; j++) {
                tabuleiro[i][j].setText("");
                tabuleiro[i][j].setEnabled(true);
            }
        }
        lblInfo.setText("Jogador 1 - Sua vez!");
    }

    private int verificarVencedor() {

        for (int i = 0; i < LINHAS; i++) {
            if (tabuleiro[i][0].getText().equals(tabuleiro[i][1].getText())
                    && tabuleiro[i][1].getText().equals(tabuleiro[i][2].getText())
                    && !tabuleiro[i][0].getText().equals("")) {
                return (tabuleiro[i][0].getText().equals("X")) ? 1 : 2;
            }
        }
        // Verificar colunas
        for (int i = 0; i < COLUNAS; i++) {
            if (tabuleiro[0][i].getText().equals(tabuleiro[1][i].getText())
                    && tabuleiro[1][i].getText().equals(tabuleiro[2][i].getText())
                    && !tabuleiro[0][i].getText().equals("")) {
                return (tabuleiro[0][i].getText().equals("X")) ? 1 : 2;
            }
        }

        // Verificar diagonais
        if (tabuleiro[0][0].getText().equals(tabuleiro[1][1].getText())
                && tabuleiro[1][1].getText().equals(tabuleiro[2][2].getText())
                && !tabuleiro[0][0].getText().equals("")) {
            return (tabuleiro[0][0].getText().equals("X")) ? 1 : 2;
        }
        if (tabuleiro[0][2].getText().equals(tabuleiro[1][1].getText())
                && tabuleiro[1][1].getText().equals(tabuleiro[2][0].getText())
                && !tabuleiro[0][2].getText().equals("")) {
            return (tabuleiro[0][2].getText().equals("X")) ? 1 : 2;
        }
        // Verificar empate
        if (jogada == MAX_JOGADAS) {
            return 3;
        }
        return 0;


    }










    private void marcarJogada(int linha, int coluna) {
        if (jogada % 2 == 0) {
            tabuleiro[linha][coluna].setText("X");
            lblInfo.setText("Jogador 2 - Sua vez!");
        } else {
            tabuleiro[linha][coluna].setText("O");
            lblInfo.setText("Jogador 1 - Sua vez!");
        }
        jogada++;
        tabuleiro[linha][coluna].setEnabled(false);
    }




    private void finalizarJogo() {
        for (int i = 0; i < LINHAS; i++) {
            for (int j = 0; j < COLUNAS; j++) {

            }
        }
        if (vencedor == 1) {
            lblInfo.setText("Jogador 1 venceu!");
        } else if (vencedor == 2) {
            lblInfo.setText("Jogador 2 venceu!");
        }
    }


    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnNovoJogo) {
            iniciarJogo();
            return;
        }
        for (int i = 0; i < LINHAS; i++) {
            for (int j = 0; j < COLUNAS; j++) {
                if (e.getSource() == tabuleiro[i][j]) {
                    marcarJogada(i, j);
                    vencedor = verificarVencedor();
                    if (vencedor != 0) {
                        finalizarJogo();
                    }
                    return;
                }
            }
        }
    }

    public static void main(String[] args) {
        new Frickfrack();
    }}

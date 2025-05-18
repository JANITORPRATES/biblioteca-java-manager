package src;

import javax.swing.JOptionPane;

public class Principal {

    public static void main(String[] args) {
        Object[] opcoes = {"Sim", "Não"};
        while (true){

            int resposta = JOptionPane.showOptionDialog(null,
                    "Deseja ver os livros disponíveis?",
                    "Sistema de Livraria ",
                    JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null, opcoes, opcoes[0]);



            if (resposta == JOptionPane.YES_OPTION) {
                System.out.println("Você escolheu Sim.");
            } else if (resposta == JOptionPane.NO_OPTION) {
                System.out.println("Obrigado por utilizar o sistema da biblioteca.");
                break;
            } else {
                System.out.println("Obrigado por utilizar o sistema da biblioteca.");
                break;
            }

        }
    }
}

import java.sql.SQLOutput;

/**
 * Classe do Sistema que realizará as operações sobre o acervo
 * @author João Enrique Cairuga
 * @version 2023-01-01
 */
import java.util.Scanner;
public class Sistema {

    //Atributos
    private Acervo a;

    //Construtor
    public Sistema(){
        this.a = new Acervo();
    }

    //Operações
    /**
     * Método que inicializa  o sistema criando 5 objetos Alugavel e cadastrando-os no acervo
     * @version 2023-01-01
     */
    public void inicializaSistema(){
        Alugavel o1 = new Alugavel(1234,"Sedan",100.00,"ABCD-08",2010,"Prata");
        Alugavel o2 = new Alugavel(5678,"Sedan",150.00,"FGHI-09",2018,"Preto");
        Alugavel o3 = new Alugavel(9012,"GOL",200.00,"JKLM-10",2019,"Vermelho");
        Alugavel o4 = new Alugavel(3456,"Sedan",300.00,"NOPQ-11",2021,"Prata");
        Alugavel o5 = new Alugavel(7890,"Fusca",50.00,"RSTU-12",1990,"Azul");

        a.adicionaAlugavel(o1);
        a.adicionaAlugavel(o2);
        a.adicionaAlugavel(o3);
        a.adicionaAlugavel(o4);
        a.adicionaAlugavel(o5);
        System.out.println("Sistema inicializado");
    }

    /**
     * Método que imprime na tela um Menu para o usuário
     * A ser refeito com Interface de Usuário
     * @version 2023-01-01
     */
    public void menu(){
        Scanner in = new Scanner(System.in);
        int entrada = -1;
        while(entrada !=0){
            System.out.println("BEM-VINDO AO SISTEMA DE ALUGUÉIS");
            System.out.println("Selecione uma das opções abaixo:\n" +
                    "[1] REGISTRAR NOVO ALUGÁVEL\n" +
                    "[2] ALUGAR CARRO\n" +
                    "[3] DEVOLVER CARRO\n" +
                    "[4] BUSCAR CARRO(S)\n" +
                    "[5] DELETAR ALUGÁVEL\n" +
                    "[0] ENCERRAR SISTEMA");
            entrada = in.nextInt();
            switch (entrada){
                case 1:
                    System.out.println();
                    System.out.println("Por favor, insira os dados necessários:");
                    System.out.print("CÓDIGO do carro: ");
                    System.out.print("\n"+ "MODELO do carro: ");
            }
        }
        System.out.println("Sistema Encerrado");
    }
}

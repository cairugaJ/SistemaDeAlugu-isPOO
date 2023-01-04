/**
 * Classe do Sistema que realizará as operações sobre o acervo
 * @author João Enrique Cairuga
 * @version 2023-01-02
 */
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
public class Sistema {

    //Atributos
    private Acervo a;
    private Scanner in;
    //Construtor
    public Sistema(){
        this.a = new Acervo();
        in = new Scanner(System.in);
    }

    //Operações
    /**
     * Método que inicializa  o sistema criando 5 objetos Alugavel e cadastrando-os no acervo
     * 2023-01-01
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
     * 2023-01-01
     */
    public void menu(){
        System.out.println("BEM-VINDO AO SISTEMA DE ALUGUÉIS");

        System.out.println("Selecione uma das opções abaixo:\n" +
                "[1] REGISTRAR NOVO ALUGÁVEL\n" +
                "[2] ALUGAR CARRO\n" +
                "[3] DEVOLVER CARRO\n" +
                "[4] BUSCAR CARRO(S)\n" +
                "[5] DELETAR ALUGÁVEL\n" +
                "[0] ENCERRAR SISTEMA");
        int entrada = in.nextInt();

        switch(entrada){
            case 1:
                opcao1();
                break;
            case 2:
                opcao2();
                break;
            case 3:
                opcao3();
                break;
            case 4:
                opcao4();
                break;
            case 5:
                opcao5();
                break;
            case 0:
                System.exit(0); //Encerra a execução
                break;

        }
    }

    /**
     * Método para relizar o cadastro de Alugáveis, imprime na tela o processo
     * 2023-01-02
     */
    private void opcao1(){
        System.out.println("Por favor, insira os dados para o cadastro do novo Alugável:");
        System.out.print("Insira um novo código para o Alugável:");
        int cod = in.nextInt();
        System.out.print("\n" + "Insira o modelo do Alugável:");
        String mod = in.next();
        System.out.print("\n" + "Insira o preço diário do Alugável:");
        double pre = in.nextDouble();
        System.out.print("\n" + "Insira a placa do Alugável:");
        String pla = in.next();
        System.out.print("\n" + "Insira o ano do Alugável:");
        int ano = in.nextInt();
        System.out.println("\n" + "Insira a cor do Alugável:");
        String cor = in.next();
        Alugavel novo = new Alugavel(cod,mod,pre,pla,ano,cor);
        if(a.adicionaAlugavel(novo)){
            System.out.println("Cadastro feito com sucesso!");
        }
        else{
            System.out.println("Falha em cadastrar novo Alugável");
        }
        menu(); //Retorna para menu inicial
    }

    /**
     * Método para alugar um Alugável
     * 2023-01-02
     */
    private void opcao2(){
        System.out.println("Digite o código do Alugável a ser alugado:");
        int cod = in.nextInt();
        Alugavel alu = a.buscaCodigo(cod);
        System.out.println("Digite o tempo de aluguel:");
        int tempo = in.nextInt();
        if(a.alugar(alu,tempo)){
            System.out.println("Aluguel realizado com sucesso!");
        }
        else{
            System.out.println("Não foi possível realizar o aluguel");
        }
        menu(); //Retorna para menu inicial
    }

    /**
     * Método para pagar o aluguel e retornar o alugável
     * 2023-01-02
     */
    private void opcao3(){
        System.out.println("Digite o código do Alugável a ser devolvido:");
        int cod = in.nextInt();
        Alugavel alu = a.buscaCodigo(cod);
        System.out.println("Digite o valor pago:");
        double pagamento = in.nextDouble();
        if(a.retorno(alu,pagamento)){
            System.out.println("Alugável retornado com sucesso!");
        }
        else{
            System.out.println("Ocorreu um erro");
        }
        menu(); //Retorna para menu inicial
    }

    /**
     * Método para realizar buscas dentro do acervo do sistema
     * refazer com switch-case
     */
    private void opcao4(){
        System.out.println("Digite o método de busca desejado:");
        System.out.println("Selecione uma das opções abaixo:\n" +
                "[1] BUSCAR POR CÓDIGO\n" +
                "[2] BUSCAR POR PLACA\n" +
                "[3] BUSCAR POR MODELO\n" +
                "Qualquer outra tecla para retornar ao menu");
        String bus = in.next();
        if (Objects.equals(bus, "1")) {
            System.out.println("Digite o código do Alugável:");
            int cod = in.nextInt();
            Alugavel alu = a.buscaCodigo(cod);
            if(alu != null){
                System.out.println("Alugável encontrado:");
                alu.imprimeDados();

            }
            else{
                System.out.println("Não foram encontrados Alugáveis com esse código");
            }
        }
        else if (Objects.equals(bus, "2")){
            System.out.println("Digite a placa do Alugável:");
            String pla = in.next();
            Alugavel alu = a.buscaPlaca(pla);
            if(alu != null){
                System.out.println("Alugável encontrado:");
                alu.imprimeDados();

            }
            else{
                System.out.println("Não foram encontrados Alugáveis com essa placa");
            }

        }
        else if (Objects.equals(bus, "3")){
            System.out.println("Digite o modelo de Alugável:");
            String mod = in.next();
            ArrayList<Alugavel> modelos =  a.buscaModelo(mod);
            if(modelos.size() != 0){
                for( Alugavel m : modelos){
                    m.imprimeDados();
                }
            }
            else{
                System.out.println("Não foram encontrados Alugáveis desse modelo");
            }

        }
        else{
            menu(); //Retorna para menu inicial
        }
        menu(); //Retorna para menu inicial
    }

    /**
     * Método para deletar um Alugável do acervo do sistema
     */
    private void opcao5(){
        System.out.println("Digite o código do Alugável que deseja deletar:");
        int cod = in.nextInt();
        Alugavel x = a.buscaCodigo(cod);
        if(a.deletarAlugável(x)){
            System.out.println("Alugável de código: " + Integer.toString(x.getCodigo()) + " deletado com sucesso");
        }
        else{
            System.out.println("Não foi possível deletar o Alugável");
        }
        menu();
    }
}

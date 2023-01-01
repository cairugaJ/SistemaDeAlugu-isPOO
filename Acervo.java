/**
 * Classe catálogo - CRUD - de Alugavel
 * @author João Enrique Cairuga
 * @version 2022-12-30
 */
import java.util.ArrayList;
import java.util.HashMap;
public class Acervo {

    //Atributos
    private  ArrayList<Alugavel> listaAlugaveis;
    private HashMap<Alugavel, Integer> alugados;


    //Construtor
    public Acervo(){
        this.listaAlugaveis = new ArrayList<>();
        this.alugados = new HashMap<>();
    }

    //Getters
    public ArrayList<Alugavel> getListaAlugaveis() {
        return listaAlugaveis;
    }

    public HashMap<Alugavel, Integer> getAlugados() {
        return alugados;
    }

    //Create

    /**
     * CREATE - adiciona alugável ao acervo
     * Alugáveis não podem ter placas e códigos repetidos
     * @param a alugável a ser adicionado
     * @return true se conseguiu adicionar
     */
    public boolean adicionaAlugavel(Alugavel a){
        for (Alugavel b : listaAlugaveis){
            if(a.getCodigo() == b.getCodigo() || a.getPlaca().equals(b.getPlaca())){
                return false;
            }
        }
        listaAlugaveis.add(a);
        return true;
    }

    //Retrieve

    /**
     * RETRIEVE - busca carro específico pela placa
     * @param placa valor a ser buscado no catálogo
     * @return carro de mesma placa ou null caso o carro não esteja no catálogo
     */
    public Alugavel buscaPlaca(String placa){
        for (Alugavel a : listaAlugaveis){
            if( placa.equals(a.getPlaca())) return a;
        }
        return null;
    }

    /**
     * RETRIEVE - busca carro específico pelo código
     * @param codigo valor a ser buscado no catálogo
     * @return carro de mesmo código ou null caso o carro não esteja no catálogo
     */
    private Alugavel buscaCodigo(int codigo){
        for (Alugavel a : listaAlugaveis){
            if( codigo == a.getCodigo()) return a;
        }
        return null;
    }

    /**
     * RETRIEVE - busca carros de um modelo específico
     * @param modelo modelo de carros a ser buscado
     * @return lista de carros desse modelo
     */
    public ArrayList<Alugavel> buscaModelo(String modelo){
        ArrayList<Alugavel> modelos = new ArrayList<>();
        for (Alugavel a : listaAlugaveis){
            if(modelo.equals(a.getModelo())) modelos.add(a);
        }
        return modelos;
    }

    //Update

    /**
     * UPDATE - atualiza status alugado de carro para true
     * @param a carro a ser alugado
     * @param tempoDia tempo em que o carro ficará alugado
     * @return true se o aluguel foi feito com sucesso
     */
    public boolean alugar(Alugavel a, Integer tempoDia){
        if(buscaCodigo(a.getCodigo()) == null) return false; //checa se carro está no catálogo
        if(alugados.containsKey(a)) return false; //checa se está alugado
        alugados.put(a,tempoDia);
        a.setAlugado(true);
        return true;
    }

    /**
     * UPDATE - atualiza status de alugado do carro para false
     * @param a carro
     * @param pagamento preço diário do carro * dias alugados
     * @return true caso o carro foi retornado e o aluguel pago
     */
    public boolean retorno(Alugavel a, double pagamento){
        double valor = a.getPrecoDiario() * alugados.get(a);
        if(a.getAlugado() && pagamento == valor){
            a.setAlugado(false);
            alugados.remove(a);
            return true;
        }
        return false;
    }

    //Delete

    /**
     * DELETE - remove carro do acervo
     * @param a carro a ser deletado
     * @return true se foi possível deletar o carro
     */
    public boolean deletarAlugável(Alugavel a){
        if(listaAlugaveis.contains(a)){
            listaAlugaveis.remove(a);
            return true;
        }
        return false;
    }
}

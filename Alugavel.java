/**
 *
 * Classe de objetos alugáveis - carros
 * @author João Enrique Cairuga
 * @version 2022-12-30
 */
public class Alugavel {

    //Atributos
    private int codigo;
    private String modelo;
    private  double precoDiario;
    private String placa;
    private int ano;
    private String cor;
    private boolean alugado;

    //Construtor
    public Alugavel(int c, String m, double pd, String pl, int a, String cor){
        this.codigo = c;
        this.modelo = m;
        this.precoDiario = pd;
        this.placa = pl;
        this.ano = a;
        this.cor = cor;
        this.alugado = false;
    }

    //Getters e Setters
    public int getCodigo(){
        return codigo;
    }
    public void setCodigo(int c){
        this.codigo = c;
    }

    public String getModelo() {
        return modelo;
    }
    public void setNome(String modelo) {
        this.modelo = modelo;
    }

    public double getPrecoDiario() {
        return precoDiario;
    }
    public void setPrecoDiario(double precoDiario) {
        this.precoDiario = precoDiario;
    }

    public String getPlaca() {
        return placa;
    }
    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getAno() {
        return ano;
    }
    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getCor() {
        return cor;
    }
    public void setCor(String cor) {
        this.cor = cor;
    }

    public boolean getAlugado() {
        return alugado;
    }
    public void setAlugado(boolean alugado) {
        this.alugado = alugado;
    }
}

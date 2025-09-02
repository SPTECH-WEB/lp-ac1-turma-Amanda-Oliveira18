package school.sptech;

public class Turma {
    private String nome;
    private Double mensalidade;
    private Integer qtdAluno;
    private Boolean ativa;

    public Turma(String nome, Double mensalidade){
        this.nome = nome;
        this.mensalidade = mensalidade;
        this.qtdAluno = 0;
        this.ativa = true;
    }

    public void matricular(Integer qtd){
        if (qtd != null && qtd > 0 && ativa) {
                qtdAluno += qtd;
        }
    }

    public Integer cancelar(Integer qtd){
        if (qtd != null && qtd > 0 && qtd <= qtdAluno && ativa) {
            qtdAluno -= qtd;
            return qtd;
        } else {
            return null;
        }
    }

    public Integer desativar(){
        if(ativa == false){
            return null;
        } else {
            ativa = false;
            Integer qtdAlunoAnterior = qtdAluno;
            this.qtdAluno = 0;
            return qtdAlunoAnterior;
        }
    }

    public void transferir(Turma destino, Integer qtdATransferir){
        if (destino != null && qtdATransferir != null && destino.ativa && qtdATransferir > 0 && qtdAluno >= qtdATransferir && ativa) {
            qtdAluno -= qtdATransferir;
            destino.qtdAluno += qtdATransferir;
        } else {
            return;
        }
    }

    public Boolean reajustarMensalidade(Double reajuste){
        if (reajuste == null || reajuste <= 0) {
            return false;
        } else {
            mensalidade += mensalidade * reajuste;
            return true;
        }
    }

    public String getNome() {
        return nome;
    }

    public Double getMensalidade() {
        return mensalidade;
    }

    public Integer getQtdAluno() {
        return qtdAluno;
    }

    public Boolean getAtiva() {
        return ativa;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}

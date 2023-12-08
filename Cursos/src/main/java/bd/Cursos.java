package bd;

public class Cursos {
    private int id;
    private String nome;
    private String descricao;
    private int duracaoEmHoras;
    private double preco;
    private String docente;

    // Construtor
    public Cursos() {
//        this.id = id;
//        this.nome = nome;
//        this.descricao = descricao;
//        this.duracaoEmHoras = duracaoEmHoras;
//        this.preco = preco;
//        this.docente = docente;
    }

    public String getDocente() {
		return docente;
	}

	public void setDocente(String docente) {
		this.docente = docente;
	}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getDuracaoEmHoras() {
        return duracaoEmHoras;
    }

    public void setDuracaoEmHoras(int duracaoEmHoras) {
        this.duracaoEmHoras = duracaoEmHoras;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

}

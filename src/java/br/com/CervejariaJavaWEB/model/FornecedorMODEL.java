package br.com.CervejariaJavaWEB.model;

public class FornecedorMODEL {

    private Integer id;
    private String cnpj;
    private String razao_social;
    private String email;
    private String telefone;
    private String endereco;
    private String cidade;
    private String estado;

    public FornecedorMODEL() {
    }

    public FornecedorMODEL(Integer id, String cnpj, String razao_social, String email, String telefone, String endereco, String cidade, String estado) {
        this.id = id;
        this.cnpj = cnpj;
        this.razao_social = razao_social;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
        this.cidade = cidade;
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazao_social() {
        return razao_social;
    }

    public void setRazao_social(String razao_social) {
        this.razao_social = razao_social;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}

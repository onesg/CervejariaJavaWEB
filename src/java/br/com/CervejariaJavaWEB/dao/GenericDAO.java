package br.com.CervejariaJavaWEB.dao;

import java.util.List;

public interface GenericDAO {

    public Boolean _Cadastrar(Object object) throws Exception;  //  METODO GENERICO PARA CADASTRAR
    public List<Object> _Listar() throws Exception;             //  METODO GENERICO PARA LISTAR
    public Boolean _Alterar(Object object) throws Exception;    //  METODO GENERICO PARA ALTERAR
    public Boolean _Excluir(Integer id) throws Exception;       //  METODO GENERICO PARA EXCLUIR
    public Object _Carregar(Integer id) throws Exception;       //  METODO GENERICO PARA CARREGAR

}

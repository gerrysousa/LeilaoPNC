/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pnc.leilaoVerde.controle;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import pnc.leilaoVerde.dominio.entidades.Entidade;

/**
 *
 * @author giovani
 */
public class CadastrarEntidadeControl extends AbstractControl {

    private Entidade entidade = null;

    private Entidade getEntidade() {
        if (entidade == null) {
            entidade = new Entidade();
            entidade.setAdmin(false);
            entidade.setValidada(false);
        }

        return entidade;
    }

    public void setCNPJ(String cnpj) {
        Entidade ent = getEntidade();
        ent.setCnpj(cnpj);
    }
    
    public void setNome(String nome) {
        Entidade ent = getEntidade();
        ent.setNome(nome);
    }

    public void setQuantidadeCER(int quantidadeCER) {
        Entidade ent = getEntidade();
        ent.setQuantidadeCER(quantidadeCER);
    }

    public void setEmail(String email) {
        Entidade ent = getEntidade();
        ent.setEmail(email);
    }

    public void setSenha(String passwd) {
        Entidade ent = getEntidade();
        ent.setSenha(passwd);
    }

    public Long getIdEntidadeCadastrada() {
        Entidade ent = getEntidade();
        return ent.getId();
    }

    public void cadastrarEntidade() {
        Entidade ent = getEntidade();
        
        // TODO: Cadastrar Entidade - defe verificar se já existe entidade com mesmo nome
        EntityManager em = createEntityManager();

        em.getTransaction().begin();
        em.persist(ent);
        em.getTransaction().commit();

        em.close();
    }
}

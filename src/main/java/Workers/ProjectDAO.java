package Workers;

import ExceptionHandler.DadoConsultadoException;
import Model.Project;

import java.util.List;

public interface ProjectDAO {
    void adicionar(Project project);
    List<Project> listar();
    Project consultarPorNome(String nome) throws DadoConsultadoException;
    Project alterar(String nome, Project project) throws DadoConsultadoException;
    void excluir(Project project) throws DadoConsultadoException;
    void excluir(String nome) throws DadoConsultadoException;
}

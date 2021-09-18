package Workers;

import ExceptionHandler.DadoConsultadoException;
import Model.Project;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ProjetoImpl implements ProjectDAO {
    private static Set<Project> projects = new HashSet<>();

    @Override
    public void adicionar(Project project) {
        projects.add(project);
        System.out.println("Projeto adicionado!");
    }

    @Override
    public List<Project> listar() {
        List<Project> projectList = new ArrayList<>();
        projectList.addAll(projects);
        return projectList;
    }

    @Override
    public Project consultarPorNome(String nome) throws DadoConsultadoException {
        for (Project queryProject : projects) {
            if(queryProject.getNome().equalsIgnoreCase(nome)){
                return queryProject;
            }
        }
        throw new DadoConsultadoException("Projeto não encontrado!");
    }

    @Override
    public Project alterar(String nome, Project project) throws DadoConsultadoException {
        Project projetoEncontrado = consultarPorNome(nome);
        projetoEncontrado.substituir(project);
        return projetoEncontrado;
    }

    @Override
    public void excluir(Project project) throws DadoConsultadoException {
        if(projects.contains(project)){
            projects.remove(project);
            System.out.println("Projeto removido!");
            return;
        }
            throw new DadoConsultadoException("Projeto não encontrado!");
    }


    @Override
    public void excluir(String nome) throws DadoConsultadoException {
        Project projetoEncontrado = consultarPorNome(nome);
        this.excluir(projetoEncontrado);
    }
}

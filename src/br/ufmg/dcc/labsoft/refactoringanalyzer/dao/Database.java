package br.ufmg.dcc.labsoft.refactoringanalyzer.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Database {

	private static EntityManager em;

	public Database() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("refactoringDB");
		em = factory.createEntityManager();
	}

	public ProjectGit getProjectByCloneUrl(String cloneUrl) {
		@SuppressWarnings("unchecked")
		List<ProjectGit> projects = em.createNamedQuery("projectGit.findByCloneUrl")
			.setParameter("cloneUrl", cloneUrl).getResultList();
		if (projects.size() > 0) {
			return projects.get(0);
		}
		return null;
	}
	
	public void insertIfNotExists(ProjectGit project) {
		try {
			em.getTransaction().begin();
			if (this.getProjectByCloneUrl(project.getCloneUrl()) == null) {
				em.persist(project);
			}
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw e;
		}
	}

}

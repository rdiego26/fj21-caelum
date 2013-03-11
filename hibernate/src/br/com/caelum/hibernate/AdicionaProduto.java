package br.com.caelum.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class AdicionaProduto {

	public static void main(String[] args) {
		
		Produto p = new Produto();
		p.setNome("Caixa de madeira");
		p.setDescricao("Descrição do Produto");
		p.setPreco(90.4);
		
		AnnotationConfiguration cfg = new AnnotationConfiguration();
		cfg.addAnnotatedClass(Produto.class);
		
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		
		session.beginTransaction();
		session.save(p);
		session.getTransaction().commit();
		
		System.out.println("ID do produto: " + p.getId());
		session.close();
	}
	
}

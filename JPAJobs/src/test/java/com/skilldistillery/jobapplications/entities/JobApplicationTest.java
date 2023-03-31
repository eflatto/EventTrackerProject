package com.skilldistillery.jobapplications.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class JobApplicationTest {
	
	private static EntityManagerFactory emf;
	private EntityManager em;
	private JobApplication job;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf=Persistence.createEntityManagerFactory("JPAJobs");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
		job =em.find(JobApplication.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		job=null;
	}

	@Test
	void test() {
		assertNotNull(job);
		assertEquals(job.getCompanyName(),"Google");
		
	}

}

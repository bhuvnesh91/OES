///*
// * To change this template, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.bebo.cms.dao.impl;
//
//import com.bebo.cms.model.Job;
//import org.hibernate.classic.Session;
//import org.junit.After;
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import static org.junit.Assert.*;
//import org.junit.Ignore;
//import org.junit.runner.RunWith;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.transaction.TransactionConfiguration;
//import org.springframework.transaction.annotation.Transactional;
//
///**
// *
// * @author bbansal
// */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"classpath*:**/action-servlet.xml"})
//public class JobDaoImplTest {
//
//    public JobDaoImplTest() {
//    }
//
//    @BeforeClass
//    public static void setUpClass() {
//    }
//
//    @AfterClass
//    public static void tearDownClass() {
//    }
//
//    @Before
//    public void setUp() {
//    }
//
//    @After
//    public void tearDown() {
//    }
//
//    /**
//     * Test of getCurrentSession method, of class JobDaoImpl.
//     */
//    @Test
//    public void testGetCurrentSession() {
//        System.out.println("getCurrentSession");
//        JobDaoImpl instance = new JobDaoImpl();
//        Session expResult = null;
//        Session result = instance.getCurrentSession();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of addJob method, of class JobDaoImpl.
//     */
//    @Ignore
//    public void testAddJob() {
//        System.out.println("addJob");
//        Job job = null;
//        JobDaoImpl instance = new JobDaoImpl();
//        instance.addJob(job);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of updateJob method, of class JobDaoImpl.
//     */
//    @Ignore
//    public void testUpdateJob() {
//        System.out.println("updateJob");
//        Job job = null;
//        JobDaoImpl instance = new JobDaoImpl();
//        instance.updateJob(job);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of deleteJob method, of class JobDaoImpl.
//     */
//    @Ignore
//    public void testDeleteJob() {
//        System.out.println("deleteJob");
//        Job job = null;
//        JobDaoImpl instance = new JobDaoImpl();
//        instance.deleteJob(job);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getJobById method, of class JobDaoImpl.
//     */
//    @Ignore
//    public void testGetJobById() {
//        System.out.println("getJobById");
//        int jobId = 0;
//        JobDaoImpl instance = new JobDaoImpl();
//        Job expResult = null;
//        Job result = instance.getJobById(jobId);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//}
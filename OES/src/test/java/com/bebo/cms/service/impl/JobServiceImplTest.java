///*
// * To change this template, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.bebo.cms.service.impl;
//
//import com.bebo.cms.dao.impl.JobDaoImpl;
//import com.bebo.cms.model.Job;
//import org.junit.After;
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import static org.junit.Assert.*;
//import org.junit.Ignore;
//
///**
// *
// * @author bbansal
// */
//public class JobServiceImplTest {
//    
//    public JobServiceImplTest() {
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
//     * Test of addJob method, of class JobServiceImpl.
//     */
//    @Test
//    public void testAddJob() {
//        System.out.println("addJob");
//        Job job = new Job();
//        job.setName("qa");
//        job.setDescription("skjfhhsfs");
//        job.setStatus("open");
//        job.setTeam(null);
//        
//        JobDaoImpl jdi = new JobDaoImpl();
//        jdi.addJob(job);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of updateJob method, of class JobServiceImpl.
//     */
//    @Ignore
//    public void testUpdateJob() {
//        System.out.println("updateJob");
//        Job job = null;
//        JobServiceImpl instance = new JobServiceImpl();
//        instance.updateJob(job);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of deleteJob method, of class JobServiceImpl.
//     */
//    @Ignore
//    public void testDeleteJob() {
//        System.out.println("deleteJob");
//        Job job = null;
//        JobServiceImpl instance = new JobServiceImpl();
//        instance.deleteJob(job);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getJobById method, of class JobServiceImpl.
//     */
//    @Ignore
//    public void testGetJobById() {
//        System.out.println("getJobById");
//        int jobId = 0;
//        JobServiceImpl instance = new JobServiceImpl();
//        Job expResult = null;
//        Job result = instance.getJobById(jobId);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//}
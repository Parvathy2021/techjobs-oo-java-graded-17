package org.launchcode.techjobs.oo;

import org.junit.Test;

import javax.swing.plaf.synth.SynthLookAndFeel;

import static org.junit.Assert.*;

public class JobTest {
    //TODO: Create your unit tests here
// TASK 4
    @Test
    public void testSettingJobId(){
        Job job1 = new Job();
        Job job2 = new Job();

        assertNotEquals(job1.getId(),job2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields(){
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertEquals("Product tester", job.getName());
        assertEquals("ACME", job.getEmployer().getValue());
        assertEquals("Desert", job.getLocation().getValue());
        assertEquals("Quality control", job.getPositionType().getValue());
        assertEquals("Persistence", job.getCoreCompetency().getValue());

        assertTrue(job.getName() instanceof String);
        assertTrue(job.getEmployer() instanceof Employer);
        assertTrue(job.getLocation() instanceof Location);
        assertTrue(job.getPositionType() instanceof PositionType);
        assertTrue(job.getCoreCompetency() instanceof CoreCompetency);

    }

    @Test
    public void testJobsForEquality(){
        Job newJob1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job newJob2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertNotEquals(newJob1, newJob2);
    }

// TASK 5: #1
    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertEquals(job1.toString().startsWith(System.lineSeparator()), true);
        assertEquals(job1.toString().endsWith(System.lineSeparator()), true);

    }
  // Task 5: #2
  @Test
  public void testToStringContainsCorrectLabelsAndData(){
        Job job1 =new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
         int id = job1.getId();

        assertTrue(job1.toString().contains("ID: "+ id + System.lineSeparator()));
        assertTrue(job1.toString().contains("Name: "+ job1.getName() + System.lineSeparator()));
        assertTrue(job1.toString().contains("Employer: "+ job1.getEmployer() + System.lineSeparator()));
        assertTrue(job1.toString().contains("Location: "+ job1.getLocation() + System.lineSeparator()));
        assertTrue(job1.toString().contains("Position Type: "+ job1.getPositionType()+ System.lineSeparator()));
        assertTrue(job1.toString().contains("Core Competency: "+ job1.getCoreCompetency()+ System.lineSeparator()));

  }
  //TASK 5: #3
  @Test
    public void testToStringHandlesEmptyField(){
        Job job1 = new Job("", new Employer("ACME"), new Location("Desert"), new PositionType(""), new CoreCompetency(""));

      assertTrue(job1.toString().contains("Name: Data not available"+ System.lineSeparator()));
      assertTrue(job1.toString().contains("Employer: ACME"+ System.lineSeparator()));
      assertTrue(job1.toString().contains("Location: Desert"+ System.lineSeparator()));
      assertTrue(job1.toString().contains("Position Type: Data not available"+ System.lineSeparator()));
      assertTrue(job1.toString().contains("Core Competency: Data not available"));


  }
  //TASK 5: #4
    @Test
    public void testToCheckJobWithJustID(){
        Job emptyJob = new Job();
        assertTrue(emptyJob.toString().contains("OOPS! This job does not seem to exist"));
    }
}

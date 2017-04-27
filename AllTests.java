package com.neet.DiamondHunter.JUnit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import junit.framework.Test;
import junit.framework.TestSuite;

@RunWith(Suite.class)
@SuiteClasses({ AnimationTest.class, DataTest.class, DiamondTest.class, EntityTest.class, ItemTest.class, PlayerTest.class, SparkleTest.class })
public class AllTests {
	public static Test suite() {
	TestSuite suite = new TestSuite(AllTests.class.getName());
	//$JUnit-BEGIN$

	//$JUnit-END$
	return suite;
	}
}

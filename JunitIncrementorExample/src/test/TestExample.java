package test;

import static org.junit.Assert.assertFalse;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


@RunWith(Parameterized.class)
public class TestExample {

	private int runCount;
	private static final int maxRuns = 200;

	public TestExample(int number) {
		this.runCount = number;
	}
	
	
	@Rule
	public TestWatcher watchman = new TestWatcher() {	
		
		@Override
		protected void succeeded(Description d) {
			incrementor.incrementPwd();
			incrementor.incrementUser();
		}
	};
	
	@Rule
	public Incrementor incrementor = Incrementor.getInstance();
	
	
	@Test
	public void test() {
		System.out.println("Run Count:" + runCount);
		boolean shouldIFail = false;
		Double d = Math.random();
		if (d < .5) {
			/*
			incrementor.incrementPwd();
			incrementor.incrementUser();
			*/
		} else {
			System.out.println("Fail");
			shouldIFail = true;
		}

		System.out.println("Current:" + incrementor.getCurrentUser() + "|" + incrementor.getCurrentPwd());
		assertFalse(shouldIFail);
	}
	
	@Parameterized.Parameters
	public static Collection<Object[]> data() {
		Collection<Object[]> data = new ArrayList<Object[]>();
		Object[] runCountArg;
		for (int i=0;i<maxRuns;i++) {
			runCountArg = new Object[] { i };
			data.add(runCountArg);
		}
		return data;
	}
	
	

}

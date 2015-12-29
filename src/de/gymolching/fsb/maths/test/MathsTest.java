package de.gymolching.fsb.maths.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.gymolching.fsb.api.FSBPosition;
import de.gymolching.fsb.regulation.Regulation;

public class MathsTest {

	public MathsTest() {

	}

	@Test
	public void testCalculatePosition_rot_0_0_0_mv_0_0_0() {
		FSBPosition pos = Regulation.calculatePosition(0, 0, 0, 0, 0, 0);
		FSBPosition posExpected = new FSBPosition(160, 160, 160, 160, 160, 160);
		assertEquals(posExpected, pos);
	}

	@Test
	public void testCalculatePosition_rot_0_300_0_mv_0_0_0() {
		FSBPosition pos = Regulation.calculatePosition(0, 0, 0, 0, 300, 0);
		FSBPosition posExpected = new FSBPosition(226, 113, 226, 113, 226, 113);
		assertEquals(posExpected, pos);
	}
	
}

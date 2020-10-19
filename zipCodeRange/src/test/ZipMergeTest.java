package test;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Range;
import main.ZipCode;
import main.ZipCodeProcessor;

class ZipMergeTest {
	List<Range> zip;
	List<Range> res;
	ZipCodeProcessor zipcodeProcessor;
	
	@BeforeEach
	public void setup(){
		System.out.println("SetUp Method");
		zip = new ArrayList<>();
		res = new ArrayList<>();
		zipcodeProcessor = new ZipCodeProcessor();
	}
	
	@Test
	public void testCase1() {
//		input: [94133,94133] [94200,94299] [94600,94699]
//		output: [94133,94133] [94200,94299] [94600,94699]
		Range zip1 = new Range(94133,94133);
		Range zip2 = new Range(94200,94299);
		Range zip3 = new Range(94600,94699);
		zip.add(zip3);
		zip.add(zip2);
		zip.add(zip1);
		res = zip;
		List<Range> result = ZipCode.merge(zip);
		Assertions.assertEquals(res, result);
	}
	
	@Test
	public void testCase2() {
//		input: [94133,94133] [94200,94299] [94226,94399] 
//		output: [94133,94133] [94200,94399]	
		Range zip1 = new Range(94133,94133);
		Range zip2 = new Range(94200,94299);
		Range zip3 = new Range(94226,94399);
		Range zip4 = new Range(94200,94399);
		zip.add(zip1);
		zip.add(zip2);
		zip.add(zip3);
		res.add(zip1);
		res.add(zip4);
		List<Range> result = ZipCode.merge(zip);
		Assertions.assertEquals(res, result);
	}

	@Test
	public void Should_Throw_Exception_Illegal_Bound_Number() {
		System.out.println(
				"Should_Throw_Exception If zip code range do not meet the requirement of only have upper and lower bound");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			zipcodeProcessor.getRangeList("[94133,94133,99999] [94200,94299]");
		});
	}
	
	@Test
	public void Should_Throw_Exception_Illegal_Zip_Code() {
		System.out.println(
				"Should_Throw_Exception If zip code do not meet the requirement of have 5 digits");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			zipcodeProcessor.getRangeList("[94133,9413] [94200,94299]");
		});
	}
	
	@Test
	public void Should_Throw_Exception_Illegal_Zip_Code_Range() {
		System.out.println(
				"Should_Throw_Exception If zip code do not meet the requirement of upper bound greater than lower bound");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			zipcodeProcessor.getRangeList("[99999,94133] [94200,94299]");
		});
	}
	
	@Test
	public void Should_Throw_Exception_Negative_Zip_Code_Number() {
		System.out.println(
				"Should_Throw_Exception If zip code do not meet the requirement of only be positive number");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			zipcodeProcessor.getRangeList("[-99999,941333] [94200,94299]");
		});
	}
	
	@AfterEach
	public void teardown(){
		System.out.println("TearDown Method");
		zip = new ArrayList<>();
		res = new ArrayList<>();
		zipcodeProcessor = new ZipCodeProcessor();
	}
}

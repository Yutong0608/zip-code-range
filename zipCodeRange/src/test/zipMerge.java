package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.ZipCode;

class zipMerge {
	List<List<Integer>> zip;
	List<List<Integer>> res;
	
	@BeforeEach
	public void setup(){
		System.out.println("SetUp Method");
		zip = new ArrayList<>();
		res = new ArrayList<>();
	}
	
	@Test
	public void testCase2() {
//		[94133,94133] [94200,94299] [94600,94699]
		List<Integer> zip1 = new ArrayList<>();
		zip1.add(94133);
		zip1.add(94133);
		List<Integer> zip2 = new ArrayList<>();
		zip2.add(94200);
		zip2.add(94299);
		List<Integer> zip3 = new ArrayList<>();
		zip3.add(94600);
		zip3.add(94699);
		List<Integer> zip4 = new ArrayList<>();
		zip4.add(94200);
		zip4.add(94399);
		zip.add(zip1);
		zip.add(zip2);
		zip.add(zip3);
		res = zip;
		List<List<Integer>> result = ZipCode.merge(zip);
		Assertions.assertEquals(res, result);
	}
	
	@Test
	public void testCase1() {
//		[94133,94133] [94200,94299] [94226,94399] 
		List<Integer> zip1 = new ArrayList<>();
		zip1.add(94133);
		zip1.add(94133);
		List<Integer> zip2 = new ArrayList<>();
		zip2.add(94200);
		zip2.add(94299);
		List<Integer> zip3 = new ArrayList<>();
		zip3.add(94226);
		zip3.add(94399);
		List<Integer> zip4 = new ArrayList<>();
		zip4.add(94200);
		zip4.add(94399);
		zip.add(zip1);
		zip.add(zip2);
		zip.add(zip3);
		res.add(zip1);
		res.add(zip4);
		List<List<Integer>> result = ZipCode.merge(zip);
		Assertions.assertEquals(res, result);
	}
	
	@AfterEach
	public void teardown(){
		System.out.println(res);
		System.out.println("TearDown Method");
		zip = new ArrayList<>();
		res = new ArrayList<>();
	}
}

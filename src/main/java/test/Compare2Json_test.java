package test;

import java.io.File;
import assertions.Compare2Json;



public class Compare2Json_test 
{
	/*
	 Test class to test functions of Compare2Json class. 
	*/
	
	public static void main(String[] args) throws Exception {
	
	Compare2Json compare=new Compare2Json();
	File file1 =new File("./resources_test/json_files/test.json");
	File file2 =new File("./resources_test/json_files/test2.json");
	compare.comparejson(file1,file2);
	
}}

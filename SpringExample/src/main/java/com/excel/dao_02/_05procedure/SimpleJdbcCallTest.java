package com.excel.dao_02._05procedure;
/*

steps:
1. create datasource
2. pass datasource to subclass of StoredProcedure which is a static innerclass
3. Register all in & out parameters
4. read data from Map object, set to bean class object & display
 */

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;
import org.springframework.jdbc.datasource.*;

public class SimpleJdbcCallTest {
	public static void main(String args[]) {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		dataSource.setUsername("hr");
		dataSource.setPassword("hr");			
		Employee emp =(Employee) 
				getEmployeeDetailsWithStoredProcedure(dataSource,"Lex");
		System.out.println("Allen Details : " + emp);
	}

	private static Object getEmployeeDetailsWithStoredProcedure
	(DataSource ds, String ename) {

		MyStoredProcedure sp = new MyStoredProcedure(ds);
		//call procedure
		Map results = sp.myexecute(ename);
		//set outparmeter values to emp object
		Employee emp = new Employee();
		emp.setName(ename);
		emp.setNo((Integer)results.get("EMPLOYEE_ID"));
//		emp.setDesignation((String)results.get("DESG"));
//		emp.setSalary((Double)results.get("SALARY"));

		return emp;
	}//method2
	private static class MyStoredProcedure extends StoredProcedure {
		public MyStoredProcedure(DataSource ds) {
			super(ds, "SHOW_EMPLOYEES");
			this.setFunction(false); //false -> indicates its a stored procedure

			SqlParameter[] params = {
					new SqlParameter("FIRST_NAME", Types.VARCHAR),
					new SqlOutParameter("EMPLOYEE_ID", Types.INTEGER),
//					new SqlOutParameter("DESG", Types.VARCHAR),
//					new SqlOutParameter("SALARY", Types.DOUBLE)
			};
			this.setParameters(params);
			compile();
		}//constructor

		public Map myexecute(String name) {
			HashMap map = new HashMap();
			map.put("FIRST_NAME",name);
			return super.execute(map);
		}

	}//inner class
}//outerclass

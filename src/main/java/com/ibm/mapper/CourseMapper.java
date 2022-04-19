package com.ibm.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import com.ibm.bean.Course;


public class CourseMapper implements RowMapper<Course>{

	@Override
	public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		
            Course course = new Course();
            course.setCourseId(rs.getInt("id"));
            course.setCourseName(rs.getString("name"));
            course.setFees(rs.getInt("fees"));
            course.setProf(rs.getString("professor"));
            return course;
    }
	// }
    // private int courseId;
	// private String courseName;
	// private int fees;
	// private int seats;
	// private String prof;

}
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class mainApplicationAssignment {

	public static void main(String[] args) {

		List<Student> students = getAllStudents();
		
		HashMap<Course, List<Student>> mapper = students.stream()
				.reduce(new HashMap<Course,List<Student>>(), 
						(acc,st)->{
							st.getCourses().forEach(
									course->{
										List<Student> studentList = acc.get(course);
										if (studentList==null) studentList = new ArrayList<>();
										studentList.add(st);			
										acc.put(course,studentList);
										}
									);
							return acc;
						}
						
						, (a,b)->a);
			
			
			System.out.println(mapper);

	}
	
	private static List<Student> getAllStudents()
	{
		Student student1 = new Student("Ahmad", 20, Gender.MALE, true, Arrays.asList(Course.MATH, Course.CHEMESTRY,Course.JAVA));
		  Student student2 = new Student("Mohammad", 25, Gender.MALE, true,Arrays.asList(Course.MATH, Course.JAVA));
		  Student student3 = new Student("Essa",27, Gender.MALE,true,Arrays.asList(Course.MATH, Course.JAVA));
		  Student student4 = new Student("Esra",19, Gender.FEMALE,true,Arrays.asList(Course.MATH, Course.ENGLISH));
		  Student student5 = new Student("Dana",40, Gender.FEMALE,true,Arrays.asList(Course.MATH, Course.ENGLISH));
		  Student student6 = new Student("Ruba",22, Gender.FEMALE,true,Arrays.asList(Course.MATH, Course.ENGLISH));
		 
		 List<Student> students = Arrays.asList(student1,student2,student3,student4,student5,student6);
		 return students;
	}

}

package com.la.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.la.dao.ClassesDao;
import com.la.dao.StudentDao;
import com.la.dao.SubjectDao;
import com.la.dao.TeacherDao;
import com.la.entity.Classes;
import com.la.entity.Student;
import com.la.entity.Subject;
import com.la.entity.Teacher;

/**
 * Servlet implementation class ControllerServlet
 */
@WebServlet("/")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SubjectDao subjectDao;
	private ClassesDao classesDao;
	private TeacherDao teacherDao;
	private StudentDao studentDao;
	

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControllerServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void init() {
		subjectDao = new SubjectDao();
		classesDao = new ClassesDao();
		teacherDao = new TeacherDao();
		studentDao = new StudentDao();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		String action = request.getServletPath();
		try {
			switch (action) {
			case "/new-subject":
				showNewSubjectForm(request, response);
				break;
			case "/insert-subject":
				insertSubject(request, response);
				break;
			case "/new-class":
				showNewClassForm(request, response);
				break;
			case "/insert-class":
				insertClass(request, response);
				break;
			case "/list-class":
				listClasses(request, response);
				break;
			case "/new-teacher":
				showNewTeacherForm(request, response);
				break;
			case "/insert-teacher":
				insertTeacher(request, response);
				break;
			case "/list-teacher":
				listTeacher(request, response);
				break;
			case "/new-student":
				showNewStudentForm(request,response);
				break;
			case "/insert-student":
				insertStudent(request,response);
				break;
			case "/list-student":
				listStudent(request, response);
				break;
			case "/add-subject":				
				addSubject(request, response);
				break;
			case "/link-class-subj":				
				linkSubjectTeacherToClass(request, response);
				break;
			case "/add-stud-class":
				System.out.println("Enroll student");
				enrollStudentToCourse(request, response);
			case "/add-student":
				addStudenttoClass(request,response);
				break;
			case "/link-class-stud":
				enrollStudentToCourse(request,response);
				break;
			case "/enrol-report":
				enrollmentReport(request, response);
			default:
				listSubject(request,response);
				break;
			}
		} catch (Exception ex) {
			throw new ServletException(ex);
		}
	}
	
	private void listSubject(HttpServletRequest request, HttpServletResponse response)
	throws SQLException, IOException, ServletException {
		List<Subject> listSubject = subjectDao.getAllSubject();
		System.out.println(listSubject);
		for(Subject s : listSubject) {
			System.out.println(s.getDesc());
		}
		request.setAttribute("listSubject", listSubject);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("list-subject.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewSubjectForm(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException
	{
		List<Teacher> listTeacher = teacherDao.getAllTeacher();
		request.setAttribute("listTeacher", listTeacher);
		RequestDispatcher dispatcher = request.getRequestDispatcher("subject-form.jsp");
		dispatcher.forward(request, response);
	}
	
	private void insertSubject(HttpServletRequest request, HttpServletResponse response) 
	throws SQLException, IOException {
		String subject_desc = request.getParameter("sdesc");
		String teacher1 = request.getParameter("teacher1");
		System.out.println("Teacher - " + teacher1);
		Subject sub = new Subject();
		sub.setDesc(subject_desc);
		sub.setTid(Integer.parseInt(teacher1));
		subjectDao.saveSubject(sub);
		response.sendRedirect("list");
	}
	
	private void showNewClassForm(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("class-form.jsp");
		dispatcher.forward(request, response);
	}
		
	private void insertClass(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		Date sdate = null;
		Date edate = null;
		DateFormat df = new SimpleDateFormat("YYYYMMDD",Locale.US);
		String class_name = request.getParameter("className");
		System.out.println(class_name);
		try {
			System.out.println(request.getParameter("sDate"));
			System.out.println(request.getParameter("eDate"));
			sdate = df.parse(request.getParameter("sDate"));
			
			edate = df.parse(request.getParameter("eDate"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Classes lacal = new Classes();
		lacal.setClassName(class_name);
		lacal.setsDate(sdate);
		lacal.seteDate(edate);
		classesDao.saveClasses(lacal);
		response.sendRedirect("list");
	}
	
	private void listClasses(HttpServletRequest request, HttpServletResponse response) 
	throws SQLException, ServletException, IOException 
	{
		List<Classes> allClasses = classesDao.getAllClasses();
		request.setAttribute("listClasses", allClasses);
		RequestDispatcher dispatcher = request.getRequestDispatcher("list-classes.jsp");
		dispatcher.forward(request, response);
	}
	
	private void showNewTeacherForm(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("teacher-form.jsp");
		dispatcher.forward(request, response);
	}
	
	private void insertTeacher(HttpServletRequest request, HttpServletResponse response)
	throws SQLException, ServletException, IOException {
		String first_name = request.getParameter("firstname");
		String last_name = request.getParameter("lastname");
		String email = request.getParameter("email");
		String skillset = request.getParameter("skillset");
		Teacher tech = new Teacher();
		tech.setFirst_name(first_name);
		tech.setLast_name(last_name);
		tech.setEmail(email);
		tech.setSkillset(skillset);
		teacherDao.saveTeacher(tech);
		response.sendRedirect("list");
	}
	
	private void listTeacher(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		System.out.println("Inside list teacher");
		List<Teacher> allTeacher = teacherDao.getAllTeacher();
		request.setAttribute("listTeacher", allTeacher);
		RequestDispatcher dispatcher = request.getRequestDispatcher("list-teacher.jsp");
		dispatcher.forward(request, response);
	}
	
	
	private void showNewStudentForm(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("student-form.jsp");
		dispatcher.forward(request, response);
	}
	
	private void insertStudent(HttpServletRequest request, HttpServletResponse response)
	throws SQLException, ServletException, IOException {
		String first_name = request.getParameter("firstname");
		String last_name = request.getParameter("lastname");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		Student student = new Student();
		student.setFirst_name(first_name);
		student.setLast_name(last_name);
		student.setEmail(email);
		student.setPhone(phone);
		studentDao.saveStudent(student);
		response.sendRedirect("list");
	}
	
	private void listStudent(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException {
		System.out.println("Inside list student");
		List<Student> allStudent = studentDao.getAllStudent();
		List<Classes> allClasses = classesDao.getAllClasses();
		request.setAttribute("listStudent", allStudent);
		request.setAttribute("listClasses", allClasses);
		RequestDispatcher dispatcher = request.getRequestDispatcher("list-student.jsp");
		dispatcher.forward(request, response);
	}
	
	private void addSubject(HttpServletRequest request, HttpServletResponse response)
	throws SQLException, ServletException, IOException {
		int cid = Integer.parseInt(request.getParameter("cid"));
		System.out.println("Course Id : " + cid);
		Classes existingClass = classesDao.getClassId(cid);
		List<Subject> subjects = subjectDao.getAllSubject();
		List<Teacher> teachers = teacherDao.getAllTeacher();
		RequestDispatcher dispatcher = request.getRequestDispatcher("class-subject.jsp");
		request.setAttribute("classes", existingClass);
		request.setAttribute("subjects", subjects);
		request.setAttribute("teachers", teachers);
		dispatcher.forward(request, response);		
	}
	
	private void linkSubjectTeacherToClass(HttpServletRequest request, HttpServletResponse response)
	throws SQLException, ServletException, IOException {
		/*
		 * System.out.println("Course Id : " + request.getParameter("cid"));
		 * System.out.println("Subject Id : " + request.getParameter("subject1"));
		 * System.out.println("Teacher Id : " + request.getParameter("teacher1"));
		 * System.out.println("Subject Id : " + request.getParameter("subject2"));
		 * System.out.println("Teacher Id : " + request.getParameter("teacher2"));
		 * System.out.println("Subject Id : " + request.getParameter("subject3"));
		 * System.out.println("Teacher Id : " + request.getParameter("teacher3"));
		 */

		int cid = Integer.parseInt(request.getParameter("cid"));
		Classes existingClass = classesDao.getClassId(cid); 
		List<Classes> laclass = new ArrayList<Classes>();
		laclass.add(existingClass);
		
		Subject subject1 = subjectDao.getSubjectId(Integer.parseInt(request.getParameter("subject1")));
		subject1.setLaclass(laclass);
		subjectDao.updateSubject(subject1);
		
		Subject subject2 = subjectDao.getSubjectId(Integer.parseInt(request.getParameter("subject2")));	
		subject2.setLaclass(laclass);
		subjectDao.updateSubject(subject2);

		Subject subject3 = subjectDao.getSubjectId(Integer.parseInt(request.getParameter("subject3")));
		subject3.setLaclass(laclass);
		subjectDao.updateSubject(subject3);
	
		//subject2.setTeacher(teacher2);
		//subject3.setTeacher(teacher3);
		//System.out.println(existingClass.getClassName()); 
		//List<Subject> classSubj = new ArrayList<Subject>();
		//classSubj.add(subject1);
		//classSubj.add(subject2);
		//classSubj.add(subject3);
		//existingClass.setSubject(classSubj);
		//classesDao.updateClasses(existingClass);
		
		 /*RequestDispatcher dispatcher = request.getRequestDispatcher("class-subject.jsp");
		 * request.setAttribute("classes", existingClass); dispatcher.forward(request,
		 * response);
		 */			
		response.sendRedirect("list");
	}
	
	private void addStudenttoClass(HttpServletRequest request, HttpServletResponse response)
	throws SQLException, ServletException, IOException {
		int cid = Integer.parseInt(request.getParameter("cid"));
		System.out.println("Course Id in Add Student: " + cid);
		Classes existingClass = classesDao.getClassId(cid);
		List<Student> students = studentDao.getAllStudent();
		RequestDispatcher dispatcher = request.getRequestDispatcher("class-student.jsp");
		request.setAttribute("classes", existingClass);
		request.setAttribute("students", students);
		dispatcher.forward(request, response);	
	}
	
	private void enrollStudentToCourse(HttpServletRequest request, HttpServletResponse response) 
	throws SQLException, ServletException, IOException
	{
		int cid = Integer.parseInt(request.getParameter("cid"));
		Classes existingClass = classesDao.getClassId(cid); 
		List<Classes> laclass = new ArrayList<Classes>();
		laclass.add(existingClass);
				
		System.out.println("Student 1 - " + request.getParameter("student1"));
		Student student1 = studentDao.getStudentId((Integer.parseInt(request.getParameter("student1"))));	
		student1.setSclasses(laclass);
		studentDao.updateStudent(student1);
		
		Student student2 = studentDao.getStudentId((Integer.parseInt(request.getParameter("student2"))));
		student2.setSclasses(laclass);
		studentDao.updateStudent(student2);
		
		Student student3 = studentDao.getStudentId((Integer.parseInt(request.getParameter("student3"))));
		student3.setSclasses(laclass);
		studentDao.updateStudent(student3);
		
		/*
		 * List<Student> laStudent = new ArrayList<Student>(); laStudent.add(student1);
		 * laStudent.add(student2); laStudent.add(student3);
		 * existingClass.setStudent(laStudent); classesDao.updateClasses(existingClass);
		 */
		response.sendRedirect("list");
	}
	
	private void enrollmentReport(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		List<Classes> allClasses = classesDao.getAllClasses();
		request.setAttribute("listClasses", allClasses);				
		/*
		 * List<Student> students = new ArrayList<Student>();
		 * 
		 * List<String> rows = new ArrayList<String>(); List<String> cols = new
		 * ArrayList<String>();
		 * 
		 * for(Classes cal : allClasses) { System.out.println(cal.getCid() + " - " +
		 * cal.getClassName()); cols.add(cal.getCid()+""); cols.add(cal.getClassName());
		 * cols.add(cal.getsDate().toString()); cols.add(cal.geteDate().toString());
		 * students = cal.getStudent(); System.out.println(students); for(Student stud :
		 * students) { System.out.println(stud.getEmail());
		 * cols.add(stud.getFirst_name()); cols.add(stud.getLast_name());
		 * cols.add(stud.getEmail()); cols.add(stud.getPhone()); } rows.addAll(cols); }
		 */
		//request.setAttribute("enrollList", rows);
		RequestDispatcher dispatcher = request.getRequestDispatcher("enroll-list.jsp");
		dispatcher.forward(request, response);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

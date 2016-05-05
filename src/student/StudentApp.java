package student;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Display reminders of students having a birthday soon.
 * @author Piromsurang
 */
public class StudentApp {
	
	static int month = LocalDate.now().getMonthValue();
	/**
	 * Print the names (and birthdays) of students having a birtday in the
	 * specified month.
	 * @param students list of students
	 * @param month the month to use in selecting bithdays
	 */
	public void filterAndPrint( List<Student> students, Predicate<Student> filter, Consumer<Student> action, Comparator<Student> sorter ) {
		students.stream().filter( filter ).sorted( sorter ).forEach( action );
	}
	
	public static void main(String[] args) {

		List<Student> students = Registrar.getInstance().getStudents();
		StudentApp app = new StudentApp();
		Predicate<Student> isBirthday = ( s ) -> ( s.getBirthdate().getMonthValue() == month );
		Consumer<Student> action = ( s ) -> System.out.println( s + " will have birthday on " + s.getBirthdate().getDayOfMonth() + " " + s.getBirthdate().getMonth() );
		Comparator<Student> byName = ( a, b ) -> a.getFirstname().charAt( 0 ) - b.getFirstname().charAt( 0 );
		Comparator<Student> byBirthdate = ( a, b ) -> a.getBirthdate().getDayOfYear() - b.getBirthdate().getDayOfYear();
		Predicate<Student> isBirthdayIntwoWeek = ( s ) -> ( (s.getBirthdate().getDayOfYear() - LocalDate.now().getDayOfYear() ) < 14 && 
				( s.getBirthdate().getDayOfYear() - LocalDate.now().getDayOfYear() ) > 0  );
		System.out.println( "By name " );
		students.sort( byName );
		System.out.println( students.toString() );
		System.out.println( "By birthday" );
		students.sort( byBirthdate );
		System.out.println( students.toString() );
		System.out.println( "By birthday in two week");
		for ( Student s : students ) {
			if ( isBirthdayIntwoWeek.test(s) ) {
				System.out.println( s );
			}
		}
		
		System.out.println( "filterandprint" );
		app.filterAndPrint(students, isBirthday, action, byBirthdate );
	}
}

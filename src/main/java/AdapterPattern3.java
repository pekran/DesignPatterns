import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AdapterPattern3 {
    public static void main(String[] args) {
        List<Araz> araz = Arrays.asList(
                new Araz("2122", true, "Java"),
                new Araz("21222", true, "Java"),
                new Araz("212222", false, "Java")
        );

        List<Elnaz> elnaz = Arrays.asList(
                new Elnaz("3434", true, "Matlab"),
                new Elnaz("9932", true, "Swiming")
        );
        System.out.println(CoursesState.passed(araz));
        System.out.println(CoursesState.courseIds(araz));
        System.out.println(CoursesState.courseName(araz));
        System.out.println("-------------------------------------------------------");
        System.out.println(CourseStateAdapt.courseId(elnaz));
        System.out.println(CourseStateAdapt.passed(elnaz));
        System.out.println(CourseStateAdapt.courseName(elnaz));
    }
}

class Araz {

    private final String courseId;
    private final boolean passed;
    private final String courseName;


    public Araz(String courseId, boolean passed, String courseName) {
        this.courseId = courseId;
        this.passed = passed;
        this.courseName = courseName;
    }

    public String getCourseId() {
        return courseId;
    }

    public boolean isPassed() {
        return passed;
    }

    public String getCourseName() {
        return courseName;
    }
}


class CoursesState {
    public static List<String> courseIds(List<Araz> arazObjects) {
        List<String> courseIds = new ArrayList<>();
        for (Araz araz : arazObjects) {
            courseIds.add(araz.getCourseId());
        }
        return courseIds;
    }

    public static long passed(List<Araz> arazObjects) {
        long count = arazObjects.stream().filter(Araz::isPassed).count();
        return count;
    }

    public static List<String> courseName(List<Araz> arazObjects) {
        List<String> courseNames = new ArrayList<>();
        for (Araz araz : arazObjects) {
            courseNames.add(araz.getCourseName());
        }
        return courseNames;
    }
}

class Elnaz {
    private final String courseId;
    private final boolean passed;
    private final String Name;

    public Elnaz(String courseId, boolean passed, String name) {
        this.courseId = courseId;
        this.passed = passed;
        Name = name;
    }

    public String getCourseId() {
        return courseId;
    }

    public boolean isPassed() {
        return passed;
    }

    public String getName() {
        return Name;
    }
}

class CourseStateAdapt {

    public static List<String> courseId(List<Elnaz> elnazObjects) {
        return CoursesState.courseIds(adapt(elnazObjects));
    }

    public static long passed(List<Elnaz> elnazObjects) {
       return CoursesState.passed(adapt(elnazObjects));
    }

    public static List<String> courseName(List<Elnaz> elnazObjects) {
       return CoursesState.courseName(adapt(elnazObjects));
    }

    private static List<Araz> adapt(List<Elnaz> elnazObjects) {
        // for loop each item and map it
        List<Araz> Arazs = new ArrayList<>();
        for (Elnaz elnaz : elnazObjects) {
            Arazs.add(ElnazToAraz(elnaz));
        }
        return Arazs;
    }
        public static Araz ElnazToAraz(Elnaz elnazObject){
            return new Araz(elnazObject.getCourseId(),elnazObject.isPassed(),elnazObject.getName());
        }
}
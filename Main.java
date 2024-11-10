import java.util.*;


class Course {
     String courseName;
     String courseCode;
     String instructorName;
    //public int numOfStudents;
    public Course(String courseName, String courseCode, String instructorName) {
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.instructorName = instructorName;
       // this.numOfStudents = numOfStudents;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getInstructorName() {
        return instructorName;
    }

    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }

  /*  public int getNumOfStudents() {
        return numOfStudents;
    }

    public void setNumOfStudents(int numOfStudents) {
        this.numOfStudents = numOfStudents;
    } */
}

class TimeSlot {
     String dayOfWeek;
     int startTime;
    int endTime;
    public TimeSlot(String dayOfWeek, int startTime, int endTime) {
        this.dayOfWeek = dayOfWeek;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }
}

class Timetable {
    public ArrayList<Course> courses;
    public ArrayList<TimeSlot> timeSlots;
    public Timetable() {
        this.courses = new ArrayList<Course>();
        this.timeSlots = new ArrayList<TimeSlot>();
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void removeCourse(int index) {
        courses.remove(index);
    }

    public void addTimeSlot(TimeSlot timeSlot) {
        timeSlots.add(timeSlot);
    }

    public void removeTimeSlot(int index) {
        timeSlots.remove(index);
    }

    public void displayTimetable() {
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("|                             TIMETABLE                                     |");
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("| Course Name | Course Code | Instructor Name | Day | Start Time | End Time |");
        System.out.println("-----------------------------------------------------------------------------");
        for (Course course : courses) {
            for (TimeSlot timeSlot : timeSlots) {
                System.out.printf("| %-12s| %-12s| %-16s| %-4s| %-10d| %-9d|\n",
                        course.getCourseName(),
                        course.getCourseCode(),
                        course.getInstructorName(),
                        timeSlot.getDayOfWeek(),
                        timeSlot.getStartTime(),
                        timeSlot.getEndTime());
            }
        }
        System.out.println("-----------------------------------------------------------------------------");
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Timetable timetable = new Timetable();
        System.out.println("--------------------WELCOME TO TIME TABLE MANAGEMENT SYSTEM---------------------");
        while (true) {
            try {

                System.out.println("1. Add Course");
                System.out.println("2. Add Time Slot");
                System.out.println("3. Remove Course");
                System.out.println("4. Remove Time Slot");
                System.out.println("5. Display Timetable");
                System.out.println("6. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:

                        System.out.print("Enter course name: ");
                        String courseName = scanner.next();
                        System.out.print("Enter course code: ");
                        String courseCode = scanner.next();
                        System.out.print("Enter instructor name: ");
                        String instructorName = scanner.next();
                        //  System.out.print("Enter number of students: ");
                        //int numOfStudents = scanner.nextInt();
                        Course course = new Course(courseName, courseCode, instructorName);
                        timetable.addCourse(course);
                        System.out.println("Course Added Successfully.....Now Add Timeslot....");
                        break;

                    case 2:

                        System.out.print("Enter day of week: ");
                        String dayOfWeek = scanner.next();
                        System.out.print("Enter start time: ");
                        int startTime = scanner.nextInt();
                        System.out.print("Enter end time: ");
                        int endTime = scanner.nextInt();
                        TimeSlot timeSlot = new TimeSlot(dayOfWeek, startTime, endTime);
                        timetable.addTimeSlot(timeSlot);
                        System.out.println("Timeslot Added Successfully....");

                        break;


                    case 3:


                        System.out.print("Enter course code to remove: ");
                        courseCode = scanner.next();
                        for (int i = 0; i < timetable.courses.size(); i++) {
                            if (timetable.courses.get(i).getCourseCode().equals(courseCode)) {
                                timetable.removeCourse(i);
                                break;
                            }
                        }
                        System.out.println("Course removed successfully.....");
                        break;

                    case 4:

                        System.out.print("Enter day of week to remove: ");
                        dayOfWeek = scanner.next();
                        System.out.print("Enter start time to remove: ");
                        startTime = scanner.nextInt();
                        System.out.print("Enter end time to remove: ");
                        endTime = scanner.nextInt();
                        for (int i = 0; i < timetable.timeSlots.size(); i++) {
                            TimeSlot t = timetable.timeSlots.get(i);
                            if (t.getDayOfWeek().equals(dayOfWeek) && t.getStartTime() == startTime && t.getEndTime() == endTime) {
                                timetable.removeTimeSlot(i);
                                break;
                            }
                        }


                        break;

                    case 5:
                        timetable.displayTimetable();
                        break;
                    case 6:
                        System.out.println("Exiting the program...");
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
            }
        }
    }
}


package com.example.timetable.controller;

import com.example.timetable.model.Course;
import com.example.timetable.model.TimeSlot;
import com.example.timetable.model.Timetable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/timetable")
public class TimetableController {

    private Timetable timetable = new Timetable();

    @PostMapping("/course")
    public String addCourse(@RequestBody Course course) {
        timetable.addCourse(course);
        return "Course added successfully";
    }

    @DeleteMapping("/course/{code}")
    public String removeCourse(@PathVariable String code) {
        timetable.removeCourse(code);
        return "Course removed successfully";
    }

    @PostMapping("/timeslot")
    public String addTimeSlot(@RequestBody TimeSlot slot) {
        timetable.addTimeSlot(slot);
        return "Time slot added successfully";
    }

    @DeleteMapping("/timeslot")
    public String removeTimeSlot(@RequestParam String day,
                                 @RequestParam int start,
                                 @RequestParam int end) {
        timetable.removeTimeSlot(day, start, end);
        return "Time slot removed successfully";
    }

    @GetMapping
    public Timetable getTimetable() {
        return timetable;
    }
}

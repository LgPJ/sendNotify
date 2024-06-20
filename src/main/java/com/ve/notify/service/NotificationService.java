package com.ve.notify.service;

import com.ve.notify.dto.NotificationRequestDto;
import com.ve.notify.entity.Student;
import com.ve.notify.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class NotificationService {

    @Autowired
    private StudentRepository studentRepository;

    public void notifyStudents(NotificationRequestDto request) {
        List<Student> students;
        switch (request.getListType()) {
            case "ListaA":
                students = studentRepository.findBySubjectAndLocation("Matemáticas", "Málaga");
                break;
            case "ListaB":
                students = studentRepository.findBySubjectAndLocation("Francés", "Málaga");
                break;
            case "ListaC":
                Set<String> allEmails = studentRepository.findBySubjectAndLocation("Matemáticas", "Málaga").stream()
                        .map(Student::getName)
                        .collect(Collectors.toSet());
                allEmails.addAll(studentRepository.findBySubjectAndLocation("Francés", "Málaga").stream()
                        .map(Student::getName)
                        .collect(Collectors.toSet()));
                sendEmail(allEmails, request.getMessage());
                return;
            default:
                throw new IllegalArgumentException("Tipo de lista no válido");
        }
        sendEmail(students, request.getMessage());
    }

    private void sendEmail(List<Student> students, String message) {
        for (Student student : students) {
            System.out.println("Enviando email a " + student.getName() + ": " + message);
        }
    }

    private void sendEmail(Set<String> studentNames, String message) {
        for (String name : studentNames) {
            System.out.println("Enviando email a " + name + ": " + message);
        }
    }
}
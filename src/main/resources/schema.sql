CREATE TABLE student (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    studentName VARCHAR(255) NOT NULL,
    dob DATE,
    email VARCHAR(255),
    fatherName VARCHAR(255),
    phone VARCHAR(15),
    state VARCHAR(50),
    address VARCHAR(255),
    studentNRC VARCHAR(15)
);

-- Insert Student 1
INSERT INTO studentdb.student (student_name, dob, email, father_name, phone, state, address, studentnrc)
VALUES ('Student 1', '2000-01-15', 'student1@example.com', 'Father 1', '1234567891', 'State 1', 'Address 1', 'NRC1');

-- Insert Student 2
INSERT INTO studentdb.student (student_name, dob, email, father_name, phone, state, address, studentnrc)
VALUES ('Student 2', '2000-02-15', 'student2@example.com', 'Father 2', '1234567892', 'State 2', 'Address 2', 'NRC2');

-- Insert Student 3
INSERT INTO studentdb.student (student_name, dob, email, father_name, phone, state, address, studentnrc)
VALUES ('Student 3', '2000-03-15', 'student3@example.com', 'Father 3', '1234567893', 'State 3', 'Address 3', 'NRC3');

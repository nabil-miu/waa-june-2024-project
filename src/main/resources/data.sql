CREATE
DATABASE IF NOT EXISTS `project` /*!40100 DEFAULT CHARACTER SET utf8 */;

INSERT INTO project.profile (id, academic_achievements, personal_bio, deleted)
VALUES (100, 'Bachelor of Science in Computer Science',
        'An enthusiastic developer with a passion for AI and machine learning.', false),
       (101, 'Bachelor of Arts in Graphic Design', 'Creative designer who loves to blend technology and art.', false),
       (102, 'Bachelor of Science in Computer Science',
        'An enthusiastic developer with a passion for AI and machine learning.', false),
       (103, 'Bachelor of Arts in Graphic Design', 'Creative designer who loves to blend technology and art.', false);

INSERT INTO project.user (id, academic_year, account_non_expired, account_non_locked, credentials_non_expired, active,
                          profile_id,
                          address, city, country, department, email, first_name, last_name,
                          major, password, phone, role, state, student_id, zip, user_type, deleted)
VALUES (1, '2023-09-01', 1, 1, 1, 1, 100, '123 Oak St.', 'Springfield', 'USA', 'Computer Science',
        'john.doe@example.com',
        'John', 'Doe',
        'Software Engineering', 'hashed_password123', '555-1234', 'STUDENT', 'MA', 'S1234567', '01101', 'STUDENT', false),
       (2, '2022-09-01', 1, 1, 1, 1, 101, '456 Maple St.', 'Rivertown', 'USA', 'Arts', 'jane.smith@example.com', 'Jane',
        'Smith',
        'Fine Arts', 'hashed_password456', '555-5678', 'STUDENT', 'NY', 'S7654321', '02202', 'STUDENT', false),
       (3, '2023-09-01', 1, 1, 1, 1, 102, '123 Oak St.', 'Springfield', 'USA', 'Computer Science',
        'john.doe2@example.com',
        'John', 'Doe',
        'Software Engineering', 'hashed_password123', '555-1234', 'STUDENT', 'MA', 'S1234567', '01101', 'STUDENT', false),
       (4, '2022-09-01', 1, 1, 1, 1, 103, '456 Maple St.', 'Rivertown', 'USA', 'Arts', 'jane.smith3@example.com',
        'Jane',
        'Smith',
        'Fine Arts', 'hashed_password456', '555-5678', 'STUDENT', 'NY', 'S7654321', '02202', 'STUDENT', false);

INSERT INTO project.event (id, local_date_time, location, name, description, deleted)
VALUES (1, '2023-07-01 18:00:00', 'Conference Hall A, Springfield University', 'Tech Talk 2023',
        'An annual gathering of tech enthusiasts to discuss emerging technologies.', false),
       (2, '2023-07-15 10:00:00', 'Auditorium B, Downtown Conference Center', 'Career Fair 2023',
        'A perfect place for students and professionals to meet potential employers.', false);

INSERT INTO project.survey (created_at, expired_at, is_active, id, description, title, deleted)
VALUES ('2023-06-30','2023-06-30', true, 1, 'A survey to understand student satisfaction with campus facilities.',
        'Campus Satisfaction Survey 2023', false),
       ('2023-07-01','2025-06-30', true, 2, 'A survey to gather feedback on the recent Tech Talk event.',
        'Tech Talk Feedback 2023', false);

INSERT INTO project.survey_question (survey_id, question, question_type, deleted)
VALUES
    (1, 'How do you find the overall campus environment?', 'MULTIPLE_CHOICE', false),
    (1, 'Are the recreational facilities adequate?', 'BOOLEAN_INPUT', false),
    (2, 'Is the faculty support satisfactory?', 'BOOLEAN_INPUT', false),
    (2, 'Are there enough professional development programs?', 'MULTIPLE_CHOICE', false);

INSERT INTO project.survey_answer_choice (choice, description, question_id, deleted)
VALUES
    ('A', 'Very Good', 1, false),
    ('B', 'Good', 1, false),
    ('C', 'Average', 1, false),
    ('D', 'Poor', 1, false),
    ('A', 'Yes', 2, false),
    ('B', 'No', 2, false),
    ('A', 'Yes', 3, false),
    ('B', 'No', 3, false),
    ('A', 'Many programs', 4, false),
    ('B', 'Some programs', 4, false),
    ('C', 'Few programs', 4, false);

INSERT INTO project.survey_response (question_id, user_id, response, deleted)
VALUES
    (1, 1, 'A', false),
    (1, 2, 'B', false),
    (1, 3, 'D', false),
    (2, 1, 'A', false),
    (2, 2, 'B', false),
    (2, 3, 'B', false),
    (3, 1, 'A', false),
    (3, 2, 'B', false),
    (4, 1, 'B', false),
    (4, 3, 'B', false),
    (4, 2, 'B', false);

INSERT INTO project.extracurricular_activity (id, name, description, deleted)
VALUES (1, 'Robotics Club', 'A club for students interested in building and learning about robots.', false),
       (2, 'Art Society', 'A society that brings together students interested in the arts.', false);

INSERT INTO project.interest (id, name, description, deleted)
VALUES (1, 'Technology', 'Interest in technology and tech advancements.', false),
       (2, 'Arts', 'Passionate about all forms of art.', false);

INSERT INTO project.resource_category (name, description, parent_id, deleted)
VALUES ('Technology', 'Resources related to all forms of technology.', NULL, false),
       ('Arts', 'Resources related to various forms of arts.', NULL, false),
       ('Programming', 'Resources related to programming languages and development techniques.', 1, false),
       ('Painting', 'Resources related to different styles and techniques in painting.', 2, false),
       ('Web Development', 'Resources related to the development of websites and web applications.', 3, false),
       ('Sculpture', 'Resources devoted to the art and technique of sculpture.', 2, false),
       ('Mobile Development', 'Resources related to developing applications for mobile devices.', 3, false),
       ('Cloud Computing', 'Resources on cloud technology and virtualization.', 1, false);


INSERT INTO project.academic_resource (id, category_id, user_id, name, url, description, deleted)
VALUES (1, 1, 1, 'Advanced Java Concepts', 'http://example.com/java', 'A comprehensive guide to mastering Java.', false),
       (2, 2, 1, 'Introduction to REST APIs', 'http://example.com/restapis',
        'Learn how REST APIs work and how to implement them.', false),
       (3, 3, 2, 'Machine Learning Basics', 'http://example.com/machinelearning',
        'An introductory course on machine learning for beginners.', true),
       (4, 1, 2, 'Effective JavaScript Techniques', 'http://example.com/javascript',
        'Techniques to improve your JavaScript coding skills.', false),
       (5, 2, 1, 'Database Optimization Strategies', 'http://example.com/dboptimization',
        'Strategies to optimize your database performance for large scale applications.', true);

INSERT INTO project.thread_post (created_at, resource_category_id, user_id, title, deleted)
VALUES ('2023-07-01 09:30:00', 1, 1, 'Introduction to Java Programming', false),
       ('2023-07-01 10:00:00', 2, 2, 'Understanding REST APIs', false),
       ('2023-07-01 11:00:00', 3, 1, 'Latest Trends in Machine Learning', false),
       ('2023-07-01 11:30:00', 1, 2, 'Tips for Effective JavaScript Debugging', false);

INSERT INTO project.post (created_at, updated_at, thread_post_id, content, deleted)
VALUES ('2023-07-01 09:35:00', '2023-07-01 09:35:00', 1,
        'This is a great introduction for beginners. What do you think about the complexities in Java?', false),
       ('2023-07-01 10:05:00', '2023-07-01 10:05:00', 2,
        'REST APIs are crucial for modern web applications. I found this very useful!', false),
       ('2023-07-01 11:05:00', '2023-07-01 11:05:00', 3,
        'Machine learning is evolving rapidly. It’s exciting to see where it goes next.', false),
       ('2023-07-01 11:35:00', '2023-07-01 11:35:00', 4,
        'Debugging is an essential skill. These tips are very practical.', false);

INSERT INTO project.student_directory (academic_year, user_id, contact_information, major, deleted)
VALUES ('2024-06-01', 1, 'john.doe@example.com, +1234567890', 'Computer Science', false),
       ('2023-09-01', 2, 'jane.smith@example.com, +0987654321', 'Graphic Design', false),
       ('2022-09-01', 3, 'alice.johnson@example.com, +1122334455', 'Mechanical Engineering', false),
       ('2021-08-01', 4, 'bob.brown@example.com, +1223344556', 'Business Administration', false);

INSERT INTO project.rsvp (date, event_id, user_id, status, deleted)
VALUES ('2023-07-01', 1, 1, 'YES', false),
       ('2023-07-01', 1, 2, 'NO', false),
       ('2023-07-02', 1, 3, 'MAYBE', false),
       ('2023-07-01', 2, 1, 'YES', false),
       ('2023-07-01', 2, 2, 'YES', false),
       ('2023-07-02', 2, 3, 'MAYBE', false);

INSERT INTO project.attendance (attendance_date, event_id, user_id, status, deleted)
VALUES ('2023-07-01', 1, 1, 'ATTENDED', false),
       ('2023-07-01', 1, 2, 'ABSENT', false),
       ('2023-07-01', 1, 3, 'ATTENDED', false),
       ('2023-07-15', 2, 1, 'ATTENDED', false),
       ('2023-07-15', 2, 2, 'ATTENDED', false),
       ('2023-07-15', 2, 3, 'ABSENT', false);

INSERT INTO project.report (report_date, reported_by_user_id, report_type, reason, deleted)
VALUES
    ('2023-07-01', 1, 'user_report', 'User was harassed in comments on their post.', false),
    ('2023-07-02', 2, 'user_report', 'User reported receiving multiple spam messages.', false),
    ('2023-07-03', 3, 'user_report', 'User reported inappropriate content in a shared document.', false),
    ('2023-07-04', 1, 'user_report', 'User reported unauthorized use of copyrighted material.', false),
    ('2023-07-05', 4, 'user_report', 'User reported a suspected fake account involved in misleading activities.', false);

-- User Activities
INSERT INTO project.user_activities (activities_id, students_id)
VALUES (1, 1),
       (2, 2);

-- User Events
INSERT INTO project.user_events (events_id, students_id)
VALUES (1, 1),
       (2, 2);

-- User Interests
INSERT INTO project.user_interests (interests_id, students_id)
VALUES (1, 1),
       (2, 2);
INSERT INTO project.user_activities (activities_id, students_id)
VALUES (1, 1),
       (2, 2);
INSERT INTO project.user_interests (interests_id, students_id)
VALUES (1, 1),
       (2, 2);

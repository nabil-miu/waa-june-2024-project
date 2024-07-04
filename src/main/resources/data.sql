CREATE
DATABASE IF NOT EXISTS `project` /*!40100 DEFAULT CHARACTER SET utf8 */;

INSERT INTO project.profile (id, academic_achievements, personal_bio)
VALUES (100, 'Bachelor of Science in Computer Science',
        'An enthusiastic developer with a passion for AI and machine learning.'),
       (101, 'Bachelor of Arts in Graphic Design', 'Creative designer who loves to blend technology and art.'),
       (102, 'Bachelor of Science in Computer Science',
        'An enthusiastic developer with a passion for AI and machine learning.'),
       (103, 'Bachelor of Arts in Graphic Design', 'Creative designer who loves to blend technology and art.');

INSERT INTO project.user (id, academic_year, account_non_expired, account_non_locked, credentials_non_expired, active,
                          profile_id,
                          address, city, country, department, email, first_name, last_name,
                          major, password, phone, role, state, student_id, zip, user_type)
VALUES (1, '2023-09-01', 1, 1, 1, 1, 100, '123 Oak St.', 'Springfield', 'USA', 'Computer Science',
        'john.doe@example.com',
        'John', 'Doe',
        'Software Engineering', 'hashed_password123', '555-1234', 'STUDENT', 'MA', 'S1234567', '01101', 'STUDENT'),
       (2, '2022-09-01', 1, 1, 1, 1, 101, '456 Maple St.', 'Rivertown', 'USA', 'Arts', 'jane.smith@example.com', 'Jane',
        'Smith',
        'Fine Arts', 'hashed_password456', '555-5678', 'STUDENT', 'NY', 'S7654321', '02202', 'STUDENT'),
       (3, '2023-09-01', 1, 1, 1, 1, 102, '123 Oak St.', 'Springfield', 'USA', 'Computer Science',
        'john.doe2@example.com',
        'John', 'Doe',
        'Software Engineering', 'hashed_password123', '555-1234', 'STUDENT', 'MA', 'S1234567', '01101', 'STUDENT'),
       (4, '2022-09-01', 1, 1, 1, 1, 103, '456 Maple St.', 'Rivertown', 'USA', 'Arts', 'jane.smith3@example.com',
        'Jane',
        'Smith',
        'Fine Arts', 'hashed_password456', '555-5678', 'STUDENT', 'NY', 'S7654321', '02202', 'STUDENT');

INSERT INTO project.event (id, local_date_time, location, name, description)
VALUES (1, '2023-07-01 18:00:00', 'Conference Hall A, Springfield University', 'Tech Talk 2023',
        'An annual gathering of tech enthusiasts to discuss emerging technologies.'),
       (2, '2023-07-15 10:00:00', 'Auditorium B, Downtown Conference Center', 'Career Fair 2023',
        'A perfect place for students and professionals to meet potential employers.');

INSERT INTO project.survey (created_at, expired_at, is_active, id, description, title)
VALUES ('2023-06-30','2023-06-30', true, 1, 'A survey to understand student satisfaction with campus facilities.',
        'Campus Satisfaction Survey 2023'),
       ('2023-07-01','2025-06-30', true, 2, 'A survey to gather feedback on the recent Tech Talk event.',
        'Tech Talk Feedback 2023');

INSERT INTO project.survey_question (survey_id, question, question_type)
VALUES
    (1, 'How do you find the overall campus environment?', 'MULTIPLE_CHOICE'),
    (1, 'Are the recreational facilities adequate?', 'BOOLEAN_INPUT'),
    (2, 'Is the faculty support satisfactory?', 'BOOLEAN_INPUT'),
    (2, 'Are there enough professional development programs?', 'MULTIPLE_CHOICE');

INSERT INTO project.survey_answer_choice (choice, description, question_id)
VALUES
    ('A', 'Very Good', 1),
    ('B', 'Good', 1),
    ('C', 'Average', 1),
    ('D', 'Poor', 1),
    ('A', 'Yes', 2),
    ('B', 'No', 2),
    ('A', 'Yes', 3),
    ('B', 'No', 3),
    ('A', 'Many programs', 4),
    ('B', 'Some programs', 4),
    ('C', 'Few programs', 4);

INSERT INTO project.survey_response (question_id, user_id, response)
VALUES
    (1, 1, 'A'),
    (1, 2, 'B'),
    (1, 3, 'D'),
    (2, 1, 'A'),
    (2, 2, 'B'),
    (2, 3, 'B'),
    (3, 1, 'A'),
    (3, 2, 'B'),
    (4, 1, 'B'),
    (4, 3, 'B'),
    (4, 2, 'B');

INSERT INTO project.extracurricular_activity (id, name, description)
VALUES (1, 'Robotics Club', 'A club for students interested in building and learning about robots.'),
       (2, 'Art Society', 'A society that brings together students interested in the arts.');

INSERT INTO project.interest (id, name, description)
VALUES (1, 'Technology', 'Interest in technology and tech advancements.'),
       (2, 'Arts', 'Passionate about all forms of art.');

INSERT INTO project.resource_category (name, description, parent_id)
VALUES ('Technology', 'Resources related to all forms of technology.', NULL),
       ('Arts', 'Resources related to various forms of arts.', NULL),
       ('Programming', 'Resources related to programming languages and development techniques.', 1),
       ('Painting', 'Resources related to different styles and techniques in painting.', 2),
       ('Web Development', 'Resources related to the development of websites and web applications.', 3),
       ('Sculpture', 'Resources devoted to the art and technique of sculpture.', 2),
       ('Mobile Development', 'Resources related to developing applications for mobile devices.', 3),
       ('Cloud Computing', 'Resources on cloud technology and virtualization.', 1);


INSERT INTO project.academic_resource (id, category_id, user_id, name, url, description)
VALUES (1, 1, 1, 'Advanced Java Concepts', 'http://example.com/java', 'A comprehensive guide to mastering Java.'),
       (2, 2, 1, 'Introduction to REST APIs', 'http://example.com/restapis',
        'Learn how REST APIs work and how to implement them.'),
       (3, 3, 2, 'Machine Learning Basics', 'http://example.com/machinelearning',
        'An introductory course on machine learning for beginners.'),
       (4, 1, 2, 'Effective JavaScript Techniques', 'http://example.com/javascript',
        'Techniques to improve your JavaScript coding skills.'),
       (5, 2, 1, 'Database Optimization Strategies', 'http://example.com/dboptimization',
        'Strategies to optimize your database performance for large scale applications.');

INSERT INTO project.thread_post (created_at, resource_category_id, user_id, title)
VALUES ('2023-07-01 09:30:00', 1, 1, 'Introduction to Java Programming'),
       ('2023-07-01 10:00:00', 2, 2, 'Understanding REST APIs'),
       ('2023-07-01 11:00:00', 3, 1, 'Latest Trends in Machine Learning'),
       ('2023-07-01 11:30:00', 1, 2, 'Tips for Effective JavaScript Debugging');

INSERT INTO project.post (created_at, updated_at, thread_post_id, content)
VALUES ('2023-07-01 09:35:00', '2023-07-01 09:35:00', 1,
        'This is a great introduction for beginners. What do you think about the complexities in Java?'),
       ('2023-07-01 10:05:00', '2023-07-01 10:05:00', 2,
        'REST APIs are crucial for modern web applications. I found this very useful!'),
       ('2023-07-01 11:05:00', '2023-07-01 11:05:00', 3,
        'Machine learning is evolving rapidly. It’s exciting to see where it goes next.'),
       ('2023-07-01 11:35:00', '2023-07-01 11:35:00', 4,
        'Debugging is an essential skill. These tips are very practical.');

INSERT INTO project.student_directory (academic_year, user_id, contact_information, major)
VALUES ('2024-06-01', 1, 'john.doe@example.com, +1234567890', 'Computer Science'),
       ('2023-09-01', 2, 'jane.smith@example.com, +0987654321', 'Graphic Design'),
       ('2022-09-01', 3, 'alice.johnson@example.com, +1122334455', 'Mechanical Engineering'),
       ('2021-08-01', 4, 'bob.brown@example.com, +1223344556', 'Business Administration');

INSERT INTO project.rsvp (date, event_id, user_id, status)
VALUES ('2023-07-01', 1, 1, 'YES'),
       ('2023-07-01', 1, 2, 'NO'),
       ('2023-07-02', 1, 3, 'MAYBE'),
       ('2023-07-01', 2, 1, 'YES'),
       ('2023-07-01', 2, 2, 'YES'),
       ('2023-07-02', 2, 3, 'MAYBE');

INSERT INTO project.attendance (attendance_date, event_id, user_id, status)
VALUES ('2023-07-01', 1, 1, 'ATTENDED'),
       ('2023-07-01', 1, 2, 'ABSENT'),
       ('2023-07-01', 1, 3, 'ATTENDED'),
       ('2023-07-15', 2, 1, 'ATTENDED'),
       ('2023-07-15', 2, 2, 'ATTENDED'),
       ('2023-07-15', 2, 3, 'ABSENT');

INSERT INTO project.report (report_date, reported_by_user_id, report_type, reason)
VALUES
    ('2023-07-01', 1, 'user_report', 'User was harassed in comments on their post.'),
    ('2023-07-02', 2, 'user_report', 'User reported receiving multiple spam messages.'),
    ('2023-07-03', 3, 'user_report', 'User reported inappropriate content in a shared document.'),
    ('2023-07-04', 1, 'user_report', 'User reported unauthorized use of copyrighted material.'),
    ('2023-07-05', 4, 'user_report', 'User reported a suspected fake account involved in misleading activities.');

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

-- ResourceCategory
INSERT INTO resource_category (name, description, parent_id)
VALUES ('Electronics', 'Category for electronic items', NULL);
INSERT INTO resource_category (name, description, parent_id)
VALUES ('Computers', 'Category for computers and accessories', 1);
INSERT INTO resource_category (name, description, parent_id)
VALUES ('Laptops', 'Subcategory for laptops', 2);
INSERT INTO resource_category (name, description, parent_id)
VALUES ('Smartphones', 'Category for smartphones', 1);
INSERT INTO resource_category (name, description, parent_id)
VALUES ('Gaming Consoles', 'Category for gaming consoles', 1);


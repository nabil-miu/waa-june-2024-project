CREATE
    DATABASE IF NOT EXISTS `project` /*!40100 DEFAULT CHARACTER SET utf8 */;

INSERT INTO profile (id, academic_achievements, personal_bio)
VALUES (100, 'Bachelor of Science in Computer Science',
        'An enthusiastic developer with a passion for AI and machine learning.'),
       (101, 'Bachelor of Arts in Graphic Design', 'Creative designer who loves to blend technology and art.');
INSERT INTO event (id, local_date_time, location, name, description)
VALUES (1, '2023-07-01 18:00:00', 'Conference Hall A, Springfield University', 'Tech Talk 2023',
        'An annual gathering of tech enthusiasts to discuss emerging technologies.'),
       (2, '2023-07-15 10:00:00', 'Auditorium B, Downtown Conference Center', 'Career Fair 2023',
        'A perfect place for students and professionals to meet potential employers.');
INSERT INTO survey (created_at, expired_at, is_active, id, description, title)
VALUES ('2023-06-30', NULL, true, 1, 'A survey to understand student satisfaction with campus facilities.',
        'Campus Satisfaction Survey 2023'),
       ('2023-07-01', NULL, true, 2, 'A survey to gather feedback on the recent Tech Talk event.',
        'Tech Talk Feedback 2023');
INSERT INTO extracurricular_activity (id, name, description)
VALUES (1, 'Robotics Club', 'A club for students interested in building and learning about robots.'),
       (2, 'Art Society', 'A society that brings together students interested in the arts.');
INSERT INTO interest (id, name, description)
VALUES (1, 'Technology', 'Interest in technology and tech advancements.'),
       (2, 'Arts', 'Passionate about all forms of art.');
INSERT INTO user (id, academic_year, account_non_expired, account_non_locked, credentials_non_expired, active,
                  profile_id,
                  address, city, country, department, email, first_name, last_name,
                  major, password, phone, role, state, student_id, zip, user_type)
VALUES (1, '2023-09-01', 1, 1, 1, 1, 100, '123 Oak St.', 'Springfield', 'USA', 'Computer Science',
        'john.doe@example.com',
        'John', 'Doe',
        'Software Engineering', 'hashed_password123', '555-1234', 'STUDENT', 'MA', 'S1234567', '01101', 'STUDENT'),
       (2, '2022-09-01', 1, 1, 1, 1, 101, '456 Maple St.', 'Rivertown', 'USA', 'Arts', 'jane.smith@example.com', 'Jane',
        'Smith',
        'Fine Arts', 'hashed_password456', '555-5678', 'STUDENT', 'NY', 'S7654321', '02202', 'STUDENT');
-- User Activities
INSERT INTO user_activities (activities_id, students_id)
VALUES (1, 1),
       (2, 2);

-- User Events
INSERT INTO user_events (events_id, students_id)
VALUES (1, 1),
       (2, 2);

-- User Interests
INSERT INTO user_interests (interests_id, students_id)
VALUES (1, 1),
       (2, 2);
INSERT INTO user_activities (activities_id, students_id)
VALUES (1, 1),
       (2, 2);
INSERT INTO user_interests (interests_id, students_id)
VALUES (1, 1),
       (2, 2);

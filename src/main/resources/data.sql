insert into _administrator (administrator_id, username, password, email, full_name, role) VALUES (1, 'george', '$2a$12$AVROg0OVGDHkgOIsdKDOq.ueaxhDQh4nrkgBmC4Dr11RBxrnviO2S', 'george@yahoo', 'George Hay','ADMINISTRATOR');
insert into _administrator (administrator_id, username, password, email, full_name, role) VALUES (2, 'antonia', '$2a$12$V.u8MS.N.REGtJx3nH49IOtJ.qzGp73lyUYsgln1RpQ8j78wNYzNa', 'antonia@gmail', 'Antonia Ray','ADMINISTRATOR');

insert into _school_class (class_id, name) VALUES (1, '30431');
insert into _school_class (class_id, name) VALUES (2, '30432');

insert into _student (student_id, username, password, email, full_name, class_id, role) VALUES (1, 'razvan', '$2a$12$jNL91lxtom25w/nKKjC.Ge6BD1aprRnjNw9QU6ylPAdaLaF98V2R6', 'razvan@yahoo', 'Razvan Pop', 1, 'STUDENT');
insert into _student (student_id, username, password, email, full_name, class_id, role) VALUES (2, 'sara', '$2a$12$tD6ZGEo.v9gwi1v7Zcc3o.WWnCjybOwUzK5JX1Qspe1rlaoyj/SuW', 'sara@gmail', 'Sara Ardelean', 1, 'STUDENT');

insert into _situation (situation_id, final_grade, student_id) VALUES (1, 10, 1);
insert into _situation (situation_id, final_grade, student_id) VALUES (2, 7, 2);

insert into _teacher (teacher_id, username, password, email, full_name, role) VALUES (1, 'john', '$2a$12$7WAmGnHNTc0GbVYTTXZFn.40Y7lcHWaWkI9uade8GkPPg680LN9d2', 'john@email', 'John Doe','TEACHER');
insert into _teacher (teacher_id, username, password, email, full_name, role) VALUES (2, 'marry', '$2a$12$c25gT5WC9tenPU.v5aRX6ONBoG0IJrvStSE5wHxlwoFcX5NpwyXSC', 'marry@email', 'Marry Sue','TEACHER');

insert into _course (course_id, name, hour, teacher_id) VALUES (1, 'SD', 10, 1);
insert into _course (course_id, name, hour, teacher_id) VALUES (2, 'PT', 11, 2);
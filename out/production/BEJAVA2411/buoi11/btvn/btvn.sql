create database quanlysinhvien;
use quanlysinhvien;
create table Students
(
    id         integer primary key auto_increment,
    first_name varchar(50),
    last_name  varchar(50),
    birth_date date,
    email      varchar(100)
);
create table Courses
(
    id                 int primary key auto_increment,
    course_name        varchar(100), -- ten khoa hoc
    course_description text
);
create table Enrollments
(
    id              int primary key auto_increment,
    student_id      int,
    course_id       int,
    enrollment_date date
);
alter table Enrollments
    add foreign key (student_id)
        references Students (id);
alter table Enrollments
    add foreign key (course_id)
        references Courses (id);

insert into Students(first_name, last_name, birth_date, email)
    value ('Nguyen', 'Kien', '2003-08-30', 'kien1@gmail.com');
insert into Students(first_name, last_name, birth_date, email)
    value ('Tran Van', 'A', '2001-01-01', 'tranvana@gmail.com');
insert into Students(first_name, last_name, birth_date, email)
    value ('Nguyen Van ', 'B', '2002-07-30', 'nguyenvanb@gmail.com');
insert into Students(first_name, last_name, birth_date, email)
    value ('Lo Thi', 'C', '2005-02-09', 'lothic@gmail.com');
insert into Students(first_name, last_name, birth_date, email)
    value ('Truong Thi ', 'Anh', '2003-12-14', 'trna@gmail.com');

select *
from Students;
insert into Courses(course_name, course_description)
    value ('Java Spring Boots', 'Tao API voi Spring Boots');
insert into Courses(course_name, course_description)
    value ('React JS', 'Tao giao dien voi React JS');
insert into Courses(course_name, course_description)
    value ('Khoa hoc khong ai dang ky', 'khong dang ky');
select *
from Courses;
insert into Enrollments(student_id, course_id, enrollment_date)
    value (1, 2, '2024-12-26');
insert into Enrollments(student_id, course_id, enrollment_date)
    value (5, 2, '2024-12-26');
insert into Enrollments(student_id, course_id, enrollment_date)
    value (4, 1, '2024-12-26');
insert into Enrollments(student_id, course_id, enrollment_date)
    value (4, 3, '2024-12-26');
insert into Enrollments(student_id, course_id, enrollment_date)
    value (2, 1, '2024-12-26');
select *
from Enrollments;
select last_name, first_name, email
from Students;
select course_name, course_description
from Courses;
select Students.first_name, Students.last_name, Courses.course_name
from Students
         join Enrollments on Students.id = Enrollments.student_id
         join Courses on Enrollments.course_id = Courses.id;

select Students.first_name, Students.last_name, Students.email, Courses.course_name
from Students
         join Enrollments on Students.id = Enrollments.student_id
         join courses on Enrollments.course_id = Courses.id
where Courses.course_name = 'Java Spring Boots';

select Students.first_name, Students.last_name, Students.email, Students.birth_date
from Students
where birth_date > '2000-01-01'
  and email like '%kien%';

update Students
set email = 'example@example.com'
where Students.id = 4;

update Courses
set course_description = 'Mô tả  mới của HTML & CSS'
where course_name = 'HTML & CSS';

delete
from Students
where id = 3
  and Students.id not in (SELECT Enrollments.student_id
                          from Enrollments);

delete
from Courses
where id = 4
  and Courses.id not in (SELECT Enrollments.course_id
                         from Enrollments);

select Students.first_name, Students.last_name, Students.birth_date
from Students
where birth_date > '2000-01-01';

select Students.first_name, Students.last_name, Students.birth_date
from Students
where first_name like 'Nguyen%';

select Students.first_name, Students.last_name, Students.birth_date, Courses.course_name
from Students
         join Enrollments on Students.id = Enrollments.student_id
         join Courses on Enrollments.student_id = Courses.id
where Students.birth_date > '2000-01-01'
  and Courses.course_name = 'Java Spring Boots';

select Students.first_name, Students.last_name, Courses.id, Courses.course_name
from Students
         join Enrollments on Students.id = Enrollments.student_id
         join Courses on Enrollments.course_id = Courses.id
where Courses.id in (1, 2);

select Courses.id, Courses.course_name, Courses.course_description
from Courses
where id between 1 and 2;

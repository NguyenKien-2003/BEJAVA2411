create
    DATABASE quanlynhansu;
use quanlynhansu;
CREATE TABLE departments
(
    department_id   INT PRIMARY KEY,
    department_name VARCHAR(100) NOT NULL,
    location        VARCHAR(100) NOT NULL
);

INSERT INTO departments (department_id, department_name, location)
VALUES (1, 'IT', 'Hà Nội'),
       (2, 'HR', 'TP. Hồ Chí Minh'),
       (3, 'Finance', 'Đà Nẵng');

CREATE TABLE employees
(
    employee_id   INT PRIMARY KEY,
    name          VARCHAR(100)   NOT NULL,
    position      VARCHAR(50)    NOT NULL,
    salary        DECIMAL(10, 2) NOT NULL,
    department_id INT,
    hire_date     DATE           NOT NULL,
    FOREIGN KEY (department_id) REFERENCES departments (department_id)
);

INSERT INTO employees (employee_id, name, position, salary, department_id, hire_date)
VALUES (1, 'Nguyễn Văn A', 'Developer', 1500, 1, '2020-05-01'),
       (2, 'Trần Thị B', 'Tester', 1200, 1, '2021-03-15'),
       (3, 'Lê Văn C', 'Developer', 1500, 2, '2019-08-10'),
       (4, 'Nguyễn Thị D', 'Project Manager', 2500, 2, '2020-01-20'),
       (5, 'Phạm Văn E', 'Tester', 1300, 3, '2021-07-12'),
       (6, 'Hoàng Thị F', 'Developer', 1400, 3, '2022-09-01'),
       (7, 'Đặng Văn G', 'Developer', 1500, 1, '2022-05-20'),
       (8, 'Nguyễn Văn H', 'Developer', 2000, 2, '2018-12-15');

/*
 1. GROUP BY:
Tính tổng lương của mỗi phòng ban:
 */
select d.department_name, SUM(employees.salary) TongLuong
from employees
         inner join departments d on employees.department_id = d.department_id
group by d.department_id;
/*
 2. HAVING:
Lọc các phòng ban có tổng lương lớn hơn 3000:
 */
select d.department_name, SUM(employees.salary) TongLuong
from employees
         join departments d on employees.department_id = d.department_id
group by d.department_id
having SUM(employees.salary) > 3000;
/*
 3. DISTINCT:
Lấy danh sách vị trí công việc duy nhất:
 */
select distinct employees.position
from employees;
/*
 4. LIMIT & OFFSET:
Lấy 3 nhân viên đầu tiên, bỏ qua 2 nhân viên đầu tiên:
 */
select *
from employees
limit 3 offset 5;
/*
  LIKE:
Tìm nhân viên có tên chứa “Nguyễn”:
 */
select *
from employees
where employees.name like '%Nguyễn%';
/*
 SUM và AVG:
Tính tổng và trung bình lương của toàn bộ nhân viên:
 */
-- tổng lương,trung bình lương
select sum(employees.salary) total, avg(employees.salary) avg
from employees;
/*
 INNER JOIN:
Lấy danh sách nhân viên và tên phòng ban của họ:
 */
select employees.name, departments.department_name
from employees
         inner join departments
                    on employees.department_id = departments.department_id;

/*
 LEFT JOIN:
Lấy danh sách tất cả phòng ban và nhân viên của phòng ban đó (nếu có):
 */
select departments.department_name, employees.name
from departments
         left join employees on departments.department_id = employees.department_id;

/*
 9. RIGHT JOIN:
Lấy danh sách tất cả nhân viên và thông tin phòng ban của họ (nếu có):
 */
select employees.name, department_name
from departments
         right join employees on departments.department_name = employees.name
/*
 10. SELF JOIN:
Tìm các nhân viên có cùng mức lương
 */
select distinct emp.salary, emp_same_salary.name
from employees emp
         inner join employees emp_same_salary
                    on emp.salary = emp_same_salary.salary and emp_same_salary.name != emp.name;

/*
 11. Tìm phòng ban có nhiều nhân viên nhất và tổng lương của phòng ban đó
 */
SELECT d.department_name, count(e.employee_id) count, sum(e.salary)
FROM departments d
         inner join employees e
                    ON d.department_id = e.department_id
group by d.department_name
ORDER by count DESC
LIMIT 1;
-- 12. Tìm nhân viên có mức lương cao nhất trong mỗi phòng ban
SELECT e.name, e.salary, d.department_name
FROM employees e
         INNER JOIN departments d ON e.department_id = d.department_id
WHERE e.salary = (SELECT MAX(salary)
                  FROM employees
                  WHERE department_id = e.department_id);
-- 13. Tính mức lương trung bình của từng vị trí công việc,
-- chỉ hiển thị các vị trí có lương trung bình lớn hơn 1500
SELECT distinct e.position, avg(e.salary) avg_salary_position
FROM employees e
group by e.position
HAVING avg_salary_position > 1500;
-- 14. Lấy danh sách nhân viên và đồng nghiệp cùng phòng ban (không bao gồm chính họ)
SELECT e2.employee_id, e2.name
FROM employees e1
         JOIN employees e2 ON e1.department_id = e2.department_id
WHERE e1.employee_id != e2.employee_id;
-- 15. Tính tổng số năm kinh nghiệm của mỗi phòng ban
SELECT d.department_name, SUM(YEAR(CURDATE()) - YEAR(e.hire_date)) total_experience
FROM employees e
         JOIN departments d ON e.department_id = d.department_id
GROUP BY d.department_name;
-- 16. Tìm nhân viên được tuyển dụng sớm nhất trong mỗi phòng ban,
-- bao gồm cả tên và ngày tuyển dụng
SELECT *
FROM employees;
-- 17. Tìm phòng ban có tổng lương lớn nhất và hiển thị tên nhân viên, lương và phòng ban đó
SELECT distinct e.name, e.salary, d.department_name, SUM(e.salary) total_salary_department
FROM departments d
         join employees e on d.department_id = e.department_id
group by e.name, e.salary, d.department_name
ORDER BY total_salary_department DESC
limit 1;
-- 18. Phân nhóm nhân viên theo bậc lương (ví dụ: < 1500, 1500-2000, > 2000)
-- và tính tổng số nhân viên trong từng nhóm/-strong/-heart:>:o:-((:-h Sử dụng CASE và GROUP BY:
SELECT CASE
           WHEN salary < 1500 THEN '< 1500'
           WHEN salary BETWEEN 1500 AND 2000 THEN '1500-2000'
           ELSE '> 2000'
           END  AS salary_group,
       COUNT(*) AS total_employees
FROM employees
GROUP BY salary_group;

-- 19. Tìm nhân viên có tổng số lương cao nhất trong tất cả các phòng ban (bao gồm cả tên phòng ban)
SELECT e.name, e.salary, d.department_name
FROM employees e
         JOIN departments d ON e.department_id = d.department_id
WHERE e.salary = (SELECT MAX(salary) FROM employees);
-- 20. Tìm tên nhân viên có lương cao hơn mức lương trung bình của phòng ban mà họ làm việc







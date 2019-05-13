CREATE TABLE departments (id bigint primary key auto_increment,
 Department_name VARCHAR(50) NOT NULL unique, comments VARCHAR(1000));
INSERT INTO departments(department_name, comments)
value('Recruiter department','This department is responsible for delivering all facets of
recruiting success throughout the organization. This will be achieved through the development
 of local and national recruiting plans, employing traditional sourcing strategies and
 resources as well as developing new, creative recruiting ideas.');
INSERT INTO departments(department_name, comments)
value('Software development department','This department is responsible for software
development. Software development is the process of conceiving, specifying, designing,
programming, documenting, testing, and bug fixing involved in creating and
maintaining applications, frameworks, or other software components.');

CREATE TABLE employees (id bigint primary key auto_increment, first_name VARCHAR(25) not null,
last_name VARCHAR(30) not null, patronymic VARCHAR(30) not null,
email VARCHAR(50) not null unique, age INT NOT NULL, phone_number VARCHAR(15), employment_date DATE,
department_id bigint, FOREIGN KEY (department_id) REFERENCES departments(id));
INSERT INTO employees (first_name, last_name, patronymic, email, phone_number, employment_date,
 department_id) value('Nikolay', 'Sokolov', 'Nikolaevich', 'nikolaysokolov@gmail.com', '32',
 '+380504563212', '2002-01-13', null, '2' );

 INSERT INTO employees (first_name, last_name, patronymic, email, phone_number, employment_date,
 department_id) value('Petr', 'Petrov', 'Petrovich', 'petrov@gmail.com', '25',
 '+380675689123', '2001-06-27', '1' );

 INSERT INTO employees (first_name, last_name, patronymic, email, phone_number, employment_date,
 department_id) value('Ivan', 'Ivanov', 'Ivanovich', 'ivanov@gmail.com', '19',
 '+380957895623', '2014-01-15', null, '1' );

 INSERT INTO employees (first_name, last_name, patronymic, email, phone_number, employment_date,
 department_id) value('Oleg', 'Olegov', 'Olegovich', 'olegovich@gmail.com', '22',
 '+380993692578', '2009-11-01', null, '2' );

 INSERT INTO employees (first_name, last_name, patronymic, email, phone_number, employment_date,
 department_id) value('Maria', 'Kotova', 'Denisovna', 'mariad@gmail.com', '23',
 '+380507415635', '2010-05-22', null, '1' );

CREATE TABLE course(
	id bigint not null,
	name varchar(255) not null,
	author varchar(255) not null,
	primary key(id)
);

/*

INSERT INTO course(id,name,author) values (1,'Learn AWS', 'g4stly');

select * from course;

delete from course where id=1;

*/
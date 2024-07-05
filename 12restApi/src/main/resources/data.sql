insert into users(id,birth_date,name)
values(10001, current_date(),'Sefa');

insert into users(id,birth_date,name)
values(10002, current_date(),'Sefa2');

insert into users(id,birth_date,name)
values(10003, current_date(),'S3fa');

insert into posts(id, description, user_id)
values(20001,'some desc',10001);

insert into posts(id, description, user_id)
values(20002,'some desc 2',10001);

insert into posts(id, description, user_id)
values(20003,'some desc 3',10002);

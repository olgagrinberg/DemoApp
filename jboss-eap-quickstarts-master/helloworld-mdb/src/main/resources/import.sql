-- You can use this file to load seed data into the database using SQL statements
insert into Customer (customerId, name, email, pending) values (1, 'olga', 'olgasilanis@gmail.com', true);
insert into Schedule (scheduleId, customerId, reminderDate) values (1, 1, {ts '2014-01-02'});
insert into Customer (customerId, name, email, pending) values (2, 'Tom', 'test1@gmail.com', false);
insert into Schedule (scheduleId, customerId, reminderDate) values (2, 2, {ts '2014-01-02'});
insert into Customer (customerId, name, email, pending) values (3, 'Jerry', 'test2@gmail.com', false);

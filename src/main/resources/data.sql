DELETE FROM User;
DELETE FROM Student;

INSERT INTO Student (id,first_name,last_name,phone,email,birth_date) VALUES(1,'Jack', 'Bauer', '+358 555 33 66', 'Jack.Bauer@vaadin.com',CURRENT_TIMESTAMP);
INSERT INTO Student (id,first_name,last_name,phone,email,birth_date) VALUES(2,'Chloe', 'OBrian', '+41 333 77 11', 'Chloe.OBrian@vaadin.com',CURRENT_TIMESTAMP);
INSERT INTO Student (id,first_name,last_name,phone,email,birth_date) VALUES(3, 'Kim', 'Bauer', '+88 478 12 47', 'Kim.Bauer@vaadin.com',CURRENT_TIMESTAMP);
INSERT INTO Student (id,first_name,last_name,phone,email,birth_date) VALUES(4, 'David', 'Palmer', '+90 364 58 43', 'David.Palmer@vaadin.com',CURRENT_TIMESTAMP);
INSERT INTO Student (id,first_name,last_name,phone,email,birth_date) VALUES(5, 'Michelle', 'Dessler', '+42 666 88 77', 'Michelle.Dessler@vaadin.com',CURRENT_TIMESTAMP);



INSERT INTO User (id,user_name,password) VALUES(1,'Feride', 'admin123');
INSERT INTO User (id,user_name,password) VALUES(2,'admin', 'admin');


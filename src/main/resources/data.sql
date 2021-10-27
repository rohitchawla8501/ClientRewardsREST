ALTER TABLE TRANSACTION ADD FOREIGN KEY (CUSTOMER_ID) REFERENCES CUSTOMER (ID);

insert into CUSTOMER values(1,'John');
insert into CUSTOMER values(2,'Bob');
insert into CUSTOMER values(3,'Kai');
insert into CUSTOMER values(4,'Joe');
insert into CUSTOMER values(5,'Ronaldo');
insert into CUSTOMER values(6,'Messi');

Insert into transaction values(1000,1,120,'2021-10-24');
Insert into transaction values(1001,1,120,'2021-09-24');
Insert into transaction values(1002,1,120,'2021-07-24');
Insert into transaction values(1003,1,120,'2021-08-24');

Insert into transaction values(1005,2,120,'2021-10-24');
Insert into transaction values(1006,2,120,'2021-09-24');
Insert into transaction values(1007,2,120,'2021-07-24');
Insert into transaction values(1008,2,120,'2021-08-24');
Insert into transaction values(1009,2,120,'2021-10-20');
Insert into transaction values(1010,2,120,'2021-09-20');
Insert into transaction values(1011,2,120,'2021-08-20');

Insert into transaction values(1012,3,51,'2021-08-24');


Insert into transaction values(1013,4,40,'2021-08-24');

Insert into transaction values(1014,5,100,'2021-08-24');

Insert into transaction values(1015,6,1000,'2019-08-24');

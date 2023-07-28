--SELECT * FROM TRANSACTION  t, METADATA m where t.EVENT_META_DATA_ID = m.EVENT_META_DATA_ID

CREATE TABLE metadata(
    event_meta_data_id int PRIMARY KEY AUTO_INCREMENT,
	payee_id varchar(255),
	amount decimal,
	card_number varchar(20),
	bill_number varchar(50)
);

CREATE TABLE transaction(
    transaction_id int PRIMARY KEY AUTO_INCREMENT,
	user_id varchar(255),
	app_id varchar(255),
	event_id varchar(255),
	event_occurred_on DATE,
	event_meta_data_id int,
	FOREIGN KEY (event_meta_data_id) REFERENCES metadata(event_meta_data_id)
);

--Money Transfer
INSERT INTO METADATA(payee_id,amount,card_number,bill_number) VALUES('PAYUser122','524.67','','');
INSERT INTO METADATA(payee_id,amount,card_number,bill_number) VALUES('PAYUser234','12.00','','');
INSERT INTO METADATA(payee_id,amount,card_number,bill_number) VALUES('PAYUser345','1245.22','','');
INSERT INTO METADATA(payee_id,amount,card_number,bill_number) VALUES('PAYUser456','2354.21','','');
INSERT INTO METADATA(payee_id,amount,card_number,bill_number) VALUES('PAYUser567','215.22','','');

--Bill Payment
INSERT INTO METADATA(payee_id,amount,card_number,bill_number) VALUES('CRIC','784.40','','BILL87745');
INSERT INTO METADATA(payee_id,amount,card_number,bill_number) VALUES('TESL','124.11','','56532965232');
INSERT INTO METADATA(payee_id,amount,card_number,bill_number) VALUES('AMAZ','412.56','','98451411211');
INSERT INTO METADATA(payee_id,amount,card_number,bill_number) VALUES('FLIP','999.99','','AS13245412');
INSERT INTO METADATA(payee_id,amount,card_number,bill_number) VALUES('PAYT','875.25','','CA1512421533');

--Credit Card Payment
INSERT INTO METADATA(payee_id,amount,card_number,bill_number) VALUES('VISA','121.12','9876-xxxx-xxxx-5678','BILL124512');
INSERT INTO METADATA(payee_id,amount,card_number,bill_number) VALUES('MASTER','421.65','8451-xxxx-xxxx-8745','BILL451511');
INSERT INTO METADATA(payee_id,amount,card_number,bill_number) VALUES('RUPAY','745.21','5642-xxxx-xxxx-6544','BILL151212');
INSERT INTO METADATA(payee_id,amount,card_number,bill_number) VALUES('VISA','657.21','8561-xxxx-xxxx-7541','BILL546412');
INSERT INTO METADATA(payee_id,amount,card_number,bill_number) VALUES('MASTER','51.22','8451-xxxx-xxxx-3651','BILL544661');

--Rent Payment
INSERT INTO METADATA(payee_id,amount,card_number,bill_number) VALUES('PAYUser251','236.95','','');
INSERT INTO METADATA(payee_id,amount,card_number,bill_number) VALUES('PAYUser234','112.54','','');
INSERT INTO METADATA(payee_id,amount,card_number,bill_number) VALUES('PAYUser641','45.21','','');
INSERT INTO METADATA(payee_id,amount,card_number,bill_number) VALUES('PAYUser987','954.74','','');
INSERT INTO METADATA(payee_id,amount,card_number,bill_number) VALUES('PAYUser567','156.68','','');

--Gift Cards
INSERT INTO METADATA(payee_id,amount,card_number,bill_number) VALUES('AMAZ','84.45','','');
INSERT INTO METADATA(payee_id,amount,card_number,bill_number) VALUES('MYNT','24.41','','');
INSERT INTO METADATA(payee_id,amount,card_number,bill_number) VALUES('FLIP','12.59','','');
INSERT INTO METADATA(payee_id,amount,card_number,bill_number) VALUES('MMT','99.75','','');
INSERT INTO METADATA(payee_id,amount,card_number,bill_number) VALUES('CMM','75.23','','');

-- User Data
INSERT INTO TRANSACTION(user_id,app_id,event_id,event_occurred_on,event_meta_data_id)  VALUES('Chris','payIt','bill-Pay','2023-07-28','6');
INSERT INTO TRANSACTION(user_id,app_id,event_id,event_occurred_on,event_meta_data_id)  VALUES('Chris','payIt','money-transfer','2023-07-07','2');
INSERT INTO TRANSACTION(user_id,app_id,event_id,event_occurred_on,event_meta_data_id)  VALUES('Chris','payIt','bill-Pay','2023-03-27','10');
INSERT INTO TRANSACTION(user_id,app_id,event_id,event_occurred_on,event_meta_data_id)  VALUES('Chris','payIt','credit-card','2023-06-18','11');
INSERT INTO TRANSACTION(user_id,app_id,event_id,event_occurred_on,event_meta_data_id)  VALUES('Chris','payIt','credit-card','2023-05-18','11');
INSERT INTO TRANSACTION(user_id,app_id,event_id,event_occurred_on,event_meta_data_id)  VALUES('Chris','payIt','credit-card','2023-04-16','11');
INSERT INTO TRANSACTION(user_id,app_id,event_id,event_occurred_on,event_meta_data_id)  VALUES('Chris','payIt','bill-Pay','2023-07-28','12');
INSERT INTO TRANSACTION(user_id,app_id,event_id,event_occurred_on,event_meta_data_id)  VALUES('Chris','payIt','money-transfer','2023-06-15','3');
INSERT INTO TRANSACTION(user_id,app_id,event_id,event_occurred_on,event_meta_data_id)  VALUES('Chris','payIt','bill-Pay','2023-05-30','7');
INSERT INTO TRANSACTION(user_id,app_id,event_id,event_occurred_on,event_meta_data_id)  VALUES('Chris','payIt','rent-pay','2023-06-28','17');
INSERT INTO TRANSACTION(user_id,app_id,event_id,event_occurred_on,event_meta_data_id)  VALUES('Chris','payIt','credit-card','2023-07-30','13');
INSERT INTO TRANSACTION(user_id,app_id,event_id,event_occurred_on,event_meta_data_id)  VALUES('Chris','payIt','rent-pay','2023-05-28','17');
INSERT INTO TRANSACTION(user_id,app_id,event_id,event_occurred_on,event_meta_data_id)  VALUES('Chris','payIt','credit-card','2023-06-28','13');
INSERT INTO TRANSACTION(user_id,app_id,event_id,event_occurred_on,event_meta_data_id)  VALUES('Chris','payIt','rent-pay','2023-07-28','17');
INSERT INTO TRANSACTION(user_id,app_id,event_id,event_occurred_on,event_meta_data_id)  VALUES('Chris','payIt','credit-card','2023-05-29','13');

INSERT INTO TRANSACTION(user_id,app_id,event_id,event_occurred_on,event_meta_data_id)  VALUES('Jill','payIt','bill-Pay','2023-06-23','15');
INSERT INTO TRANSACTION(user_id,app_id,event_id,event_occurred_on,event_meta_data_id)  VALUES('Jill','payIt','bill-Pay','2023-05-21','15');
INSERT INTO TRANSACTION(user_id,app_id,event_id,event_occurred_on,event_meta_data_id)  VALUES('Jill','payIt','money-transfer','2023-05-22','6');
INSERT INTO TRANSACTION(user_id,app_id,event_id,event_occurred_on,event_meta_data_id)  VALUES('Jill','payIt','money-transfer','2023-07-01','9');
INSERT INTO TRANSACTION(user_id,app_id,event_id,event_occurred_on,event_meta_data_id)  VALUES('Jill','payIt','money-transfer','2023-07-16','8');
INSERT INTO TRANSACTION(user_id,app_id,event_id,event_occurred_on,event_meta_data_id)  VALUES('Jill','payIt','credit-card','2023-07-09','14');
INSERT INTO TRANSACTION(user_id,app_id,event_id,event_occurred_on,event_meta_data_id)  VALUES('Jill','payIt','credit-card','2023-06-07','14');
INSERT INTO TRANSACTION(user_id,app_id,event_id,event_occurred_on,event_meta_data_id)  VALUES('Jill','payIt','rent-pay','2023-07-25','16');
INSERT INTO TRANSACTION(user_id,app_id,event_id,event_occurred_on,event_meta_data_id)  VALUES('Jill','payIt','rent-pay','2023-06-25','16');
INSERT INTO TRANSACTION(user_id,app_id,event_id,event_occurred_on,event_meta_data_id)  VALUES('Jill','payIt','rent-pay','2023-05-25','16');
INSERT INTO TRANSACTION(user_id,app_id,event_id,event_occurred_on,event_meta_data_id)  VALUES('Jill','payIt','rent-pay','2023-04-25','19');
INSERT INTO TRANSACTION(user_id,app_id,event_id,event_occurred_on,event_meta_data_id)  VALUES('Jill','payIt','rent-pay','2023-03-24','19');
INSERT INTO TRANSACTION(user_id,app_id,event_id,event_occurred_on,event_meta_data_id)  VALUES('Jill','payIt','gift-card','2022-07-19','24');
INSERT INTO TRANSACTION(user_id,app_id,event_id,event_occurred_on,event_meta_data_id)  VALUES('Jill','payIt','gift-card','2023-01-05','23');
INSERT INTO TRANSACTION(user_id,app_id,event_id,event_occurred_on,event_meta_data_id)  VALUES('Jill','payIt','gift-card','2023-07-19','22');

SELECT *
FROM   book_info;

-- Create table
CREATE TABLE book_info(book_code VARCHAR2(12) PRIMARY KEY
                      ,book_title VARCHAR2(100) NOT NULL
                      ,book_author VARCHAR2(100) NOT NULL
                      ,book_press VARCHAR2(100) NOT NULL
                      ,book_price NUMBER) tablespace users pctfree 10 initrans 1 maxtrans 255 storage(initial 64k NEXT 1m
                                                                                                      minextents 1
                                                                                                      maxextents
                                                                                                      unlimited);
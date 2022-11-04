create table tbl_book (
 book_code varchar2(10) primary key,
 book_name varchar2(100),
 author varchar2(100),
 press varchar2(100),
 price number
);

insert into tbl_book (book_code, book_name, author, press, price) values( 'B001', '이것이 자바다', '홍길동', '신흥출판사', 20000);
